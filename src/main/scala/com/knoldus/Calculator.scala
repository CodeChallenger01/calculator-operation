package com.knoldus

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/* A class for the Exception  to throw*/
class CalculatorException extends Exception("Operation Failed ")

/* A class to perform the Addition operation  */
class Addition extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2) true
    else false
  }

  /* A method to perform the addition operation */
  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head + operands.last)
  }
}

/* A class to perform the subtract operation */
class Subtraction extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    if (operands.head > operands.last) Seq(operands.head - operands.last)
    else Seq(operands.last - operands.head)
  }
}

/* A class to perform the Multiplication operation */
class Multiplication extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2 && operands.head != 0 && operands.last != 0) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(operands.head * operands.last)
  }
}

/* A class to perform the Division operation */
class Division extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2 && operands.last != 0) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    val numerator = operands.head
    val denominator = operands.last
    Seq(numerator / denominator)
  }
}

/* A class to perform the Power operation */
class Power extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2 && operands.head >= 1 && operands.last >= 1) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    val base = operands.head
    val exponent = operands.last.toInt
    val fac = for {
      x <- 1 to exponent
    } yield base.toInt
    Seq(fac.foldLeft(1)((a, b) => a * b).toDouble)
  }
}

/* A class to perform the square root of the number */
class SquareRoot extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 1 && operands.head >= 1) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    Seq(Math.sqrt(operands.head))
  }
}

/* A class to perform the Factorial of the number */
class Factorial extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 1 && operands.head >= 1) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    def factorial(number: Double, acc: Double): Double = {
      if (number <= 1) acc
      else factorial(number - 1, acc * number)
    }

    val factorialOfNumber = factorial(operands.head, 1)
    Seq(factorialOfNumber)
  }
}

/* This class is used to perform the sum of list of elements*/
class SumOfElements extends Operator with Validator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.nonEmpty) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    val operandsToList = operands.toList
    Seq(operandsToList.reduceLeft((a: Double, b: Double) => a + b))
  }
}

/* This method is used to perform the GCD Operation */
class GreatestCommonDivisor extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 2 && operands.head > operands.last && operands.head >= 1 && operands.last >= 1) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    val number1 = operands.head.toInt
    val number2 = operands.last.toInt
    val listOfDivisorOfNumber1 = (1 to number1).filter { num => number1 % num == 0 }.toSet
    val listOfDivisorOfNumber2 = (1 to number2).filter { num => number2 % num == 0 }.toSet
    val commonDivisor = listOfDivisorOfNumber1.flatMap { num =>
      listOfDivisorOfNumber2.filter { secondListNum => secondListNum == num }
    }
    Seq(commonDivisor.last)
  }
}

/* This class is used to find the Odd elements of the Sequence */
class OddElements extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.nonEmpty) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    operands.filterNot(x => x % 2 == 0)
  }
}

/* This class is used to find Even Elements Of Sequence */
class EvenElements extends Operator with Validator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.nonEmpty) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    operands.filter(x => x % 2 == 0)
  }
}

/* This class is used to find the list of Fibonacci number */
class Fibonacci extends Operator {
  override def validate(operands: Seq[Double]): Boolean = {
    if (operands.size == 1) true
    else false
  }

  override protected def execute(operands: Seq[Double]): Seq[Double] = {
    val number = operands.head.toInt
    var fibonacciList = Seq[Double](0, 1)
    (2 until number).map { index =>
      fibonacciList = fibonacciList :+ (fibonacciList(index - 1) + fibonacciList(index - 2))
    }
    fibonacciList
  }
}

/* This is a different class that is used to perform multiple operations */
class MultipleOperator {
  /* This method is used to check the Square of expression is true or not */
  def squareOfExpression(firstOperand: Double, secondOperand: Double): String = {
    val addition = new Addition
    val pow = new Power
    val mul = new Multiplication
    val list = Seq(firstOperand, secondOperand)
    val resultOfLhs = pow.validateAndExecute(addition.validateAndExecute(list) ++ Seq(2.0))
    val resultOfRhsHalfPart = addition.validateAndExecute(pow.validateAndExecute(Seq(firstOperand, 2)) ++ pow.validateAndExecute(Seq(secondOperand, 2)))
    val totalResultOfRhs = addition.validateAndExecute(resultOfRhsHalfPart ++ mul.validateAndExecute(mul.validateAndExecute(Seq(2, firstOperand)) ++ Seq(secondOperand)))
    if (resultOfLhs == totalResultOfRhs) "Equal"
    else "Not Equal"
  }

  /* This method is used to find the number whose factorial is greater than 6^num */
  def find(numbers: Seq[Double]): Future[Seq[Double]] = {
    @tailrec
    def findFactorial(number: Double, acc: Double): Double = {
      if (number <= 1) acc
      else findFactorial(number - 1, acc * number)
    }

    val res = numbers.filter { num =>
      val res1 = findFactorial(num, 1)
      res1 > math.pow(6, num)
    }
    Future(res)
  }

  /* This method is used to find the average after performing the fibonacci on each number, filter the odd elements */
  def findAverageAfterChainingOperations(numbers: Seq[Double]): Future[Double] = {
    Future {
      def fibonacci(times: Double, numberOne: Double, numberTwo: Double): Double = {
        if (times <= 1) numberTwo
        else fibonacci(times - 1, numberTwo, numberOne + numberTwo)
      }

      val filteredDataNumbers = numbers.filter { num =>
        val res = fibonacci(num.toInt, 0, 1)
        res % 2 != 0
      }
      filteredDataNumbers.foldLeft(0.0)((numOne: Double, numTwo: Double) => numOne + numTwo) / filteredDataNumbers.size
    }
  }
}


object Calculator {
  /* This method is used to match with operator and call the execute method */
  def calculate(operator: String, operands: Seq[Double]): Future[Seq[Double]] = {
    operator match {
      case "+" => execute(new Addition, operands)
      case "-" => execute(new Subtraction, operands)
      case "*" => execute(new Multiplication, operands)
      case "/" => execute(new Division, operands)
      case "^" => execute(new Power, operands)
      case "sqrt" => execute(new SquareRoot, operands)
      case "!" => execute(new Factorial, operands)
      case "sum" => execute(new SumOfElements, operands)
      case "gcd" => execute(new GreatestCommonDivisor, operands)
      case "odd" => execute(new OddElements, operands)
      case "even" => execute(new EvenElements, operands)
      case "fibonacci" => execute(new Fibonacci, operands)
      case _ => throw new CalculatorException
    }
  }

  /* This method is used to call the specific class for performing the operation as matched from above method */
  private def execute(operator: Operator, operands: Seq[Double]): Future[Seq[Double]] = {
    Future {
      val result = operator.validateAndExecute(operands)
      result
    }.recoverWith {
      case ex => Future.failed(ex)
    }
  }
}