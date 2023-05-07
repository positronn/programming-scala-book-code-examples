// src/main/scala/progscala3/introscala/shapes/ProcessMessages.scala
package progscala3.introscala.shapes

object ProcessMessages:                                              // <1>
  def apply(message: Message): Message =                             // <2>
    message match                                                    // <3>
      case Exit =>                    // pattern matching: protected by sealing
        println(s"ProcessMessage: exiting...")
        Exit
      case Draw(shape) =>             // polymorphic dispatch
        shape.draw(str => println(s"ProcessMessage: $str"))
        Response(s"ProcessMessage: $shape drawn")
      case Response(unexpected) =>    // pattern matching: protected by sealing
        val response = Response(s"ERROR: Unexpected Response: $unexpected")
        println(s"ProcessMessage: $response")
        response

/*
The `match` expressions work a lot like `if/else` expressions but are more
powerful and concise. When one of the patterns amtches, the block of 
expressions after the arrow (=>) is evaluated, upto the next `case` keyword
or the end of the whole expression. Matching is `eager`: the first match wins

If the case clauses don’t cover all possible values that can be passed to
the match expression, a MatchError is thrown at runtime.

Fortunately, the compiler can detect and warn you that the case clauses
are not exhaustive, meaning they don’t handle all possible
inputs. Note that our sealed hierarchy of messages is crucial here.
If a user could create a new subtype of Message, our match
expression would no longer cover all possibilities. Hence, a bug
would be introduced in this code!

A powerful feature of pattern matching is the ability to extract data from
the object matched, sometimes called deconstruction (the inverse
of construction).
Here, when the input message is a Draw, we extract the enclosed Shape
and assign it to the vari‐ able shape. Similarly, if Response is
detected, we extract the message as unexpected, so named because
ProcessMessages doesn’t expect to receive a Response!
*/

/**
 * 
 * One of the tenets of OOP is that you should never use if or
 * match statements that match on instance type because inheritance
 * hierarchies evolve. When a new subtype is introduced without also
 * fixing these statements, they break. Instead, polymorphic
 * methods should be used. So, is the pattern-matching code
 * just discussed an antipattern?
 * 
 * 
 * Pattern Matching Versus Subtype Polymorphism
 * Pattern matching plays a central role in FP just as subtype
 * polymorphism (i.e., overrid‐ ing methods in subtypes) plays a central
 * role in OOP. The combination of functional- style pattern
 * matching with polymorphic dispatch, as used here, is a powerful
 * combination that is a benefit of a mixed paradigm language like Scala.
 */
