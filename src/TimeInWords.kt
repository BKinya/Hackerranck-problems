import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().trim().toInt()

    val m = scan.nextLine().trim().toInt()

    val result = timeInWords(h, m)

    println(result)
}

fun timeInWords(h: Int, m: Int): String {
    if (m == 0) {
        return "${getNumberName(h)} o' clock"
    }
    if (m == 15) {
        return "quarter past ${getNumberName(h)}"
    }
    if (m == 30) {
        return "half past ${getNumberName(h)}"
    }
    if (m == 45) {
        return "quarter to ${getNumberName(h + 1)}"
    }
    if ((m >= 1) && (m < 30)) {
        var min =  if (m == 1)  "minute" else "minutes"
        if ((m> 20)) {
            return "twenty ${ getNumberName(m.minus(20))} minutes past ${getNumberName(h)}"
        }
        return "${getNumberName(m)} $min past ${getNumberName(h)}"
    }
    if ((m>30) &&(m<60)){
        var min =  if (m == 1)  "minute" else "minutes"
        var x:Int = 60

        if (((x.minus(m))> 20)) {
            return "twenty ${ getNumberName((x.minus(m).minus(20)))} minutes to ${getNumberName(h+1)}"
        }
        return "${getNumberName(x.minus(m))} $min to ${getNumberName(h +1)}"
    }
    return "unknown"
}

fun getNumberName(num: Int): String? {
    var name: String? = null

    if (num <= 10) {
        name = when (num) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            6 -> "six"
            7 -> "seven"
            8 -> "eight"
            9 -> "nine"
            10 -> "ten"
            else -> "unknown"
        }
    }
    if (num in 11..20) {
        name = when (num) {
            11 -> "eleven"
            12 -> "twelve"
            13 -> "thirteen"
            14 -> "forteen"
            15 -> "fifteen"
            16 -> "sixteen"
            17 -> "seventeen"
            18 -> "eighteen"
            19 -> "nineteen"
            20 -> "twenty"
            else -> "unknown"
        }
    }
    return name
}



