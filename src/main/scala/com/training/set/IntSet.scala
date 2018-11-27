package com.training.set

/**
  * Author : KD
  * Ref: http://insaneguy.me/2014/05/28/scala_week3_notes/
  */
trait IntSet {
  /**
    * Check if IntSet is empty or not
    * @return boolean true or false, based on if set is empty or not.
    */
  def isEmpty: Boolean

  /**
    * It includes element x in IntSet
    * @param x - Element to be included in IntSet
    * @return Reference to updated IntSet
    */
  def incl(x: Int): IntSet

  /**
    * Checks if element x is present in IntSet
    * @param x element to be checked
    * @return boolean true or false
    */
  def contains(x: Int): Boolean

  /**
    * Removes element x from IntSet
    * @param x element to be removed
    * @return boolean true or false
    */
  def excl(x: Int): IntSet

  /**
    * Unions two set.
    * @param set Set to be union with
    * @return Union of both sets
    */
  def union(set: IntSet): IntSet

  /**
    * It returns intersection of two sets
    * @param set Set to be insected with
    * @return Intset that is Intersection of this and set
    */
  def intersect(set: IntSet): IntSet
}

object EmptySet extends IntSet {
  def isEmpty = true
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)
  def excl(x: Int) = this
  def union(other: IntSet) = other
  def intersect(other: IntSet) = EmptySet

  override def toString = "."
}

class NonEmptySet(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet {
  def isEmpty = false

  def contains(x: Int): Boolean =
    if (x < elem)
      left contains x
    else if (x > elem)
      right contains x
    else
      true

  def incl(x: Int): IntSet =
    if (x < elem)
      new NonEmptySet(elem, left incl x, right)
    else if (x > elem)
      new NonEmptySet(elem, left, right incl x)
    else
      this

  def excl(x: Int) = {
    if (x < elem)
      new NonEmptySet(elem, left.excl(x), right)
    else if (x > elem)
      new NonEmptySet(elem, left, right.excl(x))
    else
      left union right
  }

  def union(x: IntSet) = ((left union right) union x) incl elem

  def intersect(x: IntSet):IntSet = {
    val r = right intersect x
    val l = left intersect x
    val n = l union r

    if (x contains elem)
      n incl elem
    else
      n
  }

}