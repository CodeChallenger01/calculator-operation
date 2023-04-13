import com.knoldus.{Calculator, MultipleOperator}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorTest extends AnyFlatSpec with Matchers with ScalaFutures {
  val calculator = Calculator


  "sum" should "return sum of value " in {
    val actualOutput = calculator.calculate("+", Seq(5.0, 8.0))
    val expectedOutput = List(13.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "sub" should "return subtraction of value " in {
    val actualOutput = calculator.calculate("-", Seq(5.0, 8.0))
    val expectedOutput = List(3.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "mul" should "return multiplication of value " in {
    val actualOutput = calculator.calculate("*", Seq(5.0, 8.0))
    val expectedOutput = List(40.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "div" should "return division of value " in {
    val actualOutput = calculator.calculate("/", Seq(6.0, 2.0))
    val expectedOutput = List(3.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "pow" should "return Power of value " in {
    val actualOutput = calculator.calculate("^", Seq(2.0, 3.0))
    val expectedOutput = List(8.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "sqrt" should "return square root of value " in {
    val actualOutput = calculator.calculate("sqrt", Seq(16.0))
    val expectedOutput = List(4.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "!" should "return factorial  value " in {
    val actualOutput = calculator.calculate("!", Seq(5.0))
    val expectedOutput = List(120.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "sumOfElements" should "return sum of more than two elements" in {
    val actualOutput = calculator.calculate("sum", Seq(15.0, 10.0, 12.0))
    val expectedOutput = List(37.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "gcd" should "return gcd  value " in {
    val actualOutput = calculator.calculate("gcd", Seq(15.0, 10.0))
    val expectedOutput = List(5.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "oddElements" should "return odd values " in {
    val actualOutput = calculator.calculate("odd", Seq(15.0, 10.0))
    val expectedOutput = List(15.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "evenElements" should "return Even values " in {
    val actualOutput = calculator.calculate("even", Seq(15.0, 10.0))
    val expectedOutput = List(10.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "fibonacci" should "return fibonacci of series " in {
    val actualOutput = calculator.calculate("fibonacci", Seq(8.0))
    val expectedOutput = List(0.0, 1.0, 1.0, 2.0, 3.0, 5.0, 8.0, 13.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  /* Other three multiple operator expressions */
  val multipleOperator = new MultipleOperator

  "squareOfExpression" should "return equal or not equal " in {
    val actualOutput = multipleOperator.squareOfExpression(2.0, 1.0)
    val expectedOutput = "Equal"
    assert(expectedOutput == actualOutput)
  }

  "findNumbers" should "return factorial number greater than 6^n " in {
    val actualOutput = multipleOperator.find(Seq(100.0, 200.0, 10.0))
    val expectedOutput = List(100.0, 200.0)
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "findNumbers" should "return no factorial number " in {
    val actualOutput = multipleOperator.find(Seq(30.0, 20.0, 10.0))
    val expectedOutput = List(100.0, 200.0)
    whenReady(actualOutput) { result =>
      assert(result != expectedOutput)
    }
  }

  "averageAfterChaining" should "return average of number " in {
    val actualOutput = multipleOperator.findAverageAfterChainingOperations(Seq(4.0, 3.0, 5.0, 10.0))
    val expectedOutput = 6.333333333333333
    whenReady(actualOutput) { result =>
      result shouldBe expectedOutput
    }
  }

  "averageAfterChaining" should "not return average of other number " in {
    val actualOutput = multipleOperator.findAverageAfterChainingOperations(Seq(4.0, 3.0, 5.0, 10.0))
    val expectedOutput = 6.3333333
    whenReady(actualOutput) { result =>
      assert(result != expectedOutput)
    }
  }

}
