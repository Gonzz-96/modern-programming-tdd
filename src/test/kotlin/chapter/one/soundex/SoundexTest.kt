package chapter.one.soundex

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SoundexTest {

    val soundex: Soundex = Soundex()

    @Test
    fun `retains Sole Letter Of One Letter Word`() {
        assertEquals(soundex.encode("A"), "A000")
    }

    @Test
    fun `Pads With Zeros To Ensure Three Digits`() {
        assertEquals(soundex.encode("I"), "I000")
    }

    @Test
    fun `Replaces Consonants With Appropriate Digits`() {
        assertEquals(soundex.encode("Ax"), "A200")
    }
}
