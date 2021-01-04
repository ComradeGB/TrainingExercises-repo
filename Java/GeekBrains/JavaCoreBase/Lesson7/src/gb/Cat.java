package gb;

import java.util.Random;

public class Cat {

    private String name;

    private int maxAmountEatenFood;
    private boolean satiety=false;

    public Cat(String name,int maxAmountEatenFood) {
        this.name = name;
        this.maxAmountEatenFood = maxAmountEatenFood;
    }
    public void eat(Plate plate) {
        if (satiety==true){
            System.out.printf("Кот %s уже сытый ", name);
        }
        else {
            if (maxAmountEatenFood <= plate.getFood()) {
                plate.decreaseFood(maxAmountEatenFood);
                satiety = true;
                System.out.printf("Кот %s сытый ", name);
            } else {
                System.out.printf("Кот %s остался голодный ", name);
            }
        }
    }
}
