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
    fun signinUser() {
        val signal = CountDownLatch(1)
        val auth = OoParamSigninUser("opusonetest03@gmail.com",  "opusone1004")
        OoRestManager.signinUser(auth) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.userToken)
            Assert.assertNotEquals(null, response?.userId)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun createUser() {
        val signal = CountDownLatch(1)

        val params = OoParamCreateUser()
        params.password = "opusone1004"
        params.birthdate = "400804"
        params.gender = "femail"
        params.deviceToken = "testToken"
        params.deviceOS = "android"
        params.deviceModel = "sm-s9"
        params.deviceSerial = "1234"
        params.isLauncher = "false"
        params.idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjI2OGNhNTBjZTY0YjQxYWIzNGZhMDM1NzIwMmQ5ZTk0ZTcyYmQ2ZWMiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoi7KCV7Jik7Y287IqkIiwicGljdHVyZSI6Imh0dHBzOi8vbGg0Lmdvb2dsZXVzZXJjb250ZW50LmNvbS8tQWk2ZC1TeTRXN3MvQUFBQUFBQUFBQUkvQUFBQUFBQUFBQUEvQUNIaTNyZG1YU0tRMzZpdllCWUZmbXREMDcwSXJjckpody9zOTYtYy9waG90by5qcGciLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vbGVhbm9udGFiIiwiYXVkIjoibGVhbm9udGFiIiwiYXV0aF90aW1lIjoxNTY2NDQ3MDgzLCJ1c2VyX2lkIjoiMEU3eDFJOENOQVlFcVAzWVZMdlZYb2JQb1I0MyIsInN1YiI6IjBFN3gxSThDTkFZRXFQM1lWTHZWWG9iUG9SNDMiLCJpYXQiOjE1NjY0NDcwODQsImV4cCI6MTU2NjQ1MDY4NCwiZW1haWwiOiJvcHVzb25ldGVzdDAzQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZSI6eyJpZGVudGl0aWVzIjp7Imdvb2dsZS5jb20iOlsiMTA2ODEzMTY0MTY5NzY5Mjg2OTQ5Il0sImVtYWlsIjpbIm9wdXNvbmV0ZXN0MDNAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoiZ29vZ2xlLmNvbSJ9fQ.Y_DtJkTH4dhZBLCq4TwR4CWFOM0OmQ61HkkCy3xUjSE88b4PrKk2Eptwp3l0eVGxOHfkO_IgpcbpW7o3GAZRlegmjG3MJGArSr0hLsbFbGQkKMyQ3kk-Z_1MUd-Abiy1QBLAwUQNIN_S3Tml3yWXzFKNKrlCSP2zCOWxa3jwMLxFNARV74Ik2FxdNRrzMd5LnDera6QDaTclvEu2ccuNUyvJFTL9V2aPUpmHWCpBc0pqi_keQLh3RA6ftgPBmDzjZXvbk9M22bIDkE61xL3a82jOdkbGEQkuu0Kg8pxwSkTKuvh0-q4gYEWmaLMq_GzLYdtvKiI42NJP1d303OAqvA"

        OoRestManager.createUser(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.userToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun requestGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamRequestGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbEZXV0hnelVrNVRUamxFVWxGWGNEaHZjRXB6SWl3aVpXMWhhV3dpT2lKellXNWhhV2g1Wlc5dVFHZHRZV2xzTG1OdmJTSXNJbTVoYldVaU9pSlpaVzl1WnlCSWVXVnZiaUJEU0U5Sklpd2ljMmhoWkc5M0lqb2laRFptT0RSbE9XSmtOekl3TW1Oa05HVXhaamsxWmpjeVkyVTRabUZqWW1SaU9EVXhZV1k1T1RrM016azFORE0zT1RneE1qYzRZV1U0TnpjeFptWTFOakEzWldabE5ETmhaRFpoTkRSak9UVmhOelkwWkRBM01ERXhaVEU0TWpZMVkyWXpNbU14TVdSa1lqZzVZVFU1T1RKaFlUUmpZelZrTlRaa01tWTBNellpTENKa1pYWnBZMlZVYjJ0bGJpSTZJbTVsZHlCMGIydGxiaklpTENKcGMweGhkVzVqYUdWeUlqb2labUZzYzJVaUxDSndhWEpqZEhWeVpTSTZJbWgwZEhBNkx5OTNkM2NpTENKcFlYUWlPakUxTmpZNE1ERTNNelo5LmowNmZweHAyUEpyMzdxTzd1dUcwN1h0MjZ3eTliWEwtSGs5Z1Z2bUlFMGsiLCJ1c2VySWQiOiJRVlh4M1JOU045RFJRV3A4b3BKcyIsImlhdCI6MTU2NjgwMTczNn0.HhGZaC3FtYqBq638VXHgcCiwQxYOKXbukpy-y85IeQM"
        params.seniorId = "Aw4OytojDaAio3u6ICzo"

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJa0YzTkU5NWRHOXFSR0ZCYVc4emRUWkpRM3B2SWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laSFZDWkZwc2FVbFhiRkU2UVZCQk9URmlSVGswY0dWTFdrbEVUbTluVDI4eVRXeEdYMk5zVDAweFpuSXRUazFUU25SWFMzZGhXa05uUjNVeGVrNTBVVmhmWmtocmFsSXlkbTFyVEZwSFJGRkhPUzFwUXpaSk9VNXBXRzlPUTBwSk1tdGFjelJIVG1sbGRqUmFhM1F3V1dOVE4wSjBWa05wZFVGWVJraDZRazF6YUVSNlNHODJPSFJPU0VsWU5VMVlUMmRHTm1FMkxVY2lMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5c2FEWXVaMjl2WjJ4bGRYTmxjbU52Ym5SbGJuUXVZMjl0THkxQlRGWjNXa3BDVUZkSU9DOUJRVUZCUVVGQlFVRkJTUzlCUVVGQlFVRkJRVUZCUVM5QlEwaHBNM0psYnpGdmVUbEpaVlJ6VjFCTlJIRTFTM1pQY25aNlpVaENSREpCTDNNNU5pMWpMM0JvYjNSdkxtcHdaeUlzSW1saGRDSTZNVFUyTmpnd01qTTVPSDAuTnhONFRtNUFmTnIwdkZLdlZTeGVKMndPcVpZV2xENzFMVzFSTEdXcXF0QSIsInVzZXJJZCI6IkF3NE95dG9qRGFBaW8zdTZJQ3pvIiwiaWF0IjoxNTY2ODAyMzk4fQ.vRt5jod_RR-YPAZBeWYls392wlFly3SHLYedR6eTZtY"
        params.guardianId = "QVXx3RNSN9DRQWp8opJs"

        OoRestManager.acceptGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
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
    fun readUser() {
        val signal = CountDownLatch(1)
        OoRestManager.readUser("dACzSSGoyPsHqgyNwPjc") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.user)
            Assert.assertNotEquals(null, response?.user?.id)
            Assert.assertNotEquals(null, response?.user?.name)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun findUser() {
        val signal = CountDownLatch(1)
        OoRestManager.findUser("opusonetest03@gmail.com") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.user)
            Assert.assertNotEquals(null, response?.user?.id)
            Assert.assertNotEquals(null, response?.user?.name)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun readAndUpdateUser() {
        val signal = CountDownLatch(1)

        OoRestManager.readUser("QVXx3RNSN9DRQWp8opJs") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.user)

            response?.let {
                val user = it.user
                user?.address1 = "update completed"

                OoRestManager.updateUser(user!!) { error, response ->
                    Assert.assertEquals(null, error)
                    Assert.assertNotNull(response?.userToken)

                    response?.let {
                        OoRestManager.readUser("QVXx3RNSN9DRQWp8opJs") { error, response ->
                            Assert.assertEquals(null, error)

                            val user = response?.user
                            Assert.assertEquals("update completed", user?.address1)
                            signal.countDown()
                        }
                    }
                }
            }
        }
        signal.await()
    }

    @Test
    fun deleteUser() {
        val signal = CountDownLatch(1)
        OoRestManager.deleteUser("dACzSSGoyPsHqgyNwPjc") { error, response ->
            Assert.assertEquals(null, error)

            OoRestManager.readUser("dACzSSGoyPsHqgyNwPjc") { error, response ->
                Assert.assertEquals(null, error)
                Assert.assertEquals(null, response?.user)
                signal.countDown()
            }
            error?.let {
                Assert.assertNotEquals(null, it)
            }
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
    fun mmse() {
        val signal = CountDownLatch(1)
        val param = OoParamMMSE("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJakJaWkdOVldtSmljVmh3WjBKaGRrUldXVlJISWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtObVk0TkdVNVltUTNNakF5WTJRMFpURm1PVFZtTnpKalpUaG1ZV05pWkdJNE5URmhaams1T1Rjek9UVTBNemM1T0RFeU56aGhaVGczTnpGbVpqVTJNRGRsWm1VME0yRmtObUUwTkdNNU5XRTNOalJrTURjd01URmxNVGd5TmpWalpqTXlZekV4WkdSaU9EbGhOVGs1TW1GaE5HTmpOV1ExTm1ReVpqUXpOaUlzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkltWmhiSE5sSWl3aWFXRjBJam94TlRZME5UVXhPVGd6ZlEuaEVYU3JHaUY4bEx4SkJvam95UGU5WkhxTl9CZHFJbFR5Rm1PdnczOXprRSIsInVzZXJJZCI6IjBZZGNVWmJicVhwZ0JhdkRWWVRHIiwiaWF0IjoxNTY0NTUxOTgzfQ.HsVA_FNEXSkHV3WN2NMF_PMD-8dxNzjUvA-9hAaielw",
            "200")
        OoRestManager.createMMSE(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
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
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbm8yUVRSSGFqUnJkams0TURGWmFYa3pVRkJSSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXpRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxzb0pYc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laVFZpWWtveU9WaFdNbGs2UVZCQk9URmlSekUyVW5wZmEwUnVNa0Z6V1hSNlVHZzJkREpLZFUxTU5uZHJVR1I1YUZNMWNYbGthUzB0VGs5MFgwRkhTRTAzWDB0TmNrWnZPSG8xUVdKSGQxWnJjVzh5UTNFeFgwcHRNVTl3YzAxcWVreFpNekV5YkZGMFFVMDFaR3QyTjFkeFkzRllSRk51YUZoTWRWTjBkRGx3ZDFaMWVGWllabFl5ZVV3MmJGSkhiSGM0V1hkMlptRWlMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5c2FEUXVaMjl2WjJ4bGRYTmxjbU52Ym5SbGJuUXVZMjl0THkxQmFUWmtMVk41TkZjM2N5OUJRVUZCUVVGQlFVRkJTUzlCUVVGQlFVRkJRVUZCUVM5QlEwaHBNM0prYlZoVFMxRXpObWwyV1VKWlJtWnRkRVF3TnpCSmNtTnlTbWgzTDNNNU5pMWpMM0JvYjNSdkxtcHdaeUlzSW1saGRDSTZNVFUyTnpReE16ZzJPWDAueDQ4QkgzcDFaeXVtbVVMbHA5TnhfZnZoTnRIdTl1ZEp2dGF3c1NhWFR4cyIsInVzZXJJZCI6Ino2QTRHajRrdjk4MDFZaXkzUFBRIiwiaWF0IjoxNTY3NDEzODY5fQ.9u-DLCUZEC015sk_L7ks_S4Ijk0ZIzJgN8lzzs4OkV8",
            "THYFao4Zv9gwaLQRz4So",
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
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbm8yUVRSSGFqUnJkams0TURGWmFYa3pVRkJSSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXpRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxzb0pYc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laVFZpWWtveU9WaFdNbGs2UVZCQk9URmlSekUyVW5wZmEwUnVNa0Z6V1hSNlVHZzJkREpLZFUxTU5uZHJVR1I1YUZNMWNYbGthUzB0VGs5MFgwRkhTRTAzWDB0TmNrWnZPSG8xUVdKSGQxWnJjVzh5UTNFeFgwcHRNVTl3YzAxcWVreFpNekV5YkZGMFFVMDFaR3QyTjFkeFkzRllSRk51YUZoTWRWTjBkRGx3ZDFaMWVGWllabFl5ZVV3MmJGSkhiSGM0V1hkMlptRWlMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5c2FEUXVaMjl2WjJ4bGRYTmxjbU52Ym5SbGJuUXVZMjl0THkxQmFUWmtMVk41TkZjM2N5OUJRVUZCUVVGQlFVRkJTUzlCUVVGQlFVRkJRVUZCUVM5QlEwaHBNM0prYlZoVFMxRXpObWwyV1VKWlJtWnRkRVF3TnpCSmNtTnlTbWgzTDNNNU5pMWpMM0JvYjNSdkxtcHdaeUlzSW1saGRDSTZNVFUyTnpReE16ZzJPWDAueDQ4QkgzcDFaeXVtbVVMbHA5TnhfZnZoTnRIdTl1ZEp2dGF3c1NhWFR4cyIsInVzZXJJZCI6Ino2QTRHajRrdjk4MDFZaXkzUFBRIiwiaWF0IjoxNTY3NDEzODY5fQ.9u-DLCUZEC015sk_L7ks_S4Ijk0ZIzJgN8lzzs4OkV8",
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
        val param = OoParamMessage("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbm8yUVRSSGFqUnJkams0TURGWmFYa3pVRkJSSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXpRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxzb0pYc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laVFZpWWtveU9WaFdNbGs2UVZCQk9URmlSekUyVW5wZmEwUnVNa0Z6V1hSNlVHZzJkREpLZFUxTU5uZHJVR1I1YUZNMWNYbGthUzB0VGs5MFgwRkhTRTAzWDB0TmNrWnZPSG8xUVdKSGQxWnJjVzh5UTNFeFgwcHRNVTl3YzAxcWVreFpNekV5YkZGMFFVMDFaR3QyTjFkeFkzRllSRk51YUZoTWRWTjBkRGx3ZDFaMWVGWllabFl5ZVV3MmJGSkhiSGM0V1hkMlptRWlMQ0pwYzB4aGRXNWphR1Z5SWpvaWRISjFaU0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5c2FEUXVaMjl2WjJ4bGRYTmxjbU52Ym5SbGJuUXVZMjl0THkxQmFUWmtMVk41TkZjM2N5OUJRVUZCUVVGQlFVRkJTUzlCUVVGQlFVRkJRVUZCUVM5QlEwaHBNM0prYlZoVFMxRXpObWwyV1VKWlJtWnRkRVF3TnpCSmNtTnlTbWgzTDNNNU5pMWpMM0JvYjNSdkxtcHdaeUlzSW1saGRDSTZNVFUyTnpReE16ZzJPWDAueDQ4QkgzcDFaeXVtbVVMbHA5TnhfZnZoTnRIdTl1ZEp2dGF3c1NhWFR4cyIsInVzZXJJZCI6Ino2QTRHajRrdjk4MDFZaXkzUFBRIiwiaWF0IjoxNTY3NDEzODY5fQ.9u-DLCUZEC015sk_L7ks_S4Ijk0ZIzJgN8lzzs4OkV8",
            "Aw4OytojDaAio3u6ICzo",
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
}
