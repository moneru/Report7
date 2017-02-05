package jp.ac.uryukyu.ie.e165743;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


public class Action extends JFrame implements ActionListener {

    /*後述の機能で利用する変数を追加する*/
    public JLabel label;
    public JPanel p;
    public boolean counter;
    public int c;
    public long start;
    public long end;
    public boolean exit;
    public JLabel result;
    public JLabel average;

    /*ウィンドウに表示する数値やボタンなどの機能を追加していく*/
    Action(String title) {
        counter = true;  /*後述するwhile文を終了する際に使用する*/
        c = 0;   /* ボタンを押した回数を保存する*/

        setTitle(title);
        p = new JPanel();
        setSize(300, 150);
        setLocationRelativeTo(null);


        result = new JLabel("");
        average = new JLabel("");
        label = new JLabel("");
        JButton button1 = new JButton("Lets Barrage!");
        button1.addActionListener(this);

        p.add(label);
        p.add(button1);
        p.add(result);
        p.add(label);
        p.add(average);

        getContentPane().add(p);


        getContentPane().add(p, BorderLayout.CENTER);

    }


    /*この下から、先述したボタンを押した際の機能を追加していく。
    「ボタンを押した瞬間の時間を取得し、押した回数を保存する機能」
    「最初にボタンを押してから１０秒後に機能を終了し、押した回数・平均を表示する機能」を作る
    この二つをスレッドを利用して並行して処理を行うようにする
     */
    public void actionPerformed(ActionEvent e) {
        Sub sub = new Sub(); /*サブのスレッドを用意する。*/
        Thread th = new Thread(sub);
        if (counter) {
            start = System.currentTimeMillis(); /*ボタンを押した時間を取得し、startに保存する*/
            label.setText("Start!!"); /*空白のlabelに表示させる*/
            exit = true; /* サブのスレッドのwhile文を終了する際に使用する*/
            th.start(); /* サブのスレッドを開始する*/
            counter = false; /*counterの値をfalseにすることでボタンを押すたびに上記の機能が実行されないようにする*/
        }
        c++; /*ボタンを押すたびに追加していく*/
        Toolkit.getDefaultToolkit().beep(); /*ボタンを押すたびに音が出る*/

    }

    class Sub extends Thread {

        public void run() {
            while (exit) {
                /*時間を取得する
                最初にボタンを押した時間から１０秒経過した時点でwhile文から抜けるようにする。
                 */
                end = System.currentTimeMillis();
                if (TimeUnit.MILLISECONDS.toSeconds(end - start) == 10) {
                    exit = false;
                }
            }
            result.setText("あなたの押した回数は" + c + "回です");/*用意したラベルに結果を表示する*/
            average.setText("１０秒間の平均回数は" + (c / 10) + "回です");/*用意したラベルに平均を表示する*/
            label.setText("");/*　「start!!」の表示をしたラベルを空白にする。*/

        }
    }
}