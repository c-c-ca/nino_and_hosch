package simplePackage;

public class SimpleProgram {
    public static void main (String[] argv) {
        Parent p1 = new Parent();
        Parent p2 = new Child();
        System.out.println(p1.getClass().getName());
        System.out.println(p2.getClass().getName());
    }
}
