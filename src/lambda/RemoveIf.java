package lambda;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Good day");
        list.add("Why do you need to learn Java language? ");
        list.add("I'm sure that I will become a very good specialist");
        list.add("How are you?");
        list.add("How did you write it?");

        list.removeIf(el-> el.length()>30);
        System.out.println(list);
    }
}
