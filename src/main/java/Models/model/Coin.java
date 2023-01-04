package Models.model;



public class Coin {
    private String name;
    private int val;
    double diameter;

    public Coin(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public String getName(){
        return name;
    }
    public int getVal() {
        return val;
    }

    public double getDiameter() {
        return diameter;
    }

}
