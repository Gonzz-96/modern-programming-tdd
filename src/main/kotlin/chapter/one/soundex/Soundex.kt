package chapter.one.soundex

import java.lang.StringBuilder

class Soundex {

    private val MAX_CODE_LENGTH = 4
    private val NOT_AT_DIGIT = "*"

    private val StringBuilder.isComplete : Boolean
        get() = length == (MAX_CODE_LENGTH - 1)

    fun encode(word: String): String {
        return zeroPad(upperFront(head(word)) + encodedDigits(tail(word)))
    }

    private fun head(word: String): String {
        return word.substring(0, 1)
    }

    private fun encodedDigits(word: String): String =
        buildString {
            for (i in word) {
                if(isComplete) break

                val digit = encodedDigit(i)
                if(digit != NOT_AT_DIGIT && digit != lastDigit(this))
                    append(encodedDigit(i))
            }
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

        val encode = encodings[letter]
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
}