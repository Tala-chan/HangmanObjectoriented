import javax.swing.*;
import java.awt.*;
public class letterField extends JPanel{
    Color brown = new Color(192, 96, 0);
    Alpha a;
    Reader r;
    letterField(Alpha alpha){
        this.a=alpha;//Liv, du gav mig dessa namn lol
        this.r=alpha.r;//r kanske verkar onödigt, men det används i Letter. Jag kan säkert skriva det finare, men orkar inte omformattera lol
        alpha.r.generateWord();//Genererar mitt ord.

        this.setBackground(brown);

        //JPanel multiPanel = new JPanel();
        GridLayout layout = new GridLayout(3,9);
        this.setBorder(BorderFactory.createLineBorder(brown, 5));
        this.setLayout(layout);

        this.add(new Letter("A",this));
        this.add(new Letter("B",this));
        this.add(new Letter("C",this));
        this.add(new Letter("D",this));
        this.add(new Letter("E",this));
        this.add(new Letter("F",this));
        this.add(new Letter("G",this));
        this.add(new Letter("H",this));
        this.add(new Letter("I",this));
        this.add(new Letter("J",this));
        this.add(new Letter("K",this));
        this.add(new Letter("L",this));
        this.add(new Letter("M",this));
        this.add(new Letter("N",this));
        this.add(new Letter("O",this));
        this.add(new Letter("P",this));
        this.add(new Letter("Q",this));
        this.add(new Letter("R",this));
        this.add(new Letter("S",this));
        this.add(new Letter("T",this));
        this.add(new Letter("U",this));
        this.add(new Letter("V",this));
        this.add(new Letter("W",this));
        this.add(new Letter("X",this));
        this.add(new Letter("Y",this));
        this.add(new Letter("Z",this));

        this.setVisible(true);
    }
}