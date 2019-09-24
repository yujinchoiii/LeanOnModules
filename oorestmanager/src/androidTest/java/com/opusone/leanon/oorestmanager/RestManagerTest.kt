package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.model.OoUserDevice
import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerTest {

    @Before
    fun setUp() {
        OoRestManager.init()

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
}
