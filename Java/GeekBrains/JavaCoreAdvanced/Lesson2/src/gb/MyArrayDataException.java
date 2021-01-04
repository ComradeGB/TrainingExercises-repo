package gb;

public class MyArrayDataException extends Throwable {
    private int i;
    private int j;
    public MyArrayDataException (int i, int j){
        this.i = i;
        this.j = j;
    }
    public void printStackTrace() {
        System.out.printf("В ячейки [%d][%d]  лежат неверные данные\n",this.i,this.j);
    }
}
