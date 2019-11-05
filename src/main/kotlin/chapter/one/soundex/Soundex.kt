package chapter.one.soundex

class Soundex {

    fun encode(word: String) : String {
        return zeroPad(word)
    }

    private fun zeroPad(word: String) : String =
        word + "000"
}