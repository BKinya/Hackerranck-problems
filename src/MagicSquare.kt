import java.util.*
import kotlin.math.abs

var cost = 0

fun placeMiddleNumber(s: Array<Array<Int>>) {
    val middleNumber = s[1][1]
    if (middleNumber != 5) {
        s[1][1] = 5
        cost += abs(5 - middleNumber)
    }
}
fun checkVertices(theNumber: Int, otherNumber: Int, a: Int, b : Int) {
    if (otherNumber < 5 ) {
        if (otherNumber <= 2 && (a != 2 && a != 8) && (b != 2  && b != 8)) {
            cost += abs(8 - theNumber)
            cost += abs(2 - otherNumber)
        } else {
            cost += abs(6 - theNumber)
            cost += abs(4 - otherNumber)
        }
    } else {
        if (otherNumber <= 7 && (a != 4 && a != 6) && (b != 4 && b != 6)) {
            cost += abs(4 - theNumber)
            cost += abs(6 - otherNumber)
        } else {
            cost += abs(2 - theNumber)
            cost += abs(8 - otherNumber)
        }
    }

}
fun placeVertices(s: Array<Array<Int>>) {
    val firstVertex = s[0][0]
    val secondVertex = s[0][2]
    val thirdVertex = s[2][0]
    val fourthVertex = s[2][2]
    if (firstVertex == 5) {
        checkVertices(firstVertex, fourthVertex, thirdVertex, secondVertex)
    } else {
        checkVertices(fourthVertex, firstVertex, thirdVertex, secondVertex)

    }
    if (secondVertex == 5) {
        checkVertices(secondVertex, thirdVertex, firstVertex, fourthVertex)
    } else {

        checkVertices(thirdVertex, secondVertex, firstVertex, fourthVertex)
//
    }
}
fun checkIfOtherNumber(theNumber: Int, otherNumber: Int, a: Int, b:Int){
    if (otherNumber < 5) {
        if (otherNumber <= 2 && (a != 1 && a != 9) && (b != 1 && b != 9)){
            cost += abs(9 - theNumber)
            cost += abs(1 - otherNumber)
        }else{
            cost += abs(7 - theNumber)
            cost += abs(3 - otherNumber)
        }
    }else{
        if (otherNumber <= 7 && (a != 3 && a != 7) && (b != 3 && b != 7)){
            cost += abs(3 - theNumber)
            cost += abs(7 - otherNumber)
        }else{
            cost += abs(1 - theNumber)
            cost += abs(9 - otherNumber)

        }
    }
}

fun placeOtherNumbers(s: Array<Array<Int>>) {
    val num1 = s[0][1]
    val num2 = s[2][1]
    val num3 = s[1][0]
    val num4 = s[1][2]
    if (num1 == 5){
        checkIfOtherNumber(num1, num2, num3, num4)
    }else{
        checkIfOtherNumber(num2, num1, num3, num4)
    }
    if (num3 == 5){
        checkIfOtherNumber(num3, num4, num1, num2)
    }else{
        checkIfOtherNumber(num4, num3, num1, num2)
    }

}

fun formingMagicSquare(s: Array<Array<Int>>): Int {
    placeMiddleNumber(s)
    placeVertices(s)
    placeOtherNumbers(s)
    return cost
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}