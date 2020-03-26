import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * Deze klasse maakt een aantal (generieke) methoden ter conversie
 * List <-> Array
 * List </-> Json
 *
 * @author Daniel Mikes
 */
public class Generic {

    public static void main(String[] args) {

        // Common List
        System.out.println(makeStringList());

        // Generic List
        System.out.println(makeGenericList("string"));

        // Array to ArrayList
        String[] stringArray = {"a", "b", "c"};
        System.out.println();
        System.out.println("arrayToList(stringArray)");
        System.out.println(Arrays.toString(stringArray));
        System.out.println(arrayToList(stringArray));

        Integer[] integerArray = {1, 2, 3};
        System.out.println();
        System.out.println("arrayToList(integerArray)");
        System.out.println(Arrays.toString(integerArray));
        System.out.println(arrayToList(integerArray));

        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println();
        System.out.println("arrayToList(doubleArray)");
        System.out.println(Arrays.toString(doubleArray));
        System.out.println(arrayToList(doubleArray));

        // ArrayList to Array
        // List could be replaced by Collection -> more general
        List<String> stringList = Arrays.asList("a", "b", "c");
        System.out.println();
        System.out.println("Arrays.toString(listToArray(String.class, stringList))");
        System.out.println(stringList.toString());
        System.out.println(Arrays.toString(listToArray(String.class, stringList)));

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println();
        System.out.println("Arrays.toString(listToArray(Integer.class, integerList))");
        System.out.println(integerList.toString());
        System.out.println(Arrays.toString(listToArray(Integer.class, integerList)));

        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        System.out.println();
        System.out.println("Arrays.toString(listToArray(Double.class, doubleList))");
        System.out.println(doubleList.toString());
        System.out.println(Arrays.toString(listToArray(Double.class, doubleList)));

        // make Map
        Map mapIn = makeMap();
        System.out.println(mapIn.toString());

        // Java to Json
        String json = mapToJson(mapIn);
        System.out.println(json);

        // Json to Java
        Map mapOut = jsonToMap(json);
        System.out.println(mapOut.toString());
    }

    // Deze methode maakt een List
    static List makeStringList() {
        List list = new ArrayList();
        list.add("hello");
        list.add(1);
        list.add(1.1);

        return list;
    }

    // Deze methode maakt een Generic ListList
    static <T> List<T> makeGenericList(T element) {
        List<T> list = new ArrayList<>();
        list.add(element);

        return list;
    }

    // Deze methode converteert Array naar List
    static <T> List<T> arrayToList(T[] array) {

        return Arrays.stream(array).collect(Collectors.toList());
    }

    // Deze methode converteert List naar Array
    static <T> T[] listToArray(Class<T> tclass, List<T> list) {

        return list.toArray((T[]) Array.newInstance(tclass, list.size()));
    }

    // Deze methode maakt een Map en vult die met allerlei Primitives, Arrays en Lists
    static Map makeMap() {

        // Maak alle Arrays en Lists
        String text = "string";
        Integer number = 1;
        Double decimal = 1.1;
        String[] stringArray = {"a", "b", "c"};
        Integer[] integerArray = {1, 2, 3};
        Double[] doubleArray = {1.1, 2.2, 3.3};
        List<String> stringList = Arrays.asList("a", "b", "c");
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        // LinkedHashMap sorteert op invoegvolgorde
        Map<String, Object> mapIn = new LinkedHashMap<>();

        // Vul Map met bovenstaande
        mapIn.put("String", text);
        mapIn.put("Integer", number);
        mapIn.put("Double", decimal);
//        mapIn.put("StringArray",stringArray);
//        mapIn.put("IntegerArray",integerArray);
//        mapIn.put("DoubleArray",doubleArray);
        mapIn.put("StringList", stringList);
        mapIn.put("IntegerList", integerList);
        mapIn.put("DoubleList", doubleList);

        return mapIn;
    }

    // Deze methode converteert Map naar Json
    static String mapToJson(Map<String,Object> map) {

        Gson gson = new Gson();

        String json = gson.toJson(map);

        return json;
    }

    // Deze methode converteert Json naar Map
    static <String,Object> Map<String,Object> jsonToMap(String json) {

        Gson gson = new Gson();
        Map<String, Object> map = new LinkedHashMap<>();

        map = gson.fromJson((java.lang.String) json, map.getClass());

        return map;
    }
}
