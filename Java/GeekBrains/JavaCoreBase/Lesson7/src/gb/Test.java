package gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Введите количество голодных котиков:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Cat [] cats = new Cat[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < cats.length; i++){
                System.out.printf("Назовите имя %d котика: ",i+1);
                String name = reader.readLine();
                System.out.print("Введите сколько он должен съесть чтобы насытиться: ");
                cats [i] = new Cat(name,Integer.parseInt(reader.readLine()));
        }
        Plate plate = new Plate();
        while (true) {
            System.out.println("Введите сколько насыпать еды");
            plate.addFoot(Integer.parseInt(reader.readLine()));
            for (Cat i : cats)
            {
                i.eat(plate);
                plate.printInfo();
            }
            System.out.println("Если хотите выйти введите exit,если хотите продолжить просто нажмите enter");
            if (reader.readLine().equals("exit")) break;
        }
    }
}