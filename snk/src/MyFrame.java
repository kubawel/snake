import javax.swing.*;
import javax.swing.Timer;


public class MyFrame extends JFrame {

    public MyFrame() {
        super("snake");
        JPanel panel = new MyPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocation(900,500);
        add(panel);
        setVisible(true);

    }







}