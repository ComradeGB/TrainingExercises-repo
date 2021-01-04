package gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] standardArray = new String[10];


    static {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            standardArray[i] = String.valueOf((random.nextInt(5)));
        }
    }

    public static String[] createArray() throws IOException {

        int size;
        while (true) {
            System.out.print("Введите желаемое количество слов в массиве от 10 до 20 - ");
            size = Integer.parseInt(reader.readLine());
            if (size >= 10 && size <= 20) {
                break;
            }
            System.out.println("Не верно указан размер массива.");
        }

        String[] userArray = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Введите элемент "+(i+1) +" : ");
            userArray[i] = reader.readLine();
        }
        return userArray;
    }

    public static List<String> uniqueArray(String[] array) {
        List<String> list = new ArrayList<>();
        for (String s : array) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static Map<String, Integer> quantifyWords(String[] array) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String i : uniqueArray(array)) {
            int quantify = 0;
            for (String j : array) {
                if (i.equals(j)) {
                    quantify++;
                }
            }
            hashMap.put(i, quantify);
        }
        return hashMap;
    }

    public static void main(String[] args) throws IOException {

        String [] array;
        System.out.print("Если хотите ввести массив самостоятельно введите +, для выбора  стандартного массива - : ");
        while (true){
        String choose = reader.readLine();

        if (choose.equals("+")){
            array = createArray();
            break;
        }else if (choose.equals("-")){
            array = standardArray;
            break;
        }
        }

        System.out.print("Начальный массив : \n");
        for (String i : array)
            System.out.print(i + " ");
        System.out.print("\nУникальный лист полученный из массива : \n");
        for (String i : uniqueArray(array))
            System.out.print(i + " ");
        System.out.print("\nКоличество уникальных слов : \n");
        for (Map.Entry<String, Integer> i : quantifyWords(array).entrySet()) {
            System.out.printf("Слово: %s  Количество повторов: %d \n", i.getKey(), i.getValue());
        }
    }
}
