package io.arctic.nanoId

import java.security.SecureRandom
import java.util.*

class NanoIdKt(
    /**
     * The default random number generator used by this class.
     * Creates cryptographically strong NanoId Strings.
     */
    private val random: Random = SecureRandom(),
    /**
     * The default alphabet used by this class.
     * Creates url-friendly NanoId Strings using 64 unique symbols.
     */
    private val alphabet: CharArray = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
    /**
     * The default size used by this class.
     */
    private val size: Int = 12
) {
    private val max = alphabet.size
    fun randomId(): String {
        val idBuilder = StringBuilder()
        while (idBuilder.length != size)
            idBuilder.append(alphabet[random.nextInt(max)])
        return idBuilder.toString()
    }

    companion object {
        fun randomId(): String = NanoIdKt().randomId()
    }
}


