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

__Test case__: Method with @Test anotation, characteristics:
- No return value
- No parameters
- Create  each time an instance of the test class and calls test method to ensure isolation, test free to change

__Assertions__: Possible result with useful error messages when fail
- __assertNull__: object reference is null
- __assertNotNull__: Object not null
- __assertSame(expected, actual)__:2 reference point same object
- __assertNotSame(eunexpected, actual)__: two references do not point to the same object
- __assertArrayEquals(expectedArray, actualArray)__: two arrays are equal
- __assertTrue(condition)__: true expresion
- __assertFalse(condition)__: false expresion
- __assertEquals(expected, actual)__: Equiality two values
- __assertNotEquals(unexpected, actual)__: Values not equals


__Expecting exception__: Extra paremeter for @Test that trows exception. 
- `@Test(expected: name_exception.class)`
- Fails without exception
- Fails if throws other exception