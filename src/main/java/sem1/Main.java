package sem1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(simpleNumbers(30));
    }

    public static List<Integer> simpleNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                result.add(i);
            }
        }
        return result;
    }
}
