package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamCreateChannel
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerVOIPTest {

    @Before
    fun setUp() {
        OoRestManager.init(false)
    }

    @Test
    fun createVoipChannel() {
        val signal = CountDownLatch(1)
        val param = OoParamCreateChannel(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNDSXNJbVJsZG1salpWUjVjR1VpT2lJeElpd2laR1YyYVdObFZHOXJaVzRpT2lKMFpYTjBJaXdpYVdGMElqb3hOVFk1TURVd01qazNmUS5ON1NwdWJJVWY4OS1Bd3B4WmMyS1ZDeGpWLTNnbnhxU1pWOV9kYko4TEVrIiwidXNlcklkIjoieG1QalZMQ3RRcjJsTXduODJyd0kiLCJpYXQiOjE1NjkwNTAyOTd9.iuZseXwXnhQ8Yy_mboqfHz7cyBi-rJZWyUaNMbKH3mo",
            "sBk1S3fwFqa9XzcgdHbI",
            "11"
        )

        OoRestManager.createChannel(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.channel?.id)
            Assert.assertNotEquals(null, response?.channel?.roomId)
            Assert.assertNotEquals(0, response?.channel?.iceServers?.size)
            Assert.assertNotEquals(null, response?.channel?.turnRestUrl)
            Assert.assertNotEquals(null, response?.channel?.signal)
            Assert.assertNotEquals(null, response?.channel?.caller)
            Assert.assertNotEquals(null, response?.channel?.callee)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun readChannel() {
        val signal = CountDownLatch(1)

        OoRestManager.readChannel("h4SQF8Jnpuiue1GRLIcY") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.channel)
            signal.countDown()
        }
        signal.await()
    }


    @Test
    fun deleteChannel() {
        val signal = CountDownLatch(1)

        OoRestManager.deleteChannel("oF870wxeF847aNGyn9wh", "QVXx3RNSN9DRQWp8opJs") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }

        signal.await()
    }

    @Test
    fun voipBusy() {
        val signal = CountDownLatch(1)
        OoRestManager.voipBusy("ao4HTpvr6dysvb3Imzse") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun voipReject() {
        val signal = CountDownLatch(1)
        OoRestManager.voipReject("a3qB4j3zXcRKC2GjzuNE") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }


    @Test
    fun turnUrl() {
        val signal = CountDownLatch(1)

        OoRestManager.turnUrl("JrALu2kwI3K4U7cmLQwc") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.iceServers)
        }

        signal.await()
    }
}