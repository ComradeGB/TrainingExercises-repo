public class Main {
    public static void main(String[] args) {
        int [] array1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 }; // Заданные данные 1 задачи
        int size = 8; // Заданные данные 2 задачи
        int [] array2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.print(" Результат 1 задачи \n");
        for (int element:changeArray(array1))  System.out.printf("%d  ",element); // Вывод результата 1 задачи
        System.out.print("\n \n Результат 2 задачи \n");
        for (int element:initializationArray(size))  System.out.printf("%d  ",element); // Вывод результата 2 задачи
        System.out.print("\n \n Результат 3 задачи \n");
        for (int element:increaseArray(array2))  System.out.printf("%d  ",element); // Вывод результата 3 задачи
        System.out.print("\n \n Результат 4 задачи \n");
        for (int[] array :createDoubleSquareDiagonalArray(size)){
            for (int element: array) System.out.printf("%d  ",element);System.out.println();} // Вывод результата 4 задачи
        System.out.print("\n \n Результат 5 задачи \n");
        outputMinMaxValueArray(size); // Вывод результата 5 задачи
        System.out.print("\n \n Результат 6 задачи \n");
        int [] array3 = new int [size]; //Задаём и инициализируем массив для проверки 6 задания
        for (int i=0; i < size; i++){
            array3[i] = (int) (Math.random()*10);
            System.out.printf("%d  ",array3[i]);
        }
        System.out.print(centerArray(array3)?"\nМассив имеет центр":"\nМассив не имеет центра");
        System.out.print("\n \n Результат 7 задачи \n");
        int [] array4 = new int [size]; //Задаём и инициализируем массив для проверки 6 задания
        int n = 4; //Задаем сдвиг элементов массива
        System.out.print("До ");
        for (int i=0; i < size; i++){
            array4[i] = (int) (Math.random()*10);
            System.out.printf("%d  ",array4[i]);
        }
        System.out.print("После ");
        for (int element:shiftArray(array4,n))  System.out.printf("%d  ",element); // Вывод результата 7 задачи


    }
    // Решение 1 задача
    private static int[] changeArray (int [] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1) {array[i] = 0;}
            else if (array[i] == 0) {array[i] = 1;}
        }
        return array;
    }
    // Решение 2 задача
    private static int [] initializationArray(int size){
        int [] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = i*3;
        }
        return array;
    }
    // Решение 3 задача
    private static int [] increaseArray (int [] array){
        for (int i=0; i < array.length; i++){
            if (array[i] < 6)
            array[i] = array[i] * 2;
        }
        return  array;
    }
    // Решение 4 задача
    private static int [][] createDoubleSquareDiagonalArray (int size){
        int [][] array = new int [size][size];
        for (int i=0; i < size; i++){
            array[i][i] = 1;
        }
        for (int i=0,j=size-1; i < size; i++,j--){
            array[i][j] = 1;
        }
        return  array;
    }
    // Решение 5 задача
    private static void outputMinMaxValueArray (int size){
        int [] array = new int [size];
        for (int i=0; i < size; i++){
            array[i] = (int) (Math.random()*100);
        }
        int min=array[0],max=array[0];
        for (int i=1; i < size; i++){
            if (array[i] > max)  max = array[i];
            if (array[i] < min)  min = array[i];
        }
        for (int element:array)  System.out.printf("%d  ",element);
        System.out.printf ("\nМинимальное значение - %d, Максимальное значение - %d",min,max);
    }
    // Решение 6 задача
    private static boolean centerArray (int [] array){
        int sum = 0;
        int middle = 0;
        boolean result = false;
        for (int i : array) {
            sum += i;
        }
        for (int i : array) {
            middle += i;
            sum -=i;
            if (middle == sum) result = true;
        }
        return result;
    }
    // Решение 7 задачи
    private static int [] shiftArray (int [] array, int n){
        if(n != 0){
            if (n > array.length)  n = Math.abs(n % array.length);
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    int buffer = array[0];
                    array[0] = array[array.length - 1];
                    for (int j = 1; j < array.length - 1; j++) {
                        array[array.length - j] = array[array.length - j - 1];
                    }
                    array[1] = buffer;
                }
            }
            else if (n < 0) {
                for (int i = 0; i > n; i--) {
                    int buffer = array[array.length - 1];
                    array[array.length - 1] = array[0];
                    for (int j = 1; j < array.length - 1; j++) {
                        array[j - 1] = array[j];
                    }
                    array[array.length - 2] = buffer;
                }
            }
        }
        return array;}
}
