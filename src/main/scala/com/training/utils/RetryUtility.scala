package com.training.utils

import scala.annotation.tailrec
import scala.concurrent.TimeoutException
import scala.concurrent.duration._
import scala.util.control.NonFatal

/**
  * This class provides method that converts a method to a retry-able method.
  */
object RetryUtility {

  case class RetryParamters(attempts: Int, duration: Duration)

  /**
    * It converts a method to a retry-able method with User-specific retry attempts and duration
    *
    * @param code            Method that would be retried.
    * @param retryParameters Optional / Implicit Parameter for providing retry attempts and duration
    * @tparam T generic return object of method that needs to be invoked
    * @return response from invoked method in Optional.
    */
  def retry[T](code: => T)(implicit retryParameters: RetryParamters = RetryParamters(3, 3 seconds)): Option[T] = {
    try {
      Option(code)
    } catch {
      case _ if retryParameters.attempts > 0 =>
        Thread.sleep(retryParameters.duration.toMillis)
        retry(code)(RetryParamters(retryParameters.attempts - 1, retryParameters.duration))
      case NonFatal(e) => throw e
    }
  }
}

