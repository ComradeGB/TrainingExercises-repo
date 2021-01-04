package gb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List <Object> inputParticipants()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Объявление массива участников

        int N = 0;

        try {
            System.out.print("Введите количество участников: ");
            N = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List <Object> participants = new ArrayList<>();
        String className = "";
        int maxHeight = 0;
        int maxLength = 0;
        String name = "";
        for (int i = 0; i < N; i++){
            System.out.print("Введите тип участника (Man, Cat, Robot): ");
            try {
                className = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Введите имя участника: ");
            try {

                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Введите максимальную высоту его прыжка: ");
            try {
                maxHeight = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Введите максимальную дистанцию его бега: ");
            try {
                maxLength = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (className) {
                case "Man": participants.add(new Man(maxLength, maxHeight,name)); break;
                case "Cat": participants.add(new Man(maxLength, maxHeight,name)); break;
                case "Robot": participants.add(new Man(maxLength, maxHeight,name)); break;
            }
        }

        return participants;
    }

    public static List <Object> inputObstacles (){
        // Объявление массива препятствий
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = "";
        int height = 0;
        int length = 0;
        int N =0;

        try {
            System.out.print("\nВведите количество препятствий: ");
            N = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List <Object> obstacles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            System.out.print("Введите тип припятствия (Wall, Treadmill): ");
            try {
                className = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Введите параметр припятствия: ");
            try {
                height = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (className) {
                case "Wall":
                    obstacles.add(new Wall(height)); break;
                case "Treadmill":
                    obstacles.add(new Treadmill(length)); break;
            }
        }
        return obstacles;

    }

    public static void main(String[] args) {

        List <Object> participants = inputParticipants();
        List <Object> obstacles = inputObstacles();

        for (Object i : participants) {
                System.out.printf("\n\nПрепятствие начал проходить %s", i.toString());
            metka:
            {   int k=1;
                for (Object j : obstacles) {
                    if (j instanceof Wall) {
                        if (!((Jump) i).jump(((Wall) j).getHeight())) {
                            System.out.printf("\n%d препятствиe %s не перепрыгнул", k++,(i.toString()));
                            break metka;
                        } else {
                            System.out.printf("\n%d препятствие %s перепрыгнул",k++, (i.toString()));
                        }

                    } else if (j instanceof Treadmill) {
                        if (!((Run) i).run(((Treadmill) j).getLength())) {
                            System.out.printf("\n%d препятствие %s не пробежал",k++, (i.toString()));
                            break metka;
                        }else {
                            System.out.printf("\n%d препятствие %s пробежал",k++, (i.toString()));
                        }
                    }
                }
            }
        }
    }
}
