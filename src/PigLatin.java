import java.util.Random;

public class PigLatin {
    private boolean isVowel;
    private String pigLatin;
    private String[] words, appender;
    private char[] vowels;
    private Random rnd;

    public PigLatin(String original){
        isVowel = true;
        setWords(original);
        setAppender();
        setVowels();
        rnd = new Random();
    }

    public boolean isVowel() {
        return isVowel;
    }

    public void setVowel(boolean vowel) {
        isVowel = vowel;
    }

    public String getpigLatin() {
        return pigLatin;
    }

    public void setpigLatin() {
        StringBuilder sb = new StringBuilder();
        for (String word:words){
            word.toLowerCase();
            char firstChar = word.charAt(0);

            for (char vowel:vowels){ // continue returns here
                if (firstChar==vowel){
                    setVowel(true);
                    break;
                } else {
                    setVowel(false);
                    continue;
                }
            } // break returns here
            if (isVowel){ // if true choose either "way" or "tay" to append
                int index = rnd.nextInt(2);
                word.concat(appender[index]);
            } else { // if false choose "ay"
                word.concat(appender[2]);
            }

            pigLatin.join(" ", word);
        }
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String originalString) {
        words = originalString.split(" ");
    }

    public String[] getAppender() {
        return appender;
    }

    public void setAppender() {
        appender = new String[]{"way", "tay", "ay"};
    }

    public char[] getVowels() {
        return vowels;
    }

    public void setVowels() {
        vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
    }


}
