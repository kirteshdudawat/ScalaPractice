package com.training

import com.training.queue.{ManualGenericQueue, ReverseStringQueue}
import com.training.utils.{MathUtils, VectorClz, RetryUtility, UtilityMethods, StringUtils}
/**
  * author : Kirtesh
  *
  *
  * Application Start Up from Here
  *
  */
object StartUp {

  def main(args : Array[String]): Unit = {
    // Start-up Logic needs to go here.. Question: How Scala application starts up.....
    println("Application Startup")

    //val queue = new ManualGenericQueue[Int](3)
    //queue.printArray

    //val queue = new ReverseStringQueue[String]

    /*
    val queue = new ManualGenericQueue[String](1) with ReverseStringQueue
    queue.enqueue("Hello")
    queue.enqueue("World")
    queue.printArray*/

    //println(MathUtils.medianCalculator(Seq(5.5,6,7,8, 1.0,2.0,3.0,4.5)))

    //val vec = new VectorClz(Seq(1,2,3,4,5))

    //val test = new RetryUtility()
    //test.retry(test.dummyMethod())

    //val test1 = new UtilityMethods()
    //println(test1.returnFirstNonNoneV1(Some(5), Some(4), None, None, None))

    //val list = 1 :: 2 :: 3 :: Nil
    //val states = Map(1 -> 1.0, 2 -> 8.0)
    //println(test1.listMapMultiply(list, states))

    //val stringUtils = new StringUtils
    //println(stringUtils.letterToWord("Hello"))
/*
    val q = new ManualGenericQueue[Int]
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    println(q.dequeue)
    println(q.dequeue)
    println(q.dequeue)
    println(q.dequeue) */

  }

}
