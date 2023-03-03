// Databricks notebook source
// DBTITLE 1,To reverse the given Integer number
def reverse(x: Integer): Integer = {
 if (x> 0 && x.toString.reverse.charAt(0) == 0) {  //when the integer is positive
    x.toString.reverse.substring(1).toInt
 }
 else if (x<0 && x.toString.substring(1).reverse.charAt(0) == 0) { //when the integer is negative
  ("-" + x.toString.substring(1).reverse.substring(1)).toInt
 }
  else {
    x.toString.reverse.toInt  //convert to Integer value
}
}


reverse(123);


// COMMAND ----------

// DBTITLE 1,Palindrome number
def isPalindrome(num: Int): Boolean = {
  var n = num
  var d = false
  var reversed = 0
  while (n > 0) {
    var q = n%10
    reversed = reversed * 10 + q;
    n = n / 10;
  }
  if(reversed == num)
  d = true;
  else
 d = false;
  return d;
  }
isPalindrome(123);

// COMMAND ----------

// DBTITLE 1,Palindrom number
def isPalindrome(num: Int): Boolean = {
  val str = num.toString
  if (str == str.reverse){
  print(num+"is a palindrome"+"\n")
  return true;
}
  else{
  print (num+"is not palindrome"+"\n")
  return false;
  }
  }


isPalindrome(123);

// COMMAND ----------

// DBTITLE 1,Convert integer to Roman Numeral
def romanconvert( number : Int): String = {
 val inputnumbers = List((1000, "M"), (500, "D"), (100, "C"), (50, "L"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (2, "II"), (1, "I"))
  var romanequivalent = ""
  var n = number
  for ((value, equivalent) <- inputnumbers){
    while (n >= value){
    romanequivalent += equivalent
    n -= value
    }
  }
return romanequivalent
  }
romanconvert(5);

// COMMAND ----------

// DBTITLE 1,To find longest Common prefix-Method-1
def CommonPrefix(text1:String, text2:String):String = {
  val maxlength = scala.math.min(text1.length, text2.length) //scala.math.min() will return the minimum length of two strings
  var i = 0
  while ( i < maxlength && text1(i)== text2(i)) 
  i += 1;
  text1.take(i);  //take() will take integer as parameter and will return a new collection of first N elements
}
CommonPrefix("sunbath","sunny");

// COMMAND ----------

// DBTITLE 1,Longest Common Prefix-Method -2
def CommonPrefix(text1: String, text2: String): String = {
     var common = true
     var i = 0
     while(common && i < scala.math.min(text1.length, text2.length)) {
       if(text1.charAt(i) != text2.charAt(i)) {
         common = false
         } else 
       {
         i += 1
         }
       }
  text1.substring(0, i)
  }    
     
CommonPrefix("filler", "filling");

// COMMAND ----------

// DBTITLE 1,letter combinations of a phone number

