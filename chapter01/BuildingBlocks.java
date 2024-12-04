package chapter01;

import java.util.Random;

public class BuildingBlocks {

    public static void main(String[] args) {

        System.out.println("Main");
        // COMMENTS --------------------
        /*
        * // anteater    MULTIPLE-LINE COMMENR
        */  

        // bear         SINGLE
        
        // // cat       SINGLE
        
        // /* dog */    SINGLE
        
        /* elephant */  //MULTILINE
       
        /*
        * /* ferret */  //  */ ERROR


        //PACKAGES -------------------

        
        Random r = new Random();
        System.out.println(r.nextInt(10)); //Random number from 0 - 9
    
        //IMPORTS -------------------
        //import java.util.*;
        //import java.util.concurrent.*;
        //import java.util.concurrent.atomic.*; //ONLY THIS WORK FOR ATOMICS
      
    }
}
 /*
public class Hola{
    public static void main(String[] args) {
        System.out.println("Hola");
    }
  
} //changed name of the file to Hola.java
   */  