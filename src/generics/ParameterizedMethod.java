package generics;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedMethod {
    public static void main(String[] args) {
        List<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);

        Integer secondElementFromArrInt = GenMethod.getSecondElement(arr);
        System.out.println(secondElementFromArrInt);


        List<String> arr1= new ArrayList<>();
        arr1.add("Happiness");
        arr1.add("Luckily");
        arr1.add("Kindly");

        String secondElementFromArrString = GenMethod.getSecondElement(arr1);
        System.out.println(secondElementFromArrString);

    }
}

class GenMethod{

    public static <T> T getSecondElement(List<T> list){
        return list.get(1);
    }
}
