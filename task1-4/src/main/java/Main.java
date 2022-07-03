import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("_____Task_1_____");
        String decodedText = "WEAREDISCOVEREDFLEEATONCE";
        String decodedText2 = "SOMEEXAMPLE";
        String encodedText = "WECRLTEERDSOEEFEAOCAIVDEN";
        String encodedText2_2 = "SMEAPEOEXML";
        String encodedText2_3 = "SEPOEXMLMAE";
        String encodedText2_4 = "SAOXMMEPEEL";
        String encodedText2_5 = "SPOMLMAEEXE";
        Task1 task1 = new Task1();

        System.out.println("encoding example: ");
        System.out.println(task1.encode(decodedText, 3) + " - current result with 3 rails");
        System.out.println(encodedText + " - expected result with 3 rails");
        System.out.println(task1.encode(decodedText2, 2) + " - current result with 2 rails");
        System.out.println(encodedText2_2 + " - expected result with 2 rails");
        System.out.println(task1.encode(decodedText2, 3) + " - current result with 3 rails");
        System.out.println(encodedText2_3 + " - expected result with 3 rails");
        System.out.println(task1.encode(decodedText2, 4) + " - current result with 4 rails");
        System.out.println(encodedText2_4 + " - expected result with 4 rails");
        System.out.println(task1.encode("", 3) + "- current result with empty String");
        System.out.println("- expected result with empty String");
        System.out.println("decoding example: ");
        System.out.println(task1.decode(encodedText2_3, 3) + " - current result with 3 rails");
        System.out.println(encodedText2_3 + " - expected result with 3 rails");

        System.out.println("decoding example: ");
        System.out.println(decodedText + " - Expected text");
        System.out.println(task1.decode(encodedText, 3) + " - 3 rails");
        System.out.println("Expected text 2: " + decodedText2);
        System.out.println(task1.decode(encodedText2_2, 2) + " - 2 rails");
        System.out.println(task1.decode(encodedText2_3, 3) + " - 3 rails");
        System.out.println(task1.decode(encodedText2_4, 4) + " - 4 rails");
        System.out.println(task1.decode(encodedText2_5, 5) + " - 5 rails");

        System.out.println("_____Task_2_____");
        Task2 task2 = new Task2();
        System.out.println("input number: 0");
        System.out.println("result: " + task2.transform(0));
        System.out.println("input number: 9");
        System.out.println("result: " + task2.transform(9));
        System.out.println("input number: 999");
        System.out.println("result: " + task2.transform(998));
        System.out.println("input number: 310");
        System.out.println("result: " + task2.transform(310));

        System.out.println("_____Task_3_____");
        Task3 task3 = new Task3();
        List<List<Integer>> generalList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(7, 8, 4, 1, 5, 9, 3, 2, 6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 3, 9, 6, 7, 2, 8, 4, 1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 1, 2, 4, 3, 8, 7, 5, 9));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(9, 2, 8, 7, 1, 5, 4, 6, 3));
        List<Integer> list5 = new ArrayList<>(Arrays.asList(3, 5, 7, 8, 4, 6, 1, 9, 2));
        List<Integer> list6 = new ArrayList<>(Arrays.asList(4, 6, 1, 9, 2, 3, 5, 8, 7));
        List<Integer> list7 = new ArrayList<>(Arrays.asList(8, 7, 6, 3, 9, 4, 2, 1, 5));
        List<Integer> list8 = new ArrayList<>(Arrays.asList(2, 4, 3, 5, 6, 1, 9, 7, 8));
        List<Integer> list9 = new ArrayList<>(Arrays.asList(1, 9, 5, 2, 8, 7, 6, 3, 4));
        generalList.add(list1);
        generalList.add(list2);
        generalList.add(list3);
        generalList.add(list4);
        generalList.add(list5);
        generalList.add(list6);
        generalList.add(list7);
        generalList.add(list8);
        generalList.add(list9);
        List<List<Integer>> generalList2 = new ArrayList<>();
        List<Integer> list2_1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2_2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        List<Integer> list2_3 = new ArrayList<>(Arrays.asList(9, 1, 2, 3));
        List<Integer> list2_4 = new ArrayList<>(Arrays.asList(4, 5, 6, 7));
        generalList2.add(list2_1);
        generalList2.add(list2_2);
        generalList2.add(list2_3);
        generalList2.add(list2_4);
        System.out.println("This sudoku(4*4) is correct: " + task3.validateStandardSudoku(generalList2));
        System.out.println("This sudoku(9*9) is correct: " + task3.validateStandardSudoku(generalList));

        System.out.println("_____Task_4_____");
        Task4 task4 = new Task4();
        task4.sortedShapesExample();
    }

}
