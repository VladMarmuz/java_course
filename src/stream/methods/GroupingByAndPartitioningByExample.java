package stream.methods;

import stream.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByAndPartitioningByExample {
    public static void main(String[] args) {
        Student st1 = new Student("Vlad",'m',18,2,7.8);
        Student st2 = new Student("Egor",'m',22,4,8.3);
        Student st3 = new Student("Nikita",'m',18,1,7.1);
        Student st4 = new Student("Ivan",'m',19,2,9.4);
        Student st5 = new Student("Misha",'m',21,3,6.5);
        List<Student> students = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students2.add(st1);
        students2.add(st2);
        students2.add(st3);
        students2.add(st4);
        students2.add(st5);

        Map<Integer, List<Student>> collectionsMap = students.stream()
                .map(element -> {
                    element.setName(element.getName().toUpperCase());
                    return element;
                })

                // метод groupingBy - группирует по какому-то полю и возрващает мапу с нескольким колиичеством сгруппированных листов
                //т.е. используем, когда нужно сгруппировать и разделить в разные списки
                .collect(Collectors.groupingBy(element -> element.getCourse()));

        for(Map.Entry<Integer,List<Student>> map: collectionsMap.entrySet()){
            System.out.println(map.getKey() +" : "+  map.getValue().toString());
        }

       //делит коллекцию на 2 листа по сравнения( элементы, которые удовлетворяют сравнению- заносят в лист true, Другие -  в лист false
        Map<Boolean, List<Student>> listMap = students2.stream()
                .collect(Collectors.partitioningBy(el -> el.getAvgGrd() > 8));

        for(Map.Entry<Boolean,List<Student>> element: listMap.entrySet()){
            System.out.println(element.getKey()+" : "+ element.getValue().toString());
        }


    }
}
