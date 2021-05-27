import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Display extends JFrame{


    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
    public Display(){

        int pairs = 10;
        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> set = new ArrayList<Integer>();
        // get a set of random numbers
        for (int i = 0; i < pairs; i++){
            set.add(i);
            set.add(i);
        }
        Collections.shuffle(set);

        // set value to the card
        for (int val : set){
            Card c = new Card();
            Font newButtonFont=new Font(c.getFont().getName(),c.getFont().getStyle(),32);
            c.setFont(newButtonFont); // set the font size of the text
            c.setVal(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;

        t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");
    }
    // turningCard event:
    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getVal()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getVal()));
            t.start();

        }
    }

    public void checkCards(){
        if (c1.getVal() == c2.getVal()){
            c1.setEnabled(false);
            c2.setEnabled(false);
            c1.check(true);
            c2.check(true);
            if (this.won()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

        else{
            c1.setText("");
            c2.setText("");
        }
        c1 = null;
        c2 = null;
    }

    public boolean won(){
        for(Card c: this.cards){
            if (c.wrong() == false){
                return false;
            }
        }
        return true;
    }

}