import java.io.File

class Day3(private val fileName: String) {
  fun part1(): Int {
    val file = File(fileName)
    var sum = 0
    file.forEachLine { line ->
      val regex = Regex("mul\\(\\d+,\\d+\\)")
      val matches = regex.findAll(line)
      sum += matches.map(::mul).sum()
    }
    return sum
  }

  private fun mul(mulStr: MatchResult): Int =
      mulStr.value.substringAfter("mul(").substringBefore(")").split(",").zipWithNext { a, b ->
        a.toInt() * b.toInt()
      }[0]

  fun part2(): Int {
    val file = File(fileName)
    var sum = 0
    file.forEachLine { line ->
      val regex = Regex("""mul\(\d+,\d+\)|do\(\)|don't\(\)""")
      val matches = regex.findAll(line)
      var isCounting = true
      for (match in matches) {
        val value = match.value
        when (value) {
          "don't()" -> isCounting = false
          "do()" -> isCounting = true
          else -> if (isCounting) sum += mul(match)
        }
      }
    }
    return sum
  }
}
