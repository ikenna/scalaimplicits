import org.scalatest.FunSuite


class MyTest extends FunSuite {

  implicit def a2b(a:A):B = new B
  implicit def takeFunction2NewB(a:A => Int):B = new B

  test("implicit conversion to an expected type"){
    val b:B = new A()
    val b2:B = (a:A) => 3
    val f:(Int, Int) => Int = (a:Int, b:Int) => a + b


  }

  test("convert the receiver of a method call"){

     new A().method2
  }


  test("Implicit parameters"){
    implicit val x = 5
    new C().method3(4)
  }

  test("Print the size of a string"){
     printSizeOfStrings("boo hhhall", "bbf")
  }

  implicit def inputStringToInt(s:String):Int =  s.length

  def printSizeOfStrings[String <% Int](s1:Int, s2:Int)= {    //[String <% Int] is a view bound. It means there is an implicit function that converts Strings to Ints
    println("The size of the string is : " + (s1 - s2))       // so we can do a subtraction on strings
  }
}




class A {
  def method1 = {
     println("method1")
  }
}

class B{
  def method2 = {
    println("method2")
  }
}

class C {
  def method3(a:Int)(implicit b:Int) = {
      println("Result was " + a + b)
  }
}