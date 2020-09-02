import java.util.*

fun main() {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()

    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}

fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): List<Int> {
    //working solution but fails few tests coz of time out
    val scoreSet = scores.toMutableSet()
    val alicePosition = mutableListOf<Int>()
    var newScoreSet = listOf<Int>()
    alice.forEach {
        scoreSet.add(it)
        newScoreSet = scoreSet.sortedDescending()
        alicePosition.add(newScoreSet.indexOf(it) + 1)
    }

    return alicePosition

}

fun positionAliceScore(scores: Array<Int>, alice: Array<Int>): List<Int> {
    //Attempts to pass failing tests but didn't seem to get it right
    val scoreSet = scores.distinct().toMutableList()
    val alicePosition = mutableListOf<Int>()
    var index = scoreSet.size -1
    alice.forEach {
        for(i in  index downTo 0){
            if (it <= scoreSet[index]) {
                print("${scoreSet[index]}\n")
                alicePosition.add(index + 2)
                print("Alice position $alicePosition\n")
                break
            }
        }
    }
    return alicePosition

}
