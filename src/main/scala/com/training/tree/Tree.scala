package com.training.tree

abstract class IntTree

/**
  * Empty node structure
  */
case object EmptyTree extends IntTree

/**
  * Node Structure
  * @param elem Node data
  * @param left Reference to left child
  * @param right Reference to right child
  */
case class Node(val elem: Int, val left: IntTree, val right: IntTree) extends IntTree

object IntTree {
  /**
    * Method defines if an element exist in a Tree or Not
    * @param t root node
    * @param v element to be searched in tree t
    * @return Boolean true or false based on whether element exist in tree or not
    */
  def contains(t: IntTree, v: Int): Boolean = t match {

    case EmptyTree => false

    case Node(e, left, right) => {
      if (e == v)
        return true
      else if (e > v)
        contains(left, v)
      else
        contains(right, v)
    }
  }

  /**
    * Method used to insert a new element in tree
    * @param tree root node to tree in which element needs to be inserted
    * @param value element that needs to be inserted
    * @return root node reference post insertion of element
    */
  def insert(tree: IntTree, value: Int): IntTree = tree match {

    case EmptyTree => Node(value,EmptyTree,EmptyTree)

    case Node(v, left, right) =>
      if (v > value)
        Node(v, insert(left, value), right)
      else
        Node(v, left, insert(right, value))
  }

}
