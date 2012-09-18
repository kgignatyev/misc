package kgi.poc.scala.cool.data

import org.specs2.mutable._
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner



//both ways of defining spec are failing because ClassNotFoundException

@RunWith(classOf[JUnitRunner])
class HelloWorldSpec extends Specification{
//class HelloWorldSpec extends SpecificationWithJUnit{
  override def is =

    "This is a specification to check the 'Hello world' string" ^
      p ^
      "The 'Hello world' string should" ^
      `contain 11 characters` ^
      `start with 'Hello'` ^
      `end with 'world'` ^
      end

  def `contain 11 characters` = "Hello world" must have size (11)

  def `start with 'Hello'` = "Hello world" must startWith("Hello")

  def `end with 'world'` = "Hello world" must endWith("world")

}
