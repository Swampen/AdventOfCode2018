package Input;

import java.util.ArrayList;
import java.util.Scanner;

public class Inputs {

    public static ArrayList<String> getDay01(){
            Scanner scanner = new Scanner(Inputs.class.getResourceAsStream("/day_01.txt"));
            ArrayList<String> input = new ArrayList<>();
            while (scanner.hasNextLine()){
                input.add(scanner.nextLine());
            }
            return input;

    }
}
