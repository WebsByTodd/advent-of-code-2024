import java.io.File

class Day1 {
  fun read() {
    val fileName = "src/main/resources/day1-test.txt"
    val file = File(fileName)
    file.forEachLine { println(it) }
  }
}
