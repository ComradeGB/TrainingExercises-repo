package gb;

public class MyArraySizeException extends Throwable {
    @Override
    public void printStackTrace() {
        System.out.println("Введен не верный размер массива");
    }
}
