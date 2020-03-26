import java.util.Arrays;
import java.util.List;

class Mapper {

    // Driver code
    public static void main(String[] args) {

        System.out.print("Stream after applying " +
            "Function is : ");

        // Create list of Integers
        List<Integer> list = Arrays.asList(3, 6, 9, 12);

        // Use Stream Map (Function Mapper) and
        // display New Stream
        list.stream().map(number -> number * 3).forEach(System.out::println);
    }
}
