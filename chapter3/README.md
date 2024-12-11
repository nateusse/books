# An introduction to the tools

## Stop me if you've hear this before
- Book uses Java, JUnit4, Hamcrest and JMock2

## Minimal introduction to JUnit4
> **JUnit**:  Framework to walk the strcuture of a class and run within that class what represent a test

```
public class CatalogTest {
    private final Catalog catalog = new Catalog();

    @Test public void containsAnAddedEntry(){
    Entry entry = new Entry("fish","chips");
    catalog.add(entry);

    //True to condition catalog has the entry
    assertTrue(catalog.contains(entry));



    @Test public void indexesEntriesByName(){
    Entry entry = new Entry("fish","chips");
    catalog.add(entry);

    //Not a single entry for missing name
    assertNull(catalog.EntryFor("missing name"));

    // Name entry matches created
    assertEquals(entry, catalog.entryFor("fish"))
    }
} 
```

## __Test case__: Method with @Test anotation, characteristics:
- No return value
- No parameters
- Create  each time an instance of the test class and calls test method to ensure isolation, test free to change

 ## __Assertions__: Possible result with useful error messages when fail
- __assertNull__: object reference is null
- __assertNotNull__: Object not null
- __assertSame(expected, actual)__:2 reference point same object
- __assertNotSame(eunexpected, actual)__: two references do not point to the same object
- __assertArrayEquals(expectedArray, actualArray)__: two arrays are equal
- __assertTrue(condition)__: true expresion
- __assertFalse(condition)__: false expresion
- __assertEquals(expected, actual)__: Equiality two values
- __assertNotEquals(unexpected, actual)__: Values not equals


## __Expecting exception__: Extra paremeter for @Test that trows exception. 

Structure: `@Test(expected= name_exception.class)`

Example:
```
@Test(expected= IllegalArgumentException.class)
public void cannotAddTwoEntriesWithTheSameName(){
    catalog.add(new Entry("fish", "chips");
    catalog.add(new Entry("fish", "peas");
}
```
- Fails if:
    - Not throws exception
    - If throws other exception

## Test fixtures
- Fixed state at the beggining of the test
- Ensures test is repetable
- Must be setup before the test runs @__Befere__ and torn down after it has finished with annotations ___@After___
- Definied by the class that define the test in JUnit
- Set up by fields, constructor or instance initializer blocks

Example catalog:

```
public class CatalogTest {
    private final Catalog catalog = new Catalog();
    final Entry entry = new Entry("fish","chips);

    @Before public void fillTheCatalog() {
        catalog.add(entry); 
    }

    @Test public void containsAnAddedEntry(){
        assertTrue(catalog.contains(entry));
    }

    @Test public void indexesEntriesByName(){
        assertEquals(entry, catalog.entryFor("fish"))
        assertNull(catalog.EntryFor("missing name"));
    }

    @Test(expected= IllegalArgumentException.class)
    public void cannotAddTwoEntriesWithTheSameName(){
        catalog.add(new Entry("fish", "peas");
    }
```
## Test runners
__Test runner:__  Way that JUnit has to tell the class to find and run the test with __@RunWith__

JUnit has small library for test runners
    - __Parameterized__: Write data-driven test (same test methods for many different data values)

## Hamcrest Matchers and assertThat()
- __Hamcrest__ Framework to write declarative match criteria, no framework itself
    -  - User-extensible: New condition, new matcher by implementinf Matcher interface with appropiate named factory method

- __Hamcrest matcher__ : Reports whether a given object matches some criteria
    - can describe the criteria 
    - Describe why an object does not meet it's criteria
    ```
    String s = "yes we have no bananas today"

    Matcher<String> containsBananas = new StrinContains("bananas");

    Matcher<String> containsMangoes = new StrinContains("mangoes");
    ```

    - Not instantiated directly, but with static factory methods

    ```
    assertTrue(containsString("bananas").matchers(s));
    assertFalse(containsString("manoges").matchers(s));
    ```
    - Is usually used with JUnit assertThat(). Matcher describes what went wrong
    - Can combine criterias with existing matchers. Example: factory function not()
    ```
    assertThat(s, containsString("bananas"));
    assertThat(s, not(containsString("mangoes"));
    ```
    ```
    java.lang.AssertionError:
    Expected: not a string containing "bananas"
    got: "Yes, we have no bananas"
    ```
   

## JMock2: Mock Objects
- Creates mocks dynamically. No nned to create implmementation of types of mocks
- High-level API. How the object should invoke the mock object it interacts with, and how it will bhaves in response

__Mockery__: COntext of the object under test, neighboring objects

__Mock objects:__ neighboring objects while the test runs

__Expectation__: How the object under test should invoke its neighbors during the test

```
@RunWith(JMock.class) 
public class AuctionMessageTranslatorTest {

    private final Mockery context = new JUnit4Mockery();

    private final AuctionEventListener listener =
    context.mock(AuctionEventListener.class); 

    private final AuctionMessageTranslator translator =
    new AuctionMessageTranslator(listener); 

    @Test public void
    notifiesAuctionClosedWhenCloseMessageReceived() {
        Message message = new Message();
        message.setBody("SOLVersion: 1.1; Event: CLOSE;");

        context.checking(new Expectations() {{ 
            oneOf(listener).auctionClosed(); 
        }});

        translator.processMessage(UNUSED_CHAT, message); 
    } 
}
```




## Expectation
- Minimum and max number of times an invocation is expected
- Expected invocation (fails if not received) or merelly allow to happen (pass if not received)
- Parameter value (literally given or provided by Matchers)
- Ordering constraints with respect to other expectations
- What should happen when the method is invoked (value returned, exception, so on)