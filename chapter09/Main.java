import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
public class Main {

    public static void main(String[] args) {

       


        /* DIAMOND OPERATION ERRORS
        List<> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        class InvalidUse { void use(List<> data) {}  } // DOES NOT COMPILE */
        var listDiamontOperator = new ArrayList<>(); //Compile! Supertype is Object
        listDiamontOperator.add("a");
        //for (String s: list) { } // DOES NOT COMPILE, Object type, cant convert from Object to String


        //Collection method add, remove, contains, clear,size, remove if  with ArrayList
        Collection<String> birds = new ArrayList<>();
        birds.add("hawk"); // [hawk]
        birds.add("hawk"); // [hawk, hawk] duplicate
        System.out.print(birds.remove("hawk")); // true
        System.out.print(birds.isEmpty()); // false
        System.out.print(birds.size()); // 1
        System.out.println(birds.contains("hawk")); // true
        birds.clear(); // []
        System.out.print(birds.size()); // 0
        System.out.println(birds.contains("robin")); // false
        birds.add("pigeon"); // [pigeon]
        birds.add(""); // [pigeon, ]
        birds.size(); // 2
        System.out.println(birds.removeIf( c -> c.startsWith("p"))); // true, remove if
        System.out.println(birds.isEmpty()); // true


        
        //Collection methods with set
        Collection<String> set = new HashSet<>();
        set.add("hawk"); // [hawk] true
        set.add("hawk"); // [hawk] false, duplicate
        set.add(""); // [hawk, ] true
        set.size(); // 2
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin"));
        set.removeIf(String::isEmpty); //true
        

        //Iteration for each, enchance loop and 
        //Don warp them in system.out .print
        Collection<String> cats = new ArrayList<>();
        cats.forEach(cat -> System.out.println(cat)); //lion tiger cheetah, lambda
        cats.forEach(System.out::println); //lion tiger cheetah, metohd reference
  
        //enhanced loop
        for (String cat : cats) {
            System.out.println(cat);
        }

        //iterator
        Iterator<String> iter = cats.iterator();
        while (iter.hasNext()) {
            String cat = iter.next();
            System.out.println(cat);
        }


        //Equals to compare collections by type and elements
        var list1 = List.of(1, 2);
        var list2 = List.of(2, 1);
        var set1 = Set.of(1, 2);
        var set2 = Set.of(2, 1);
        
        System.out.println(list1.equals(list2)); //false, care ortders
        System.out.println(set1.equals(set2)); //true , dont care order
        System.out.println(list1.equals(set1)); //false, different types
      
         // NullPointerException, calling any method on a null reference
        var heights = new ArrayList<Integer>();
        heights.add(null);
        int h = heights.get(0);
        System.out.println(h); //NullPointerException


        //LIST ---------------------------------------------------

        /* FACTORY METHOD LIST*/
        String[] array = new String[] {"a", "b", "c"}; //reference array
        List<String> asListCopy = Arrays.asList(array); // [a, b, c] fixed size list, can replace , but not add or delete 
        List<String>  asList = Arrays.asList("n","a","t","a"); // [n, a, t, a] fixed size list, duplicates 
        List<String> ofCopy = List.of(array);   //  [a, b, c]  Inmutable 
        List<Integer> of = List.of(1, 2,3,4,5); //  [1, 2, 3, 4, 5] Inmutable list
        List<String> copy = List.copyOf(asList); //   [a, b, c] Inmutable list
        array[0] = "z";  //change in initial array
     

        //Altering factory methods List
        System.out.println(asListCopy); // [z, b, c] //can replace
        System.out.println(ofCopy); // [a, b, c]
        System.out.println(copy); // [a, b, c]
        asListCopy.set(0, "x"); //changing the list, affects array
        System.out.println(Arrays.toString(array)); // [x, b, c]
        copy.add("y"); // UnsupportedOperationException, it's imutable
        copy.set(0,"x"); // UnsupportedOperationException, it's imutable
        ofCopy.add("y"); // UnsupportedOperationException, it's imutable
        of.add("y"); // UnsupportedOperationException, it's imutable
        asListCopy.add("y"); // UnsupportedOperationException, it's fixed size

    
    
        // list Constructors, default (empty), copy of another collection, and  with initial capacity
        var constructorEmpty = new LinkedList<String>(); //EMPTY
        var constructorCopy = new LinkedList<String>(constructorEmpty); //copy of anotehr linked list
        var constructorInitialCapacity = new ArrayList<String>(10); //slots, no assigned


        List<String> listBasics = new ArrayList<>();
        listBasics.add("SD");// [SD]
        listBasics.add(0, "NY");// [NY,SD]
        listBasics.set(1, "FL");// [NY,FL]
        System.out.println(list.get(0)); // NY

        //remove is a Overloaded method
        listBasics.remove("NY");// [FL] remove by element from Collection
        listBasics.remove(0);// [] remove by index List

        listBasics.set(0, "?");// IndexOutOfBoundsException, no elements to replace
        //repalce All
        var numbersReplaceAll = Arrays.asList(1, 2, 3);
        numbersReplaceAll.replaceAll(x -­> x*2); //multiply values by 2
        System.out.println(numbersReplaceAll);// [2, 4, 6]
        //lambda with ternary replaceAlla
        numbersReplaceAll.replaceAll(x -> x >= 2 ? x * 2 : x); //multiply values by 2 if greater than 2
        System.out.println(numbersReplaceAll);// [2, 8, 12]


        //remove overloaded
        var listRemoveOverloaded = new LinkedList<Integer>();
        listRemoveOverloaded.add(3); // [3]
        listRemoveOverloaded.add(2); // [3, 2]
        listRemoveOverloaded.add(1); // [3, 2, 1]
        listRemoveOverloaded.remove(2); //index or value? primitive so index [3,2]
        listRemoveOverloaded.remove(Integer.valueOf(2)); //[3]
        System.out.println(listRemoveOverloaded); // [3]
        listRemoveOverloaded.remove(100); //IndexOutOfBoundsException, no elements to remove


        //COnvert list to array
        List<String> listToArray = new ArrayList<>();
        listToArray.add("hawk"); // [hawk]
        listToArray.add("robin"); // [hawk, robin]
        Object[] objectArray = listToArray.toArray(); // [hawk, robin], defaul array class Object
        String[] stringArray = listToArray.toArray(new String[0]); // [hawk, robin], array of strings [0] java creates right size
        // listToArray.clear();
        list.set(1, "new"); // [hawk, new]
        System.out.print(Arrays.toString(stringArray)); //[hawk, robin]
        System.out.println(objectArray.length); // 2 Eliminate list, array still has elements
        System.out.println(stringArray.length); // 2 Eliminate list, array still has elements



        //SET ------------------------------------------------------
        //Factory to create sets
        Set<String> setOf= Set.of('z','o','o'); // [z, o]  Inmutable
        Set<String> setCopyOf = Set.copyOf(setFactory); // [z, o]  Inmutable
        setOf.add("x"); // UnsupportedOperationException, it's imutable
        setCopyOf.add("x"); // UnsupportedOperationException, it's imutable
        setOf.remove("z"); // UnsupportedOperationException, it's imutable
        
        //methods with HashSet
        Set<Integer> setHash = new HashSet<>();
        boolean b1 = setHash.add(66);// true
        boolean b2 = setHash.add(10);// true
        boolean b3 = setHash.add(66); // false
        boolean b4 = setHash.add(8); // true
        setHash.forEach(System.out::println); // 66 8 10 in three lines, arbitrary order

        //methods with three set
        Set<Integer> treeSet = new TreeSet<>();
        boolean b1 = treeSet.add(66);// true
        boolean b2 = treeSet.add(10);// true
        boolean b3 = treeSet.add(66); // false
        boolean b4 = treeSet.add(8); // true
        treeSet.forEach(System.out::println); // 8 10 66 in three lines,sorted



    //---- DEQUE/ QUEUE -------------------------------------------
        

    Queue<Integer> queue = new LinkedList<>();
    queue.add(10);
    queue.add(4); // [10, 4]
    System.out.println(queue.remove());// 10, remove front
    System.out.println(queue.peek());// 4

    deque.offerFirst(10); // true [10]
    deque.offerLast(4); // true [10, 4]
    deque.peekFirst(); // 10 [10, 4]
    deque.pollFirst(); // 10 [4]
    deque.pollLast(); // 4 []
    deque.pollFirst(); //null
    deque.removeFirst(); //NoSuchElementException
    deque.peekFirst(); // null
    deque.getFirst(); //NoSuchElementException
       
    




















    }
}
