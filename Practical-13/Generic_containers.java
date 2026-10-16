class Box<T>{
    private T Value;

    public void set(T Value) {
        this.Value = Value;
    }

    public T get() {
        return Value;
    }
}

class Pair<A,B>{
    A first;
    B second;

    Pair(A first, B second){
        this.first = first;
        this.second = second;
    }
}

class Main{
    public static void main(String[] args){
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println("Integer Value: " + integerBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("String Value: " + stringBox.get());

        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair.first + " - " + pair.second);
    }
}