package chapter.one.soundex

class Soundex {

    fun encode(word: String) : String {
        var encoded = word.substring(0, 1)

        if(word.length > 1) {
            encoded += "1"
        }

        return zeroPad(encoded)
    }

    private fun zeroPad(word: String) : String {
        val zerosNeeded = 4 - word.length
        return word + "0".repeat(zerosNeeded)
    }
}