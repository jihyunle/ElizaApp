public class Red implements IConstants {
    private String red;

    public Red(String original){
        red = ANSI_RED + original + ANSI_RESET;
    }

    public String getRed() {
        return red;
    }

}
