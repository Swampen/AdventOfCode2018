package Day_02;

import Input.Inputs;

import java.util.ArrayList;
import java.util.Arrays;

public class Stars_02 {
    public static void main(String[] args) {
        ArrayList<String> input = Inputs.getDay02();

        String[] s = {"abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"};
        ArrayList<String> test = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            test.add(s[i]);
        }

        int checksum = findChecksum(input);
        System.out.println("The checksum is: " + checksum);
        String commonletters = findCommonLettersIDbox(input);
        System.out.println("The common letters are: " + commonletters);
    }

    private static String findCommonLettersIDbox(ArrayList<String> input) {
        for (int i = 0; i < input.size(); i++) {
            char[] first = input.get(i).toCharArray();
            for (int i1 = i; i1 < input.size(); i1++) {
                char[] second = input.get(i1).toCharArray();
                int notEqual = 0;
                int index = 0;
                for (int j = 0; j < first.length; j++) {
                    if (notEqual > 1){
                        break;
                    }
                    if (first[j] != second[j]){
                        notEqual++;
                        index = j;
                    }
                }
                if (notEqual == 1){
                    StringBuilder s = new StringBuilder();
                    for (int j = 0; j < first.length; j++) {
                        if (j != index){
                            s.append(first[j]);
                        }
                    }
                    return s.toString();
                }
            }
        }

        return "wrong";
    }

    private static int findChecksum(ArrayList<String> input) {
        int twos = findExactTwo(input);
        int threes = findExactThree(input);
        System.out.println("Twos: " + twos + "\nThrees: " + threes);
        return twos * threes;
    }

    private static int findExactThree(ArrayList<String> input) {
        int threes = 0;
        for (int i = 0; i < input.size(); i++) {
            char[] c = input.get(i).toCharArray();
            Arrays.sort(c);
            int counter = 1;
            for (int j = 0; j < c.length-1; j++){
                if (c[j] == c[j+1]){
                    counter++;
                    if (j == c.length-2 && counter == 3){
                        threes++;
                    }
                }else if (counter != 3){
                    counter = 1;
                }else if (counter == 3){
                    threes++;
                    break;
                }
            }
        }

        return threes;
    }

    private static int findExactTwo(ArrayList<String> input) {
        int twos = 0;
        for (int i = 0; i < input.size(); i++) {
            char[] c = input.get(i).toCharArray();
            Arrays.sort(c);
            int counter = 1;
            for (int j = 0; j < c.length-1; j++){
                if (c[j] == c[j+1]){
                    counter++;
                    if (j == c.length-2 && counter == 2){
                        twos++;
                    }
                }else if (counter != 2){
                    counter = 1;
                }else if (counter == 2){
                    twos++;
                    break;
                }
            }
        }
        return twos;
    }
}
