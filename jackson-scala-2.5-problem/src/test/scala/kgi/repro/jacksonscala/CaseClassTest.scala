package kgi.repro.jacksonscala


import java.text.SimpleDateFormat

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.BeforeAndAfterAll
import org.scalatest.FunSuite

import scala.beans.BeanProperty

/**
 * Created by ignatyek on 1/6/15.
 */

class LabeledValue[T](@BeanProperty  var label:String ,@BeanProperty var value:T )


class CaseClassTest extends FunSuite  {

  val om:ObjectMapper = {
    val res = new ObjectMapper
    res.registerModule(DefaultScalaModule)
    res.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"))
    res
  }

  test("serialize case class"){
     val v = new LabeledValue("aaaaa","bbbbb")

     val serializedV =  om.writeValueAsString(v)
    println("serializedV = \n" + serializedV)

    val deserializedV = om.readValue(serializedV, classOf[LabeledValue[_]])

    println(deserializedV)

  }

}
