import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
enum Color {
    NOT_DEFINE,
    RED,
    WHITE,
    BLACK,
    BLUE,
    GREEN,
    YELLOW;
    private static final Map<Integer, Color> colorMap = new HashMap<>();
    
    static {
        colorMap.put(1, RED);
        colorMap.put(2, WHITE);
        colorMap.put(3, BLACK);
        colorMap.put(4, BLUE);
        colorMap.put(5, GREEN);
        colorMap.put(6, YELLOW);
    }
    public static Color getColorFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color (1: RED, 2: WHITE, 3: BLACK, 4: BLUE, 5: GREEN, 6: YELLOW): ");
        int choice = scanner.nextInt();

        return colorMap.getOrDefault(choice, NOT_DEFINE);

    }

}
