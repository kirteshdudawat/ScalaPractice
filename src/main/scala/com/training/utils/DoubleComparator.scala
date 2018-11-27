package com.training.utils

object DoubleComparator {

  case class Precision(value: Double)

  implicit class DoubleComparison(value : Double){
    def ~= (comp : Double)(implicit precision: Precision = Precision(0.5)): Boolean = {
      math.abs(value - comp) < precision.value
    }
  }

  /**
    *
    * @param x Double parameter 1
    * @param y Double parameter 2
    * @param p Implicit Double paramter for precision match
    * @return Boolean true or false based on parameter x and y are equal or not.
    *
    *  Ref: https://alvinalexander.com/scala/how-to-compare-floating-point-numbers-in-scala-float-double
    */
  def ~=(x: Double, y: Double)(implicit p : Double = 0.000001): Boolean = {
    if ((x - y).abs < p) true else false
  }

}
