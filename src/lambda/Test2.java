package lambda;

public class Test2 {
    public static void main(String[] args) {

        def(s -> s.length());

    }

    static void def(I i) {
        System.out.println(i.abc("Hello"));
    }
}

interface I {
    int abc(String s);
}
