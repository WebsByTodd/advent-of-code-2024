import com.diffplug.selfie.Selfie.expectSelfie
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun part1() {
        val day3Test = Day3("src/main/resources/day3-test.txt")
        expectSelfie(day3Test.part1()).toBe(161)
        val day3 = Day3("src/main/resources/day3.txt")
        expectSelfie(day3.part1()).toBe(168_539_636)
    }
}
