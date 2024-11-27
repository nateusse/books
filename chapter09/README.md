# Chapter 9: Collections and generics


## Terminology
- **Collection** : 
Group of objects contained in a single object.
Usually 2 constructors, default, and parameters
- **Java Collections Framework**: 
Set of classes in java.util for storing collections ![Java Collections Framework](/images/chapter09/collection.png)


## Interfaces
- **List** : Ordered, yes duplicate entries. Access int index
- **Set**: No duplicates
- **Queue**: Specific order
    - **Deque** : Subinterface, acess both ends
- **Map**: Key/value, no duplicate keys. No  Collection (because map needs different methods) but yes part of the Java Framework.


## Collection methods
- **add()**: `public boolean add(E element)`
- **remove()**: Once instance by call. `public boolean remove(Object object)`
- **IsEmpty()**: `public booolean isEmpty()`
- **size()**: Amount of elements `public int size()`
- **clear()**:
Bye all elements.
 `public void clear()`
 - **contains**: Call equals() `public boolean contains(Object object)`
 - **removeIf()**: Remove all elements that match the condition as method reference or block of code
    - ` public boolean removeIf(Predicate <? super E> filter)`
    - Ej: `list.removeIf(s -> s.startWith("A"));`
    - Ej: `set.removeIf (String:: is Empty);`
 - **equals**: Compare 2 Collections by type and content `boolean equals(Object object)`



### Iterating collections
For each, enchanced loop and Itetaror should not be wrapped in System.out.print , they don't return value to be printed, they are type void, none becuase is a flow statement and Iterator respectible.

1. **for each**: 
 Iterate Collection, no loop, using method reference or lambdas `public void forEach(consumer<? super T> action)`

- Ej method reference: ` cats.forEach(Sytem.out:print)`
- Ej lamda: ` cats.forEach(c -> System.out.print(c));`

2. **loop**: 
***enhanced for loop***: ` for (String element : cats)
System.out.println(element);`

3. **Iterator**

`Iterator <String> iter = cats.iterator();`
    `while (iter.hasNext()){
        String string = iter.next();
        System.out.print(String);
    }
`
- hasNext(): Check if there is a next value
- next(): moves Iterator to next element


## LIST
Yes duplicates, yes order starting 0, int index to retrieve and add. No static like arrays

- **LIST METHODS** :
  - add element and add by index, get by index, remove by index, replace set replace element in index, sort
  - remove is overloaded method, remvoe from Collection by Object, remove from List by index
    - ` var listRemoveOverloaded = asList(1, 2, 3);
       listRemoveOverloaded.remove(2); 
        listRemoveOverloaded.remove(Integer.valueOf(2));`


| Method| Description                                              |
|:---------------------------------------|---------------------------------:|
| public boolean add(E element)         | Adds element to end (available on all Collection APIs)   |
| public void add(int index, E element) | Adds element at index and moves the rest toward the end. |
| public E get(int index)               | Returns element at index. |                               |
| public E remove(int index)| Removes element at index and moves the rest toward the front.|
| public default void replaceAll(UnaryOperator<E> op) | Replaces each element in list with result of operator.|
| public E set(int index, E e) | Replaces element at index and returns original. Throws IndexOutOfBoundsException if index is invalid.|
| public default void sort(Comparator<? super E> c)| Sorts list. We cover this later in the chapter in the “Sorting Data” section |


- **LIST CLASSES IMPLEMENTATION** :
  - **ArrayList** :
  Resizable array, use this by default, best when I need to read often, 'cause looking in constant time, adding or removing is O(n).
  - **LinkedList** :
  For Queue and Deque, add, remove, access beginning and end constant time, search arbitrary index is linear time

**Factory methods to create list**: Create a list with asList, of, CopyOf

| Method                  | Description                                     | Add | Replace | Delete | 
|:-------------------------|:-------------------------------------------------:|:-----:|:---------:|--------:|
| Arrays.asList(varargs)  | Fixed size list backed to array                 | NO  |  YES    | NO  |
| List.of (varargs)       | Immutable list                                  | NO  | NO    | NO   |
| List.CopyOf(collection) | Immutable list, copy original collection values | NO  | NO     | NO |

**Factory methods to converting List to Array**: toArray, a completly new copy not affected by original list

## SET
No duplicates, no specific order

![HashSet and TreeSet](/images/chapter09/hashset_hast_tree.png)

**FACTORY METHODS TO CREATE**: Create set with of, CopyOf. Inmutable both, else `UnsupportedOperationException`

| Method                  | Description                                     | Add | Replace | Delete | 
|:-------------------------|:-------------------------------------------------:|:-----:|:---------:|--------:|
| Set.of (varargs)       | Immutable list                                  | NO  | NO    | NO   |
| Set.CopyOf(collection) | Immutable list, copy original collection values | NO  | NO     | NO |


- **SET METHODS** :

| Method          | Description                                                  |
|:-------------------------------|--------------------------------------------------------------:|
| public boolean add(E element) | True unless element already in the set                       |
| for.Each                      | Print arbitrary order for hashSet, natural order with Comparable for TreeSet |  
| equals()                     |                     |


- **SET CLASSES IMPLEMENTATION** :
  - **HashSet** :
    -  Key are a hash, values are Objects. 
    - Uses hashCode() method
    - Adding, search is O(1)
    - No order elements
  - **TreeSet** : Order, is sorted
    - Adding, searching takes linear
    - Uses Comparable to sort

## QUEUE, DEQUE 
- Deque is pronounce "deck"
- Queue adds and removes in specific order. FIFO (first-In First-Out)
- Queues LIFO (last-in, first-out) are Stacks
- Deque is double-ended queue, insert and removes front(head) and back(tail)
- Stack: Remove, add top

- **QUEUE CLASSES IMPLEMENTATION** :
  - **LinkedList** :
    - For Queue and Deque and List. Add, remove, and access constant time.
    - Search arbitrary index is linear time
  - **ArrayDeque** :
    - No list methods (add, get by index, remove by index, replace, sort)
    - Search arbitrary index is linear time

- **DEQUE METHODS** :
  - 6 methods, 3 with exception
  - FIFO

| Method| Description                                              |
|:---------------------------------------|---------------------------------:|
| public boolean add(E e)         | Add back exception  |
| public boolean offer(E e)  | Add back |
| public E element()               | Read front exception |                               |
| public E peek()| Read front|
| public E remove()| Get and remove front exception |
| public E poll()| Get and remove front |



- **STACKS METHODS** :
  - 3 methods, push, pop, peek
  - LIFO

| Method| Description                                              |
|:-----------------------------|---------------------------------:|
| public void push(E e)  | Add back exception  |                             |
| public E pop()| Get and remove back exception|
| public E peek()| Read back|

- **DEQUE METHODS** :
Inherits Queue methods

| Method| Description                                              |
|:---------------------------------------|---------------------------------:|
| public boolean addLast(E e)         | Add back exception  |
| public boolean offerLast(E e)  | Add back |
| public boolean addFirst(E e)  | Add front exception  |
| public boolean offerFirst(E e)  | Add front |
| public E getFirst()   | Read front exception |                               |
| public E peekFirst()| Read front|
| public E getLast()   | Read back exception |                               |
| public E peekLast()| Read back|
| public E removeFirst()| Get and remove front exception |
| public E pollFirst()| Get and remove front |
| public E removeLast()| Get and remove back exception |
| public E pollLast()| Get and remove  back|

## MAP
- Key(K), value (V)
- Doesn't extends Collection

**FACTORY METHODS TO CREATE MAP**: Create set with Map.of, CopyOf. Inmutable both, else `UnsupportedOperationException`

| Method                  | Description                                     | Add | Replace | Delete | 
|:-------------------------|:-------------------------------------------------:|:-----:|:---------:|--------:|
| Map.of("key1","value1", "key2", "value2")       | Immutable map             | NO  | NO    | NO   |
| Map.ofEntries( (Map.entry("key1","value1"); Map.entry("key2", "value2")))    |         nop |
| Map.CopyOf(collection) | Immutable map, copy original collection values | NO  | NO     | NO |



- **MAP CLASSES IMPLEMENTATION** :
  - **HashMap** :
    -  Key are a hash, values are Objects. 
    - Uses hashCode() method
    - Adding, search is O(1), constant
    - No order elements
  - **TreeMap** : 
    - Sorted
    - Adding, searching takes linear time
    - Uses Comparable to sort
  - **LinkedHashMap** : 
    - Order for insertion
    - Adding, searching takes linear time
    - Uses Comparable to sort

| Method| Description                                              |
|:---------------------------------------|---------------------------------:|
| public void forEach(BiConsumer<K key, V value>) | Loops through each key/value pair. |
| public V get(Object key) | Returns value mapped by key or null if none is mapped. |
| public V getOrDefault(Object key,V defaultValue) |Returns value mapped by key or default value if none is mapped. |
| public boolean isEmpty() | Returns whether map is empty. |
| public Set<K> keySet()  | Returns set of all keys. |                               |
| public V merge(K key, V value,Function(<V, V, V> func))| Sets value if key not set. Runs function if key is set, to determine new value. Removes if value is null.|
| public V put(K key, V value) | Adds or replaces key/value pair. Returns previous value or null. |                               |
| public V putIfAbsent(K key, V value)| Adds value if key not present and returns null. Otherwise, returns existing value.|
| public V remove(Object key)| Removes and returns value mapped to key. Returns null if none. |
| public V replace(K key, V value)| Replaces value for given key if key is set. Returns original value or null if none.|
| public void replaceAll( BiFunction<K, V, V> func)| Replaces each value with results of function. |
| public int size()| Returns number of entries (key/valuepairs) in map.|
| public Collection<V> values()| Returns Collection of all values.|


### Iterating Maps
For each, 

1. **for each**: 
Lambda with 2 parameters.
  - Example: `map.forEach(k,v) -> System.out.println(k,v)`

2. **entrySet **: 
- Entry is a static interface inside map to get key and value
  - Example: `map.entrySet().forEach(e -­> System.out.println(e.getKey() + " " + e.getValue()));`


3. **Iterator**


## Generics
### Diamond operator
- Specify type, short notation. 
- Right side statement ONLY, when type can be inferred, error:

`List<> list = new ArrayList<Integer>()`
- Not as type in variable declaration

`Class InvalidUse { void use(List<> data){} }`

### Null pointer exception
Calling any method on null value, gives a NullPointerException