# Chapter 9: Collections and generics


## Terminology
**Collection** : 
Group of objects contained in a single object.
Usually 2 constructors, default, 
**Java Collections Framework**: 
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
Yes duplicates, yes order, int index to retrieve and add. No static like arrays

- **LIST METHODS** :

| Method| Description                                              |
|:---------------------------------------|---------------------------------:|
| public boolean add(E element)         | Adds element to end (available on all Collection APIs)   |
| public void add(int index, E element) | Adds element at index and moves the rest toward the end. |
| public E get(int index)               | Returns element at index. |                               |
| public E remove(int index)| Removes element at index and moves the rest toward the front.|
| public default void replaceAll(UnaryOperator<E> op) | Replaces each element in list with result of operator.|
| public E set(int index, E e) | Replaces element at index and returns original. Throws IndexOutOfBoundsException if index is invalid.|
| public default void sort(Comparator<? super E> c)| Sorts list. We cover this later in the chapter in the “Sorting Data” section |


- **LIST CLASSES** :
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

**Converting List to Array**:
`list.toArray()`
` list.toArray(new String[0] \\type`

## SET
No duplicates, no specific order
- **SET CLASSES** :
  - **HashSet** : Key are a hash, values are Objects. 
    - Uses hashCode() method
    - Adding, search is O(1)
    - No order elements
  - **TreeSet** : Order, sorted
    - Adding, searching takes time

![HashSet and TreeSet](/images/chapter09/hashset_hast_tree.png)


- **SET METHODS** :

| Method          | Description                                                  |
|:-------------------------------|--------------------------------------------------------------:|
| public boolean add(E element) | True unless element already in the set                       |
| for.Each                      | Print arbitrary order for hashSet, natural order for TreeSet |  
| equals()                     | Uses hashCode() or Comparable for sorted                     |


**Factory methods to create set**: Create set with of, CopyOf



## Generics
### Diamond operator
- Specify type, short notation. 
- Right side statement ONLY, when type can be inferred, error:

`List<> list = new ArrayList<Integer>()`
- Not as type in variable declaration

`Class InvalidUse { void use(List<> data){} }`

### Null pointer exception
Calling any method on null value, gives a NullPointerException