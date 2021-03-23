
package flashcards

fun main() {
    println("Input the number of cards:")
    val count = readLine()!!.toInt()
    val flachcards = Flashcards(count)
    flachcards.update()
    flachcards.askTerms()
}

class Flashcards(var count: Int) {
    val cards = mutableListOf<List<String>>()
    var list: List<String> = emptyList()
    var term: String = ""
    var definition: String = ""
    var n = 1
    var checkDef = -2

    fun askTerms() {
        n = 1
        repeat(count) {
            term = cards[it][0]
            definition = cards[it][1]
            println("Print the definition of \"$term\":")
            val answer = readLine()!!
            if (definition == answer) {
                println("Correct!")
            } else {
                checkDef = checkDefinition(definition)
//                print("Wrong. The right answer is \"$definition\".")
                if (checkDef < 0) {
                    print("Wrong. The right answer is \"$definition\".\n")
                } else {
                    println("Wrong. The right answer is \"$definition\", but your definition is correct for \"${cards[checkDef][0]}\".")

//                    print("Wrong. The right answer is \"$definition\", but your definition is correct for \"${cards[checkDef][0]}\" \n")
//                    println("Wrong. The right answer is \"$definition\", but your definition is correct for '${cards[checkDef][0]}' ")
//                    println("Wrong. The right answer is \"$definition\", but your definition is correct for '${cards[checkDef][0]}'")
//                    println(", but your definition is correct for '${cards[checkDef][0]}' ")
//                    println(", but your definition is correct for \"${cards[checkDef][0]}\" ")
                }
//                println(".")
//                "but your definition is correct for 'term' "
            }
            n++
        }
    }

    fun update() {
        n = 1
        repeat(count) {
            readTerm(n)
            readDefinition(n)
            list = listOf(term.toString(), definition.toString())
            cards += list
            n++
        }
    }

    fun readTerm(n: Int) {
        println("Card #$n:")
        while (true) {
            term = readLine()!!
            if (checkTerm(term)) return
            println("The term \"$term\" already exists. Try again:")
        }
    }

    private fun checkTerm(term: String): Boolean {
        for (t in cards) {
            if (t[0] == term) return false
        }
        return true
    }

    fun readDefinition(n: Int) {
        println("The definition for card #$n:")
        while (true) {
            definition = readLine()!!
            if (checkDefinition(definition) < 0) return
            println("The definition \"$definition\" already exists. Try again:")
        }
    }

    private fun checkDefinition(definition: String): Int {
        for (i in 0 until cards.size) {
            if (cards[i][1] == definition) return i+1
        }
        return -1
    }
}
