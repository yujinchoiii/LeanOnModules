package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerAccountTest {

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
    fun signup() {
        val signal = CountDownLatch(1)

        val params = OoParamUserSignup()
        params.idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjBhOTAwNTFmYzA5ZThmNjBlMTE2N2ViYzMxMjYwZjNiM2Y2YmJhYmIiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiWWVvbmcgSHllb24gQ0hPSSIsInBpY3R1cmUiOiJodHRwczovL2xoNi5nb29nbGV1c2VyY29udGVudC5jb20vLURaa3lLTVhPS2xFL0FBQUFBQUFBQUFJL0FBQUFBQUFBQS1VL25QWnFqQWxnUXljL3Bob3RvLmpwZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9sZWFub250YWIiLCJhdWQiOiJsZWFub250YWIiLCJhdXRoX3RpbWUiOjE1NjkxMjY3NDcsInVzZXJfaWQiOiJ2QTBGY0hOa1plZGNnd1NodEE2YmhJTGswRkIzIiwic3ViIjoidkEwRmNITmtaZWRjZ3dTaHRBNmJoSUxrMEZCMyIsImlhdCI6MTU2OTEyNjc0NywiZXhwIjoxNTY5MTMwMzQ3LCJlbWFpbCI6InNhbmFpaHllb25AZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZ29vZ2xlLmNvbSI6WyIxMTA0MTYxMjQ3MjMyOTU2OTE1OTciXSwiZW1haWwiOlsic2FuYWloeWVvbkBnbWFpbC5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJnb29nbGUuY29tIn19.X4hhUkUX27kOig98snjoGD6OVYIkUH8ly9kZrn06EQRMFYfTXMu5ZPg5TXX1ALw1C-c7WCF_DWlMqvuKvaFGoxRNuJrKi6r3Q-tQKByp8Kx1CBAq2JTue59JqYYNQIX6vPIaa8sG7wNwb-9m0SflJTx-ohAia6BuwvqckZpAVWqKJHKJobMWmn_oGFc7ALuvOqDNkWlK5M4fokOf5HPgLEKd22x5OGqONi3xy_rUDqNmn2xiEPhvx0diiEgIuKHzy990fLLtX59JbSTCU8yJujsKF_TMV05G27sALvpwrrA805fYpcmWY_yLiHq3c3ubzmn-qbPgSyInm5kjT5L7yQ"
        params.password = "opusone1004"
        params.birthdate = "830415"
        params.picture = "http://yepan.net/data/file/news/thumb/720x0_90/3667595528_5d0a3c42_1.jpg"
        params.gender = "male"
        params.address1 = "서울시"
        params.address2 = "도봉"
        params.tel = "031-382-7992"
        params.mobile = "010-2000-0000"
        params.height = "175"
        params.weight = "75"
        params.nationalCode = "82"
        params.deviceType= "12"
        params.deviceOs = "android"
        params.deviceToken = "test"
        params.deviceModel = "SM-S610"
        params.deviceVersion = "8.1.0"

        OoRestManager.signupUser(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.userId)
            Assert.assertNotEquals(null, response?.userToken)
            Assert.assertNotEquals(null, response?.webrtcToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun signin() {
        val signal = CountDownLatch(1)

        val params = OoParamUserSignin()
        params.email = "cyh3813@gmail.com"
        params.password = "opusone1004"
        params.deviceType= "12"
        params.deviceOs = "android"
        params.deviceToken = "fTiY-WMWnU4:APA91bG3jJmoo9rlcGhbYofj8Btm9BtyfUL2d8lnw-YbsxhviORgRXxpMyT6kvRmUE6i4eEYRNJ76HqA_GGz4ZwdW9GaUhO2sdpmfPDr0eOkXtJRrTKPT-KHUJO0YLq6aMxksV_2CRuh"
        params.deviceModel = "iPhone Xs"
        params.deviceVersion = "12"

        //OoUserDevice 활용
//        OoUserDevice.type = "1"
//        OoUserDevice.token = "testToken"
//        params.deviceType= OoUserDevice.type
//        params.deviceOs = OoUserDevice.os
//        params.deviceToken = OoUserDevice.token
//        params.deviceModel = OoUserDevice.model
//        params.deviceVersion = OoUserDevice.version

        OoRestManager.signinUser(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.userId)
            Assert.assertNotEquals(null, response?.userToken)
            Assert.assertNotEquals(null, response?.webrtcToken)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun signout() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNkM2R5NW1iMk4xYzI1bGQzTXhMbU52YlM5dVpYZHpMM0JvYjNSdkx6SXdNVGt3TXk4eU5UY3dNRjh4TkRVeU1GOHpNekUwTG1wd1p5SXNJbVJsZG1salpWUjVjR1VpT2lJeE1pSXNJbVJsZG1salpWUnZhMlZ1SWpvaVpUUm1jVnBvVlVkSFRFMDZRVkJCT1RGaVNFZzNjRmRpYjB0cGRUZ3dWR28yY1hGWFQzRlRjMlJIUlVaMGMxUk9VMFZsZWxSVGRYVk1ZVVF4U21sTmExQlhiMjlYZWkxaVlYUkxjamRQYUZRd2JXSmpOUzB6Y2t0SlNISnFTbEUwU3pKa1ZsTlRkVnBYTTNKTVV6bGZjM1JKT1hseE1XTlNNVEYwWXpoQ1lrRm9OMmhhZHpGRmFYRjNhalV6T0VwUWNuWktWM2Q2YTNBaUxDSnBZWFFpT2pFMU5qazVNVEUwTlRkOS5QLWFWbFBpR1hWVm0wYU9ldkhhXy1kRS1fa29wbGNUSmZXVGNBTV9fbFpFIiwidXNlcklkIjoiR1VleE10ZWVNbXFVQTBRcDVIcmMiLCJpYXQiOjE1Njk5MTE0NTd9.GN9R_a0K7WqWciPlY5qgdC93RdMBoE04xGLHo1iZDGk"
        OoRestManager.signoutUser(userToken) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(null, response)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun device() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNDSXNJbVJsZG1salpWUjVjR1VpT2lJeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKMFpYTjBJaXdpYVdGMElqb3hOVFk1TURNNU5qVTVmUS5QRlZmSXZfcFk5cENsMmN4QUFJOFJFbFlmNjRDT1pHZkY5dlNNbnRvVWk0IiwidXNlcklkIjoieG1QalZMQ3RRcjJsTXduODJyd0kiLCJpYXQiOjE1NjkwMzk2NTl9.7elAdi0VrV-W-7rqMhf6SGhco5oZX0U3dWRb9CWC3dk"
        OoRestManager.device(userToken) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isExist())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun userRead() {
        val signal = CountDownLatch(1)

        val userId = "xmPjVLCtQr2lMwn82rwI"
        OoRestManager.readUser(userId) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(userId, response?.user?.id)
            Assert.assertNotEquals(null, response?.user?.nationalCode)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun userFind() {
        val signal = CountDownLatch(1)

        val email = "cyh3813@gmail.com"
        OoRestManager.findUser(email) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(email, response?.user?.email)
            Assert.assertNotEquals(null, response?.user?.nationalCode)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun updateUser() {
        val signal = CountDownLatch(1)

        OoRestManager.readUser("GUexMteeMmqUA0Qp5Hrc") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotEquals(null, response?.user)

            response?.let {
                val user = it.user
                user?.address1 = "update completed2"
                user?.deviceType = "2"

                OoRestManager.updateUser(user!!) { error, response ->
                    Assert.assertEquals(null, error)
                    Assert.assertNotNull(response?.userToken)

                    response?.let {
                        OoRestManager.readUser("GUexMteeMmqUA0Qp5Hrc") { error, response ->
                            Assert.assertEquals(null, error)

                            val user = response?.user
                            Assert.assertEquals("update completed2", user?.address1)
                            signal.countDown()
                        }
                    }
                }
            }
        }
        signal.await()
    }
}