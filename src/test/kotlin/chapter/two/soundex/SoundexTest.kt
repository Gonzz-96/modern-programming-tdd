package chapter.two.soundex

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.hamcrest.CoreMatchers.*

@RunWith(JUnit4::class)
class SoundexTest {

    val soundex: Soundex = Soundex()

    @Test
    fun `retains Sole Letter Of One Letter Word`() {
        assertThat(soundex.encode("A"), `is`(equalTo("A000")))
    }

    @Test
    fun `Pads With Zeros To Ensure Three Digits`() {
        assertThat(soundex.encode("I"), `is`(equalTo("I000")))
    }

    @Test
    fun `Replaces Consonants With Appropriate Digits`() {
        assertThat(soundex.encode("Ax"), `is`(equalTo("A200")))
    }

    @Test
    fun `Ignores non-alphabetic characters`() {
        assertThat(soundex.encode("A#"), `is`(equalTo("A000")))
    }

    @Test
    fun `Replaces multiple constants with digits`() {
        assertThat(soundex.encode("Acdl"), `is`(equalTo("A234")))
    }

    @Test
    fun `Limits length to four characters`() {
        assertThat(soundex.encode("Dcdlb").length, `is`(equalTo(4)))
    }

    @Test
    fun `Ignores vowel-like letters`() {
        assertThat(soundex.encode("BaAeEiIoOuUhHyYcdl"), `is`(equalTo("B234")))
    }

    @Test
    fun `Combines duplicate encodings`() {

        assertThat(soundex.encode("Abcd"), `is`(equalTo( soundex.encode("Afgt") )))
//        That test is equivalent to:
//        assertEquals(soundex.encodedDigit('b'), soundex.encodedDigit('f'))
//        assertEquals(soundex.encodedDigit('c'), soundex.encodedDigit('g'))
//        assertEquals(soundex.encodedDigit('d'), soundex.encodedDigit('t'))

        assertThat(soundex.encode("Abfcgdt"), `is`(equalTo("A123")))
    }

    @Test
    fun `Uppercases first letter`() {
        assertThat(soundex.encode("abcd").startsWith('A'), `is`(true))
    }

    @Test
    fun `Ignore cases when encoding consonants`() {
        assertThat(soundex.encode("BCDL"), `is`(equalTo(soundex.encode("Bcdl"))))
    }

    @Test
    fun `Combines duplicate codes when 2nd letter duplicates 1st`() {
        assertThat(soundex.encode("Bbcd"), `is`(equalTo("B230")))
    }

    @Test
    fun `Does not combine duplicate encoding separater by vowels`() {
        assertThat(soundex.encode("Jbob"), `is`(equalTo("J110")))
    }
}
