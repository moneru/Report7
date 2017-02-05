package jp.ac.uryukyu.ie.e165743;
import javax.swing.JFrame;

public class Main {


    public static void main(String args[]) {
        Action Barrage = new Action("title");    /* ウィンドウのタイトル*/
        Barrage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* ウィンドウを閉じる機能を追加する*/
        Barrage.setVisible(true); /*ウィンドウを表示する*/

    }

}