# Chapter 1: Building Blocks


## Java Development Kit (JDK)
- __javac__: Converts .java into .class bytecode
- __java__: Executes the program. Launches ___Java VIrtual Machine (JVM)___ to read .class
- __jar__: Packages files together
- __javadoc__: Generates documentation

> - Before Java 8, ___Java Runtime Environment(JRE)___, to run program , but couldn't compile one. Now, JDK runs the Java program.
> - New release Java version, each 6 months
> - Commands: javac --version and  java --version

- __Class__: Basic building blocks, describe part and characteristics 
- __Object__ : Runtime instance of a class in memory. Represents a single representation of the class
- __State of my program__: Various objects of all the different classes
- __Reference__: Variable that point to an object

## Fields and methods
- __Members of the class__: Methods and fields
- __Methods__ : 
    - Functions, procedments
    - Operates the state of the program
    - Operation that can be called
- __Method signature__: Methods name, and parameter type. _Example_: setName(String)
- __Fields__: Variables, hold the state of the program
- __Keyword__: Word with special meaning
- __Parameter__: Information to be received in the method


```
1.  public class Animal{
2.    String name;
3.    public String getName(){
4.       return name;
5.    }  
6.    public void setName(String newName){
7.       name = newName;
8.    }
9.  }
```
## Comments
- __Comments__: Non executable code
- __Single line:__ //
- __Multiple lines or multiline:__  /*  */
- __Documentation:__  /** @author @parameter @return   */

## Classes and source file
- __Top level type__: Data structure defined within a source file. _Example:_ Class, often public, tho is not required

Is possible to have two classes in a file, the one that matches the .java file name should be the public

```
public class Animal{
    private String name;

    public static void main(String[] args) {
         System.out.println("Animal");
    }
}
class Animal2{} 
//if Animal2 is public, it doesn't compile, "must be defined in its own file"
```
- __main()__: Java entry point to the program
    - __public__: Access modifier, full exposure from anywhere in the program
    - __static:__ Binds method to class, no need to create instances.Just call the class
    - __void__: Return type, no return. Void usually changes object state. In main, from started to finished
    - __(String[] args)__: String of arrays, other valid options:
        - String[] args
        - String options[]
        - String... friends
    - __... varags__: (variable argument list)

## Passing parameters to a Java Program
```
public class Zoo {
    public static void main(String[] args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
```
The code args[0] accesses the first element of the To run it:
- javac Zoo.java
- java Zoo Bronx Zoo
- Other option: java Zoo.java Bronx Zoo

Output:  Bronx Zoo

For input with multiple words
- javac Zoo.java
- java Zoo "San Diego" Zoo

If not passing enough arguments:

- javac Zoo.java
- java Zoo Zoo

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException:
Index 1 out of bounds for length 1
at Zoo.main(Zoo.java:4)


## Packages

- Si no puede encontrar el import: _error: cannot find symbol_
- __Statement__: Instruction, complete unit of execution in Java terminated with a semicolon (;)
- __import statement__: Package for the compiler to search for an specific class
    - If starts with java, is from JDK
    - If not, usually is website name in reverse
- __Child package__: More details packages

### Wildcards and imports
Import all classes, no methods, together with *
```
import java.util.*;

public class NumberPicker {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}
```

java.lang imports automatically,  no need to import, redundant: 
- `import java.lang.System;`
- `import java.lang.*;`

this is also redundant:
- `import java.util.Random;`
- `import java.util.*;`


For example, a good import located in e java.nio.file for:
```
public void read(Files files) {
    Paths.get("name");
}
```
would be:
- `import java.nio.file.*;`
- `import java.nio.file.Files;` `import java.nio.file.Paths;`

And bad ones would it:

- `import java.nio.*;  ` * is for class not "file.Files"
- `import java.nio.*.*; `// Only one *, must be at the end
- `import java.nio.file.Paths.*; ` // Cannot import methods, just classes
