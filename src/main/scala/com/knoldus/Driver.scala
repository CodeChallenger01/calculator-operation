package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/* This is the driver class to print the output of all the operations */
object Driver extends App {
  private val loggers = Logger(getClass)
  /* This is instance of Calculator object */
  private val calculator = Calculator

  /* Here I am calling the calculate method to perform the addition operation */
  private val sum = calculator.calculate("+", Seq(5.0, 8.0))
  sum.onComplete {
    case Success(value) => loggers.info("Sum :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the subtraction operation */
  private val sub = calculator.calculate("-", Seq(3.0, 9.0))
  sub.onComplete {
    case Success(value) => loggers.info("Sub :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the multiplication operation */
  private val mul = calculator.calculate("*", Seq(3.0, 9.0))
  mul.onComplete {
    case Success(value) => loggers.info("Multiplication :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the division operation */
  private val div = calculator.calculate("/", Seq(9.0, 9.0))
  div.onComplete {
    case Success(value) => loggers.info("Division :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the power operation */
  private val pow = calculator.calculate("^", Seq(2.0, 3.0))
  pow.onComplete {
    case Success(value) => loggers.info("Power :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the square root operation */
  private val sqrt = calculator.calculate("sqrt", Seq(16.0))
  sqrt.onComplete {
    case Success(value) => loggers.info("SquareRoot :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the factorial operation */
  private val fac = calculator.calculate("!", Seq(3.0))
  fac.onComplete {
    case Success(value) => loggers.info("Factorial :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the sum of elements for more than 2 value */
  private val sumOfElements = calculator.calculate("sum", Seq(3.0, 9.0, 10.0))
  sumOfElements.onComplete {
    case Success(value) => loggers.info("Sum of Elements :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to perform the greater common divisor operation */
  private val gcd = calculator.calculate("gcd", Seq(15.0, 10.0))
  gcd.onComplete {
    case Success(value) => loggers.info("GCD :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to find the odd elements  */
  private val oddElements = calculator.calculate("odd", Seq(3.0, 9.0, 2.0))
  oddElements.onComplete {
    case Success(value) => loggers.info("Odd Elements " + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to find the even elements  */
  private val evenElements = calculator.calculate("even", Seq(3.0, 2.0, 9.0))
  evenElements.onComplete {
    case Success(value) => loggers.info("Even Elements :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the calculate method to list of Fibonacci  the odd elements  */
  private val fibonacci = calculator.calculate("fibonacci", Seq(8.0))
  fibonacci.onComplete {
    case Success(value) => loggers.info("Fibonacci :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* This is instance for other three method that is used to perform multiple operation*/
  private val multipleOperators = new MultipleOperator

  /* Here I am calling the Square of Expression to perform operations */
  private val squareOfExpression = multipleOperators.squareOfExpression(12.0, 14.0)
  loggers.info("Is Expression Equal :" + squareOfExpression)

  /* Here I am calling the find method to find the factorial number greater than 6^n */
  private val findNumbers = multipleOperators.find(Seq(100.0, 200.0, 10.0))
  findNumbers.onComplete {
    case Success(value) => loggers.info("Factorial Greater than 6^n :" + value)
    case Failure(exception) => loggers.warn("Error",exception)
  }

  /* Here I am calling the find Average method to perform the operations */
  private val averageAfterChaining = multipleOperators.findAverageAfterChainingOperations(Seq(4.0, 3.0, 5.0, 10.0))
  averageAfterChaining.onComplete {
    case Success(value) => loggers.info(s"$value")
    case Failure(exception) => loggers.warn("Error",exception)
  }

  Thread.sleep(2000)

}
