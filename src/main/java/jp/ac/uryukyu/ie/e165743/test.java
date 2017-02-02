package jp.ac.uryukyu.ie.e165743;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;

class SSample1_1 extends JFrame{
    public static void main(String args[]){
        SSample1_1 frame = new SSample1_1("タイトル");
        frame.setVisible(true);
    }

    SSample1_1(String title){
        setTitle(title);
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        JButton button1 = new JButton();
        JButton button2 = new JButton("確認");
        JButton button3 = new JButton();
        button3.setText("キャンセル");

        p.add(button1);
        p.add(button2);
        p.add(button3);

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER);
    }
}