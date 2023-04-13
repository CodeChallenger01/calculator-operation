package com.knoldus

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/* This is the driver class to print the output of all the operations */
object Driver extends App {
  /* This is instance of Calculator object */
  private val calculator = Calculator

  /* Here I am calling the calculate method to perform the addition operation */
  private val sum = calculator.calculate("+", Seq(5.0, 8.0))
  sum.onComplete {
    case Success(value) => println("Sum :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the subtraction operation */
  private val sub = calculator.calculate("-", Seq(3.0, 9.0))
  sub.onComplete {
    case Success(value) => println("Sub :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the multiplication operation */
  private val mul = calculator.calculate("*", Seq(3.0, 9.0))
  mul.onComplete {
    case Success(value) => println("Multiplication :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the division operation */
  private val div = calculator.calculate("/", Seq(9.0, 9.0))
  div.onComplete {
    case Success(value) => println("Division :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the power operation */
  private val pow = calculator.calculate("^", Seq(2.0, 3.0))
  pow.onComplete {
    case Success(value) => println("Power :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the square root operation */
  private val sqrt = calculator.calculate("sqrt", Seq(16.0))
  sqrt.onComplete {
    case Success(value) => println("SquareRoot :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the factorial operation */
  private val fac = calculator.calculate("!", Seq(3.0))
  fac.onComplete {
    case Success(value) => println("Factorial :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the sum of elements for more than 2 value */
  private val sumOfElements = calculator.calculate("sum", Seq(3.0, 9.0, 10.0))
  sumOfElements.onComplete {
    case Success(value) => println("Sum of Elements :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to perform the greater common divisor operation */
  private val gcd = calculator.calculate("gcd", Seq(15.0, 10.0))
  gcd.onComplete {
    case Success(value) => println("GCD :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to find the odd elements  */
  private val oddElements = calculator.calculate("odd", Seq(3.0, 9.0, 2.0))
  oddElements.onComplete {
    case Success(value) => println("Odd Elements " + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to find the even elements  */
  private val evenElements = calculator.calculate("even", Seq(3.0, 2.0, 9.0))
  evenElements.onComplete {
    case Success(value) => println("Even Elements :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the calculate method to list of Fibonacci  the odd elements  */
  private val fibonacci = calculator.calculate("fibonacci", Seq(8.0))
  fibonacci.onComplete {
    case Success(value) => println("Fibonacci :" + value)
    case Failure(exception) => println(exception)
  }

  /* This is instance for other three method that is used to perform multiple operation*/
  private val multipleOperators = new MultipleOperator

  /* Here I am calling the Square of Expression to perform operations */
  private val squareOfExpression = multipleOperators.squareOfExpression(12.0, 14.0)
  println("Is Expression Equal :" + squareOfExpression)

  /* Here I am calling the find method to find the factorial number greater than 6^n */
  private val findNumbers = multipleOperators.find(Seq(100.0, 200.0, 10.0))
  findNumbers.onComplete {
    case Success(value) => println("Factorial Greater than 6^n :" + value)
    case Failure(exception) => println(exception)
  }

  /* Here I am calling the find Average method to perform the operations */
  private val averageAfterChaining = multipleOperators.findAverageAfterChainingOperations(Seq(4.0, 3.0, 5.0, 10.0))
  averageAfterChaining.onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  }

  Thread.sleep(2000)

}
