import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Reader {
    String currentLetter;
    Letter letter;
    int match=0;
    int notWrong=0;
    int wrongGuesses=0;
    boolean dead = false;
    boolean won = false;

    ArrayList<String> words = new ArrayList<>(Arrays.asList("GEEKS", "CATS", "AMBULANCE"));
    //Ordlista, orkar inte skriva så mycket ord. Men detta bevisar att det funkar i princip!
    Random rand = new Random();
    int upperbound = 3;
    int int_random = rand.nextInt(upperbound);
    String word = words.get(int_random);//Här väljs ett slumpmässigt ord ur arrayen.
    String[] letters = word.split("(?!^)");//Det splittras i bokstäver, så de kan lättare jämföras.
    String[] reveal = new String[word.length()];//Det dolda ordet är lika långt som ordet.


    //Här finns all kod. Funktionerna är kallade i andra klasser, men de beskrivs här.
    public Reader(){
    }
    public void generateWord(){
        for (int i = 0; i < (word.length()); i++) {
            reveal[i] = "_"; //Ordet är dolt för spelaren i början. Alla dess täcken är _.
        }
    }
    public String progressionText(){
        //För att skriva ut det dolda ordet behöver dess bokstäver först sättas ihop igen.
        return String.join(" ",reveal);
    }
    public void setLetter(Letter letter) {
        this.letter = letter;
        currentLetter=letter.theLetter;
        comparer();
    }
    public void comparer(){
        for (int i = 0; i < (word.length()); i++) {
             if(letters[i].equals(currentLetter)){//Alla digits i ordet jämförs med spelarens gissning.
                 reveal[i]=currentLetter;//Eftersom ordet och spelarens dolda ord har samma längd, är den sanna bokstaven i samma position.
                 notWrong++;//Det spelar ingen roll hur många gånger du har rätt, bara att du inte har fel minst en gång.
             }
        }
        for (int i = 0; i < (word.length()); i++){
            if(reveal[i].equals(letters[i])){
                match++;//Match tittar hur många bokstäver du har hittils gissat rätt.
            }
        }
        if(notWrong==0){
            wrongGuesses++;//Om du inte hade rätt en enda gång, har du fel (lol)
        }
        if(match==word.length()){
            won=true;//När du har lika många rätt som det finns bokstäver i ordet, har du gissat allt. Då vinner du.
        }
        if(wrongGuesses==8){
            dead=true;//När du har gissat fel åtta gånger är du död.
        }
        match=0;
        notWrong=0;
    }
}
