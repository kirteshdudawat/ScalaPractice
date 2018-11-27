package com.training.queue

import scala.collection.mutable.ArrayBuffer

/**
  *
  * author : kirtesh
  *
  * @tparam T Type of Elements to be stored in Queue
  */
class ManualGenericQueue[T]() extends Queue[T]{

  private val queue = new ArrayBuffer[T]

  override def isEmpty: Boolean = queue.isEmpty

  override def enqueue(element: T): Unit = {
    queue.append(element)
  }

  override def dequeue: Option[T] = {
    if(!isEmpty)
      return Some(queue.remove(0))
    return None
  }

}