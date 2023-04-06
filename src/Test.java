public class Test {
    int a;
    int b;
    boolean c = false;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public boolean isC() {
        return c;
    }
}
