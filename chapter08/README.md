# Chapter  8: Lambdas and Functional Interfaces


> __Functional programming__: Write code more declarative, what I want to do, isntead of dealing with the states ob an objects


> __Lamba expression or lambdas__: 
- Block of code, get passed around to be used later
- Closures in other languages
- Like unnamed method inside a anonymous class,  with parameters and bodymaed method
- Needs ___interfaces with exactly one abstract method___
- Java realies on ___contexts___ to give meaning to the Lambda

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
            return a.cabHop();
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

__Why works__: Java knows print signature  ` private static void print(List<Animal> animals, CheckTrait checker)` expects the functional interface, it takes the 

