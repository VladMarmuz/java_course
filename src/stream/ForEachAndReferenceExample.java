package stream;

import java.util.Arrays;

public class ForEachAndReferenceExample {
    public static void main(String[] args) {
        int[] array = {5, 9, 10, 8, 12, 18, 7};

        //перебираем массив и умножаем каждое число на 2
        Arrays.stream(array).forEach(el-> {
            el*=2;
            System.out.println(el);
        });


        Arrays.stream(array).forEach(el-> System.out.println(el));
        Arrays.stream(array).forEach(System.out::println);

        Arrays.stream(array).forEach(element-> Utils.myMethod(element));
        //==
        Arrays.stream(array).forEach(Utils::myMethod);

    }

    class Utils{
        public static void myMethod(int a){
            a=a+5;
            System.out.println(a);
        }
    }
}


