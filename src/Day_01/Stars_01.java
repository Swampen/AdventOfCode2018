package Day_01;

import Input.Inputs;

import java.util.ArrayList;

public class Stars_01 {
    public static void main(String[] args) {
        ArrayList<String> input = Inputs.getDay01();

        int frequency = findFrequency(input);
        System.out.println("The frequency after the input is: " + frequency);
        int twiceFrequency = findTwiceFrequency(input);
        System.out.println("The frequency seen twice is: " + twiceFrequency);
    }

    private static int findFrequency(ArrayList<String> input) {
        int baseFrequency = 0;
        for (int i = 0; i < input.size(); i++) {
            String addition = input.get(i).substring(0, 1);
            int frequency = Integer.parseInt(input.get(i).substring(1));
            if (addition.equals("+")){
                baseFrequency += frequency;
            }else {
                baseFrequency -= frequency;
            }
        }

        return baseFrequency;
    }

    //takes some time
    private static int findTwiceFrequency(ArrayList<String> input) {
        int baseFrequency = 0;
        ArrayList<Integer> seen = new ArrayList<>();

        for (int i = 0; !seen.contains(baseFrequency); i++) {
            seen.add(baseFrequency);
            String addition = input.get(i%input.size()).substring(0, 1);
            int frequency = Integer.parseInt(input.get(i%input.size()).substring(1));

            if (addition.equals("+")){
                baseFrequency += frequency;
            }else {
                baseFrequency -= frequency;
            }
        }

        return baseFrequency;
    }
}
