public interface IConstants {
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";

    // public static final is redundant but good practice for now
    // never Private b/c this is an interface
    // final static = constant and limited to that class
}
