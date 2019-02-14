import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    private HashMap<String, String> myMap;
    private ArrayList<String> hedge;
    private ArrayList<String> qualifier;
    private ArrayList<String> history;
    private Scanner keybd;
    private Random rnd;
    private String userInput, elizaSays;
    private boolean isPig, isCaps, isRed;

    public Eliza(){
        setMyMap();
        setHedge();
        setQualifier();
        history = new ArrayList<>();
        rnd = new Random();
        userInput = ""; elizaSays = "";
        isPig = false; isCaps = false; isRed = false;
    }

    public Eliza(Scanner input){
        setMyMap();
        setHedge();
        setQualifier();
        history = new ArrayList<>();
        keybd = input;
        rnd = new Random();
        userInput = ""; elizaSays = "";
        isPig = false; isCaps = false; isRed = false;
        setHedge();
        setQualifier();
    }

    public HashMap<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap() {
        myMap = new HashMap<>();
        myMap.put("i", "you");
        myMap.put("me", "you");
        myMap.put("my", "your");
        myMap.put("am", "are");
    }

    public String getHedge() {
        return hedge.get(rnd.nextInt(hedge.size()));
    }

    public void setHedge() {
        hedge = new ArrayList<>();
        hedge.add("Please tell me more");
        hedge.add("Many of my patients tell me the same thing");
        hedge.add("It is getting late, maybe we had better quit");
    }

    public String getQualifier() {
        return qualifier.get(rnd.nextInt(qualifier.size()));
    }

    public void setQualifier() {
        qualifier = new ArrayList<>();
        qualifier.add("Why do you say that");
        qualifier.add("You seem to think that");
        qualifier.add("So, you are concerned that");
    }


    public ArrayList<String> getHistory(){
        return history;
    }


    public void setHistory(String str) {
        history.add(str);
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getElizaSays() {
        return elizaSays;
    }

    public void setElizaSays(String elizaSays) {
        this.elizaSays = elizaSays;
    }

    public boolean isPig() {
        return isPig;
    }

    public void setPig() {
        isPig = !isPig;
    }

    public boolean isCaps() {
        return isCaps;
    }

    public void setCaps() {
        isCaps = !isCaps;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed() {
        isRed = !isRed;
    }

//    public void chatSession(){
//        print(welcome());
//        while (true){
//            print("Enter your response here");
//            userInput = keybd.nextLine().toLowerCase();
//            setHistory(userInput);
//            switch (userInput){
//                case "pig":
//                    setPig();
//                    if (isPig){
//                        print("pig ON");
//                    } else {
//                        print("pig OFF");
//                    }
//                    continue;
//                case "caps":
//                    setCaps();
//                    if (isCaps){
//                        print("caps ON");
//                    } else {
//                        print("caps OFF");
//                    }
//                    continue;
//                case "red":
//                    setRed();
//                    if (isRed){
//                        print("red ON");
//                    } else {
//                        print("red OFF");
//                    }
//                    continue;
//                case "play game":
//                    print("Loading game...");
//                    System.out.println();
//                    PlayGame pg = new PlayGame(keybd);
//                    pg.start();
//                    print("Finished playing a game");
//                    continue;
//
//            }
//            if (confirmQuit(userInput)){
//                break;
//            } else {
//                setElizaSays(getReply());
//                if (isPig){
//                    PigLatin pig = new PigLatin();
//                    pig.setPigString(getReply());
//                    setElizaSays(pig.getPigString());
//                }
//                if (isCaps){
//                    Caps caps = new Caps();
//                    caps.setCapString(getReply());
//                    setElizaSays(caps.getCapString());
//                }
//                if (isRed){
//                    Red red = new Red();
//                    red.setRedString(getReply());
//                    setElizaSays(red.getRedString());
//                }
//                print(getElizaSays());
//            }
//        }
//        print(">>> END");
//        keybd.close();
//        getHistory();
//        // where bulk goes in
//        // create pig latin object to use and optionally pass rnd
//    }

    public boolean confirmQuit(String str){
        if (str.equalsIgnoreCase("q") || str.equalsIgnoreCase("i am feeling great")){
            return true; // quit Eliza
        } else {
            return false;
        }
    }

    public boolean onOffSwitch(boolean onOff){
        return !onOff;
    }

    public String getReply(){
        StringBuilder sb = new StringBuilder();
        String reply = "";
        int replyType = rnd.nextInt(2) + 1;
        switch (replyType){
            case 1: // call hedge
//                return getHedge();
                reply = getHedge();
                break;
            case 2:
//                return sb.append(getQualifier()).append(replaceWords(userInput)).toString();
                reply = sb.append(getQualifier()).append(replaceWords(userInput)).toString();
                break;
//            default:
//                return null;
        }
        return reply;
    }

    public String replaceWords(String originalString){
        String replacedString = "";
        StringBuilder sb = new StringBuilder();
        String[] words = originalString.toLowerCase().split(" ");
        for (String word:words){
            if (myMap.containsKey(word)){
                word = myMap.get(word);
            }
            replacedString = sb.append(" ").append(word).toString();
        }
        return replacedString;
    }


    public String welcome(){
        return "Hello, My name is Eliza. What can I help you with today?";
    }





}































