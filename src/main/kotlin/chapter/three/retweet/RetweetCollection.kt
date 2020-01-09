package chapter.three.retweet

class Tweet

class RetweetCollection {

    var size: Int = 0

    fun isEmpty() : Boolean = 0 == size

    fun add(tweet: Tweet) {
        size++
    }
}

