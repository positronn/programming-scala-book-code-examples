// src/main/scala/progscala3/introscala/UpperMain2.scala
package progscala3.introscala

@main def Hello2(params: String*): Unit =
  /* `mkString`: concatenate the strings into a final strin. */
  val output = params.map(_.toUpperCase).mkString(" ")
  println(output)
