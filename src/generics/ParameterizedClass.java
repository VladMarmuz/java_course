package generics;

public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("hello");
        System.out.println(info1);
        String value = info1.getValue();
        Info<Integer> info2 = new Info<>(200);
        System.out.println(info2);
        Integer value1 = info2.getValue();
    }

}

class Info <T>{
    private T value;

    public Info(T value){
        this.value= value;
    }

    public T getValue(){
        return value;
    }


    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }

}
