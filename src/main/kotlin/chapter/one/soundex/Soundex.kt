package chapter.one.soundex

class Soundex {

    fun encode(word: String) : String {
        return zeroPad(head(word) + encodeDigits(word))
    }

    private fun head(word: String) : String {
        return word.substring(0, 1)
    }

    private fun encodeDigits(word: String) : String =
        if(word.length > 1) "1" else ""


    private fun zeroPad(word: String) : String {
        val zerosNeeded = 4 - word.length
        return word + "0".repeat(zerosNeeded)
    }
}