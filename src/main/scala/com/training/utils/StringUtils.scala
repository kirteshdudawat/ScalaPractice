package com.training.utils

/**
  * author : KD
  *
  * This class contains methods linked to String
  */
class StringUtils {

  /**
    * This method find the longest word from input provided
    * @param input A statement containing words sperated by Space
    * @return Longest word of statement
    */
  def findLongestWord(input : String) : String = {
    input.split(" ").maxBy(word => word.length)
  }

  /**
    * This method find the most re-ccuring word of a String.
    * @param input A statement containing words separated by Space
    * @return Most recurring word
    */
  def mostCommonWord(input : String) : String = {
    input.split(" ").groupBy(element => element).maxBy(element => element._2.length)._1
  }

  /**
    * It returns the most re-curring charater of statement
    * @param input A statement containing words separated by Space
    * @return Most recurring character
    */
  def mostCommonLetter(input : String) : Char = {
    input.split(" ").flatMap(str => str.toCharArray).groupBy(element => element).maxBy(element => element._2.length)._1
  }

  /**
    * It returns character to word mapping in Statements. Words are distinct.
    * @param input A statement containing words separated by Space
    * @return Letter to corresponding words map.
    */
  def letterToWord(input : String) : Map[Char, Array[String]] = {
    input.split(" ").flatMap(str => str.toCharArray.map(c => (c,str))).groupBy(c => c._1).mapValues(keySet => keySet.map(p => p._2).distinct)
  }

  /**
    * It returns List of all characters provided in input List of Strings.
    *
    * @param input List Strings
    * @return List Char
    *
    *  Ref.: https://stackoverflow.com/questions/22392787/convert-a-list-of-strings-to-a-list-of-chars
    */
  def stringArrayToCharacterArray(input : List[String]) : List[Char] = {
    input.flatten
  }

  /**
    * A function which squares all elements of a list and returns a list with the results
    * @param xs - List of Int
    * @return List of Int
    */
  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => xs
    case y :: ys => y * y :: squareList(ys)
  }

  /**
    * A function which squares all elements of a list and returns a list with the results
    * @param xs - List of Int
    * @return List of Int
    */
  def squareListV1(xs: List[Int]): List[Int] = {
    xs map (x => x * x)
  }
}
