package stream;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("How are you?");
        list.add("Will you here tomorrow");
        list.add("Why did want to work here?");

       /* for (int i = 0; i < list.size(); i++) {
            list.set(i,String.valueOf(list.get(i).length()));
        }
        System.out.println(list);*/

        //проходит по списку и изменяем каждое значение на то, которое укажем
        List<Integer> list2 = list.stream()
                .map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println(list2);

        int[] array = {5, 9, 10, 8, 12, 18, 7};
        array = Arrays.stream(array)
                .map(element -> {
                    if (element % 3 == 0) {
                        element = element / 3;
                    }
                    return element;
                })
                .toArray();

        System.out.println(Arrays.toString(array));

        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("How are you?");
        set.add("Will you here tomorrow");
        set.add("Why did want to work here?");


        Set <Integer> set2 = set.stream()
                .map(element->element.length())
                .collect(Collectors.toSet());

        List <Integer> list3 = set.stream()
                .map(element->element.length())
                .collect(Collectors.toList());

        System.out.println(set2);


    }
}
