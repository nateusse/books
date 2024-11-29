package chapter08;

import java.util.ArrayList;
import java.util.List;

// Record Animals 3 fields, 2 boolean swing or jump , and 1 string name)
record Animal(String species, boolean canHop, boolean canSwim){}

// interface with exactly one abstract method, functional interface
//checks traits of animals
interface CheckTrait{
    boolean test(Animal a);
}

//class to check if animal can hop, specific trait
class CheckIfHopper implements CheckTrait{
    public boolean test(Animal a){
        return a.canHop();
    }
}

public class Main {


    // Helper method print animals
    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) {
                System.out.print(animal.species() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
      
    // LAMBDA traditional

    //list of animals, adding three
    var animals = new ArrayList<Animal>();
        animals.add(new Animal("fish",false, true));
        animals.add(new Animal("kangaroo",true, false));
        animals.add(new Animal("rabbit",true, false));
        animals.add(new Animal("turtle",false, true));

        
    //canHop, traditional way
    print(animals, new CheckIfHopper());
    //can swim 
    print(animals, a -> a.canSwim());
    //can't swim
    print(animals, a -> !a.canSwim());
    }
}
