package chapter.two.soundex

import java.lang.StringBuilder

class Soundex {

    private val MAX_CODE_LENGTH = 4
    private val NOT_AT_DIGIT = "*"

    private val StringBuilder.isComplete : Boolean
        get() = length == MAX_CODE_LENGTH

    fun encode(word: String): String {
        return zeroPad(upperFront(head(word)) + tail(encodedDigits(word)))
    }

    private fun head(word: String): String {
        return word.substring(0, 1)
    }

    private fun encodedDigits(word: String): String =
        buildString {
            encodeHead(this, word)
            encodeTail(this, word)
        }

    private fun encodeHead(encoding: StringBuilder, word: String) {
        encoding.append(encodedDigit(word.first()))
    }

    private fun encodeTail(encoding: StringBuilder, word: String) {
        for(i in 1 until word.length)
            if(!encoding.isComplete)
                encodeLetter(encoding, word[i], word[i - 1])
    }

    private fun encodeLetter(encoding: StringBuilder, letter: Char, lastLetter: Char) {
        val digit = encodedDigit(letter)
        if(digit != NOT_AT_DIGIT && (digit != lastDigit(encoding) || isVowel(lastLetter)) )
            encoding.append(digit)
    }

    private fun encodedDigit(letter: Char): String {
        val encodings = hashMapOf(
            'b' to "1", 'f' to "1", 'p' to "1", 'v' to "1",
            'c' to "2", 'g' to "2", 'j' to "2", 'k' to "2", 'q' to "2", 's' to "2", 'x' to "2", 'z' to "2",
            'd' to "3", 't' to "3",
            'l' to "4",
            'm' to "5", 'n' to "5",
            'r' to "6"
        )

        val encode = encodings[letter.toLowerCase()]
        return encode ?: NOT_AT_DIGIT
    }

    private fun lastDigit(s: StringBuilder) : String =
        if(s.isEmpty()) NOT_AT_DIGIT else s.last().toString()

    private fun zeroPad(word: String): String {
        val zerosNeeded = MAX_CODE_LENGTH - word.length
        return word + "0".repeat(zerosNeeded)
    }

    private fun tail(word: String): String =
        word.substring(1)

    private fun upperFront(word: String) : String =
        word[0].toUpperCase().toString()

    private fun isVowel(letter: Char) : Boolean =
        listOf('a', 'e', 'i', 'o', 'u', 'y').contains(letter.toLowerCase())
}