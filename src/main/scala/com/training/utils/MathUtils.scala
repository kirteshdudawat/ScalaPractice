package com.training.utils

/**
  * author : kirtesh
  *
  */


object MathUtils {
  /**
    * This method calculates Greatest Common Divisor for given two paramer a and b
    *
    * @param a Paramter 1
    * @param b Paramter 2
    * @return Integer that would be gcd of the two parameter received.
    */
  def gcd(a: Int, b: Int): Int = {

    val _a = math.abs(a)
    val _b = math.abs(b)

    if(_b == 0) return _a

    _a % _b match {
      case 0 => _b
      case _ => gcd(_b, _a%_b)
    }
  }

  /**
    * This method takes Method as parameter and produces output for
    *
    * @param block call by name
    * @param R Generic Class Type
    * @return R, Generic Class Object
    */
  def timeit[R](block: => R)(print: Any => Unit = println): R = { //print : Any = println(_ : Any)
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    print(s"Elapsed time: ${(t1 - t0)/1000000} ms")
   //println(s"Elapsed time: ${(t1 - t0)/1000} ms")
    result
  }
  // How do you test this - need to make sure the time is correct enough

  
  /**
    * This methods calculates and return median for provided Sequence of Numeral.
    * @param seq Sequence of Numeral
    * @tparam T - Type of Elements in Seq
    * @return Double. Median for Input sequence
    */
  def medianCalculator[T](seq: Seq[T])(implicit numeric: Numeric[T]): Double = {

    if(seq.isEmpty){
      0.0
    }

    val sortedSeq = seq.sorted

    if (seq.size % 2 == 1)
      sortedSeq(sortedSeq.size / 2).asInstanceOf[Double]
    else {
      val (up, down) = sortedSeq.splitAt(seq.size / 2)
      val sum = numeric.plus(up.last, down.head)
      numeric.toDouble(sum) / 2
    }
  }


}
