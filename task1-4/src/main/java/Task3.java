import java.util.ArrayList;
import java.util.List;

/**
 * Validating Sudoku with size `NxN`
 */
public class Task3 {

    /**
     * Return a boolean value indicating if the sudoku is filled correctly
     *
     * @param inputData Sudoku for checking
     * @return Boolean correctly filled sudoku
     */
    public boolean validateStandardSudoku(List<List<Integer>> inputData) {
        boolean correct = true;
        boolean correctDimension = validateDimension(inputData);
        if (!correctDimension) {
            return false;
        }
        boolean correctRows = validateRows(inputData);
        if (!correctRows) {
            return false;
        }
        boolean correctColumns = validateColumn(inputData);
        if (!correctColumns) {
            return false;
        }
        boolean correctSquare = validateSquare(inputData);
        if (!correctSquare) {
            return false;
        }
        return correct;
    }

    /**
     * Return a boolean value indicating if the sudoku data structure is correct
     *
     * @param inputData Sudoku for checking
     * @return Boolean correct sudoku data structure
     */
    private boolean validateDimension(List<List<Integer>> inputData) {
        String invalidData = "input data are not correct";
        int height = inputData.size();
        if (height <= 1) {
            System.out.println(invalidData);
            return false;
        }
        double squareRoot = Math.sqrt(height);
        int squareRootInt = (int) squareRoot;
        if (squareRoot != squareRootInt) {
            System.out.println(invalidData);
            return false;
        }
        for (List<Integer> currentList : inputData) {
            if (currentList.size() != height) {
                System.out.println(invalidData);
                return false;
            }
        }
        return true;
    }

    /**
     * Return a boolean value indicating if the sudoku rows are filled correctly
     *
     * @param inputData Sudoku for checking
     * @return Boolean correctly filled sudoku rows
     */
    private boolean validateRows(List<List<Integer>> inputData) {
        for (List<Integer> currentList : inputData) {
            boolean currentListValidated = validateCurrentRow(currentList);
            if (!currentListValidated) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return a boolean value indicating if the sudoku row is filled correctly
     *
     * @param currentList Sudoku for checking
     * @return Boolean correctly filled sudoku row
     */
    private boolean validateCurrentRow(List<Integer> currentList) {
        for (int j = 0; j < currentList.size(); j++) {
            int currentDigit = currentList.get(j);
            int uniqueDigit = 0;
            for (Integer integer : currentList) {
                if (integer.equals(currentDigit)) {
                    uniqueDigit++;
                }
            }
            if (uniqueDigit > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return a boolean value indicating if the sudoku columns are filled correctly
     *
     * @param inputData Sudoku for checking
     * @return Boolean correctly filled sudoku columns
     */
    private boolean validateColumn(List<List<Integer>> inputData) {
        for (int i = 0; i < inputData.size(); i++) {
            List<Integer> currentColumn = new ArrayList<>();
            for (List<Integer> inputDatum : inputData) {
                currentColumn.add(inputDatum.get(i));
            }
            boolean currentListValidated = validateCurrentRow(currentColumn);
            if (!currentListValidated) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return a boolean value indicating if the sudoku small squares are filled correctly
     *
     * @param inputData Sudoku for checking
     * @return Boolean correctly filled sudoku small squares
     */
    private boolean validateSquare(List<List<Integer>> inputData) {
        int squareSize = (int) Math.sqrt(inputData.size());
        int counter = 0;
        int startRow = 0;
        int startColumn = 0;
        while (counter < inputData.size()) {
            List<Integer> currentList = new ArrayList<>();
            for (int i = startRow; i < startRow + squareSize; i++) {
                for (int j = startColumn; j < startColumn + squareSize; j++) {
                    currentList.add(inputData.get(i).get(j));
                }
            }

            boolean currentListValidated = validateCurrentRow(currentList);
            if (!currentListValidated) {
                return false;
            }

            startColumn = startColumn + squareSize;
            if (startColumn == inputData.size()) {
                startColumn = 0;
                startRow = startRow + squareSize;
            }
            counter++;
        }
        return true;
    }

}
