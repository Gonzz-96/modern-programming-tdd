package chapter.three.retweet

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class RetweetCollectionTest {

    @Test
    fun `It's empty when created`() {
        val retweetCollection = RetweetCollection()

        assertTrue(retweetCollection.isEmpty())
    }

    @Test
    fun `Has size zero when created`() {
        val retweetCollection = RetweetCollection()

        assertTrue(retweetCollection.size == 0)
    }

    @Test
    fun `It's no longer Empty After Tweet Added`() {
        val retweetCollection = RetweetCollection()

        retweetCollection.add(Tweet())

        assertFalse(retweetCollection.isEmpty())
    }
}
