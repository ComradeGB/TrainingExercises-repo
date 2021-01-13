package gb;

public class Main {

    public static void main(String[] args) {
        Date d1 = new Date(1,"2");
        int [] arrayInt = {1,2,3,4,5,6,1};
        String [] arrayString = {"1","2","3","442"};
        long startTime = System.nanoTime();
        d1.searchInt(arrayInt);
        d1.searchString(arrayString);
        long endTime = System.nanoTime();
        long time =endTime - startTime;
        System.out.println("\nВремя выполнения операций сравнения "+time+" нс");

    }
}

class Date {
    private int primitive;
    String reference;

    public Date(int primitive, String reference) {
        this.primitive = primitive;
        this.reference = reference;
    }

    public void printOut (){
        System.out.println("Объект хранит примитивные данные "+ primitive);
        System.out.println("Объект хранит ссылочный тип данных "+ reference);
    }

    public void searchInt (int [] arrayInt){
        int j = 0;
        for (int i = 0; i < arrayInt.length; i++ ){
            if (arrayInt [i] == primitive){
                System.out.printf("\nЭлемент с индексом %d совпадает с примитивными данными хранящимся в объекте", i);
                j++;
            }
        }
        if (j == 0) System.out.println("\nВ массиве нет элементов равных примитивными данным хранящимся в объекте");
    }

    public void searchString (String [] arrayString){
        int j = 0;
        for (int i = 0; i < arrayString.length; i++ ){
            if (arrayString [i].equals(reference)){
                System.out.printf("\nЭлемент с индексом %d совпадает с ссылочными данными хранящимся в объекте", i);
                j++;
            }
        }
        if (j == 0) System.out.println("\nВ массиве нет элементов равных ссылочными данным хранящимся в объекте");
    }
}
