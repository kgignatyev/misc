package kgi.repro.repl_in_war

import org.springframework.beans.factory.InitializingBean
import scala.tools.nsc.interpreter.IMain

import scala.tools.nsc.Settings

/**
 * User: kgignatyev
 * Date: 10/29/13
 */
class ReplService extends InitializingBean {

  var repl: IMain = _


  def afterPropertiesSet() {

    // per thread fixed, still do not like classpath construction at all
    // https://groups.google.com/forum/#!topic/scala-user/wV86VwnKaVk

    val cl = this.getClass.getClassLoader // or getClassLoader.getParent, or one more getParent...

    val urls = cl match {
      case cl: java.net.URLClassLoader => cl.getURLs.toList
      case a => sys.error("oops: I was expecting an URLClassLoader, foud a " + a.getClass)
    }
    val classpath = urls map {_.toString}
    val settings = new Settings
    settings.classpath.value = classpath.distinct.mkString(java.io.File.pathSeparator)
    settings.embeddedDefaults(cl)



//    settings.usejavacp.value = true
    settings.Yreplsync.value = true


    repl = new IMain(settings)


    repl.bind("MotoLocationsService", "test")


  }

  def interpret(code: String): scala.tools.nsc.interpreter.IR.Result = {
    val res = repl.interpret(code)
    res
  }

}
