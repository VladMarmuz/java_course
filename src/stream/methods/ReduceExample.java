package stream.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(4);
        list.add(2);
        list.add(8);

        // считаем произведение всех чисел из листа
        int result = list.stream()
                .reduce((accumulator,el)->accumulator*el).get();
        System.out.println(result);

        //Optional = испульзуем, когда результат может быть, а может быть равен 0
        Optional<Integer> list1 = list.stream()
                .reduce((accumulator,el)->accumulator*el);
        if (list1.isPresent()){
            System.out.println(list1);
        }else System.out.println("No such value");




        List<String>stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("How are you?");
        stringList.add("Will you here tomorrow");
        stringList.add("Why did want to work here?");

        String resultString = stringList.stream().reduce((a,e)-> a+" "+e).get();
        System.out.println(resultString);
    }
}
