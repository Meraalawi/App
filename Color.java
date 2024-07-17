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
        System.out.print("Enter color:\n1: RED\n2: WHITE\n3: BLACK\n4: BLUE\n5: GREEN\n6: YELLOW\n");
        int choice = scanner.nextInt();

        return colorMap.getOrDefault(choice, NOT_DEFINE);

    }

}
