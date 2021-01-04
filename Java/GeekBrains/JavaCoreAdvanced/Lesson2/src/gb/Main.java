package gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void twoDimensioalArray (String [][] array ) throws MyArraySizeException{
        int sum = 0;

        try {
        if (array.length == 2 && array[0].length == 2 ){
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 2; j++){
                    try{
                    sum += Integer.parseInt(array[i][j]);}
                    catch (NumberFormatException e){
                        throw new MyArrayDataException (i,j);
                    }
                }
            }
            System.out.println("Сумма элементов массива равна "+sum);
        } else {
            throw new MyArraySizeException ();
        }}
        catch(MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            }
    }
    public static void main(String[] args) throws IOException, MyArraySizeException, MyArrayDataException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите N двухмерного массива N х N : ");
            int N = Integer.parseInt(reader.readLine());
            String [][] array = new String[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    System.out.printf("Введите элемент [%d][%d] массива: ",i,j);
                    array[i][j] = reader.readLine();
                }
            }

            twoDimensioalArray(array);

    }
}
