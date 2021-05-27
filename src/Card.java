import javax.swing.JButton;


public class Card extends JButton{
    private int val;
    private boolean match = false;

    public void setVal(int val){
        this.val = val;
    }
    public int getVal(){
        return this.val;
    }
    public void check(boolean match){
        this.match = match;
    }
    public boolean wrong(){
        return this.match;
    }
}