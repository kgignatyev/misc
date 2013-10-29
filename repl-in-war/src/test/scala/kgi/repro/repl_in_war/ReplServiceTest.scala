package kgi.repro.repl_in_war

import org.scalatest.FunSuite
import org.springframework.context.support.ClassPathXmlApplicationContext


/**
 * User: kgignatyev
 * Date: 10/29/13
 */
class ReplServiceTest extends FunSuite {

  val springCxt = {
        val cxt = new ClassPathXmlApplicationContext()
        cxt.setConfigLocation("classpath:/applicaiton.xml")
        cxt.refresh()
        cxt
      }

  test("repl execution") {
    val repl = springCxt.getBean(classOf[ReplService])
    println(repl.interpret("val a = 2 + 2"))
    println(repl.interpret("println( MotoLocationsService )"))
  }

}
