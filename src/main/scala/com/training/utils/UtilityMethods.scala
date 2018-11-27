package com.training.utils

import java.util.Collections

/**
  * Utility methods
  */
class UtilityMethods {

  /**
    * Takes three Option paramter and returns first Not None parameter. If all paramter are None than None
    *
    * @param x Option Paramter 1
    * @param y Option Paramter 2
    * @param z Option Paramter 3
    * @tparam T Generic type of element to be passed in Option
    * @return First Not None parameter. If all paramter are None than None
    */

  def returnFirstNonNone[T](x : Option[T], y : Option[T], z : Option[T]) = {
    x orElse y orElse z
  }


  /**
    * Takes variable lengtj Option paramter and returns first Not None parameter. If all paramter are None than None
    * @param elements Variable length Optional parameters
    * @tparam T Generic type of element to be passed in Option
    * @return First Not None parameter. If all paramter are None than None
    */
  def returnFirstNonNoneV1[T](elements : Option[T]*): Any = {
    elements.find(_.isDefined).flatMap(p => p)
  }

  /**
    *  This method multiply all the numbers in the list with their corresponding value in the map, and drop if don't exists.
    * @param list Input list of Int
    * @param map Input Map of Int to Double Mapping
    * @return List Double
    */
  def listMapMultiply(list: List[Int], map: Map[Int, Double]) : List[Double] = {
    // Find an easier way with get and flatMap
    //for (e <- list if map.contains(e)) yield e.toDouble * map.get(e.toInt).get

    list.filter{element => map.contains(element)}.flatMap(element => List(map.get(element).get * element))
    //list.collect({case element if map.contains(element) => map.get(element).get * element})
  }
}
