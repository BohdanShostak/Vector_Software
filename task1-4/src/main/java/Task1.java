import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Encoding and decoding a string by the Rail Fence Cipher.
 */
public class Task1 {

    /**
     * Returns String encoded by the Rail Fence Cipher
     *
     * @param decodedText String for encoding
     * @param railsNumber Number of rails.
     * @return Encoded string
     */
    public String encode(String decodedText, int railsNumber) {
        if (railsNumber < 2) {
            return "number of rails must be >= 2";
        }
        StringBuilder result = new StringBuilder();
        String[] rows = new String[railsNumber];
        Arrays.fill(rows, "");
        int textLength = decodedText.length();
        int counter = 0;
        int tempCounter = 0;
        boolean reverse = false;
        while (counter < textLength) {
            char currentChar = decodedText.charAt(counter);
            rows[tempCounter] = rows[tempCounter] + currentChar;
            if (!reverse) {
                tempCounter++;
            }
            if (reverse) {
                tempCounter--;
            }
            if (tempCounter == railsNumber - 1) {
                reverse = true;
            }
            if (tempCounter == 0) {
                reverse = false;
            }
            counter++;
        }
        for (int i = 0; i < railsNumber; i++) {
            result.append(rows[i]);
        }
        return result.toString();

    }

    /**
     * Returns String decoded by the Rail Fence Cipher
     *
     * @param encodedText String for decoding
     * @param railsNumber Number of rails.
     * @return Decoded string
     */
    public String decode(String encodedText, int railsNumber) {
        if (railsNumber < 2) {
            return "number of rails must be >= 2";
        }
        StringBuilder result = new StringBuilder();
        int textLength = encodedText.length();
        int counter = 0;
        int reverseCounter = textLength - 1;
        int currentPosition = 0;
        int reverseCurrentPosition;
        int step = (railsNumber - 1) * 2;
        char[] decoded = new char[textLength];
        List<Integer> upNumbers = new ArrayList<>();
        List<Integer> downNumbers = new ArrayList<>();
        boolean reverse = false;

        while (currentPosition < textLength) {
            char currentChar = encodedText.charAt(counter);
            decoded[currentPosition] = currentChar;
            counter++;
            upNumbers.add(currentPosition);
            if (textLength - currentPosition < step) {
                break;
            }
            currentPosition = currentPosition + step;
        }

        int temReverseCurrentPosition = currentPosition + step / 2;
        if (temReverseCurrentPosition < textLength) {
            reverseCurrentPosition = temReverseCurrentPosition;
        } else {
            reverseCurrentPosition = currentPosition - step / 2;
        }
        while (reverseCurrentPosition > 0) {
            char currentChar = encodedText.charAt(reverseCounter);
            decoded[reverseCurrentPosition] = currentChar;
            reverseCounter--;
            downNumbers.add(reverseCurrentPosition);
            if (reverseCurrentPosition < step) {
                break;
            }
            reverseCurrentPosition = reverseCurrentPosition - step;
        }

        if (railsNumber > 2) {
            step = 1;
            for (int i = 0; i < railsNumber - 2; i++) {
                if (!reverse) {
                    for (int temp : upNumbers) {
                        int leftTemp = temp - step;
                        int rightTemp = temp + step;
                        if (leftTemp > 0 & leftTemp < textLength) {
                            char currentChar = encodedText.charAt(counter);
                            decoded[leftTemp] = currentChar;
                            counter++;
                        }
                        if (rightTemp > 0 & rightTemp < textLength) {
                            char currentChar = encodedText.charAt(counter);
                            decoded[rightTemp] = currentChar;
                            counter++;
                        }
                    }
                } else {
                    for (int l = downNumbers.size(); l > 0; l--) {
                        int temp = downNumbers.get(l);
                        int leftTemp = temp - step;
                        int rightTemp = temp + step;
                        if (leftTemp > 0 & leftTemp < textLength) {
                            char currentChar = encodedText.charAt(reverseCounter);
                            decoded[leftTemp] = currentChar;
                            reverseCounter--;
                        }
                        if (rightTemp > 0 & rightTemp < textLength) {
                            char currentChar = encodedText.charAt(reverseCounter);
                            decoded[rightTemp] = currentChar;
                            reverseCounter--;
                        }
                    }

                }
                step++;
            }
        }

        for (int i = 0; i < textLength; i++) {
            result.append(decoded[i]);
        }
        return result.toString();
    }

}
