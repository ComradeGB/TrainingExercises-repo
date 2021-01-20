package gb;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float [] arr = new float [size];
    {
        for (int i = 0; i < size; ) {
            arr[i] = 1.0F;
        }
    }

    public static void method1 () {

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++){
            arr [i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Вреся выполнения метода 1: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void method2 () {
        float a1 [] = new float[h];
        float a2 [] = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        TwoMethods twoMethods1 = new TwoMethods(a1);
        TwoMethods twoMethods2 = new TwoMethods(a2);

        twoMethods1.start();
        twoMethods2.start();

        a1 = twoMethods1.getA();
        a2 = twoMethods2.getA();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Вреся выполнения метода 2: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void main(String[] args) {
	// write your code here
        method1();
        method2();
    }
}

class TwoMethods extends Thread{

    private float [] a;

    public TwoMethods (float a []){
        this.a = a;
    }

    public void run (){
        for (int i = 0; i < a.length; i++){
            a [i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getA() {
        return a;
    }
}