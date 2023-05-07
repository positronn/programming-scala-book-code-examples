// src/main/scala/progscala3/introscala/UpperMain1.scala
package progscala3.introscala                                   // <1>

object UpperMain1:
  def main(params: Array[String]): Unit =                       // <2>
    print("UpperMain1.main: ")
    params.map(s => s.toUpperCase).foreach(s => printf("%s ",s))
    println("")

def main(params: Array[String]): Unit =                         // <3>
  print("main: ")
  /*
    the `foreach` method is used when we want to process
    each element and perform only side effects, without
    returning a new value. 
    in contrast, `map` returns a new value for
    each element (and isde effects should be avoided).
  */
  params.map(s => s.toUpperCase).foreach(s => printf("%s ",s))
  println("")

@main def Hello(params: String*): Unit =                        // <4>
  print("Hello: ")
  params.map(s => s.toUpperCase).foreach(s => printf("%s ",s))
  println("")

/*
  note gthat the type of the return value of all three mehtods
  is `Unit`. Fo now, think of `Unit` as analogous to `void` in other
  languages, meaning nothing useful is returned
*/

/*
  Declaring UpperMain1 as an object makes it a singleton, 
  meaning there will always be only one istance
  of it, which the scala runtime will creat for us.
  You can't create you own instances with new.
*/

/* Singleton
  In software engineering, the singleton pattern is a software design patter
  that restricts the instantiation of a class to a singular instance. One of the
  well-known "Gang of four" design patters, which describe how to solve recurring
  problems in object-oriented software, the pattern is useful when exactly
  one object is needed to coordinate actions across a system.

  More specifically, the singleton pattern allows objects to:
      * ensure they only have one instance
      * Provide easy access to that instance
      * Control their instantiation (for example, hidihng the constructors of a class)
  
  The term comes from the mathematical concept of a singleton:
      "A set with only one element".
*/

/*

  The singleton design pattern has drawbacks. It’s hard to replace a
  singleton instance with a test double in unit tests, and forcing
  all computation through a single instance raises concerns about
  thread safety and limits scalability options. However, we’ll
  see plenty of examples in the book where objects are used effectively.

*/

/* side-effects
  The notion of side effects means that the function we pass
  to `foreach` does something to affect the state outside
  the local context. We could write to a database or to a file,
  or print to the console, or launch missiles...
*/