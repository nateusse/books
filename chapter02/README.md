# Chapter 2: Operators

 ` var res = a + b; `

- __Operator__: Special symbol that can be applied to a set of variables, values or literals-referred to as operands-and that returns a result. 

    - Operators:  = , +
- __Operand__: Value or variable the operator is being applied to

    - Operands: a, b

- __Result__: Output operation
    - result assigned to res

## Type of operators
- __Unary__: Requires one operand , or variable, to function


| Method| Example |Description |
|:----------|:------:|---------:|
| Logical complement | !a  | Inverts a boolean’s logical value |
| Bitwise complement | ~b | Inverts all 0s and 1s in a number |
| Plus | +c | Indicates a number is positive, although numbers are assumed to be positive in Java unless accompanied by a negative unary operator |
| Negation or minus | -­d |Indicates a literal number is negative or negates an expression |
| Increment | ++e , f++ | Increments a value by 1|
| Decrement| -­-­f ,  h-­-­ | Decrements a value by 1 |
| Cast | (String)i | Casts a value to a specific type |

- __Binary__:
- __ternary__:
 
## Operator procedment
Which operators are evaluated and in which order

| Operator | Symbols and examples | Evaluation |
|:----------|:------:|---------:|
Post-­unary operators| expression++, expression-­- |­Left-­to-­right|
|Pre-­unary operators | ++expression, -­-­expression |Left-­to-­right|
| Other unary operators|-­, !, ~, +, (type)|Right-­to-­left|
|Cast | (Type)reference | Right-­to-­left|
|Multiplication/division/modulus|*, /, %|Left-­to-­right|
|Addition/subtraction |+, - | ­Left-­to-­right|
|Shift operators | <<, >>, >>> |Left-­to-­right|
|Relational operators | <, >, <=, >=, instanceof | Left-­to-­right|
|Equal to /not equal to | ==, != | Left-­to-­right|
| Logical | AND& | Left-­to-­right |
| Logical exclusive | OR^ | Left-­to-­right |
| Logical inclusive | OR | Left-­to-­right |
| Conditional AND | && | Left-­to-­right |
| Conditional OR | II | Left-­to-­right |
| Ternary operators | boolean expression ? expression1 : expression2 | Right-­to-­left|
| Assignment operators | =, +=, -­=, *=, /=, %=, &=, ^=, !=, <<=, >>=, >>>= | Right-­to-­left|
Arrow operator | -­> | Right-­to-­left|

