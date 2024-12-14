 # Appendix A Junit primer

- __JUnit test class__: Java class
    - @Test anotation
    -  public method, no arguments
    - void method, no static
    - Setup / teardown methods (zero or more)
    -  Assertion about expected conditions and side effects
    - Should not throw an exception (except if I explicitly indicate with expected)

## Lifecycle 
- Create instance of the test class
- Invoke setup methods on the instance
- Invoke test methods
- Invoke teardonw

Lifeclycle includes inhereted methods, test, teardown and setup from superclass

## Assertions
Common public static methods in ___org.junit.Assert___ class


- __assertEquals()__ Two objects or primitives are equal
- __assertArrayEquals()__ Assert two arrays have same items
- __assertFalse()__ Flase statement
- __assertTrue()__ statement is true
- __assertNull()__ Object reference is null
- __assertSame()__ Two object references point to the same isntance
- __assertNotSame__ 2 Object references dont point to the same instance
- __assertThat()__ object matches given condition


## assertThat() and Hamcrest matchers
Extend assertions with third-party libraries of ___matchers___



` assertThat(someObject, [matchesThisCondition]);`

- First parameter: Object or value
- Second parameter: Matchers that makes the assertion

Create personalized matchers by extending Matcher interface

## Exceptions 
- Test fails if it doesn't throw the exception. Example:

`@Test (expected = IllegalArgumentException.class)`
```
public void ensureThatInvalidPhoneNumberYieldsProperException(){
    FaxMachine fax = new FaxMachine();
    fax.connect("+n0t-a-ph0n3-Numb3r");
}
```
- Combine with ___try-catch___ if more information is needed. 

Example: What is the invalid argument, specific "root cause "expcetion


## Setup and teardown
- __@Before__
- __@BeforeClass__ Run only once before any test in this class.
_Example_ Server is running before making connections
- __@After__
- __@AfterClass__ Run after all tests in this class

Any number of annotations, but not specific order garantee