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

    @Test
    fun `Ignores non-alphabetic characters`() {
        assertEquals(soundex.encode("A#"), "A000")
    }

    @Test
    fun `Replaces multiple constants with digits`() {
        assertEquals(soundex.encode("Acdl"), "A234")
    }

    @Test
    fun `Limits length to four characters`() {
        assertEquals(soundex.encode("Dcdlb").length, 4)
    }

    @Test
    fun `Ignores vowel-like letters`() {
        assertEquals(soundex.encode("Baeiouhycdl"), "B234")
    }

    @Test
    fun `Combines duplicate encodings`() {

        assertEquals(soundex.encode("Abcd"), soundex.encode("Afgt"))
//        assertEquals(soundex.encodedDigit('b'), soundex.encodedDigit('f'))
//        assertEquals(soundex.encodedDigit('c'), soundex.encodedDigit('g'))
//        assertEquals(soundex.encodedDigit('d'), soundex.encodedDigit('t'))

        //assertEquals(soundex.encode("Abfcgdt"), "A123")
    }
}
