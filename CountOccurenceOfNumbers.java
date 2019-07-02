//Christian Lockley
import java.util.*;

public class CountOccurenceOfNumbers {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int continueLoop = 0;
        int[] numbers = null;
        Map<Integer, Integer> map = new TreeMap<>();
        String [] tmp = null;
        do {
            System.out.print("Enter number: ");
            try {
                try {
                    tmp = stdin.nextLine().split("\\s+");
                } catch (NoSuchElementException ex0) {
                    break;
                }
                numbers = new int[tmp.length];
                continueLoop = -1;
                for (int i = 0; i < numbers.length; ++i) {
                    if ((numbers[i] = Integer.parseInt(tmp[i])) == 0) {
                        continueLoop = 0;
                        break;
                        }
                    }
            } catch (NumberFormatException ex1) {
                System.out.println("Invalid input");
                continueLoop = -1;
                continue;
            }
            if (numbers != null) {
                for (int i = 0; i < numbers.length; ++i) {
                    if (!map.containsKey(numbers[i]) && numbers[i] != 0) {
                        map.put(numbers[i], 1);
                    } else if (numbers[i] != 0) {
                        map.put(numbers[i], map.get(numbers[i])+1);
                    }
                }
            }
        } while (continueLoop != 0);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        boolean first = true;
        for (Map.Entry<Integer, Integer> entry: entrySet) {
            if (first) {
                System.out.println("Value\tKey");
                first = false;
            }
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }
}
