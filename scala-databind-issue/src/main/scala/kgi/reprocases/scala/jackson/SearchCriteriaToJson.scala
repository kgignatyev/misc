package kgi.reprocases.scala.jackson

import org.springframework.core.convert.converter.GenericConverter
import org.springframework.core.convert.TypeDescriptor

/**
 * User: kgignatyev
 * Date: 7/3/13
 */
class SearchCriteriaToJson extends GenericConverter{



  val types = collection.JavaConversions.setAsJavaSet( Set(
    new GenericConverter.ConvertiblePair(classOf[SearchCriteria],classOf[String]),
    new GenericConverter.ConvertiblePair(classOf[String],classOf[SearchCriteria]))
  )

  def getConvertibleTypes = types

  def convert(source: Any, sourceType: TypeDescriptor, targetType: TypeDescriptor):AnyRef = {

    if( classOf[String].equals( sourceType.getObjectType) ){
      McyObjectMapper.mapper.readValue(source.asInstanceOf[String],classOf[SearchCriteria])
    } else {
      McyObjectMapper.mapper.writeValueAsString( source )
    }
  }


}
