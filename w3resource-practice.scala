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

// COMMAND ----------

// DBTITLE 1,to check either of the 2 temperatures is less than 0 or 100
def tempcheck(temp1:Int, temp2:Int): Boolean = {
  if (temp1 < 0 && temp2 > 100 || temp2 < 0 && temp1 >100){
  return true
}
  else return false
}
tempcheck(-2,-120)

// COMMAND ----------

// DBTITLE 1,to check two given integers whether either of them is in the range 100..200 inclusive. 
def checkrange(n1:Int, n2:Int): Boolean = {
  if (n1>=100 && n1<=200 || n2>=100 && n2<=200){
    return true
  }
  else return false
}
checkrange(210,300)

// COMMAND ----------

// DBTITLE 1,check whether three given integer values are in the range 20..50 inclusive.
def checknum(n1:Int, n2:Int, n3:Int): Boolean = {
  if (n1>=20 && n1<=50 || n2>=20 && n2<=50 || n3>=20 && n3<=50){
    return true
  }
  else return false
}
checknum(10,70,60)

// COMMAND ----------

// DBTITLE 1,check whether two given integer values are in the range 20..50
def checknum(n1:Int, n2:Int): Boolean = {
  if (n1>=20 && n1<=50 || n2>=20 && n2<=50){
    return true
  }
  else return false
}
checknum(10,50)

// COMMAND ----------

// DBTITLE 1, check whether a string 'yt' appears at index 1 in given string. If it appears return a string without 'yt' otherwise return the original string. 
def returnnewstring(s:String): String = {
  if (s.drop(1).startsWith("yt")){
   return s.replaceFirst("yt", "")
  }
  else return s
}
returnnewstring("kytite")

// COMMAND ----------

// DBTITLE 1,check the largest number among three given integers.
def checklargest(n1:Int, n2:Int, n3:Int): Integer = {
  if(n1>n2 && n1>n3){
    return n1
    }
    else if(n2>n1 && n2>n3){
      return n2
    }
    else return n3
  }
var largest = checklargest(4,6,7)
println("The largest number is :"+largest)


// COMMAND ----------

// DBTITLE 1,check which number is nearest to the value 100 among two given integers
def checknearest(n1:Int, n2:Int): Integer = {
  var out1 = 100-n1
  var out2 = 100-n2
  if (n1 == n2){
    return 0
  }
  else if ((100-n1) < (100-n2)){
    return out1
  } 
  else return out2
}
checknearest(97,100)

// COMMAND ----------

// DBTITLE 1,check whether two given integers are in the range 40..50 inclusive, or they are both in the range 50..60 inclusive.
def checknuminrange(n1:Int, n2:Int): Boolean = {
  if ((n1>=40 && n1<=50) && (n2>=40 && n2<=50) || (n1>=50 && n1<=60) && (n2>=50 && n2<=60)) {
    return true
  }
   else return false
}
checknuminrange(40,60)

// COMMAND ----------

// DBTITLE 1,to find the larger value from two positive integer values in the range 20..30 inclusive, or return 0 if neither is in that range.
def findmaxinrange(n1:Int, n2:Int): Integer = {
  if((n1>=20 && n1 <=30) || (n2>=20 && n2<=30)){
    return math.max(n1,n2)
  }
  else return 0
}
println("the larger number is: " +findmaxinrange(20,39))

// COMMAND ----------

// DBTITLE 1,check whether a given character presents in a string between 2 to 4 times.


// COMMAND ----------

// DBTITLE 1,check whether two given positive integers have the same last digit
def samelastdigit(n1:Int, n2:Int): Boolean = {
  if ((n1%10) == (n2%10)){
    return true
  }
    else return false
}
samelastdigit(24,33)

// COMMAND ----------

// DBTITLE 1,convert the last 4 characters of a given string in upper case. If the length of the string has less than 4 then uppercase all the characters
def convertupper(s:String): String ={
  var len = s.length()
  s.take(len - 4)+s.drop(len - 4).toUpperCase()
}
convertupper("nirata")

// COMMAND ----------

// DBTITLE 1,create a new string which is n (non-negative integer ) copies of a given string.
def copies(n:Int, s:String): String = {
  var repeat = ""
  for (i <- 1 to n){
  repeat += s
}
  return repeat
}
println(" The copies of given string is :" +copies(2,"nirata"))
