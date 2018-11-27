package com.training.queue

/**
  * Author : Kirtesh
  *
  *
  * trait to define a generic queue of strings with 'put' and 'get' methods
  */
trait Queue[T] {

  /**
    * Method to insert Object in Queue,
    *
    * @param t : Generic object that would be Inserted in queue.
    *
    *          Note: Check if Queue is empty before insertion.
    *
    * @return A boolean, true   If insertion succeeds
    *               OR   false  If insertion fails
    *
    */
  def enqueue(t: T) : Unit

  /**
    * Method to extract an element from queue.
    *
    * @return     None           If queue is empty.
    *         OR instanceOf T   If element is present.
    */
  def dequeue : Option[T]

  /**
    * Method to know if queue is empty or not.
    *
    * @return A boolean, true   If Queue is empty
    *                 OR false  If Queue is full.
    */
  def isEmpty: Boolean

}
