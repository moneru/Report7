package jp.ac.uryukyu.ie.e165743;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;

class main extends JFrame{
    public static void main(String args []){
        main Barrage = new main("title");
        Barrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Barrage.setVisible(true);

    }

    main(String title){

        setTitle(title);
        JPanel p = new JPanel();
        setSize(400,500);
        setLocationRelativeTo(null);


        JButton button1 = new JButton("Lets Barrage!");

        p.add(button1);
        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER);

    }
}
