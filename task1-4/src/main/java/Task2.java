import java.util.ArrayList;
import java.util.List;

/**
 * Printing a new number by adding one to each of its digit
 */
public class Task2 {

    /**
     * Return a new number by adding one to each of its digit
     *
     * @param number Number for transforming
     * @return Transformed number
     */
    public int transform(int number) {
        int result = 0;
        int tempNumber = number;
        int multiplier = 1;
        List<Integer> digits = new ArrayList<>();
        while (tempNumber > 9) {
            int previous = tempNumber;
            tempNumber = tempNumber / 10;
            int currentDigit = previous - (tempNumber * 10);
            digits.add(currentDigit);
        }
        digits.add(tempNumber);
        for (Integer digit : digits) {
            int temp = digit + 1;
            result = result + temp * multiplier;
            multiplier = multiplier * 10;
            if (temp == 10) {
                multiplier = multiplier * 10;
            }
        }
        return result;
    }

}
