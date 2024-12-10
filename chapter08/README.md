# Chapter  8: Lambdas and Functional Interfaces


> __Functional programming__: Write code more declarative, what I want to do, instead of dealing with the states ob an objects

> __Functional interface__: Interface that contains a single abstract method (SAM)

> __Lamba expression or lambdas__: 
- Block of code, get passed around to be used later
- Closures in other languages
- Like unnamed method inside a anonymous class,  with parameters and bodymaed method
- Needs ___interfaces with exactly one abstract method___
- Java realies on ___contexts___ to give meaning to the Lambda

> __Method reference__:  Name of the method

> __Context__:Where and how the lambda is interpreted

Example:

1. Record class. Animals with 3 fields, 2 boolean swing or jump , and 1 string name

    `public record Animal(String species, boolean canHop, boolean canSwim){}
    `

2. Create interface to filter test

    `
    public interface CheckTrait{
        boolean test(Animal a);
    }
    `

3. Provide implementation  of the interface 

    ```
    public class CheckIfHopper implements ChechTrait{
        public boolean test(Animal a){
            return a.canHop();
        }
    }
    ```

Main

```  

var animals = new ArrayList<Animal>();
animals.add(new Animal("fish",false, true));
animals.add(new Animal("kangaroo",true, false));
animals.add(new Animal("rabbit",true, false));
animals.add(new Animal("turtle",false, true));
    
print(animals, new CheckIfHopper());
}
```

Auxiliar method print, static to be called by main method in the same class


```
 private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.print(animal.species() + " ");
            }
        }
        System.out.println();
    }
```

__Problem to add new check__: 
1.  Need for a new file for the trait
`public class CheckIfSwim implements CheckTrait{...}`
2. Need to alter main code to add instantiates taht class
`print(animals, new CheckIfSwim())}`

__Solution__:
- Lambdas , no new class, thanks to  ___deferred execution___
` print(animals, a -> a.canSwim());`

- ___deferred execution___:Write code now, run later. In the example, later is inside print() instead of passed to the method

__Why works__: Java knows print signature  ` private static void print(List<Animal> animals, CheckTrait checker)` expects the functional interface, so Java mapss lambda to the abstract method declaration in `CheckTrait` interface, knowing that it has to take an animal, and return a boolean 


## Lambda syntax
`a -> a.canHop()`

- _Parameters_: a
- _Arrow:_  ->
- _body:_  a.canHop()

### When to omit parentheses
- Omit `()` only if there is a single parameter:
    - ` a -> { return a.canHop();}`
- Omit  `()`  only when its type is __NOT__ explicitly stated.
    - _Example_ (String, boolean, char ...)


### Omit return and semicolon
- Omit `return ;`  when no braces `{}` are used
- With only one statement
- ` (Animal a) -> a.canHop()`

Valid Lambda examples:

| Lambda | # of parameters|
|:----------|---------:|
| () -­> true | 0 |
| x -­> x.startsWith("test") |1|
|(String x) -­> x.startsWith("test") |1|
|(x, y) -­> { return x.startsWith("test"); }|2|
|(String x, String y) -­> x.startsWith("test")|2|

Valid Lambda examples:

| Lambda | Reason|
|:----------|---------:|
|x, y -­> x.startsWith("fish") |Missing parentheses on left|
|x -­> { x.startsWith("camel"); }|Missing return on right|
| x -­> { return x.startsWith("giraffe") } | Missing semicolon inside braces |
| String x -­> x.endsWith("eagle")|Missing parentheses on left|
| var invalid = (Animal a) -> a.canHop() |Neither lambda or var have enough information to determinane whan type of functional interface should be used|



## Coding functional interface

 > ___@FunctionalInterface___: Tells the compiler that the code is a functional interface, meaning, an interface with only one abstract method



```
@FunctionalInterface
public interface Sprint {
    public void sprint(int speed);
}
```
```
public class Tiger implements Sprint {
    public void sprint(int speed) {
        System.out.println("Animal is sprinting fast! " + speed);
    }
}
```

### Example of bad functional iterfaces

```
public interface Skip extends Sprint {
    void skip();
}
```
__why?__: Two abstract methods, skip() and the inherited by Sprint

```
public interface Sleep {
    private void snore() {}
    default int getZzz() { return 1; }
}
```
__why?__: Two abstract methods, snore() and getZzz() 



### Example of good functional iterfaces

`public interface Dash extends Sprint {} `

__why?__: Inherits abstract method from Sprint

```
public interface Climb {
    void reach();
    default void fall() {}
    static int getBackUp() { return 100; }
    private static boolean checkHeight() { return true; }
}
```
__why?__: One abstract method reach() with not implmeentation. Static  methods can't override, but can be called without an instance, and default method has an implementation: {}

### Adding Object methods
If a functional interface has a public method found in `Object`, _those methods do not count toward the single abstract method test_


- public String toString()
- public boolean equals(Object)
- public int hashCode()

Is not possible to declare an interface method that is incompatible with Object


#### Examples invalid functional interface

`public interface Soar {
abstract String toString();
}`

__why?__: Conflict with toString from Object, same signature (name and parameters), also same return type.


```
public interface Hibernate {
    String toString();
    public boolean equals(Hibernate o);
    public abstract int hashCode();
    public void rest();
}
```
__why?__: equals() has parameter Hibernate, no Object



#### Examples valid functional interface
```
public interface Dive {
    String toString();
    public boolean equals(Object o);
    public abstract int hashCode();
    public void dive();
}
```
__why?__: Object's methods, one abstract: dive()


## Method reference

:: Defferred execution with a functional interface
 
4 types:
