package com.training.utils

/**
  * Lazy Initialization
  *
  * @param elements Sequence of Integers
  */
class VectorClz(elements: Seq[Int]) {

  lazy val x = getSquareList(elements)
  lazy val y = x.foldLeft(0)(_ + _)
  lazy val z = Math.sqrt(y)

  /**
    * Return Square list of inserted Sequence of Int,
    *
    * @param list List if Integers
    * @return List of Integer, which would be square of elements provided in Input
    */
  def getSquareList(list: Seq[Int]): Seq[Int] = list map (n => n * n)
}

