package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierExample {

    // Supplier поставляет нам объекты (Поставщик)
    //Consumer - принимает объекты и что-то с ним делаем (Потребитьель)


    public static List<Car> addThreeCars(Supplier<Car> carSupplier) {
        List<Car> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            newList.add(carSupplier.get());
        }
        return newList;
    }


    public static void changeCar(Car car, Consumer<Car> c){
        c.accept(car);
    }

    public static void main(String[] args) {
        List<Car> cars = addThreeCars(() -> new Car("Grey", "Nissan Tilda", 1.8));
        System.out.println("Our cars " + cars);

        changeCar(cars.get(1), car -> {
            car.color="Black";
            car.model="BMW";
            System.out.println("We bought new car: "+ car);
        });

    }

}

class Car {
    String color;
    String model;
    double engine;

    public Car(String color, String model, double engine) {
        this.color = color;
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }
}
