// src/main/scala/progscala3/introscala/shapes/Shapes.scala
package progscala3.introscala.shapes

/*
  The `case` keyword before the class declaration causes special handling.
  First, each constructor parameter is automatically converted to a read-only
  (immutable) field for `Point` instances. In other words, it's as if we put a 
  `val` before each field declaration.
  When you instantiate a `Point` instance named `point`, you can read the fields
  using `point.x` and `point.y`, but you cant change their values. Attempring
  to write point = 3.0 causes a compilation error.
*/
case class Point(x: Double = 0.0, y: Double = 0.0)                    // <1>

abstract class Shape():                                               // <2>
  /**
   * Draw the shape.
   * @param f is a function to which the shape will pass a
   * string version of itself to be rendered.
   */
  def draw(f: String => Unit): Unit =
      f(s"draw: $this")               // <3>
// interpolated strings: 
//    begin with s""
// If you forget the s before the interpolated string, you’ll get the lit‐ eral output draw: $this, with no interpolation.

case class Circle(center: Point, radius: Double)                      // <4>
      extends Shape

case class Rectangle(lowerLeft: Point, height: Double, width: Double) // <5>
      extends Shape

case class Triangle(point1: Point, point2: Point, point3: Point)      // <6>
      extends Shape


/*
While there is no class body for `Point` another feature of the `case` keyword
is that the compiler automatically generates several methods for us, including
commonly used `toString`, `equals` and `hashCode` methods.
The equals and hashCode methods are difficult for most developers to
implement correctly, so autogeneration of these methods is a real benefit.
However, you can provide your own definitions for any of these
methods, if you prefer.

When we asked if p20 == p20b and p20 == p02, Scala invoked the generated
equals method, which compares the instances for equality by comparing the
fields. (In some languages, == just compares references. Do p20 and
p20b point to the same spot in memory?)

The last feature of case classes that we’ll mention now is that the compiler
also gener‐ ates a companion object, a singleton object of the same name,
for each case class. In other words, we declared the class Point, and the
compiler also created an object Point.

You can define companions yourself. Any time an object and a class have the
same name and they are defined in the same file, they are companions.


To recap, when an argument list is put after an object or class instance,
Scala looks for an apply method to call where the param‐ eter list matches
the provided arguments. Hence, anything with an apply method behaves
like a function—e.g., Point(2.0, 3.0).

A companion object apply method is a factory method for the companion
class instances. A class apply method has whatever meaning is
appropriate for instances of the class; for example, Seq.apply(index: Int)
returns the item at position index.


Normally in FP, we prefer pure functions that have no side effects and
return all their work as their return value. These functions are far
easier to reason about, test, com‐ pose, and reuse. Side effects are a
common source of bugs, so they should be used carefully.

Use side effects only when necessary and in well-defined places. Keep
the rest of the code pure.
*/

/*
When a function accepts other functions as parameters or returns functions
as values, it is called a higher-order function (HOF).
*/