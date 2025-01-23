import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    
    final String[] MATCH_AGAINST = { "a", "e", "i", "o", "u" };

    public int findFirstVowel(String word){
    for (int i = 0; i < word.length(); i++) {
        String sub = word.substring(i, i + 1);
        for (String car : MATCH_AGAINST) {
            if (sub.equals(car)) return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
    if (findFirstVowel(sWord) == -1) {
        return sWord + "ay";
    } else {
        int vowel = findFirstVowel(sWord);
        if (vowel == 0) {
        return sWord + "way";
        } else if (sWord.substring(0, 2).equals("qu")) {
        return sWord.substring(2) + "quay";
        } else {
        while (findFirstVowel(sWord) != 0) {
            sWord = sWord.substring(1) + String.valueOf(sWord.charAt(0));
        }
        return sWord + "ay";
        }
    }
    }
}//end PigLatin class
