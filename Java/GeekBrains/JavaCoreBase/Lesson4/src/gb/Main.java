package gb;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char [][] map;
    public static int size;
    public static final char LABEL = 9733;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        size=levelSelection()+2;
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");

    }

    private static boolean checkWin(char symb) {

        for (int i = 0,quality1=0,quality2=0; i < size ; i++)
        {
            if (map[i][i]==symb){ //проверка одной диагонали
                quality1++;}
            if (map[i][(size-1)-i]==symb){ //проверка второй диагонали
                quality2++;}
            if (quality1 == size || quality2 == size) {return true;}
        }

        for (int i = 0; i < size ; i++) {
            for (int j = 0,quality1=0,quality2=0; j < size ; j++)  {
                if (map[i][j] == symb) { //проверка строчек
                    quality1++;
                }
                if (map[j][i] == symb) { //проверка столбцов
                    quality2++;
                }
                if (quality1 == size || quality2 == size) {return true;}
            }
        }

        return false;
    }

    private static int levelSelection() {
        System.out.println("Добро пожаловать в игру крестики нолики !\n " +
                "Выбирете один из уровней игры, путем ввода числа от 1 до 3:\n" +
                " 1. 3 x 3 \n 2. 4 x 4 \n 3. 5 x 5 \nВвод числа: ");
        int level;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Введите число от 1 до 3");
                scanner.nextLine();
                continue;
            }
            level = scanner.nextInt();
            if (level >= 1 && level <= 3) {
                    break;
            }else {
                scanner.nextLine();
                System.out.println("Введите число от 1 до 3");}
        }
        return level;
    }

    private static void printMap(){
        System.out.print(LABEL+" ");

        for (int i = 1; i <= size; i++){
            System.out.print(i+" ");
        }

        for (int i = 0; i < size; i++){
            System.out.print("\n"+(i+1)+" ");
            for (int j = 0; j < size; j++){
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void initMap(){
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void humanTurn() {
        System.out.println("\nХод игрока:");
        int x = -1,y=-1;
        do {
            System.out.println("Введите координаты X и Y выбранной ячейки:");
            if (!scanner.hasNextInt()) {
                System.out.println("Первый символ не является числом, попробуйте заново");
                scanner.nextLine();
                continue;
            }
            x = scanner.nextInt()-1;
            if (!scanner.hasNextInt()) {
                System.out.println("Второй символ не является числом, попробуйте заново");
                scanner.nextLine();
                scanner.nextLine();
                continue;
            }
            y = scanner.nextInt()-1;
        }while(!isCellValid(x,y));
        map[y][x] = DOT_X;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y){
        if (x < 0 || x >= size || y < 0 || y >= size){
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
