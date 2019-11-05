package chapter.one.soundex

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SoundexTest {


    @Test
    fun `retains Sole Letter Of One Letter Word`() {

        val soundex: Soundex = Soundex()

        val encoded = soundex.encode("A")

        assertEquals(encoded, "A")
    }

    @Test
    fun `Pads With Zeros To Ensure Three Digits`() {

        val soundex = Soundex()

        val encoded = soundex.encode("I")

        assertEquals(encoded, "I000")
    }
}
