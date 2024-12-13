import java.io.File
import kotlin.math.abs

class Day2(private val fileName: String) {
  fun part1(): Int {
    val file = File(fileName)
    var safeReportCount = 0
    file.forEachLine { line ->
      line
          .split("\\s+".toRegex())
          .map { it.toInt() }
          .zipWithNext { a, b -> false to a - b }
          .reduce { acc, i ->
            if (acc.first) {
              return@reduce acc
            }
            val prevDiff = acc.second
            val nextDiff = i.second
            val isUnsafe =
                abs(prevDiff) > 3 ||
                    abs(nextDiff) > 3 ||
                    prevDiff == 0 ||
                    nextDiff == 0 ||
                    (prevDiff < 0 && nextDiff > 0) ||
                    (prevDiff > 0 && nextDiff < 0)
            isUnsafe to prevDiff
          }
          .let { if (!it.first) safeReportCount++ }
      println("safeReportCount: $safeReportCount $line")
    }
    return safeReportCount
  }
}
