package kgi.reprocases.scala.jackson

import scala.collection.mutable.ListBuffer

/**
 * Created by ignatyek on 5/5/15.
 */
class ContentPage {

  var contents:ListBuffer[Either[String,ContentPointer]] = ListBuffer()

}

case class ContentPointer (var id:String, var cType:String )
