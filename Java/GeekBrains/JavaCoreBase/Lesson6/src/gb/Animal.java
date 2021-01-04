package gb;

public  class Animal implements Move{
    private int maxRunningDistance;
    private int maxSwimmingDistance;
    private int maxJumpHeight;

    public Animal(int maxRunningDistance, int maxSwimmingDistance, int maxJumpHeight) {
        this.maxRunningDistance = maxRunningDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        this.maxJumpHeight = maxJumpHeight;
    }
    public void doing (String method,int distance,Object o){

        int maxDistance = 0;

        switch (method){
            case "run": maxDistance = maxRunningDistance; break;
            case "swim": maxDistance = maxSwimmingDistance; break;
            case "jump": maxDistance = maxJumpHeight; break;
        }

     if (o instanceof Cat)
            System.out.printf("Результат выполнения котом команды %s - команда %s",
                  method,
                    ((distance <= maxDistance) ? "возможна" : "невозможна"));
     if (o instanceof Dog)
            System.out.printf("Результат выполнения собаки команды %s - команда %s",
                    method,
                    ((distance <= maxDistance) ? "возможна" : "невозможна"));
    }
}

class Dog extends Animal{

    public Dog(int maxRunningDistance, int maxSwimmingDistance, int maxJumpHeight) {
        super(maxRunningDistance, maxSwimmingDistance, maxJumpHeight);
    }
}

class Cat extends Animal{
    public Cat(int maxRunningDistance, int maxSwimmingDistance, int maxJumpHeight) {
        super(maxRunningDistance, maxSwimmingDistance, maxJumpHeight);
    }
}

