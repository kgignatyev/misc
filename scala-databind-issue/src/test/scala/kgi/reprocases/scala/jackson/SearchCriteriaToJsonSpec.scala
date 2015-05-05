package kgi.reprocases.scala.jackson

import org.scalatest.FunSuite

/**
 * User: kgignatyev
 * Date: 7/3/13
 */
class SearchCriteriaToJsonSpec extends FunSuite {


  test("can handle 'either'") {
    val p = new ContentPage
    p.contents += Left("some string")
    p.contents += Right(ContentPointer("a","widget"))
    val ser =  McyObjectMapper.mapper.writeValueAsString(p)
    println("ser:\n\n"+ ser)

    val newPage = McyObjectMapper.mapper.readValue(ser, classOf[ContentPage])

    assert(newPage.contents.length==2)
  }

}
