import java.io.File
import kotlin.math.abs
import kotlin.math.sign

class Day2(private val fileName: String) {
  fun part1(): Int {
    val file = File(fileName)
    var safeReportCount = 0
    file.forEachLine { line ->
      val isSafe =
          line
              .split("\\s+".toRegex())
              .map { it.toInt() }
              .zipWithNext { a, b -> a - b }
              .zipWithNext { diffA, diffB -> diffIsSafe(diffA, diffB) }
              .all { it }
      if (isSafe) safeReportCount++
      println("safeReportCount: $safeReportCount $line")
    }
    return safeReportCount
  }

  private fun diffIsSafe(diffA: Int, diffB: Int): Boolean {
    return diffA.sign == diffB.sign &&
        abs(diffA).let { it == 1 || it == 2 || it == 3} &&
        abs(diffB).let { it == 1 || it == 2 || it == 3}
  }
}
