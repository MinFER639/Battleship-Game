package battleship;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static Pattern pattern = Pattern.compile("([A-J]([1-9]|10)\\s[A-J]([1-9]|10))");
    final static Pattern pattern2 = Pattern.compile("([A-Z]([1-9]|10))");
    static int[] coordinates = new int[4];
    static int[] coordinatesOfShot = new int[2];
    public static String[][] battlefieldPlayer1 = new String[11][11];
    public static String[][] battlefieldPlayer2 = new String[11][11];
    public static String[][] fogOfWarPlayer1 = new String[11][11];
    public static String[][] fogOfWarPlayer2 = new String[11][11];

    public static Ship aicraftP1 = new Ship("Aircraft Carrier", 5);
    public static Ship battleP1 = new Ship("Battleship", 4);
    public static Ship submP1 = new Ship("Submarine", 3);
    public static Ship cruiP1 = new Ship("Cruiser", 3);
    public static Ship destP1 = new Ship("Destroyer", 2);

    public static Ship aicraftP2 = new Ship("Aircraft Carrier", 5);
    public static Ship battleP2 = new Ship("Battleship", 4);
    public static Ship submP2 = new Ship("Submarine", 3);
    public static Ship cruiP2 = new Ship("Cruiser", 3);
    public static Ship destP2 = new Ship("Destroyer", 2);

    public static boolean airStateP1 = false;
    public static boolean batStateP1 = false;
    public static boolean subStateP1 = false;
    public static boolean cruStateP1 = false;
    public static boolean desStateP1 = false;

    public static boolean airStateP2 = false;
    public static boolean batStateP2 = false;
    public static boolean subStateP2 = false;
    public static boolean cruStateP2 = false;
    public static boolean desStateP2 = false;

    public static void main(String[] args) {
        battlefieldPlayer1 = Battlefield.createBattlefield();
        battlefieldPlayer2 = Battlefield.createBattlefield();
        fogOfWarPlayer1 = Battlefield.createBattlefield();
        fogOfWarPlayer2 = Battlefield.createBattlefield();
        

        System.out.println("Player 1, place your ships on the game field");
        Battlefield.displayBattlefield(battlefieldPlayer1, true);

        addShipToBattlefield(aicraftP1, coordinates, battlefieldPlayer1);
        addShipToBattlefield(battleP1, coordinates, battlefieldPlayer1);
        addShipToBattlefield(submP1, coordinates, battlefieldPlayer1);
        addShipToBattlefield(cruiP1, coordinates, battlefieldPlayer1);
        addShipToBattlefield(destP1, coordinates, battlefieldPlayer1);

        promptEnterKey(true);

        System.out.println("Player 2, place your ships on the game field");
        Battlefield.displayBattlefield(battlefieldPlayer2, true);

        addShipToBattlefield(aicraftP2, coordinates, battlefieldPlayer2);
        addShipToBattlefield(battleP2, coordinates, battlefieldPlayer2);
        addShipToBattlefield(submP2, coordinates, battlefieldPlayer2);
        addShipToBattlefield(cruiP2, coordinates, battlefieldPlayer2);
        addShipToBattlefield(destP2, coordinates, battlefieldPlayer2);

        promptEnterKey(true);

        while (true) {
            try {
                displayPlayer1Console();
                promptEnterKey(false);
                displayPlayer2Console();
                promptEnterKey(false);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

    }


    public static void displayPlayer1Console() {
        Battlefield.displayBattlefield(fogOfWarPlayer1, true);
        System.out.println("---------------------");
        Battlefield.displayBattlefield(battlefieldPlayer1, false);

        System.out.println("\nPlayer 1, it's your turn:");

        try {
            coordinatesOfShot = ReadCoordinates.readCoordinatesOfShot();

            int[] coorAir = aicraftP2.getCoorOfShip();
            String typeAir = aicraftP2.getShipType();
            int[] coorAirRight;
            if (typeAir.equals("horizontal")) {
                coorAirRight = new int[]{coorAir[0], coorAir[1], coorAir[0], coorAir[2], coorAir[0], coorAir[3], coorAir[0], coorAir[4], coorAir[0], coorAir[5]};
            } else {
                coorAirRight = new int[]{coorAir[1], coorAir[0], coorAir[2], coorAir[0], coorAir[3], coorAir[0], coorAir[4], coorAir[0], coorAir[5], coorAir[0]};
            }
            int[] coorBat = battleP2.getCoorOfShip();
            String typeBat = battleP2.getShipType();
            int[] coorBatRight;
            if (typeBat.equals("horizontal")) {
                coorBatRight = new int[]{coorBat[0], coorBat[1], coorBat[0], coorBat[2], coorBat[0], coorBat[3], coorBat[0], coorBat[4]};
            } else {
                coorBatRight = new int[]{coorBat[1], coorBat[0], coorBat[2], coorBat[0], coorBat[3], coorBat[0], coorBat[4], coorBat[0]};
            }
            int[] coorSub = submP2.getCoorOfShip();
            String typeSub = submP2.getShipType();
            int[] coorSubRight;
            if (typeSub.equals("horizontal")) {
                coorSubRight = new int[]{coorSub[0], coorSub[1], coorSub[0], coorSub[2], coorSub[0], coorSub[3]};
            } else {
                coorSubRight = new int[]{coorSub[1], coorSub[0], coorSub[2], coorSub[0], coorSub[3], coorSub[0]};
            }
            int[] coorCru = cruiP2.getCoorOfShip();
            String typeCru = cruiP2.getShipType();
            int[] coorCruRight;
            if (typeCru.equals("horizontal")) {
                coorCruRight = new int[]{coorCru[0], coorCru[1], coorCru[0], coorCru[2], coorCru[0], coorCru[3]};
            } else {
                coorCruRight = new int[]{coorCru[1], coorCru[0], coorCru[2], coorCru[0], coorCru[3], coorCru[0]};
            }
            int[] coorDes = destP2.getCoorOfShip();
            String typeDes = destP2.getShipType();
            int[] coorDestRight;
            if (typeDes.equals("horizontal")) {
                coorDestRight = new int[]{coorDes[0], coorDes[1], coorDes[0], coorDes[2]};
            } else {
                coorDestRight = new int[]{coorDes[1], coorDes[0], coorDes[2], coorDes[0]};
            }

            if (battlefieldPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]].equals("O") || battlefieldPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]].equals("X")) {
                battlefieldPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]] = "X";
                fogOfWarPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]] = "X";
                int shipsHitted = Battlefield.numOfHitShip(battlefieldPlayer2);
                if (fogOfWarPlayer1[coorAirRight[0]][coorAirRight[1]].equals("X") && fogOfWarPlayer1[coorAirRight[2]][coorAirRight[3]].equals("X") && fogOfWarPlayer1[coorAirRight[4]][coorAirRight[5]].equals("X") && fogOfWarPlayer1[coorAirRight[6]][coorAirRight[7]].equals("X") && fogOfWarPlayer1[coorAirRight[8]][coorAirRight[9]].equals("X") && !airStateP2) {
                    airStateP2 = true;
                    if (airStateP2 && batStateP2 && subStateP2 && cruStateP2 && desStateP2) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer1[coorBatRight[0]][coorBatRight[1]].equals("X") && fogOfWarPlayer1[coorBatRight[2]][coorBatRight[3]].equals("X") && fogOfWarPlayer1[coorBatRight[4]][coorBatRight[5]].equals("X") && fogOfWarPlayer1[coorBatRight[6]][coorBatRight[7]].equals("X") && !batStateP2) {
                    batStateP2 = true;
                    if (airStateP2 && batStateP2 && subStateP2 && cruStateP2 && desStateP2) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer1[coorSubRight[0]][coorSubRight[1]].equals("X") && fogOfWarPlayer1[coorSubRight[2]][coorSubRight[3]].equals("X") && fogOfWarPlayer1[coorSubRight[4]][coorSubRight[5]].equals("X") && !subStateP2) {
                    subStateP2 = true;
                    if (airStateP2 && batStateP2 && subStateP2 && cruStateP2 && desStateP2) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer1[coorCruRight[0]][coorCruRight[1]].equals("X") && fogOfWarPlayer1[coorCruRight[2]][coorCruRight[3]].equals("X") && fogOfWarPlayer1[coorCruRight[4]][coorCruRight[5]].equals("X") && !cruStateP2) {
                    cruStateP2 = true;
                    if (airStateP2 && batStateP2 && subStateP2 && cruStateP2 && desStateP2) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer1[coorDestRight[0]][coorDestRight[1]].equals("X") && fogOfWarPlayer1[coorDestRight[2]][coorDestRight[3]].equals("X") && !desStateP2) {
                    desStateP2 = true;
                    if (airStateP2 && batStateP2 && subStateP2 && cruStateP2 && desStateP2) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                }  else {
                    System.out.println("\nYou hit a ship!");
                }
            } else {
                fogOfWarPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]] = "M";
                battlefieldPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]] = "M";
                System.out.println("\nYou missed!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void displayPlayer2Console() {
        Battlefield.displayBattlefield(fogOfWarPlayer2, true);
        System.out.println("---------------------");
        Battlefield.displayBattlefield(battlefieldPlayer2, false);

        System.out.println("\nPlayer 2, it's your turn:");

        try {
            coordinatesOfShot = ReadCoordinates.readCoordinatesOfShot();

            int[] coorAir = aicraftP1.getCoorOfShip();
            String typeAir = aicraftP1.getShipType();
            int[] coorAirRight;
            if (typeAir.equals("horizontal")) {
                coorAirRight = new int[]{coorAir[0], coorAir[1], coorAir[0], coorAir[2], coorAir[0], coorAir[3], coorAir[0], coorAir[4], coorAir[0], coorAir[5]};
            } else {
                coorAirRight = new int[]{coorAir[1], coorAir[0], coorAir[2], coorAir[0], coorAir[3], coorAir[0], coorAir[4], coorAir[0], coorAir[5], coorAir[0]};
            }
            int[] coorBat = battleP1.getCoorOfShip();
            String typeBat = battleP1.getShipType();
            int[] coorBatRight;
            if (typeBat.equals("horizontal")) {
                coorBatRight = new int[]{coorBat[0], coorBat[1], coorBat[0], coorBat[2], coorBat[0], coorBat[3], coorBat[0], coorBat[4]};
            } else {
                coorBatRight = new int[]{coorBat[1], coorBat[0], coorBat[2], coorBat[0], coorBat[3], coorBat[0], coorBat[4], coorBat[0]};
            }
            int[] coorSub = submP1.getCoorOfShip();
            String typeSub = submP1.getShipType();
            int[] coorSubRight;
            if (typeSub.equals("horizontal")) {
                coorSubRight = new int[]{coorSub[0], coorSub[1], coorSub[0], coorSub[2], coorSub[0], coorSub[3]};
            } else {
                coorSubRight = new int[]{coorSub[1], coorSub[0], coorSub[2], coorSub[0], coorSub[3], coorSub[0]};
            }
            int[] coorCru = cruiP1.getCoorOfShip();
            String typeCru = cruiP1.getShipType();
            int[] coorCruRight;
            if (typeCru.equals("horizontal")) {
                coorCruRight = new int[]{coorCru[0], coorCru[1], coorCru[0], coorCru[2], coorCru[0], coorCru[3]};
            } else {
                coorCruRight = new int[]{coorCru[1], coorCru[0], coorCru[2], coorCru[0], coorCru[3], coorCru[0]};
            }
            int[] coorDes = destP1.getCoorOfShip();
            String typeDes = destP1.getShipType();
            int[] coorDestRight;
            if (typeDes.equals("horizontal")) {
                coorDestRight = new int[]{coorDes[0], coorDes[1], coorDes[0], coorDes[2]};
            } else {
                coorDestRight = new int[]{coorDes[1], coorDes[0], coorDes[2], coorDes[0]};
            }

            if (battlefieldPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]].equals("O") || battlefieldPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]].equals("X")) {
                battlefieldPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]] = "X";
                fogOfWarPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]] = "X";
                int shipsHitted = Battlefield.numOfHitShip(battlefieldPlayer1);
               /* if (shipsHitted == 17) {
                    throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                } else */ if (fogOfWarPlayer2[coorAirRight[0]][coorAirRight[1]].equals("X") && fogOfWarPlayer2[coorAirRight[2]][coorAirRight[3]].equals("X") && fogOfWarPlayer2[coorAirRight[4]][coorAirRight[5]].equals("X") && fogOfWarPlayer2[coorAirRight[6]][coorAirRight[7]].equals("X") && fogOfWarPlayer2[coorAirRight[8]][coorAirRight[9]].equals("X") && !airStateP1) {
                    airStateP1 = true;
                    if (airStateP1 && batStateP1 && subStateP1 && cruStateP1 && desStateP1) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer2[coorBatRight[0]][coorBatRight[1]].equals("X") && fogOfWarPlayer2[coorBatRight[2]][coorBatRight[3]].equals("X") && fogOfWarPlayer2[coorBatRight[4]][coorBatRight[5]].equals("X") && fogOfWarPlayer2[coorBatRight[6]][coorBatRight[7]].equals("X") && !batStateP1) {
                    batStateP1 = true;
                    if (airStateP1 && batStateP1 && subStateP1 && cruStateP1 && desStateP1) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer2[coorSubRight[0]][coorSubRight[1]].equals("X") && fogOfWarPlayer2[coorSubRight[2]][coorSubRight[3]].equals("X") && fogOfWarPlayer2[coorSubRight[4]][coorSubRight[5]].equals("X") && !subStateP1) {
                    subStateP1 = true;
                    if (airStateP1 && batStateP1 && subStateP1 && cruStateP1 && desStateP1) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer2[coorCruRight[0]][coorCruRight[1]].equals("X") && fogOfWarPlayer2[coorCruRight[2]][coorCruRight[3]].equals("X") && fogOfWarPlayer2[coorCruRight[4]][coorCruRight[5]].equals("X") && !cruStateP1) {
                    cruStateP1 = true;
                    if (airStateP1 && batStateP1 && subStateP1 && cruStateP1 && desStateP1) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else if (fogOfWarPlayer2[coorDestRight[0]][coorDestRight[1]].equals("X") && fogOfWarPlayer2[coorDestRight[2]][coorDestRight[3]].equals("X") && !desStateP1) {
                    desStateP1 = true;
                    if (airStateP1 && batStateP1 && subStateP1 && cruStateP1 && desStateP1) {
                        throw new RuntimeException("\nYou sank the last ship. You won. Congratulations!");
                    } else {
                        System.out.println("\nYou sank a ship! Specify a new target:");
                    }
                } else {
                    System.out.println("\nYou hit a ship!");
                }
            } else {
                fogOfWarPlayer2[coordinatesOfShot[0]][coordinatesOfShot[1]] = "M";
                battlefieldPlayer1[coordinatesOfShot[0]][coordinatesOfShot[1]] = "M";
                System.out.println("\nYou missed!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addShipToBattlefield(Ship ship, int[] coordinates, String[][] battlefield) {
        displayCommand(ship);

        while (true) {
            try {
                coordinates = ReadCoordinates.readCoordinates();
                Battlefield.modifyfBattlefield(ship, coordinates, battlefield);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Battlefield.displayBattlefield(battlefield, true);
    }

    public static void displayCommand(Ship shortName) {
        System.out.printf("\nEnter the coordinates of the %s (%d cells)\n", shortName.name, shortName.size);
    }

    public static void promptEnterKey(boolean xddd) {
        if (xddd) {
            System.out.println("\nPress Enter and pass the move to another player");
        } else {
            System.out.println("Press Enter and pass the move to another player");
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
