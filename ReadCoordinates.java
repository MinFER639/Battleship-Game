package battleship;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadCoordinates {
    public static int[] readCoordinates() {
        System.out.println();
        String coo = Main.scanner.nextLine();
        if (coo.isEmpty()) {
            throw new IllegalArgumentException("\nError! No coordinates provided! Try again:");
        } else if (!Main.pattern.matcher(coo).matches()) {
            throw new IllegalArgumentException("\nError! Invalid format of coordinates! Try again:");
        } else {
            String[] words = coo.split("\\s+");
            int[] coordinates = new int[4];
            if(words[0].length() == 2 && words[1].length() == 2) {
                coordinates[0] = ((int) words[0].charAt(0)) - 64;
                coordinates[1] = ((int) words[0].charAt(1)) - 48;
                coordinates[2] = ((int) words[1].charAt(0)) - 64;
                coordinates[3] = ((int) words[1].charAt(1)) - 48;
            } else if (words[0].length() > 2 && words[1].length() == 2){
                coordinates[0] = ((int) words[0].charAt(0)) - 64;
                coordinates[1] = (((int) words[0].charAt(1)) - 48) + 9;
                coordinates[2] = ((int) words[1].charAt(0)) - 64;
                coordinates[3] = ((int) words[1].charAt(1)) - 48;
            } else if (words[1].length() > 2 && words[0].length() == 2){
                coordinates[0] = ((int) words[0].charAt(0)) - 64;
                coordinates[1] = ((int) words[0].charAt(1)) - 48;
                coordinates[2] = ((int) words[1].charAt(0)) - 64;
                coordinates[3] = (((int) words[1].charAt(1)) - 48) + 9;
            } else if (words[0].length() > 2 && words[1].length() > 2) {
                coordinates[0] = ((int) words[0].charAt(0)) - 64;
                coordinates[1] = (((int) words[0].charAt(1)) - 48) + 9;
                coordinates[2] = ((int) words[1].charAt(0)) - 64;
                coordinates[3] = (((int) words[1].charAt(1)) - 48) + 9;
            }

            boolean statment1 = coordinates[0] == coordinates[2];
            boolean statment2 = coordinates[1] == coordinates[3];
            if (statment1 || statment2) {
                int[] coordinatesA = Arrays.copyOfRange(coordinates, 0, 2);
                int[] coordinatesB = Arrays.copyOfRange(coordinates, 2, 4);
                int[] startPoint;
                int[] endPoint;
                if(arraySum(coordinatesA) < arraySum(coordinatesB)){
                    startPoint = coordinatesA;
                    endPoint = coordinatesB;
                } else {
                    startPoint = coordinatesB;
                    endPoint = coordinatesA;
                }
                coordinates = new int[]{startPoint[0], startPoint[1], endPoint[0], endPoint[1]};
                return coordinates;
            } else {
                throw new IllegalArgumentException("\nError! Wrong ship location! Try again:");
            }
        }
    }

    public static int arraySum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static int[] readCoordinatesOfShot() {
        System.out.println();
        String coo = Main.scanner.nextLine();
        if (coo.isEmpty()) {
            throw new IllegalArgumentException("\nError! No coordinates provided! Try again:");
        } else if (!Main.pattern2.matcher(coo).matches()) {
            throw new IllegalArgumentException("\nError! Invalid format of coordinates! Try again:");
        } else {
            if(coo.length() == 2) {
                int checkXCoor = coo.charAt(0);
                int checkYCoor = coo.charAt(1);
                if (checkXCoor > 74) {
                    throw new IllegalArgumentException("\nError! You entered wrong coordinates! Try again:");
                } else {
                    return new int[]{checkXCoor - 64,checkYCoor - 48};
                }
            } else if (coo.length() > 2){
                int checkXCoor = coo.charAt(0);
                int checkYCoor = ((int) coo.charAt(1)) - 48;
                int checkYCoorPt2 = ((int) coo.charAt(2)) - 48;
                if (checkXCoor > 74 || checkYCoorPt2 != 0) {
                    throw new IllegalArgumentException("\nError! You entered wrong coordinates! Try again:");
                } else {
                    return new int[]{checkXCoor - 64,10};
                }
            } else {
                throw new IllegalArgumentException("\nError! You entered wrong coordinates! Try again:");
            }
        }
    }
}
