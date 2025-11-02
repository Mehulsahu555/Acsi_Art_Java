import java.util.*;

public class Ascii {
    private static final String[][] LETTERS = {
        {" XX  XXX   XX  XXX  XXXX XXXX  XX  X  X XXXX    X X  X X    X  X X  X  XX  XXX   XX  XXX  XXXX XXXX X  X X  X X  X X  X X  X XXXX "},
        {"X  X X  X X  X X  X X    X    X    X  X  XX     X X X  X    XXXX XX X X  X X  X X  X X  X X     XX  X  X X  X X  X X  X X  X   X  "},
        {"XXXX XXX  X    X  X XXXX XXXX X XX XXXX  XX     X XX   X    X  X X XX X  X XXX  X  X XXX  XXXX  XX  X  X X  X X  X  XX   XX   X   "},
        {"X  X X  X X  X X  X X    X    X  X X  X  XX  X  X X X  X    X  X X  X X  X X    X XX X X     X  XX  X  X X  X XXXX X  X  XX  X    "},
        {"X  X XXX   XX  XXX  XXXX X     XX  X  X XXXX  XX  X  X XXXX X  X X  X  XX  X     XXX X  X XXXX  XX  XXXX  XX  X  X X  X  XX  XXXX "}
    };

    private static final String[][] NUMBERS = {
        {" XX   XX   XX   XX     X XXXX XXXX XXXX  XX  XXXX "},
        {"X  X XXX  X  X X  X   XX X    X       X X  X X  X "},
        {"X  X  XX    X    X   X X XXXX XXXX   X   XX  XXXX "},
        {"X  X  XX   X   X  X XXXX    X X  X  X   X  X    X "},
        {" XX  XXXX XXXX  XX     X XXXX XXXX X     XX  XXXX "}
    };

    private static final String[][] SYMBOLS = {
        {"XX       X X     X  X     XX         X   XX      XXXX    XXXX "},
        {"XX       X X     X  X   XXXXXX  XX  X   X  X    XX   X  X    X"},
        {"XX              XXXXXX  X       XX X     XX         XX  X XX X"},
        {"XX               X  X   XXXXXX    X XX   XX X      XX   X X XX"},
        {"XX              XXXXXX       X   X  XX  X  X      XX    X XXXX"},
        {"                 X  X   XXXXXX  X        XX X           X     "},
        {"XX               X  X     XX                      XX     XXX  "}
    };

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> showLetter();
                case 2 -> showWord();
                case 3 -> showAlphaRange();
                case 4 -> showNumbers();
                case 5 -> showSymbol();
                case 0 -> {
                    System.out.println("Goodbye ");
                    return;
                }
                default -> System.out.println(" Invalid choice, try again...");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n\t Welcome to ASCII Code \n");
        System.out.println("1. Show Letter\t\t2. Show Word");
        System.out.println("3. Show Range\t\t4. Show Numbers");
        System.out.println("5. Show Symbol\t\t0. Exit");
        System.out.print(" Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ------------------- Features -------------------

    private static void showLetter() {
        System.out.print("Enter your letter: ");
        char ch = Character.toUpperCase(input.nextLine().charAt(0));
        if (ch < 'A' || ch > 'Z') {
            System.out.println("Invalid letter");
            return;
        }
        printAscii(LETTERS, ch - 'A', 5, 5);
    }

    private static void showWord() {
        System.out.print("Enter your word: ");
        String word = input.nextLine().toUpperCase();
        for (int i = 0; i < 5; i++) {
            for (char ch : word.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    printRow(LETTERS[i][0], (ch - 'A') * 5, 5);
                }
            }
            System.out.println();
        }
    }

    private static void showAlphaRange() {
        System.out.print("Enter your range (e.g., A-Z): ");
        String range = input.nextLine().toUpperCase();

        if (range.length() != 3 || range.charAt(1) != '-') {
            System.out.println("Invalid format! Use like A-F");
            return;
        }

        char start = range.charAt(0);
        char end = range.charAt(2);

        if (start < 'A' || end > 'Z' || end < start) {
            System.out.println("Invalid range");
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (char ch = start; ch <= end; ch++) {
                printRow(LETTERS[i][0], (ch - 'A') * 5, 5);
            }
            System.out.println();
        }
    }

    private static void showNumbers() {
        System.out.print("Enter your number: ");
        String digits = input.nextLine();
        for (int i = 0; i < 5; i++) {
            for (char d : digits.toCharArray()) {
                if (d >= '0' && d <= '9') {
                    printRow(NUMBERS[i][0], (d - '0') * 5, 5);
                }
            }
            System.out.println();
        }
    }

    private static void showSymbol() {
        System.out.print("Choose one of the symbol (!,\",#,$,%,&,?,@): ");
        char sym = input.nextLine().charAt(0);
        int pos = switch (sym) {
            case '!' -> 0;
            case '"' -> 1;
            case '#' -> 2;
            case '$' -> 3;
            case '%' -> 4;
            case '&' -> 5;
            case '?' -> 6;
            case '@' -> 7;
            default -> -1;
        };

        if (pos == -1) {
            System.out.println("Invalid symbol");
            return;
        }

        for (int i = 0; i < 7; i++) {
            printRow(SYMBOLS[i][0], pos * 8, 6);
            System.out.println();
        }
    }

    // ------------------- Helpers -------------------

    private static void printAscii(String[][] arr, int index, int height, int width) {
        for (int i = 0; i < height; i++) {
            printRow(arr[i][0], index * width, width);
            System.out.println();
        }
    }

    private static void printRow(String row, int start, int length) {
        for (int j = start; j < start + length; j++) {
            System.out.print(row.charAt(j));
        }
    }
}
