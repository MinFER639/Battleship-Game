package battleship;

public class Ship {
    String name;
    int size;
    String shipType;
    int[] coorOfShip;

    public String getShipType() {
        return shipType;
    }

    public Ship(String name, int size){
        this.name=name;
        this.size=size;
    }

    public int[] getCoorOfShip() {
        return coorOfShip;
    }


    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public void setCoorOfShip(int[] coorOfShip) {
        this.coorOfShip = coorOfShip;
    }

}
