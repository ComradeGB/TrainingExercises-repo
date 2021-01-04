package gb;

public class Plate {

    private int food = 0;

    public void addFoot(int food) {
        this.food += food;
    }

    public int getFood() {
        return food;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\nВ тарелке " + food;
    }

    public void decreaseFood(int food) {
        this.food -= food;

    }

    public void increaseFood(int food) {
        this.food += food;

    }
}
