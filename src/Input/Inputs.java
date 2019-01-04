package Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inputs {

    public static ArrayList<Integer[]> getDay03(){
        Scanner scanner = new Scanner(Inputs.class.getResourceAsStream("/day_03.txt"));
        ArrayList<Integer[]> input = new ArrayList<>();
        while (scanner.hasNextLine()){
            String s[] = scanner.nextLine().split(" ");
            String s1[] = s[2].split(",");
            String s2[] = s[3].split("x");
            Integer[] intArr = {Integer.parseInt(s1[0]),
                                Integer.parseInt(s1[1].substring(0, s1[1].length()-1)),
                                Integer.parseInt(s2[0]),
                                Integer.parseInt(s2[1])};
            input.add(intArr);
        }

        return input;
    }

    public static ArrayList<String> getDay02(){
        Scanner scanner = new Scanner(Inputs.class.getResourceAsStream("/day_02.txt"));
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNextLine()){
            input.add(scanner.nextLine());
        }
        return input;
    }

    public static ArrayList<String> getDay01(){
            Scanner scanner = new Scanner(Inputs.class.getResourceAsStream("/day_01.txt"));
            ArrayList<String> input = new ArrayList<>();
            while (scanner.hasNextLine()){
                input.add(scanner.nextLine());
            }
            return input;
    }


}
