// Databricks notebook source
// DBTITLE 1,Display Hello World
def display(s:String): Unit = {
  println(s)
}
display("Hello World")

// COMMAND ----------

// DBTITLE 1,sum of 2 integers
def sum(x:Int, y:Int): Unit = {
 if (x == y){
   println("the sum is:"+(x+y)*3)
 }
  else
  println("the sum is :"+(x+y))
}

  
sum(2,2)

// COMMAND ----------

// DBTITLE 1,to find absolute difference between n and 51
def diff(n:Int): Unit = {
  if(n > 51){
    println("the absolute value is :" +Math.abs(n-51)*3)
  }
  else
  println("the absolute value is :" +Math.abs(n-51))
}
diff(64)

// COMMAND ----------

// DBTITLE 1,to return True if one of the integer is 30 or sum of them is 30
def check(n:Int, m:Int): Boolean ={
  if(n == 30 || m == 30 || n+m == 30){
    return true
  }
  else return false
}
check(15,40)

// COMMAND ----------

// DBTITLE 1,check integer if it is within 20 of 100 or 300
def check(n:Int): Boolean = {
  if (Math.abs(100-n) <= 20 || Math.abs(300-n) <= 20){
    return true
  }
  else return false
}
check(130)

// COMMAND ----------

// DBTITLE 1,check string with prefix IF or not otherwise add prefix to the string
def prefix(s: String): String = {
  if (s.startsWith("If")){
    s
  }
  else return "If"+s
}
prefix("into")

// COMMAND ----------

// DBTITLE 1,remove character from a given position in a string
def removechar(s:String, n:Int) : String = {
 var out = s.take(n) + s.drop(n+1)
  return out
}
removechar("Nirata", 1)


// COMMAND ----------

// DBTITLE 1,to exchange the first and last character in a string
def exchange(s:String): String = {
  var len = s.length
  if(len <= 1){
    return s
  }
  else 
  s.charAt(len - 1)+s.substring(1,len-1)+s.charAt(0)
}
exchange("nirata")

// COMMAND ----------

// DBTITLE 1,to create a new string which is 4 copies of the 2 front characters of a string
def copies(s:String): String = {
  if (s.length <= 2){
    return s
  }
  else 
  return s.substring(0,2)*4
}
copies("nirata")

// COMMAND ----------

// DBTITLE 1,to add last character to the front and back of the string
def addfrontback(s:String): String = {
  var len = s.length
  var end = s.charAt(len-1)
  return end+s+end
  
}
addfrontback("nirata")

// COMMAND ----------

// DBTITLE 1,to check if the given number is multiple of 3 or 7
def checkmultiple(n:Int): Boolean = {
  if (n%3 == 0 || n%7 == 0){
    return true
  }
  else return false
  
}
checkmultiple(10)

// COMMAND ----------

// DBTITLE 1,create a string taking first 3 characters and return the string with 3 characters at front and back
def add3charfrontback(s:String): String = {
  if (s.length < 3){
    return s*3
  }
  else
   return s.substring(0,3)+s+s.substring(0,3)
}
add3charfrontback("nirata")

// COMMAND ----------

// DBTITLE 1,to check if the given string starts with 'Sc'
def check(s:String): Boolean = {
  if (s.startsWith("Sc")){
    return true
  }
  else return false
}
check("ScNirata")
