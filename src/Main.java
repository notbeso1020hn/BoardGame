import java.awt.Dimension;
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args){
        Display b = new Display();
        b.setPreferredSize(new Dimension(500,500));
        b.setLocation(550, 200);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }
}