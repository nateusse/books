# What is the point of Test - Driven Development


## Software development is a learning process
Anticipate changes 

## Feedback is the fundamental tool
Work with changes:
1. Work iterative: Progressively features based in feedback until good enough.
2. Work incremental: Feature by feature.
  
  
## Practice that support changes
Anticipate changes:
1. Automatized testing 
2. Refactoring, to keep code simple

Refactoring vs Redesing
- Refactoring: Change structure, without changing behavior
- Redesing:  Change large-scale structure of the code

Test Driven Development (TDD) is testing before coding, testing now is  design to achive simple code that is modular and change proved.

TDD feedback:
1. Implmenetation: Does it work?
- Errors, bugs
2. Design: Is it well strcutured? 
 - Are the compoenents loosely couple to be tested
 - Avoid unnecesary features
 - Aceptance criteria for tests

## Test- Driven Development in a Nutsell

Test Driven Development (TDD) Cycle: 
1. Write failure unit test
2. Make the test pass
3. Refactor

## The big picture

Acceptance test:
- Functionality I want, directly relevant
- Procede to TDD cycle
- Test end-to-end without directly calling internal code, avoid internal objects and its methods if possible.

## Levels of testing
- Acceptance: Does it work?
- Integration: Code works along code we can't cahnge?
- Unit: Objects does the right thing

## External and internal quality