public class ExampleTest {

    static int a =  3;
    static int b;

    public static void main(String args[]){

        rtr();

        System.out.println(b);
        System.out.println(a);
        System.out.println(ExampleA.A(5,7));
        // (char)27 + "[31m"  в красный
        // (char)27 + "[0m" сбросить в стандарт
        System.out.println((char) 27 + "[31mWarning! " + (char)27 + "[0m");
        System.out.println("31mWarning! ");
    }

    public static void rtr(){
        b = ++a;

    }

}
