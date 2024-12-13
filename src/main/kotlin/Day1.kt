import java.io.File
import kotlin.math.abs

class Day1(private val fileName: String) {

  private val leftList = mutableListOf<Int>()
  private val rightList = mutableListOf<Int>()
  private var isDebug = false
  private val rightMap = mutableMapOf<Int, Int>()

  private fun readInput() {
    val file = File(fileName)
    printDebug("*****INPUT******")
    file.forEachLine {
      printDebug(it)
      val numbers = it.split("\\s+".toRegex()).map { it.toInt() }
      leftList.add(numbers[0])
      val rightListNum = numbers[1]
      rightList.add(rightListNum)
      if (rightMap.containsKey(rightListNum)) {
        rightMap[rightListNum] = rightMap[rightListNum]!! + 1
      } else {
        rightMap[rightListNum] = 1
      }
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

  fun part1() {
    readInput()
    leftList.sort()
    rightList.sort()
    var totalDistance = 0
    for (i in 0..<leftList.size) {
      val leftNum = leftList[i]
      val rightNum = rightList[i]
      val distance = abs(rightNum - leftNum)
      totalDistance += distance
    }
    println("******************************")
    println("******************************")
    println("Total Distance is $totalDistance")
    println("******************************")
    println("******************************")
  }

  fun part2() {
    readInput()
    var similarityScore = 0
    for (i in 0..<leftList.size) {
      val leftNum = leftList[i]
      if (!rightMap.containsKey(leftNum)) {
        continue
      }
      val similarity = leftNum * rightMap[leftNum]!!
      similarityScore += similarity
    }
    println("******************************")
    println("******************************")
    println("Total Similarity is $similarityScore")
    println("******************************")
    println("******************************")
  }
}
