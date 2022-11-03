package stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {

        // используем, когда очень много элементов, нужен для увеличения скорости выполнения задачи

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        //т.е. используется на месте обычного стрима они взаимозаменяемы

        double sumResult = list.parallelStream()
                .reduce((a, e) -> a + e).get();

        System.out.println("Сумма элементов " + sumResult);
    }
}
