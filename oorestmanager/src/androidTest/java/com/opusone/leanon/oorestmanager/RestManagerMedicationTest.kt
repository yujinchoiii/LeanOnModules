package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamRegisterMedication
import com.opusone.leanon.oorestmanager.params.OoParamResultMedication
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerMedicationTest {

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
    fun registerMedication() {
        val signal = CountDownLatch(1)
        val params = OoParamRegisterMedication()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkluUnlkV1VpTENKd2FYSmpkSFZ5WlNJNkltaDBkSEE2THk5M2QzY2lMQ0pwWVhRaU9qRTFOamMyTnpBME5qWjkuU3hHZnF5bGE4Wl8zLTB3MkdzQS1zYi0wMnNjbGxteVJJNXg4NDNWZkF0QSIsInVzZXJJZCI6IlVGV3ZRMU9WMmdwdUJhU2o0V25kIiwiaWF0IjoxNTY3NjcwNDY2fQ.LddVfqlVt9q9Ur-FFcJ1cHl8fHzZfbT_14x7GhFad2Q"
        params.seniorId = "UFWvQ1OV2gpuBaSj4Wnd"
        params.alarmId = "120"
        params.alarmName = "depression"
        params.hour = "8"
        params.min = "20"
        params.picture = ""
//        params.weekdaysInfo = "true" //배열 수정?

        OoRestManager.registerMedication(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun resultMedication() {
        val signal = CountDownLatch(1)
        val params = OoParamResultMedication()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWNHbHlZM1IxY21VaU9pSm9kSFJ3T2k4dmQzZDNJaXdpYVdGMElqb3hOVFkzTmpZd056STVmUS5KTTRDUmRyRXMwNExGcGQ1OEd2eWZrOXZJRlA5OE9pLWZvWkw5Q05TSEZFIiwidXNlcklkIjoiVUZXdlExT1YyZ3B1QmFTajRXbmQiLCJpYXQiOjE1Njc2NjA3Mjl9.WWrGS5-UDDMXoI7aO4fjjkOj9vSUKOmEQrq3Bfb7qB4"
        params.medicationId = "-Lo-fw4JyxKQ_Yja6it-"
        params.isTaken = "false"

        OoRestManager.resultMedication(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getMedicationList() {
        val signal = CountDownLatch(1)
        OoRestManager.getMedications("UFWvQ1OV2gpuBaSj4Wnd") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun deleteMedication() {
        val signal = CountDownLatch(1)
        OoRestManager.deleteMedications("UFWvQ1OV2gpuBaSj4Wnd", "-Lo-fw4JyxKQ_Yja6it-") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            signal.countDown()
        }
        signal.await()
    }
}