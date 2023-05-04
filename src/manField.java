import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class manField extends JPanel {
    Alpha a;
    Reader reader;
    Color darkBlue = new Color(0, 128, 224);
    manField(Alpha alpha){
        this.setBackground(darkBlue);
        this.a=alpha;
        this.reader=alpha.r;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 =(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(5.0f));
        g.setColor(Color.white);

        g.setFont(new Font("TimesRoman", Font.BOLD, 18));

        if(reader.progressionText()!=null){
            g.drawString(reader.progressionText(),380,100);
        }

        //Nu ritas allt. Det ritas upp lager på lager, så jag avgör vilka som ska visas med många if-satser.
        //De tittar på hur många fel du har, och avgör utifrån det.

        g.fillOval(50,200,200,200);//Hill

        if(reader.wrongGuesses>0){
            g.fillRect(145,50,5,160);//Scaffold pole
            if(reader.wrongGuesses>1){
                g.fillRect(145,50,75,5);//Scaffold arm
                if(reader.wrongGuesses>2){
                    g2.draw(new Line2D.Double(150,75,170,55));//Scaffold support
                    if(reader.wrongGuesses>3){
                        g2.draw(new Line2D.Double(220,52,220,70));//Noose
                        g2.draw(new Line2D.Double(220,70,230,85));
                        g2.draw(new Line2D.Double(220,70,210,85));
                        g.drawOval(207,80,25,25);
                        if(reader.wrongGuesses>4){
                            g.fillOval(207,80,25,25);//Head
                            if(reader.wrongGuesses>5){
                                g2.draw(new Line2D.Double(220,95,220,135));//Body
                                g.fillOval(212,135,15,15);
                                if(reader.wrongGuesses>6){
                                    g2.draw(new Line2D.Double(212,145,215,170));//Legs
                                    g2.draw(new Line2D.Double(227,145,224,170));
                                    g2.draw(new Line2D.Double(213,170,216,195));
                                    g2.draw(new Line2D.Double(226,170,223,195));
                                    g2.draw(new Line2D.Double(214,195,217,203));
                                    g2.draw(new Line2D.Double(225,195,222,203));
                                    if(reader.wrongGuesses>7){
                                        g.fillOval(212,110,15,15);//Arms and details
                                        g2.draw(new Line2D.Double(210,115,208,150));
                                        g2.draw(new Line2D.Double(229,115,231,150));
                                        g.fillOval(205,150,8,9);
                                        g.fillOval(227,150,8,9);
                                        g.setColor(darkBlue);
                                        g.fillOval(210,93,8,8);
                                        g.fillOval(222,93,8,8);
                                        g.fillOval(217,101,5,5);
                                        g.setColor(Color.white);
                                        g.fillOval(210,90,8,8);
                                        g.fillOval(222,90,8,8);
                                        g.fillOval(216,102,8,5);
                                        g.fillOval(213,99,2,2);
                                        g.fillOval(224,99,2,2);
                                        Graphics2D g3 =(Graphics2D)g;
                                        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                        g3.setStroke(new BasicStroke(1.0f));
                                        g.setColor(Color.red);
                                        g3.draw(new Line2D.Double(221,102,221,107));
                                        g.fillOval(219,108,2,2);
                                        g.fillOval(219,118,2,2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if(reader.dead==true){
            g.drawString(reader.word.replace("", " ").trim(),380,127);
            g.drawString("GAME OVER",380,150);
        }
        if(reader.won==true){
            if(reader.wrongGuesses>4){
                reader.wrongGuesses=4;
            }
            g.setColor(Color.white);
            g.drawString("YOU GOT IT!",380,150);
        }

        repaint();

    }

}
