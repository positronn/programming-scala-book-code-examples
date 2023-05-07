// src/main/scala/progscala3/introscala/UpperMain2.scala
package progscala3.introscala

@main def Hello2(params: String*): Unit =
  /* `mkString`: concatenate the strings into a final string. */
  val output = params.map(_.toUpperCase).mkString("[", ", ", "]")
  /* note the function passed to `map`. The following funciton literals
  are esentually rhe same:
    s => s.toUpperCase
    _.toUpperCase
  Rather than providing a name for the single argument, we can use _ as a placeholder.
  This generalizes to functions with two or more arguments, where each
  use of _ takes the place of one argument. 
  This means that placeholders can’t be used if it’s necessary to refer
  to any one of the arguments more than once.
  */
  println(output)
