package chapter.one.soundex

class Soundex {

    private val MAX_CODE_LENGTH = 4

    fun encode(word: String) : String {
        return zeroPad(head(word) + encodedDigits(word))
    }

    private fun head(word: String) : String {
        return word.substring(0, 1)
    }

    private fun encodedDigits(word: String) : String =
        if(word.length > 1) encodedDigit(word[1]) else ""

    private fun encodedDigit(letter: Char) : String =
        if(letter == 'c') "2" else "1"


    private fun zeroPad(word: String) : String {
        val zerosNeeded = MAX_CODE_LENGTH - word.length
        return word + "0".repeat(zerosNeeded)
    }
}