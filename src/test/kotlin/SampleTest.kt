import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class SampleTest {

  private val testSample: Sample = Sample()

  @Test
  fun testSum() {
    val expected = 42
    assertEquals(expected, testSample.sum(40, 2))
  }
}
