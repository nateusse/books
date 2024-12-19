import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.Iterator;
public class CollectionsGenerics {

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
        System.out.println(birds.remove("hawk")); // true
        System.out.println(birds.isEmpty()); // false
        System.out.println(birds.size()); // 1
        System.out.println(birds.contains("hawk")); // true
        birds.clear(); // []
        System.out.println(birds.size()); // 0
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
        //int h = heights.get(0);
        //System.out.println(h); //NullPointerException


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
        //copy.add("y"); // UnsupportedOperationException, it's imutable
        //copy.set(0,"x"); // UnsupportedOperationException, it's imutable
        //ofCopy.add("y"); // UnsupportedOperationException, it's imutable
        //of.add("y"); // UnsupportedOperationException, it's imutable
        //asListCopy.add("y"); // UnsupportedOperationException, it's fixed size

    
    
        // list Constructors, default (empty), copy of another collection, and  with initial capacity
        var constructorEmpty = new LinkedList<String>(); //EMPTY
        var constructorCopy = new LinkedList<String>(constructorEmpty); //copy of anotehr linked list
        var constructorInitialCapacity = new ArrayList<String>(10); //slots, no assigned


        List<String> listBasics = new ArrayList<>();
        listBasics.add("SD");// [SD]
        listBasics.add(0, "NY");// [NY,SD]
        listBasics.set(1, "FL");// [NY,FL]
        System.out.println(listBasics.get(0)); // NY

        //remove is a Overloaded method
        listBasics.remove("NY");// [FL] remove by element from Collection
        listBasics.remove(0);// [] remove by index List

        //listBasics.set(0, "?");// IndexOutOfBoundsException, no elements to replace
        //repalce All
        var numbersReplaceAll = Arrays.asList(1, 2, 3);
        numbersReplaceAll.replaceAll(x -> x*2); //multiply values by 2
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
        //listRemoveOverloaded.remove(100); //IndexOutOfBoundsException, no elements to remove


        //COnvert list to array
        List<String> listToArray = new ArrayList<>();
        listToArray.add("hawk"); // [hawk]
        listToArray.add("robin"); // [hawk, robin]
        Object[] objectArray = listToArray.toArray(); // [hawk, robin], defaul array class Object
        String[] stringArray = listToArray.toArray(new String[0]); // [hawk, robin], array of strings [0] java creates right size
        // listToArray.clear();
        listToArray.set(1, "new"); // [hawk, new]
        System.out.print(Arrays.toString(stringArray)); //[hawk, robin]
        System.out.println(objectArray.length); // 2 Eliminate list, array still has elements
        System.out.println(stringArray.length); // 2 Eliminate list, array still has elements



        //SET ------------------------------------------------------
        //Factory to create sets
        Set<Character> setOf= Set.of('z','o'); // [z, o]  Inmutable, no duplicates, if zoo, seria solo zo
        Set<Character> setCopyOf = Set.copyOf(setOf); // [z, o]  Inmutable
        //setOf.add("x"); // UnsupportedOperationException, it's imutable
        //setCopyOf.add('x'); // UnsupportedOperationException, it's imutable
        //setOf.remove('z'); // UnsupportedOperationException, it's imutable
        
        //methods with HashSet
        Set<Integer> setHash = new HashSet<>();
        boolean b1H = setHash.add(66);// true
        boolean b2H = setHash.add(10);// true
        boolean b3H = setHash.add(66); // false
        boolean b4H = setHash.add(8); // true
        setHash.forEach(System.out::println); // 66 8 10 in three lines, arbitrary order

        //methods with three set
        Set<Integer> treeSet = new TreeSet<>();
        boolean b1T = treeSet.add(66);// true
        boolean b2T = treeSet.add(10);// true
        boolean b3T = treeSet.add(66); // false
        boolean b4T = treeSet.add(8); // true
        treeSet.forEach(System.out::println); // 8 10 66 in three lines,sorted



    //---- DEQUE/ QUEUE -------------------------------------------
        

    Queue<Integer> queue = new LinkedList<>();
    queue.add(10);
    queue.add(4); // [10, 4]
    System.out.println(queue.remove());// 10, remove front
    System.out.println(queue.peek());// 4

    Deque<Integer> deque = new LinkedList<>();
    deque.offerFirst(10); // true [10]
    deque.offerLast(4); // true [10, 4]
    deque.peekFirst(); // 10 [10, 4]
    deque.pollFirst(); // 10 [4]
    deque.pollLast(); // 4 []
    deque.pollFirst(); //null
   // deque.removeFirst(); //NoSuchElementException
    deque.peekFirst(); // null
   // deque.getFirst(); //NoSuchElementException

    // --- MAP --------------------

    //HASMAP
    Map<String, String> hashMap = new HashMap<>();
    hashMap.put("koala", "bamboo");
    hashMap.put("lion", "meat");
    hashMap.put("giraffe", "leaf");
    String foodHashMap = hashMap.get("koala"); // bamboo
    for (String key: hashMap.keySet()) // koala, giraffe, lion,
    System.out.println(key + ","); // koala,giraffe,lion,
       
    //TREEMAP
    Map<String, String> treeMap = new TreeMap<>();
    treeMap.put("koala", "bamboo");
    treeMap.put("lion", "meat");
    treeMap.put("giraffe", "leaf");
    String foodTreeMap = treeMap.get("koala"); // bamboo
    for (String key: treeMap.keySet()) // koala, giraffe, lion,
    System.out.println(key + ","); // giraffe, koala, lion, SORTED

    //MAP METHODS
    //System.out.println(hashMap.contains("lion")); // DOES NOT COMPILE, contains in from COllections, not in Map
    System.out.println(hashMap.containsKey("lion")); // true
    System.out.println(hashMap.containsValue("lion")); // false
    System.out.println(hashMap.size()); // 3
    hashMap.clear();
    System.out.println(hashMap.size()); // 0
    System.out.println(hashMap.isEmpty()); // true

    //Map contains, contains key, contains value, size, is empty
    //System.out.println(hashMap.contains("lion")); // DOES NOT COMPILE is from COLLECTIONS
    System.out.println(hashMap.containsKey("lion")); // true
    System.out.println(hashMap.containsValue("lion")); // false
    System.out.println(hashMap.size()); // 3
    hashMap.clear(); //clear map
    System.out.println(hashMap.size()); // 0
    System.out.println(hashMap.isEmpty()); // true

    //get personalized messages
      //getOrDefault to personalized exception
    Map<Character, String> mapGetDefault = new HashMap<>();
    mapGetDefault.put('x', "spot"); // key x, value spot
    System.out.println(mapGetDefault.get('x')); //spot
    System.out.println(mapGetDefault.getOrDefault('x', "")); // spot, valid so not perzonlized exception
    System.out.println(mapGetDefault.get('y')); // null 
    System.out.println(mapGetDefault.getOrDefault('y', "")); // "" Personalized exception
  
    //replacing values
    Map<Integer, Integer> mapReplace = new HashMap<>();
    mapReplace.put(1, 2);
    mapReplace.put(2, 4);
    Integer original = mapReplace.replace(2, 10); // 4
    System.out.println(mapReplace);// {1=2, 2=10}
    mapReplace.replaceAll((k, v) -> k + v);
    System.out.println(mapReplace);// {1=3, 2=12}

    //putting if absent
    Map<String, String> favorites = new HashMap<>();
    favorites.put("Jenny", "Bus Tour");
    favorites.put("Tom", null);
    favorites.putIfAbsent("Jenny", "Tram");
    favorites.putIfAbsent("Sam", "Tram");
    favorites.putIfAbsent("Tom", "Tram");
    System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}


 //merging values
   BiFunction<String, String, String> mapper = (v1, v2) -> v1.length()> v2.length() ? v1: v2;
   Map<String, String> favoritesMerge = new HashMap<>();
   favoritesMerge.put("Jenny", "Bus Tour");
   favoritesMerge.put("Tom", "Tram");
   String jenny = favoritesMerge.merge("Jenny", "Skyride", mapper);
   String tom = favoritesMerge.merge("Tom", "Skyride", mapper);
   System.out.println(favoritesMerge); // {Tom=Skyride, Jenny=Bus Tour}
   System.out.println(jenny); // Bus Tour
   System.out.println(tom);// Skyride
     //If mapping function were called, it would be NullPointerException
    //maping used only between two real values to decided from

    //mapping call with null
    BiFunction<String, String, String> mapperNull = (v1, v2) -> null;
    Map<String, String> favoritesNull = new HashMap<>();
    favoritesNull.put("Jenny", "Bus Tour");
    favoritesNull.put("Tom", "Bus Tour");
    favoritesNull.merge("Jenny", "Skyride", mapperNull );
    favoritesNull.merge("Sam", "Skyride", mapperNull );
    System.out.println(favoritesNull);
// {Tom=Bus Tour, Sam=Skyride}

    // Iterate map
    Map<Integer, Character> mapForEach = new HashMap<>();
    mapForEach.put(1, 'a');
    mapForEach.put(2, 'b');
    mapForEach.put(3, 'c');
    mapForEach.forEach((k, v)-> System.out.println(v)); //or k, or both, is up to me
    mapForEach.values().forEach(System.out::println); // a b c
  


    //Set iteration in maps
    mapForEach.entrySet().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

  




















    }
}