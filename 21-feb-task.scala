// Databricks notebook source
// DBTITLE 1,To find if the number is Prime or not
/*object ReadInput {
  def main(args: Array[String]) ={
   Console.println("Enter a number: ")
    val number = scala.io.StdIn.readInt;
    Console.println("Prime Number is : "+ number) */
def isPrime(number: Int) : Boolean = {
    for (i <- 2 to number - 1) {
        if (number % i == 0) {
          print (number+"\t" +"Is not prime number"+"\n");
          return false;
        }
    }
   print (number+"\t" +"Is prime number"+"\n");
   return true;
  }
isPrime(21)
 /* }
}
ReadInput.main(null);*/


// COMMAND ----------

// DBTITLE 1,fibonacci number
def fibonacci(n: Int): Int = {
  if (n <= 1) n
  else fibonacci(n-1) + fibonacci(n-2)
}
fibonacci(12);

// COMMAND ----------

// DBTITLE 1,To find the nth fibonacci number
def fibonacci(n: Int): BigInt = n match {
  //case n if n < 0 => (if (n % 2 == 0) -1 else 1) * fibonacci(-n)
  case 0 => 0
  case 1 => 1
  case n => fibonacci(n - 2) + fibonacci(n - 1)
}
(0 to 8).map(fibonacci(_))
//fibonacci(5)

// COMMAND ----------

// DBTITLE 1,To find the ASCII value of a character
def ASCII(C:Char): Unit ={
  val Value = C.toInt
  println(s"The ascii value of $C is: $Value")
}
ASCII(80);


// COMMAND ----------

// DBTITLE 1,To find the sum of squares of 'n' natural numbers
def sumofsquares(n:Int) :Int = {
  (0 to n).map(n=>n*n).sum
}
sumofsquares(3);

// COMMAND ----------

// DBTITLE 1,To find the sum of cubes of n natural numbers
def sumofcubes(n:Int) :Int = {
  (0 to n).map(n=>n*n*n).sum
}
sumofcubes(3);
