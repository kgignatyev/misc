package kgi.reprocases.scala.jackson

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.specs2.mutable.Specification
import org.springframework.core.convert.TypeDescriptor

/**
 * User: kgignatyev
 * Date: 7/3/13
 */
@RunWith(classOf[JUnitRunner])
class SearchCriteriaToJsonSpec extends Specification {


  "can convert string to criteria" in {
    val conv = new SearchCriteriaToJson()
    val input = """
                  |{"geoBox":{"swCorner":{"lng":0.0,"lat":51.0},"neCorner":{"lng":0.0,"lat":52.0}},"mapCenter":{"lng":0.0,"lat":52.0},"mapZoom":5,"rentals":true,"swaps":true,"requests":true,"timeInterval":{"beginning":1361260800000,"ending":1363071600000},"cruiser":0,"dualSport":0,"scooter":0,"standard":0,"touring":0,"trike":0}
                """.stripMargin

    val res = conv.convert(input, TypeDescriptor.valueOf(classOf[String]), TypeDescriptor.valueOf(classOf[SearchCriteria]))
    println(res)
    res.isInstanceOf[SearchCriteria] must beTrue
  }

}
