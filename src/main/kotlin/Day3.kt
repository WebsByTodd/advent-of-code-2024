import java.io.File

class Day3(private val fileName: String) {
  fun part1(): Int {
    val file = File(fileName)
    var sum = 0
    file.forEachLine { line ->
      val regex = Regex("mul\\(\\d+,\\d+\\)")
      val matches = regex.findAll(line)
      sum +=
          matches
              .map {
                it.value.substringAfter("mul(").substringBefore(")").split(",").zipWithNext { a, b
                  ->
                  a.toInt() * b.toInt()
                }
              }
              .flatten()
              .sum()
    }
    return sum
  }
}
