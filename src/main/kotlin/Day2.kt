import java.io.File
import kotlin.math.abs

class Day2(private val fileName: String) {
  fun part1(): Int {
    val file = File(fileName)
    var safeReportCount = 0;
    file.forEachLine { line ->
      val report = line.split("\\s+".toRegex()).map { it.toInt() }
      var direction = 0
      var isSafe = true
      report.zipWithNext({ a, b ->
        val diff = a - b
        if (abs(diff) > 3 || diff == 0) {
          isSafe = false
        } else if (diff < 0) {
          if (direction == 1) {
            isSafe = false
          } else {
            direction = -1
          }
        } else {
          if (direction == -1) {
            isSafe = false
          } else {
            direction = 1
          }
        }
      })
      if (isSafe) {
        safeReportCount++
      }
    }
    return safeReportCount
  }
}
