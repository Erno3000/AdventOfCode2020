package day6

import java.io.File

val input = File("input.txt").readLines()

var groups = mutableListOf<String>()
var groups2 = mutableListOf<List<String>>()
var group = ""
var group2 = mutableListOf<String>()

input.forEach { line ->
    if (line.isNotBlank()) {
        group += line.replace("\n", "")
        group2.add(line)
    } else {
        groups.add(group)
        group = ""
        groups2.add(group2)
        group2 = mutableListOf()
    }
}
groups.add(group)
groups2.add(group2)

var count = 0
groups.forEach {
    count += it.toSet().size
}
println("$count")

count = 0
groups2.forEach { group ->
    val sets = group.map { it.toSet() }
    var uniqueChars = sets.first()

    for (set in sets.drop(1)) {
        uniqueChars = set.intersect(uniqueChars)
    }

    count += uniqueChars.size
}
println("$count")

