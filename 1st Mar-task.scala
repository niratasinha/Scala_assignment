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


isPalindrome(121);

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
