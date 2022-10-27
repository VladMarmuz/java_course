package generics;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class Wildcard {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();

        List<Double> list1 = new ArrayList<>();
        list1.add(2.2);
        list1.add(2.7);
        list1.add(3.2);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Good");
        list2.add("Bad");
        list2.add("Happiness");

        List<Double> list3 = new ArrayList<>();
        list3.add(2.2);
        list3.add(2.7);
        list3.add(3.2);
        System.out.println(sumAllElements(list3));
        
        List<Integer> list4 = new ArrayList<>();
        list4.add(22);
        list4.add(27);
        list4.add(32);
        System.out.println(sumAllElements(list4));

    }

    static void showListInfo(List<?> list){
        System.out.println("My list include the next elements "+ list);
    }

    public static double sumAllElements(List<? extends Number> list){
        double sum = 0;

        for(Number el: list){
            sum+= el.doubleValue();
        }
        return sum;
    }

}


