package com.gainjava.knowledge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


class Test_about_University extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton[] radioButton = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1,  now = 0;
    int[] m = new int[10];

    Test_about_University(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct answers: " + count);
            System.exit(0);
        }
    }


    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Q1:  When Ala-Too International University (MUA) was established?");
            radioButton[0].setText("2001");
            radioButton[1].setText("1996");
            radioButton[2].setText("1998");
            radioButton[3].setText("1995");
        }
        if (current == 1) {
            label.setText("Q2:  How many labs are in the B block?");
            radioButton[0].setText("3");
            radioButton[1].setText("4");
            radioButton[2].setText("5");
            radioButton[3].setText("2");
        }
        if (current == 2) {
            label.setText("Q3: Who is the rector of MUA?");
            radioButton[0].setText("Sanzharbek Erdolatov");
            radioButton[1].setText("Ruslan Isaev");
            radioButton[2].setText("Tahir Aslan");
            radioButton[3].setText("Khaled Muhammed");
        }
        if (current == 3) {
            label.setText("Q4: How many blocks we have in University?");
            radioButton[0].setText("4");
            radioButton[1].setText("2");
            radioButton[2].setText("5");
            radioButton[3].setText("3");
        }
        if (current == 4) {
            label.setText("Q5:  The main language of instruction is ....");
            radioButton[0].setText("English");
            radioButton[1].setText("Turkish");
            radioButton[2].setText("Kyrgyz");
            radioButton[3].setText("Russian");
        }
        if (current == 5) {
            label.setText("Q6: How many faculties, institutes and departments we have?");
            radioButton[0].setText("4 faculties,3 institutes and 16 departments ");
            radioButton[1].setText("I don't remember");
            radioButton[2].setText("6 faculties, 3 institutes and 12 departments ");
            radioButton[3].setText("I don't know");
        }
        if (current == 6) {
            label.setText("Q7: Study fee of COM for students in Kyrgyzstan?");
            radioButton[0].setText("2700$");
            radioButton[1].setText("2230$");
            radioButton[2].setText("1130$");
            radioButton[3].setText("2311$");
        }
        if (current == 7) {
            label.setText("Q8: Who is the supervisor of COM19?");
            radioButton[0].setText("Tahir Aslan");
            radioButton[1].setText("Khaled Muhammed");
            radioButton[2].setText("Ruslan Isaev");
            radioButton[3].setText("Gulzada Esenalieva");
        }
        if (current == 8) {
            label.setText("Q9: The founder of the International University \"Ala-Too\" is ....");
            radioButton[0].setText("Sapat");
            radioButton[1].setText("Ata-Turk");
            radioButton[2].setText("American founders");
            radioButton[3].setText("Kyrgyz government");
        }
        if (current == 9) {
            label.setText("Q10: Will you put 100 points for this project?");
            radioButton[0].setText("Yes");
            radioButton[1].setText("No");
            radioButton[2].setText("Maybe");
            radioButton[3].setText("I don't know.");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }


    boolean check() {
        if (current == 0)
            return (radioButton[1].isSelected());
        if (current == 1)
            return (radioButton[1].isSelected());
        if (current == 2)
            return (radioButton[0].isSelected());
        if (current == 3)
            return (radioButton[2].isSelected());
        if (current == 4)
            return (radioButton[0].isSelected());
        if (current == 5)
            return (radioButton[0].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[2].isSelected());
        if (current == 8)
            return (radioButton[0].isSelected());
        if (current == 9)
            return (radioButton[0].isSelected());
        return false;
    }


    public static void main(String[] s) {
        new Test_about_University("Test_about_University");
    }
}