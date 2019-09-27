package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerReportTest {

    @Before
    fun setUp() {
        OoRestManager.init()

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDNCa2N5NXFiMmx1Y3k1amIyMHZMMjVsZDNNdlkyOXRjRzl1Wlc1MEwyaDBiV3h3YUc5MGIxOXRiV1JoZEdFdk1qQXhPREEwTHpJeUwyUXhaVE01T0dJNUxUSTRNVE10TkRNek55MDRPVEUwTFRrNE5EZGpaR1ExWXpjM1pTNXFjR2NpTENKa1pYWnBZMlZVZVhCbElqb2lNU0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laVzltY0hSM2NtcDRaMGs2UVZCQk9URmlSalpxZUdSTExWVjFhM0ozY2pSMVIzQkVSV0UwT0hoaGExTjNaM1UyVUdsTVVFWnVabTF0VDNkUWJVaG9ZMFIwWW05dFRFazVMVGhGVUU1VlRHNUdaM2hmWTFOUmFWSXdRMGd6YjFOa1RISk9VbVJIVFRsalgxWmtUemt4YUZsMk9VZ3dPVkYzUWtvdFFXeGZXVWRVTm5VdFYxWkNNRmhhTjFKamNuaFZjVW81U1ZBM1ZtY2lMQ0pwWVhRaU9qRTFOamswT1RRNU1qTjkuSjY1VUFVWG03VzZIT3FQYlUweTFrY1l5Tk1lZFJfR2hyVk53c016LTJzWSIsInVzZXJJZCI6ImJ6VDhHeWJxTFl5eVJKZFhseUpSIiwiaWF0IjoxNTY5NDk0OTIzfQ.W91l02Bc9w2GSIT42qczjuI4roYkxZ09yHtuiKOSLdI"
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
        OoRestManager.getScaleReport("bzT8GybqLYyyRJdXlyJR") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.scale?.report)
            Assert.assertNotNull(response?.scale?.timestamp)
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
        OoRestManager.getLocationReport("bzT8GybqLYyyRJdXlyJR") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.location?.report)
            Assert.assertNotNull(response?.location?.timestamp)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getDailyReport() {
        val signal = CountDownLatch(1)
        OoRestManager.getDailyReport("bzT8GybqLYyyRJdXlyJR") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.daily?.appRunCount?.report)
            Assert.assertNotNull(response?.daily?.location?.report)
//            Assert.assertNotNull(response?.daily?.medication)
            Assert.assertNotNull(response?.daily?.scale?.report)
            Assert.assertNotNull(response?.daily?.brainDoctor?.diagnosis)
            Assert.assertNotNull(response?.daily?.brainDoctor?.daily)
            Assert.assertNotNull(response?.daily?.greeting?.ampm)
            signal.countDown()
        }
        signal.await()
    }


    @Test
    fun registerGreeting() {
        val signal = CountDownLatch(1)
        val params = OoParamRegisterGreeting()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNkM2R5NW1iMk4xYzI1bGQzTXhMbU52YlM5dVpYZHpMM0JvYjNSdkx6SXdNVGt3TXk4eU5UY3dNRjh4TkRVeU1GOHpNekUwTG1wd1p5SXNJbVJsZG1salpWUjVjR1VpT2lJeE1pSXNJbVJsZG1salpWUnZhMlZ1SWpvaVpuQjNUV010YXpCTWMwRTZRVkJCT1RGaVJXSk9USFJFY0dkelMyaE5USGRVWHpacWVqRjJkR2w1YkVWbVRVSmlhMHhsUVhGb09Ib3hTMDVyY1ZobE9YRllWaTFXTWpGVE5ESklaRlIzVG5OQ09XeHBSR2RNWldaQkxXa3RVR0pSVkhCMldrZzRhMHBUTlRSZlMzZHBOSFpPYUdoTGJEbDZNWGxZU0VoRVVrd3hNa3QwYUdOWVdEbFROV1pKWTJwUlV6ZFZNSE4xWm1FaUxDSnBZWFFpT2pFMU5qazBPVGMyTnpkOS5QSFZYVHR2OUxIRWdseURNa1RnQ0tuTXpKanFLNjdieUh1ZnpyLWM2MHE0IiwidXNlcklkIjoiR1VleE10ZWVNbXFVQTBRcDVIcmMiLCJpYXQiOjE1Njk0OTc2Nzd9.fNRspBIGZkq9rVmWI0Lp6mAgap5fTvD4dEF57KkMd2o"
        params.seniorId = "bzT8GybqLYyyRJdXlyJR"
        params.hour = "9"
        params.minute= "00"
        params.ampm = "am"
        params.message = "살아계십니까?"
        params.on = "true"

        OoRestManager.registerGreeting(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun resultGreeting() {
        val signal = CountDownLatch(1)
        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNkM2R5NW1iMk4xYzI1bGQzTXhMbU52YlM5dVpYZHpMM0JvYjNSdkx6SXdNVGt3TXk4eU5UY3dNRjh4TkRVeU1GOHpNekUwTG1wd1p5SXNJbVJsZG1salpWUjVjR1VpT2lJeE1pSXNJbVJsZG1salpWUnZhMlZ1SWpvaVpuQjNUV010YXpCTWMwRTZRVkJCT1RGaVJXSk9USFJFY0dkelMyaE5USGRVWHpacWVqRjJkR2w1YkVWbVRVSmlhMHhsUVhGb09Ib3hTMDVyY1ZobE9YRllWaTFXTWpGVE5ESklaRlIzVG5OQ09XeHBSR2RNWldaQkxXa3RVR0pSVkhCMldrZzRhMHBUTlRSZlMzZHBOSFpPYUdoTGJEbDZNWGxZU0VoRVVrd3hNa3QwYUdOWVdEbFROV1pKWTJwUlV6ZFZNSE4xWm1FaUxDSnBZWFFpT2pFMU5qazBPVGMyTnpkOS5QSFZYVHR2OUxIRWdseURNa1RnQ0tuTXpKanFLNjdieUh1ZnpyLWM2MHE0IiwidXNlcklkIjoiR1VleE10ZWVNbXFVQTBRcDVIcmMiLCJpYXQiOjE1Njk0OTc2Nzd9.fNRspBIGZkq9rVmWI0Lp6mAgap5fTvD4dEF57KkMd2o"
        OoRestManager.resultGreeting(userToken) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }
}