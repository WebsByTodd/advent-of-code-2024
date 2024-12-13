import com.diffplug.selfie.Selfie.expectSelfie
import kotlin.test.Test

class Day1Test {

  @Test
  fun part1() {
    val day1Test = Day1("src/main/resources/day1-test.txt")
    expectSelfie(day1Test.part1()).toBe(11)
    val day1 = Day1("src/main/resources/day1.txt")
    expectSelfie(day1.part1()).toBe(2_756_096)
  }

  @Test
  fun part2() {
    val day1Test = Day1("src/main/resources/day1-test.txt")
    expectSelfie(day1Test.part2()).toBe(31)
    expectSelfie(day1Test.part2b()).toBe(31)
    val day1 = Day1("src/main/resources/day1.txt")
    expectSelfie(day1.part2()).toBe(23_117_829)
    expectSelfie(day1.part2b()).toBe(23_117_829)
  }
}
