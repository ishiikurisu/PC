# Functions

    any x;
    x: any

    any f(any x) {...}
    f: any -> any

Let "any" be a generic type.

# Monoids

A monoid is a set A equipped with

+ a binary operation a + b

    a, b @ A | a + b @ A

+ a unit object e @ A

    a, b, c @ A, a+(b+c) == (a+b)+c
    £ a @ A, e+a = a+e = a

A monoid object in a monoidal category C is an object
A @ C equipped with morphisms satisfying associative
and unit axioms.



# Monads
