import java.awt.*;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener , ActionListener{
    final int DELAY=1;
    Timer timer;
    Random rand = new Random();
    int xr = rand.nextInt(30)*10;
    int yr = rand.nextInt(30)*10;


    int []x =new int[33333];
    int []y =new int[33333];
    int []xm =new int[10];
    int []ym =new int[10];
    int a=2;

    public MyPanel() {
        timer = new Timer(100, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    void granica()
    {
        if(x[0]>370 || x[0]<0 || y[0]>350 || y[0]<0)
        {
            x[0]=0;
            y[0]=0;
            xm[0]=0;
            ym[0]=0;
            a=2;
        }

    }




    void duplicate()
    {
        for(int i = a;i>0;i--)         //tutaj
        {
            x[i]=x[i-1];
            y[i]=y[i-1];
            if(x[0]==x[i+1] && y[0]==y[i+1] && a>2)
            {
                x[0]=0;
                y[0]=0;
                xm[0]=0;
                ym[0]=0;
                a=2;

            }

        }

    }
    void move()
    {
        x[0]  = x[0] + xm[0];
        y[0]  = y[0] + ym[0];
    }
    void apple()
    {
        if(x[0]==xr && y[0]==yr)
        {
            a++;
            xr = rand.nextInt(30)*10;
            yr = rand.nextInt(30)*10;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D[] rectangle = new Rectangle2D.Double[a];   // tutaj
        rectangle[0] = new Rectangle2D.Double(x[0],y[0],10,10);
        Rectangle2D apple = new Rectangle2D.Double(xr,yr,10,10);
        g2d.draw(apple);
        

        g2d.draw(rectangle[0]);
        for(int i = 1;i<a;i++)    //tutaj
        {

           rectangle[i] = new Rectangle2D.Double(x[i],y[i],10,10);
           g2d.draw(rectangle[i]);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

     move();
     apple();

     duplicate();
     repaint();
     granica();



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        if(c == KeyEvent.VK_LEFT){
            xm[0] = -10;
            ym[0] = 0;


        }
        else if(c == KeyEvent.VK_RIGHT){
            xm[0]= 10;
            ym[0]= 0;


        }
        else if(c == KeyEvent.VK_UP){
            xm[0]= 0;
            ym[0]= -10;

        }
        else if(c == KeyEvent.VK_DOWN){
            xm[0]= 0;
            ym[0]= 10;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {



    }
}