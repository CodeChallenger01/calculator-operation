# Calculator by using Future

Step 1: Open IntelliJ and create scala file inside src/main/scala/com/knoldus
Step 2: Inside this create three class 
1. Calculator: Inside this scala, it is used to perform all the operation and validation of operands .  
1.1 Create classes for Addition, Subtraction, Division, Multiplication, Square Root, Power, Odd NUmber, Even NUmber, Factorial, Fibonacci.
2. Now create a Validator scala file inside this create two trait   
2.1 Validator that contains abstract method for validate.  
2.2 Operator that extends the Validator trait and inside this create two methods one for validateAndExecute with body and other one execute with no body.  
3. Create Driver scala file inside this create instance of Object Calculator and call the different operation to perform on operand.
> private val loggers = Logger(getClass)   
> /* This is instance of Calculator object*/   
> private val calculator = Calculator   
> /* Here I am calling the calculate method to perform the addition operation */    
> private val sum = calculator.calculate("+", Seq(5.0, 8.0))   
> sum.onComplete {    
> case Success(value) => loggers.info("Sum :" + value)   
> case Failure(exception) => loggers.warn("Error",exception)   
> }

Step 3: Now Inside the build.sbt add the dependencies for both the loggers and scalatest to perform the test cases on following mathematical operation.
>**For Scalatest**  
>>libraryDependencies+="org.scalatest"%%"scalatest"%"3.2.15"%"test"  

>**For Loggers**   
>>libraryDependencies ++= Seq(
>>"com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
>>"ch.qos.logback" % "logback-classic" % "1.3.5"
)

Step 4: Now Inside the src/test/scala/ create Calculator Test to perform the Test Operation.   
Step 5: Create a Calculator class and extend AnyFlatSpec With Matchers for testing and extend ScalaFuture to handle the test case for future.  
>class CalculatorTest extends AnyFlatSpec with Matchers with ScalaFutures  

Step 6: Test with addition, subtraction, multiplication, division,factorial etc. operator   
>**Example**
>>  "sum" should "return sum of value " in {   
>>val actualOutput = calculator.calculate("+", Seq(5.0, 8.0))  
>>val expectedOutput = List(13.0)  
> 
>>To check for Future value
>>>whenReady(actualOutput) { result =>  
>>>result shouldBe expectedOutput  
>>>}   
>>>}

Step 7: Now save and in terminal compile and run the project 
>sbt compile : 
>>to compile the project   

>sbt run : 
>>to run the project and print the output 

>sbt test : 
>>to check with test cases are running or not