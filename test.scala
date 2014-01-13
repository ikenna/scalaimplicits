#!/usr/bin/env scala

import scala.language.implicitConversions

implicit def inputStringToInt(s:String):Int =  s.length

def printSizeOfStrings[String <% Int](s1:Int, s2:Int)= {    //[String <% Int] is a view bound. It means there is an implicit function available that converts Strings to Ints
  println("The size of the string is : " + (s1 - s2))       // so we can do a subtraction on strings
}

printSizeOfStrings("boo hhhall", "bbf")
