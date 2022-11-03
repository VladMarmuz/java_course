package stream.methods;

import java.util.stream.Stream;

public class DistinctAndCountExample {
    public static void main(String[] args) {
        Stream<Integer> str1= Stream.of(1,2,3,4,5,3,6,4,2);
        Stream<Integer> str2= Stream.of(1,2,3,4,5,3,6,4,2);
        Stream<Integer> str3= Stream.of(1,2,3,4,5,3,6,4,2);

     /** Stream нельзя переиспользовать(поэотому для каждого метода создали разные стримы*/

        //count - считает колличество элементов в стриме и возвращает long
        System.out.println(str1.count());

        // distinct - подсчитывает только уникальные значения
        str2.distinct().forEach(System.out::println);

        //peek - работает, как forEach, только возвращает Stream
        long count = str3.distinct().peek(System.out::println).count();
        System.out.println(count);

    }
}
