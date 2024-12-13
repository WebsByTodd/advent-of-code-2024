import java.io.File
import kotlin.math.abs

class Day1(private val fileName: String) {

  private val leftList = mutableListOf<Int>()
  private val rightList = mutableListOf<Int>()
  private var isDebug = false

  private fun readInput() {
    val file = File(fileName)
    printDebug("*****INPUT******")
    file.forEachLine {
      printDebug(it)
      val numbers = it.split("\\s+".toRegex()).map { it.toInt() }
      leftList.add(numbers[0])
      rightList.add(numbers[1])
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

  fun go() {
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
}
