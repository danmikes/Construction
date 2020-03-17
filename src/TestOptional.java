import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {

        TestOptional testOptional = new TestOptional();
        Integer value1 = null;
        Integer value2 = 8;

        // Optional.ofNullable - allows passed parameter to be null
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(TestOptional.sum(a,b));

    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // Optional.isPresent - checks if value present or absent

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // Optional.orElse - returns value if present otherwise returns
        // default value passed
        Integer value1 = a.orElse(0);

        // Optional.get - gets value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }

}
