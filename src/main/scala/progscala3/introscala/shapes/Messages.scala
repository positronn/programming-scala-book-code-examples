// src/main/scala/progscala3/introscala/shapes/Messages.scala
package progscala3.introscala.shapes

sealed trait Message                                                 // <1>
case class Draw(shape: Shape) extends Message                        // <2>
case class Response(message: String) extends Message                 // <3>
case object Exit extends Message                                     // <4>

/*
A trait is similar to an abstract class.

The `sealed` keyword means that we can only define subtypes of `Message`
in the same file. This prevents bugs where users define their own `Message`
subtypes that would beak the code.
*/
