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




    val settings = new Settings
    settings.usejavacp.value = true
    settings.Yreplsync.value = true


    repl = new IMain(settings)


    repl.bind("MotoLocationsService", "test")


  }

  def interpret(code: String): scala.tools.nsc.interpreter.IR.Result = {
    val res = repl.interpret(code)
    res
  }

}
