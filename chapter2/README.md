# Test-Driven Development with Objects

## A web of Objects
- Object oriented design cares about the communition between objects.
- Objects communicate by messages, by methods to handle them and by encapsulating internal states used to coordinate communication
- Change behavior of the system by changing composition between objects, what we want to do, not how, is a declarative definition.

## Values and Objects
- Identify which  values that change states or not over time.
- Values are inmutable instances that model fixed quantities, same identity if same state
- Objects uses vaules that mutate, different identity even with same state (can diverge when receive message)
- Values has piece of functionality, objects implement stateful behaviors


## Follow the message
- Domain model is the communication patterns
- Communication patterns: Rules to define how objects talk to each other, what is the message, when send it, so on..s
- In java object roles are defined by abstract interfaces.
- Think of objects (implementation of a role) in termn of roles (related responsabilities), responsability (obligation to perfmorm a task) and collaborators (interaction between objects y/o roles)
- Use CRC cards (candidates, responsabilities and collaborators)


## Tell, don't ask
- What message objects communicate between each other? What they want in terms of the neighbors' role, but the called object should decide how to make that happen
- **Demeter's law**: Tell, don't ask. Objects take decision based only in the information they hold internally or what it came with the triggering message, avoid navigation other objectos to make things happen
- Easy swap objects with same role
- Caller doesn't see nothing of their internal strcuture or the rest of the system behind role interface.
- Not following tell, don't ask results in **"Train wreck"**, a series of getters chained together like a train:
    - Example: `((EditSaveCustomizer) master.       getModelSable()
        .getDockablePanel()
            .getCustomized())
                .getSaveItem().setenabled(Boolean.FALSE.booleanValue()); `
    - Instead, do: `master.allowSavingCustomisations();`

- Lesson:Wrap implementation detail up behind a single call, reduce risk of a design change affecting little other parts
- Name interaction explicitly between objects, rather than implicit in the chain of getters. Clearer what is for, not jus how it happens the implementation.

## But sometime ask
- Ask values, collections, or factory to create objects.
- Ocassionally ask objects about their states when searching or filtering ("avoiding train wreck")
- ASk the question I really want answered, not the info to help us figure out the ansers ourselves:
    - Example wrong:   `if (carriage.getSeat().getPercentReserved() < percentReserbedBarrier){...} `
    - Good: ` if (carriage.hasSeatAvailableWithin(percentReservedBarrier)){...}`
- Explanatory names, and queries that describe the intention of calling objects, makes testing easier

## Unit-Testing the Collaborating Objects
- How to send messages without exposing states? Without states, waht can we assert during testing? How to check is doing it correctly?
- Replace neighbors with mocks to check "expectations" (how we expect communication to works between target and mockes)
- Mocks assert they have been called as expected, they also implmeents stubbed behaviors needed for the test to work
- **Interface discovery**: Using interface in testing  to see the supporting roles our target object needs when we don't know how the neighboor looks like.

## Support for TDD with Mock Objects
1. Create mock instances of the neighbors
2. Create real objects, including target
3. Specify how target call mock objects
4. Call triggering method on target object
5. Assert valid relationships and that all calls were made
- **Unit test**: Makes explicit relationship between target objects and its environment
- Make clear:
    - Intention of every test
    - Test functionality
    - Supporting infraestructure
    - Object infraestrcuture