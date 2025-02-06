package com.example.worldclass.Class

fun main (){
//variables numericas
    val age: Int =20
    val long_number:Long=6786786979987767867
    val temperature: Float= 27.33f
    val weight:Double=66.45534
//string variables
    val gebero: Char='m'
    val name:String="ricardo"
//Bool variable
    val isGreater:Boolean=false
//collection variables
    val names= arrayOf("cr7","messi","javier","ff")
   println(age)
    println("welcome $name, to your first kotlin project")

    print(add())
    print(product(5,8))
    printarray(names)
    val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    iseven(numbers)
}

fun add():Int {
    val x=10
    val y =5
    return(x+y)
}
fun product(x:Int,y:Int):Int{
    return(x * y)
}
//ciclo for para que me muestre algo en el array
fun printarray(names:Array<String>){
    println(names)
    for(name in names){
        println("hello $name")
    }

}
fun iseven(numbers:Array<Int>){
    for(number in numbers){
        if(number%2==0 ){
            println("the number $number is even")
        }else{
            println("the number $number is odd")
        }
    }
}