package kgi.reprocases.scala.jackson

import scala.beans.{BeanProperty, BeanInfo}


/**
 * User: kgignatyev
 * Date: 7/3/13
 */
@BeanInfo()
class SearchCriteria extends Serializable {


  @BeanProperty var mapZoom:Int = 4

  @BeanProperty var rentals:Boolean  = true
  @BeanProperty var swaps:Boolean  = true
  @BeanProperty var requests:Boolean  = true

}
