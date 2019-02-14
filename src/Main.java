import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Eliza eliza = new Eliza(input);

        chatSession(eliza, input);
        viewHistory(eliza);

    }

    public static void chatSession(Eliza eliza, Scanner keybd){
        print(eliza.welcome());
        while (true){
            print("Enter your response here");
            eliza.setUserInput(keybd.nextLine().toLowerCase());
            eliza.setHistory(eliza.getUserInput());

            switch (eliza.getUserInput()){
                case "pig":
                    eliza.setPig();
                    if (eliza.isPig()){
                        print("pig ON");
                    } else {
                        print("pig OFF");
                    }
                    break;
                case "caps":
                    eliza.setCaps();
                    if (eliza.isCaps()){
                        print("caps ON");
                    } else {
                        print("caps OFF");
                    }
                    break;
                case "red":
                    eliza.setRed();
                    if (eliza.isRed()){
                        print("red ON");
                    } else {
                        print("red OFF");
                    }
                    break;
                case "play game":
                    print("Loading game...");
                    System.out.println();
                    PlayGame pg = new PlayGame(keybd);
                    pg.start();
                    System.out.println();
                    print("Finished playing a game");
                    break;

            }
            if (eliza.confirmQuit(eliza.getUserInput())){
                break;
            }
            else {
                eliza.setElizaSays(eliza.getReply());
                if (eliza.isPig()){
                    PigLatin pig = new PigLatin(eliza.getReply());
                    pig.setpigLatin();
                    eliza.setElizaSays(pig.getpigLatin());
                }
                if (eliza.isCaps()){
                    Caps caps = new Caps(eliza.getReply());
                    eliza.setElizaSays(caps.getCaps());
                }
                if (eliza.isRed()){
                    Red red = new Red(eliza.getReply());
                    eliza.setElizaSays(red.getRed());
                }
                print(eliza.getElizaSays());
            }
        }
        print(">>> END");
        keybd.close();
    }

    public static void print(String str){
        System.out.println(str);
        Eliza eliza = new Eliza();
        eliza.setHistory(str);
    }

    public static void viewHistory(Eliza eliza) {
        System.out.println("Printing chat history:");
        for (int i=0; i<eliza.getHistory().size(); i++){
            System.out.println(eliza.getHistory().get(i));
        }
    }


}
