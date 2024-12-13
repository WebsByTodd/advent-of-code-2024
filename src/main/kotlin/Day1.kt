import java.io.File
import kotlin.math.abs

class Day1(fileName: String) {

  private val leftList = mutableListOf<Int>()
  private val rightList = mutableListOf<Int>()
  private var isDebug = false
  private val rightMap = mutableMapOf<Int, Int>()

  init {
    val file = File(fileName)
    printDebug("*****INPUT******")
    file.forEachLine {
      printDebug(it)
      val numbers = it.split("\\s+".toRegex()).map { it.toInt() }
      check(numbers.size == 2) { "Invalid input. Expected 2 numbers, got $numbers" }
      leftList.add(numbers[0])
      val rightListNum = numbers[1]
      rightList.add(rightListNum)
      rightMap.compute(rightListNum) { _, count -> count?.plus(1) ?: 1 }
    }
    printDebug("*****INPUT******")
  }

  fun enableDebug() {
    isDebug = true
  }

  fun printDebug(message: String) {
    if (isDebug) {
      println(message)
    }
  }

  fun part1() = leftList.sorted().zip(rightList.sorted()).sumOf { abs(it.first - it.second) }

  fun part2() = leftList.filter { rightMap.containsKey(it) }.sumOf { it * rightMap[it]!! }

  fun part2b() = leftList.mapNotNull { rightMap[it]?.let { count -> it * count } }.sum()
}
