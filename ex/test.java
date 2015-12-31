public class test
{
    public static void main(String[] args) {
        int n = 5;
        System.out.println(n);
        func(n);
        System.out.println(n);
    }

    static void func(int n) {
        n++;
    }
}
