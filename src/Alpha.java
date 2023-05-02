import javax.swing.*;
import java.awt.*;

public class Alpha extends JFrame {
    //Här skapas min enda Reader. Den var i letterField förut, men jag flyttade den hit eftersom när den var där kunde jag inte skicka den till ManField.
    //Jag är inte säker på varför jag kallade den för Alpha, men jag misstänker att det kommer från alphabet.
    Reader r = new Reader();
    Alpha(){
        this.setResizable(false);
        this.setTitle("Hangman");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.green);

        //Massa setup, separata rutor för tangentbordet och gubbens fält

        JPanel multiPanel = new JPanel();
        GridLayout layout = new GridLayout(2,1);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.white,10));
        multiPanel.setLayout(layout);

        //Jag skickar Alpha med dem eftersom där finns min Reader. Allt behöver tillgång till det.
        multiPanel.add(new manField(this));
        multiPanel.add(new letterField(this));

        this.getContentPane().add(multiPanel);

        this.pack();
        this.setVisible(true);
    }
}
