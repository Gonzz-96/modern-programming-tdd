package chapter.one.soundex

class Soundex {

    private val MAX_CODE_LENGTH = 4

    fun encode(word: String): String {
        return zeroPad(head(word) + encodedDigits(tail(word)))
    }

    private fun head(word: String): String {
        return word.substring(0, 1)
    }

    private fun encodedDigits(word: String): String =
        buildString {
            for (i in word) {
                if(length < MAX_CODE_LENGTH - 1)
                    append(encodedDigit(i))
            }
        }

    fun encodedDigit(letter: Char): String {
        val encodings = hashMapOf(
            'b' to "1", 'f' to "1", 'p' to "1", 'v' to "1",
            'c' to "2", 'g' to "2", 'j' to "2", 'k' to "2", 'q' to "2", 's' to "2", 'x' to "2", 'z' to "2",
            'd' to "3", 't' to "3",
            'l' to "4",
            'm' to "5", 'n' to "5",
            'r' to "6"
        )

        val encode = encodings[letter]
        return encode ?: ""
    }

    private fun zeroPad(word: String): String {
        val zerosNeeded = MAX_CODE_LENGTH - word.length
        return word + "0".repeat(zerosNeeded)
    }

    private fun tail(word: String): String =
        word.substring(1)
}