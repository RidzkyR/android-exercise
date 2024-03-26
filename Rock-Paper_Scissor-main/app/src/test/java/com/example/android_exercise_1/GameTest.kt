package com.example.android_exercise_1

import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class GameTest {
    @Test
    fun pickRandom() {
        val option= listOf("ELEPHANT", "ANT", "HUMAN")
        assertTrue(option.contains(Game.pickRandom()))
        assertTrue(option.contains(Game.pickRandom()))
        assertTrue(option.contains(Game.pickRandom()))
        assertTrue(option.contains(Game.pickRandom()))
        assertTrue(option.contains(Game.pickRandom()))
    }

    @Test
    fun pickDrawable() {
        Assert.assertEquals(R.drawable.elephant, Game.pickDrawable("ELEPHANT"))
        Assert.assertEquals(R.drawable.ant, Game.pickDrawable("ANT"))
        Assert.assertEquals(R.drawable.human, Game.pickDrawable("HUMAN"))
    }

    @Test
    fun isDrawTest() {
        assertTrue(Game.isDraw("ANT", "ANT"))
        assertTrue(Game.isDraw("ELEPHANT", "ELEPHANT"))
        assertTrue(Game.isDraw("HUMAN", "HUMAN"))

        Assert.assertFalse(Game.isDraw("ANT", "HUMAN"))
        Assert.assertFalse(Game.isDraw("ANT", "ELEPHANT"))
        Assert.assertFalse(Game.isDraw("ELEPHANT", "HUMAN"))
    }

    @Test
    fun isWinTest() {
        assertTrue(Game.isWin("ELEPHANT", "HUMAN"))
        assertTrue(Game.isWin("ANT", "ELEPHANT"))
        assertTrue(Game.isWin("HUMAN", "ANT"))

        assertFalse(Game.isWin("ELEPHANT", "ANT"))
        assertFalse(Game.isWin("ANT", "HUMAN"))
        assertFalse(Game.isWin("HUMAN", "ELEPHANT"))
    }
}