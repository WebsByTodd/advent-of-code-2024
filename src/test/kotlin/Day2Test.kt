import com.diffplug.selfie.Selfie.expectSelfie
import org.junit.jupiter.api.Test

class Day2Test {
    @Test
    fun part1() {
        val day2Test = Day2("src/main/resources/day2-test.txt")
        expectSelfie(day2Test.part1()).toBe(2)
        val day2 = Day2("src/main/resources/day2.txt")
        expectSelfie(day2.part1()).toBe(479)
    }
}
