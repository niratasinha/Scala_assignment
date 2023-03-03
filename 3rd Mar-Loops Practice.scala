// Databricks notebook source
// DBTITLE 1,Even and odd numbers-for loop
object Main {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 100) {
      if (i % 2 == 0) {
        print("\n"+"Even numbers are:"+i+"\t")
      }
      else  {
         print("\t"+"Odd numbers are:"+i+"\t")
      }
    }
   
  }
}
Main.main(Array("1-100"));

// COMMAND ----------

// DBTITLE 1,even and odd number using do-while loop
object Main {
  def main(args: Array[String]): Unit = {
    var i=1
    do {
      if (i % 2 == 0) {
        print("\n"+"Even numbers are:"+i+"\t")
      }
      else  {
         print("\t"+"Odd numbers are:"+i+"\t")
      }
      i += 1
     }
  while (i >= 1)
  }
}
Main.main(Array("1-100"));

// COMMAND ----------

// DBTITLE 1,even and odd numbers-while loop
object Main {
  def main(args: Array[String]): Unit = {
    var i=1
     while (i <= 100) {
      if (i % 2 == 0) {
        print("\n"+"Even numbers are:"+i+"\t")
      }
      else  {
         print("\t"+"Odd numbers are:"+i+"\t")
      }
      i += 1
     }
 
  }
}
Main.main(Array("1-100"));

// COMMAND ----------

// DBTITLE 1,even and odd in reverse pattern
object Main {
  def main(args: Array[String]): Unit = {
    var i = 100
   do {
      if (i % 2 == 0) {
        print("\n"+"Even numbers are:"+i+"\t")
      }
      else  {
         print("\t"+"Odd numbers are:"+i+"\t")
      }
      i -= 1
     }
  while (i >= 1)
  }
}
Main.main(Array("1-100"));

// COMMAND ----------

val str = "Nirata"
val reversedStr = str.reverse
println(reversedStr)

// COMMAND ----------

// DBTITLE 1,Reverse the string
object Main {
  def main(text1 : String): String = {
val str = "Nirata"
var reversedStr = ""

for (i <- str.length - 1 to 0 by -1) {
  reversedStr += str(i)
}

return reversedStr
  }
}
Main.main("Nirata")
