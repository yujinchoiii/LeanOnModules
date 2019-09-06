package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamLocation
import com.opusone.leanon.oorestmanager.params.OoParamMMSE
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamScale
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerReport {

    @Before
    fun setUp() {
        OoRestManager.retrofitInit()

        val signal = CountDownLatch(1)
        OoRestManager.auth(
            OoParamPartnerAuth(
                "dev@theopusone.com",
                "opusone1004"
            )
        ) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.accessToken)
            OoRestManager.setBearerToken(response?.accessToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun scaleReport() {
        val signal = CountDownLatch(1)
        val params = OoParamScale()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFJJV1VaaGJ6UmFkamxuZDJGTVVWSjZORk52SWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXpRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxzb0pYc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lZM1ZDWXpJNWNuZHhka1U2UVZCQk9URmlSbVZsTWxSM1JrdGphMUZoTW00dGRYVkRlRUZDYmpkcmFFUmpVWGd5YkhGVGRYSk9ja1JxVFRGVWRXUlFObFZLWmtocWNERnVTSEpXTFZSb09YaFRjemRrY1VaRWIwSTFUVmxEWDJ3M1oxQk5lVkl0VTBGQmRrVXdORGRqYTFwRVltRnlObGxhYTBkUlUzcHZkbk5uY3pKcE4wZEdhMjkxVFZkbVlsTk5iRzltVVZCVFVGQWlMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5c2FEUXVaMjl2WjJ4bGRYTmxjbU52Ym5SbGJuUXVZMjl0THkxQmFUWmtMVk41TkZjM2N5OUJRVUZCUVVGQlFVRkJTUzlCUVVGQlFVRkJRVUZCUVM5QlEwaHBNM0prYlZoVFMxRXpObWwyV1VKWlJtWnRkRVF3TnpCSmNtTnlTbWgzTDNNNU5pMWpMM0JvYjNSdkxtcHdaeUlzSW1saGRDSTZNVFUyTlRrMU1ESXlOWDAuM3lFVWY3Q1FtLUhpa3JweTZQbmNYUERFM2JVSVU2MHFiT240cW10QkxoQSIsInVzZXJJZCI6IlRIWUZhbzRadjlnd2FMUVJ6NFNvIiwiaWF0IjoxNTY1OTUwMjI1fQ.YxBkHUiYD7uhJUi1Haz4zK8vKbfDpSWgbnVgALWcFKU"
        params.weight = "1"
        params.bmi = "2"
        params.bodyFatRate = "34"
        params.subcutaneousFat = "5"
        params.visceralFat = "6"
        params.bodyWaterRate = "7"
        params.muscleRate = "8"
        params.boneMass = "9"
        params.bmr = "0"
        params.heartRate = "12"

        OoRestManager.scaleReport(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getScaleReport() {
        val signal = CountDownLatch(1)
        OoRestManager.getScaleReport("UFWvQ1OV2gpuBaSj4Wnd") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.scale?.userId)
            Assert.assertNotNull(response?.scale?.weight)
            Assert.assertNotNull(response?.scale?.bmi)
            signal.countDown()
        }
        signal.await()
    }


    @Test
    fun locationReport() {
        val signal = CountDownLatch(1)
        val params = OoParamLocation()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWNHbHlZM1IxY21VaU9pSm9kSFJ3T2k4dmQzZDNJaXdpYVdGMElqb3hOVFkzTkRnNE56VTJmUS5QZE5Wb2lJWDY4dkp4Qll4Ql9jREdCbTNMZ1pWeDN5NG11Q3hzRV9sWU53IiwidXNlcklkIjoiVUZXdlExT1YyZ3B1QmFTajRXbmQiLCJpYXQiOjE1Njc0ODg3NTZ9.-rLfj8jIy6mqpnWC2fKmf7opCsut1DJVh6xv6nr26gY"
        params.geoCoding = "서울 턱별시"
        params.latitude = "23.3633"
        params.longitude= "34.33"

        OoRestManager.locationReport(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getLocationReport() {
        val signal = CountDownLatch(1)
        OoRestManager.getLocationReport("UFWvQ1OV2gpuBaSj4Wnd") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.location?.userId)
            Assert.assertNotNull(response?.location?.geoCoding)
            Assert.assertNotNull(response?.location?.latitude)
            Assert.assertNotNull(response?.location?.longitude)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun mmse() {
        val signal = CountDownLatch(1)
        val param = OoParamMMSE("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkluUnlkV1VpTENKd2FYSmpkSFZ5WlNJNkltaDBkSEE2THk5M2QzY2lMQ0pwWVhRaU9qRTFOamMyTnpjeU5UaDkuLXBZYXQ5UnJhWEhEeE1hQUpNZFozMmxwc2d5bzQtVXNUcmpxdGR1UHN5SSIsInVzZXJJZCI6IlVGV3ZRMU9WMmdwdUJhU2o0V25kIiwiaWF0IjoxNTY3Njc3MjU4fQ.UwHBRJcyj03OJ0ef_gdhqrVppTCL6fndQAlTmEnKqbw",
            "200")
        OoRestManager.createMMSE(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getMMSE() {
        val signal = CountDownLatch(1)
        OoRestManager.getMMSE("UFWvQ1OV2gpuBaSj4Wnd") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.mmse?.userId)
            Assert.assertNotNull(response?.mmse?.result)
            Assert.assertNotNull(response?.mmse?.timestamp)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getDailyReport() {
        val signal = CountDownLatch(1)
        OoRestManager.getDailyReport("UFWvQ1OV2gpuBaSj4Wnd") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.daily?.appRunCount)
            Assert.assertNotNull(response?.daily?.location)
            Assert.assertNotNull(response?.daily?.medication)
            Assert.assertNotNull(response?.daily?.mmse)
            Assert.assertNotNull(response?.daily?.scale)
            signal.countDown()
        }
        signal.await()
    }
}