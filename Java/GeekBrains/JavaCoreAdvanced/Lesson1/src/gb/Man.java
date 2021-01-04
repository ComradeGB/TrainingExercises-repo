package gb;

public class Man implements Run,Jump {
private int  maxLength, maxHeight;
String name;

    public Man(int maxLength, int maxHeight, String name) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    @Override
    public boolean run(int length) {
        if (maxLength > length){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxHeight > height){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return  name ;
    }

}
