import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //COLLECTION
            // 2 constructors
        var list1 = new LinkedList<String>(); //EMPTY
        var list2 = new LinkedList<String>(list1); //copy of anotehr linked list
        var list3 = new ArrayList<String>(10); //slots, no assigned



        /* DIAMOND OPERATION ERRORS
        List<> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        class InvalidUse { void use(List<> data) {}  } // DOES NOT COMPILE */
        var list = new ArrayList<>(); //Compile! Supertype is Object
        var list = new ArrayList<>();
        list.add("a");
        for (String s: list) { } // DOES NOT COMPILE, Object type

        //method contains
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin")); // false


        /* FACTORY METHOD LIST*/
        String[] array = new String[] {"a", "b", "c"};
        List<String> asList = Arrays.asList(array); // [a, b, c]
        List<String> of = List.of(array);// [a, b, c]
        List<String> copy = List.copyOf(asList);// [a, b, c]
        array[0] = "z";


        System.out.println(asList); // [z, b, c]
        System.out.println(of); // [a, b, c]
        System.out.println(copy); // [a, b, c]
        asList.set(0, "x");
        System.out.println(Arrays.toString(array)); // [x, b, c]
        copy.add("y"); // UnsupportedOperationException
        }
}
