package gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int [] parametrCat = inputParameters("кота");
        Cat cat = new Cat(parametrCat[0],parametrCat[1],parametrCat[2]);
        int [] parametrDog = inputParameters("собаки");
        Dog dog = new Dog(parametrDog[0],parametrDog[1],parametrDog[2]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){

        System.out.println("\nВведите для кота команду для бега - run, для плавания - swim, для прыжков - jump, для выхода из программы - exit");
        String command = reader.readLine();
        if (command.equals("exit")) break;
        System.out.println("Введите параметр комманды");
        cat.doing(command,Integer.parseInt(reader.readLine()),cat);

        System.out.println("\nВведите для собаки команду для бега - run, для плавания - swim, для прыжков - jump, для выхода из программы - exit");
        command = reader.readLine();
        if (command.equals("exit")) break;
        System.out.println("Введите параметр комманды");
        dog.doing(command,Integer.parseInt(reader.readLine()),dog);
        }
    }

    public static int [] inputParameters(String name){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Введите возможности %s \nВведите максимально возможную беговую дистанцию: ",name);
        int [] parametrs = new int[3];
        try {
            parametrs[0] = Integer.parseInt(reader.readLine());
            System.out.print("Введите максимально возможную дистанцию заплыва: ");
            parametrs[1] = Integer.parseInt(reader.readLine());
            System.out.print("Введите максимально возможную высоту прыжка: ");
            parametrs[2] = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parametrs;
    }
}
