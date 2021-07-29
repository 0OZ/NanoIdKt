import io.arctic.nanoId.NanoIdKt
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class NanoIdKtTest {
    @Test
    fun `10000 unique ids`() {
        val idCount = 10000
        val ids = mutableListOf<String>()
        println("init")
        for (i in 0 until idCount) {
            val id = NanoIdKt.randomId()
            if (!ids.contains(id)) {
                ids.add(id)
            } else {
                fail("Non-unique ID generated: $id")
            }
        }
    }
}