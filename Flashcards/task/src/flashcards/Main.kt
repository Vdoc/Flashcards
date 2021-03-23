package flashcards

fun main() {
    println("Input the number of cards:")
    val count = readLine()!!.toInt()

    val cards = mutableListOf<List<String>>()
    var list: List<String> = emptyList()
    var term: String = ""
    var definition: String = ""

    var n = 1
    repeat(count) {
        println("Card #$n:")
        term = readLine()!!

        println("The definition for card #$n:")
        definition = readLine()!!

        list = listOf(term.toString(), definition.toString())
        cards += list
        n++
    }

    n = 1
    repeat(count) {
        term = cards[it][0]
        definition = cards[it][1]
        println("Print the definition of \"$term\":")
        val answer = readLine()!!
        if (definition == answer)
            println("Correct!")
        else
            println("Wrong. The right answer is \"$definition\".")
        n++
    }
}
