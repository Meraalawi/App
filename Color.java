
import java.io.Serializable;
import java.util.Scanner;

enum Color implements Serializable {
    NOT_DEFINE,
    RED,
    WHITE,
    BLACK,
    BLUE,
    GREEN,
    YELLOW;
    static Scanner scanner = new Scanner(System.in);

    public static Color getColorFromInput() {
        System.out.println("Enter color:");
        for (int i = 1; i < Color.values().length; i++) {
            System.out.println(i + ": " + Color.values()[i]);
        }

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-" + (Color.values().length - 1) + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice < Color.values().length) {
                    return Color.values()[choice];
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
