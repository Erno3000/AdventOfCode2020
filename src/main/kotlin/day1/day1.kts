import java.io.File

val inputList = File("input.txt").readLines().map { it.toInt() }

for ((i, x) in inputList.withIndex()) {
    for (y in inputList.toMutableList().apply { removeAt(i) }) {
        if (x + y == 2020) {
            println("${x * y}")
        }
    }
}

for ((i, x) in inputList.withIndex()) {
    for ((j, y) in inputList.toMutableList().apply { removeAt(i) }.withIndex()) {
        for (z in inputList.toMutableList().apply { removeAt(i); removeAt(j) }) {
            if (x + y + z == 2020)
                println("${x * y * z}")
        }
    }
}