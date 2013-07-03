package kgi.reprocases.scala.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.datatype.joda.JodaModule

/**
 * User: kgignatyev
 * Date: 7/3/13
 */
class McyObjectMapper extends ObjectMapper{
  registerModule(DefaultScalaModule)
  registerModule(new JodaModule)

}

object McyObjectMapper {

  val mapper = new McyObjectMapper
}
