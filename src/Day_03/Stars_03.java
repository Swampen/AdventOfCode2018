package Day_03;

import Input.Inputs;

import java.util.ArrayList;
import java.util.Arrays;

public class Stars_03 {

    public static void main(String[] args) {
        ArrayList<Integer[]> input = Inputs.getDay03();
        int[] maxSize = findMaxSize(input);
        int[][] map = new int[maxSize[1]][maxSize[0]];

        System.out.println("Square inches of fabric are within two or more claims: " + mapping(map, input));

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println("Field that still stay intact after all the claims: " + mappingCheck(map, input));


    }

    private static int mappingCheck(int[][] map, ArrayList<Integer[]> input) {

        int nonOverlappingField = 0;
        int field = 0;
        h:for (Integer[] in : input) {
            field++;
            System.out.println(Arrays.toString(in));
            int fromX = in[0];
            int fromY = in[1];
            int toX = fromX+in[2];
            int toY = fromY+in[3];


            for (int i = fromY; i < toY; i++) {
                for (int j = fromX; j < toX; j++) {
                    if (map[i][j] != field) {
                        continue h;
                    }
                }
            }
            nonOverlappingField = field;
        }

        return nonOverlappingField;
    }

    private static int mapping(int[][] map, ArrayList<Integer[]> input) {
        int counter = 0;
        int field = 0;
        for (Integer[] in : input) {
            field++;
            System.out.println(Arrays.toString(in));
            int fromX = in[0];
            int fromY = in[1];
            int toX = fromX+in[2];
            int toY = fromY+in[3];


            for (int i = fromY; i < toY; i++) {
                for (int j = fromX; j < toX; j++) {
                    if (map[i][j] != 0){
                        map[i][j] = -1;
                        counter++;
                    }else if (map[i][j] == 0){
                        map[i][j] = field;
                    }
                }
            }
        }
        return counter;
    }

    private static int[] findMaxSize(ArrayList<Integer[]> input) {
        int maxX = 0;
        int maxY = 0;
        for (Integer[] integers : input) {
            int x = integers[0] + integers[2];
            int y = integers[1] + integers[3];
            if (x > maxX) maxX = x;
            if (y > maxY) maxY = y;
        }
        int[] max = {maxX, maxY};
        return max;
    }
}
