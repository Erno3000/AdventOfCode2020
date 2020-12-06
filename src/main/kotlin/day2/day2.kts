package day2

import java.io.File

data class Password(
    val min: Int,
    val max: Int,
    val char: Char,
    val pass: String
)

val passwords: List<Password> = File("input.txt").readLines().map {
    val line = it
        .trim()
        .replace("-", " ")
        .replace(":", "")
        .split(" ")
    return@map Password(line[0].toInt(), line[1].toInt(), line[2].first(), line[3])
}

var valid = 0
passwords.forEach { p ->
    val occurrences = p.pass.count { it == p.char }
    if (occurrences >= p.min && occurrences <= p.max) {
        valid++
    }
}

println("valid in old job policy: $valid")

valid = 0
passwords.forEach { p ->
    with(p) {
        if ((pass[min-1] == char) xor (pass[max-1] == char))
            valid++
    }
}

println("valid for corporate policy: $valid")

