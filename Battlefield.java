package battleship;

import java.util.Arrays;

public class Battlefield {


    public static String[][] createBattlefield() {
        String[][] battlefield = new String[11][11];
        battlefield[0][0] = " ";

        for (int i = 1; i <= 10; i++) {
            battlefield[i][0] = String.valueOf((char) (i + 64));
            for (int j = 1; j <= 10; j++) {
                battlefield[0][j] = String.valueOf(j);
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                battlefield[i][j] = "~";
            }
        }
        return battlefield;
    }

    public static void displayBattlefield(String[][] battlefield, boolean withSpace) {
        if (!withSpace) {
            for (String[] strings : battlefield) {
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println();
            for (String[] strings : battlefield) {
                for (String string : strings) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        }
    }

    public static int numOfHitShip(String[][] battlefield){
        int counter = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (battlefield[i][j].equals("X")) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void modifyfBattlefield(Ship ship, int[] coordinates, String[][] battlefield) {
        int[] coordinatesA = Arrays.copyOfRange(coordinates, 0, 2);
        int[] coordinatesB = Arrays.copyOfRange(coordinates, 2, 4);

        int counter1 = 0;
        for (int i = coordinatesA[0]; i <= coordinatesB[0]; i++) {
            for (int j = coordinatesA[1]; j <= coordinatesB[1]; j++) {
                counter1++;
            }
        }

        if (counter1 != ship.size) {
            throw new IllegalArgumentException(String.format("\nError! Wrong length of the %s! Try again:", ship.name));
        } else if (coordinatesA[0] == coordinatesB[0]) {
            ship.setShipType("horizontal");
            int[] newCoordinates = new int[ship.size + 1];
            newCoordinates[0] = coordinatesA[0];
            newCoordinates[1] = coordinatesA[1];
            int val = coordinatesA[1];
            for (int i = 2; i < newCoordinates.length; i++) {
                val++;
                newCoordinates[i] = val;
            }
            ship.setCoorOfShip(newCoordinates);

        } else if (coordinatesA[1] == coordinatesB[1]) {
            ship.setShipType("vertical");
            int[] newCoordinates = new int[ship.size + 1];
            newCoordinates[0] = coordinatesA[1];
            newCoordinates[1] = coordinatesA[0];
            int val = coordinatesA[0];
            for (int i = 2; i < newCoordinates.length; i++) {
                val++;
                newCoordinates[i] = val;
            }
            ship.setCoorOfShip(newCoordinates);
        }

        if (ship.shipType.equals("horizontal")) {
            try {
                boolean st3 = battlefield[ship.coorOfShip[0] - 1][ship.coorOfShip[1] - 1].equals("O");

                if (st3) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[0]][ship.coorOfShip[1] - 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[0] + 1][ship.coorOfShip[1] - 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                }
            } catch (IndexOutOfBoundsException e) {
                e.getLocalizedMessage();
            }

            try {
                boolean st6 = battlefield[ship.coorOfShip[0] - 1][ship.coorOfShip[ship.coorOfShip.length - 1] + 1].equals("O");

                if (st6) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[0]][ship.coorOfShip[ship.coorOfShip.length - 1] + 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[0] + 1][ship.coorOfShip[ship.coorOfShip.length - 1] + 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                }
            } catch (IndexOutOfBoundsException e) {
                e.getLocalizedMessage();
            }

            try {
                for (int i = ship.coorOfShip[1]; i < ship.size; i++) {
                    boolean st2 = battlefield[ship.coorOfShip[0] - 1][i].equals("O");
                    if (st2) {
                        throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
                    }
                }
                for (int i = ship.coorOfShip[1]; i < ship.size; i++) {
                    boolean st1 = battlefield[ship.coorOfShip[0] + 1][i].equals("O");
                    if (st1) {
                        throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                e.getLocalizedMessage();
            }
        } else {
            try {
                boolean st3 = battlefield[ship.coorOfShip[1] - 1][ship.coorOfShip[0] - 1].equals("O");

                if (st3) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[1]][ship.coorOfShip[0] - 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[1] + 1][ship.coorOfShip[0] - 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                }
            } catch (IndexOutOfBoundsException e) {
                e.getLocalizedMessage();
            }

            try {
                boolean st6 = battlefield[ship.coorOfShip[ship.coorOfShip.length - 1] + 1][ship.coorOfShip[0] - 1].equals("O");

                if (st6) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[ship.coorOfShip.length - 1] + 1][ship.coorOfShip[0]].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                } else if (battlefield[ship.coorOfShip[ship.coorOfShip.length - 1] + 1][ship.coorOfShip[0] + 1].equals("O")) {
                    throw new IllegalArgumentException("\nError! You placed it too close to another one. Try again:");
                }
            } catch (IndexOutOfBoundsException e) {
                e.getLocalizedMessage();
            }


            for (int i = ship.coorOfShip[1]; i < ship.size; i++) {
                if (battlefield[i][ship.coorOfShip[0] + 1].equals("0") || battlefield[ship.coorOfShip[0] - 1][i].equals("O")) {
                    throw new IllegalArgumentException("Error! You placed it too close to another one. Try again:");
                }
            }
        }

        for (int i = coordinatesA[0]; i <= coordinatesB[0]; i++) {
            for (int j = coordinatesA[1]; j <= coordinatesB[1]; j++) {
                battlefield[i][j] = "O";
            }
        }


    }


}

