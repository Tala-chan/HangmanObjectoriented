import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Letter extends JPanel implements MouseListener {
    Color darkGreen = new Color(64, 160, 0);
    Color myGreen = new Color(128, 224, 0);
    Color transparent = new Color(90,186,0);
    final int SIZE = 20;
    String theLetter;
    letterField myF;
    Reader myR;
    public Letter(String theLetter, letterField f){
        this.setPreferredSize(new Dimension(SIZE,SIZE));
        this.addMouseListener(this);
        this.setBackground(myGreen);
        this.setVisible(true);

        this.setBorder(BorderFactory.createLineBorder(darkGreen,3));
        this.theLetter = theLetter;
        this.myF = f;
        this.myR= f.r;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Denna if-sats låser alla mina knappars funktionalitet om det har redan varit klickat
        //eller om spelet är över
        if (getBackground() != transparent && myR.dead==false && myR.won==false) {

            myR.setLetter(this);
            setBackground(transparent);

            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString(theLetter,25,50);//Skiver bokstäver i mina rutor
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
