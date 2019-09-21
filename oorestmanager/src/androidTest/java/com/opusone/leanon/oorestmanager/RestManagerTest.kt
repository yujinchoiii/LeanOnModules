package com.opusone.leanon.oorestmanager

import android.util.Log
import androidx.test.runner.AndroidJUnit4
import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*
import java.util.concurrent.CountDownLatch

class RestManagerTest {

    @Before
    fun setUp() {
        OoRestManager.retrofitInit()

        val signal = CountDownLatch(1)
        OoRestManager.auth(OoParamPartnerAuth("dev@theopusone.com", "opusone1004")) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.accessToken)
            OoRestManager.setBearerToken(response?.accessToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun hello() {
        val signal = CountDownLatch(1)
        OoRestManager.hello {
            Assert.assertNotEquals(null, it)
            Assert.assertEquals(true, it?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun auth() {
        val signal = CountDownLatch(1)
        OoRestManager.auth(OoParamPartnerAuth("dev@theopusone.com", "opusone1004")) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.accessToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun requestGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamRequestGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbEZXV0hnelVrNVRUamxFVWxGWGNEaHZjRXB6SWl3aVpXMWhhV3dpT2lKellXNWhhV2g1Wlc5dVFHZHRZV2xzTG1OdmJTSXNJbTVoYldVaU9pSlpaVzl1WnlCSWVXVnZiaUJEU0U5Sklpd2ljMmhoWkc5M0lqb2laRFptT0RSbE9XSmtOekl3TW1Oa05HVXhaamsxWmpjeVkyVTRabUZqWW1SaU9EVXhZV1k1T1RrM016azFORE0zT1RneE1qYzRZV1U0TnpjeFptWTFOakEzWldabE5ETmhaRFpoTkRSak9UVmhOelkwWkRBM01ERXhaVEU0TWpZMVkyWXpNbU14TVdSa1lqZzVZVFU1T1RKaFlUUmpZelZrTlRaa01tWTBNellpTENKa1pYWnBZMlZVYjJ0bGJpSTZJbTVsZHlCMGIydGxiaklpTENKcGMweGhkVzVqYUdWeUlqb2labUZzYzJVaUxDSndhWEpqZEhWeVpTSTZJbWgwZEhBNkx5OTNkM2NpTENKcFlYUWlPakUxTmpjMk5qazFOekY5LnBBQzQ1S1pSRzc3VFgwTVNhTVR0dFp2bHJKU09MR0l4Q3pOcU42MjVkcEkiLCJ1c2VySWQiOiJRVlh4M1JOU045RFJRV3A4b3BKcyIsImlhdCI6MTU2NzY2OTU3MX0.E0Ryt5OQxI5ifSRVgznRip4vsXdHFUY05ePB-NdFJtk"
        params.seniorId = "UFWvQ1OV2gpuBaSj4Wnd"

        OoRestManager.requestGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun acceptGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamAcceptGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWNHbHlZM1IxY21VaU9pSm9kSFJ3T2k4dmQzZDNJaXdpYVdGMElqb3hOVFkzTmpZd056STVmUS5KTTRDUmRyRXMwNExGcGQ1OEd2eWZrOXZJRlA5OE9pLWZvWkw5Q05TSEZFIiwidXNlcklkIjoiVUZXdlExT1YyZ3B1QmFTajRXbmQiLCJpYXQiOjE1Njc2NjA3Mjl9.WWrGS5-UDDMXoI7aO4fjjkOj9vSUKOmEQrq3Bfb7qB4"
        params.guardianId = "QVXx3RNSN9DRQWp8opJs"

        OoRestManager.acceptGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.daily?.appRunCount)
            Assert.assertNotNull(response?.daily?.location)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun rejectGuardian() {
        val signal = CountDownLatch(1)

        OoRestManager.rejectGuardian("UFWvQ1OV2gpuBaSj4Wnd", "QVXx3RNSN9DRQWp8opJs") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun fineDust() {
        val signal = CountDownLatch(1)
        OoRestManager.fineDust("서울", "도봉") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.fineDust?.sidoName)
            Assert.assertNotEquals(null, response?.fineDust?.cityName)
            Assert.assertNotEquals(null, response?.fineDust?.sidoName)
            Assert.assertNotEquals(null, response?.fineDust?.pm25Value)
            Assert.assertNotEquals(null, response?.fineDust?.pm10Value)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun weather() {
        val signal = CountDownLatch(1)
        OoRestManager.weather("경기", "성남") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.weather?.sidoName)
            Assert.assertNotEquals(null, response?.weather?.cityName)
            Assert.assertNotEquals(null, response?.weather?.temp)
            Assert.assertNotEquals(null, response?.weather?.minTemp)
            Assert.assertNotEquals(null, response?.weather?.maxTemp)
            Assert.assertNotEquals(null, response?.weather?.sky)
            Assert.assertNotEquals(null, response?.weather?.rain)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun appUseReport() {
        val signal = CountDownLatch(1)
        val au = OoParamAppUse("Music", "음악스",  "com.google.music", null, "1.0.0", "happyLife", "100")
        val param = OoParamAppUseReport("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJa0YzTkU5NWRHOXFSR0ZCYVc4emRUWkpRM3B2SWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lablJEZW5Bek1FeHNZV002UVZCQk9URmlSVTV1Tm10aE1EaFpSWGxDU2t0UFlWSkhha3ROTTNKeWRrNUViM054VVdWU2VuUjBPRmRGYWpkVVQxZ3RXRXhRTTJKcVlsaFBjbHAwVlZCT2RYUlBNMnBCVEhWQ1FrdGZSWE41Y0RCSVQxWmhlUzFRWkZVd2JXZFFaVkJTWm5KMFptczNXRkF3V0ZOWE5GSm5UbTVxUlVSaGIwSTVRMlZJZVZJNFVtZENaWFJ4Vld4TlNrb2lMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW1saGRDSTZNVFUyTkRjME1UQTRPSDAuLXlfeWZWUG5hZjZKeU83bXZCcTdkbFZfRm90WlFLWTBhY1UxdEg4eFFLQSIsInVzZXJJZCI6IkF3NE95dG9qRGFBaW8zdTZJQ3pvIiwiaWF0IjoxNTY0NzQxMDg4fQ.sYq3Q0IgUwr6us2oBCGSs02vXOMRCFL-2hzCc6-LMEc",
            arrayListOf(au))
        OoRestManager.createAppUseReport(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendMessage() {
        val signal = CountDownLatch(1)
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWNHbHlZM1IxY21VaU9pSm9kSFJ3T2k4dmQzZDNJaXdpYVdGMElqb3hOVFkzTmpZd056STVmUS5KTTRDUmRyRXMwNExGcGQ1OEd2eWZrOXZJRlA5OE9pLWZvWkw5Q05TSEZFIiwidXNlcklkIjoiVUZXdlExT1YyZ3B1QmFTajRXbmQiLCJpYXQiOjE1Njc2NjA3Mjl9.WWrGS5-UDDMXoI7aO4fjjkOj9vSUKOmEQrq3Bfb7qB4",
            "QVXx3RNSN9DRQWp8opJs",
            "0", "0","Hello", mutableListOf(""))
        OoRestManager.sendMessage(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.message)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendGroupMessageFromSenior() {
        val signal = CountDownLatch(1)
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWNHbHlZM1IxY21VaU9pSm9kSFJ3T2k4dmQzZDNJaXdpYVdGMElqb3hOVFkzTmpZd056STVmUS5KTTRDUmRyRXMwNExGcGQ1OEd2eWZrOXZJRlA5OE9pLWZvWkw5Q05TSEZFIiwidXNlcklkIjoiVUZXdlExT1YyZ3B1QmFTajRXbmQiLCJpYXQiOjE1Njc2NjA3Mjl9.WWrGS5-UDDMXoI7aO4fjjkOj9vSUKOmEQrq3Bfb7qB4",
            null,
            "0", "0","Hello, I'm senior", mutableListOf(""))
        OoRestManager.sendGroupMessage(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.message)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendGroupMessageFromGuardian() {
        val signal = CountDownLatch(1)
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbEZXV0hnelVrNVRUamxFVWxGWGNEaHZjRXB6SWl3aVpXMWhhV3dpT2lKellXNWhhV2g1Wlc5dVFHZHRZV2xzTG1OdmJTSXNJbTVoYldVaU9pSlpaVzl1WnlCSWVXVnZiaUJEU0U5Sklpd2ljMmhoWkc5M0lqb2laRFptT0RSbE9XSmtOekl3TW1Oa05HVXhaamsxWmpjeVkyVTRabUZqWW1SaU9EVXhZV1k1T1RrM016azFORE0zT1RneE1qYzRZV1U0TnpjeFptWTFOakEzWldabE5ETmhaRFpoTkRSak9UVmhOelkwWkRBM01ERXhaVEU0TWpZMVkyWXpNbU14TVdSa1lqZzVZVFU1T1RKaFlUUmpZelZrTlRaa01tWTBNellpTENKa1pYWnBZMlZVYjJ0bGJpSTZJbTVsZHlCMGIydGxiaklpTENKcGMweGhkVzVqYUdWeUlqb2labUZzYzJVaUxDSndhWEpqZEhWeVpTSTZJbWgwZEhBNkx5OTNkM2NpTENKcFlYUWlPakUxTmpjMk5qYzROeko5LmhaWkJLVFBBMENwNjFkUndyMmdfSjE4b2F3R1VGR0xYY2diT2xTTURpWEEiLCJ1c2VySWQiOiJRVlh4M1JOU045RFJRV3A4b3BKcyIsImlhdCI6MTU2NzY2Nzg3Mn0.Ma953JhxGNUWp-drUxtf5-ciLjRu7e4gw1eWuHb-qXE",
            "UFWvQ1OV2gpuBaSj4Wnd",
            "0", "0","Hello, I'm guardian", mutableListOf(""))
        OoRestManager.sendGroupMessage(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.message)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun createVoipChannel() {
        val signal = CountDownLatch(1)
        val param = OoParamCreateChannel(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbEZXV0hnelVrNVRUamxFVWxGWGNEaHZjRXB6SWl3aVpXMWhhV3dpT2lKellXNWhhV2g1Wlc5dVFHZHRZV2xzTG1OdmJTSXNJbTVoYldVaU9pSlpaVzl1WnlCSWVXVnZiaUJEU0U5Sklpd2ljMmhoWkc5M0lqb2laRFptT0RSbE9XSmtOekl3TW1Oa05HVXhaamsxWmpjeVkyVTRabUZqWW1SaU9EVXhZV1k1T1RrM016azFORE0zT1RneE1qYzRZV1U0TnpjeFptWTFOakEzWldabE5ETmhaRFpoTkRSak9UVmhOelkwWkRBM01ERXhaVEU0TWpZMVkyWXpNbU14TVdSa1lqZzVZVFU1T1RKaFlUUmpZelZrTlRaa01tWTBNellpTENKa1pYWnBZMlZVYjJ0bGJpSTZJbTVsZHlCMGIydGxiaklpTENKcGMweGhkVzVqYUdWeUlqb2labUZzYzJVaUxDSndhWEpqZEhWeVpTSTZJbWgwZEhBNkx5OTNkM2NpTENKcFlYUWlPakUxTmpjME56Z3lPREI5LlEtYVJHbmRreFdQNHAxLUV4U3NPTjJwVjRDTXgxUk1YTTVFR29fZ3d4dzQiLCJ1c2VySWQiOiJRVlh4M1JOU045RFJRV3A4b3BKcyIsImlhdCI6MTU2NzQ3ODI4MH0.FCDayior7LTy6qB8LZlInwEYqD9hkp8mAGPUJSLiF5M",
            "UFWvQ1OV2gpuBaSj4Wnd"
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

        OoRestManager.readChannel("TZugOgil7Tb8W5UR2F4c") { error, response ->
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
        OoRestManager.voipReject("ao4HTpvr6dysvb3Imzse") { error, response ->
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
