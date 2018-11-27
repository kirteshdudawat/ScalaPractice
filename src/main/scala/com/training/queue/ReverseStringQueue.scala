package com.training.queue

/**
  * author : KD
  *
  * Implementation of Stackable Trait Pattern Using Manual Generic Queue Class.
  *
  * Ref: https://www.artima.com/scalazine/articles/stackable_trait_pattern.html
  *
  *
  */
trait ReverseStringQueue extends Queue[String] {

  /**
    * This method reverses the String before passing to Super class Manual Generic Queue class.
    *
    * @param element Element to be inserted in queue
    * @return A boolean, true   If insertion succeeds
    *               OR   false  If insertion fails
    *
    */
  abstract override def enqueue(element : String) : Unit = super.enqueue(element.reverse)

}
