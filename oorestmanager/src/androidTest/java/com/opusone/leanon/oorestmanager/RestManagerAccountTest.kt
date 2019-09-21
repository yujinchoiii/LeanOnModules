package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.restful.OoDeviceWrapper
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
        params.idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6ImVlMjc0MWQ0MWY5ZDQzZmFiMWU2MjhhODVlZmI0MmE4OGVmMzIyOWYiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiWWVvbmcgSHllb24gQ0hPSSIsInBpY3R1cmUiOiJodHRwczovL2xoNi5nb29nbGV1c2VyY29udGVudC5jb20vLURaa3lLTVhPS2xFL0FBQUFBQUFBQUFJL0FBQUFBQUFBQS1VL25QWnFqQWxnUXljL3Bob3RvLmpwZyIsImlzcyI6Imh0dHBzOi8vc2VjdXJldG9rZW4uZ29vZ2xlLmNvbS9sZWFub250YWIiLCJhdWQiOiJsZWFub250YWIiLCJhdXRoX3RpbWUiOjE1NjkwNDk2MTgsInVzZXJfaWQiOiJ2QTBGY0hOa1plZGNnd1NodEE2YmhJTGswRkIzIiwic3ViIjoidkEwRmNITmtaZWRjZ3dTaHRBNmJoSUxrMEZCMyIsImlhdCI6MTU2OTA0OTYxOSwiZXhwIjoxNTY5MDUzMjE5LCJlbWFpbCI6InNhbmFpaHllb25AZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZ29vZ2xlLmNvbSI6WyIxMTA0MTYxMjQ3MjMyOTU2OTE1OTciXSwiZW1haWwiOlsic2FuYWloeWVvbkBnbWFpbC5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJnb29nbGUuY29tIn19.Ihp7komCS1gh3kS9BO8DzwcvSCLRqZvlsvuRnUipH9eytnMKlI1jjppmxpFvFgN0kq4dqrGsFHCyDdft4GB6PcYr5CqaWqLQ2XMeT-4B0CJl1k5RtcGMg2RmuW2pA29Y0LdkBijEU3ZE0-8QcS565CX5Qwbus5SPLLyg1j8PgYzgLDoN1whIGIsDda4UzEOnYcwuqlacp-TISbwIcX971Zsqv8xbO5cAo7bNzq7E8KiixEQAdo9dNZ4Wq9J7K7PVhbPJLjcgfkplvyXSZpgRqoxRftFB-0n8A0eiQEoX_MR0P1RB-6SOSJiLhJRUoGVVI6suTk4eFJQ8LE4r4Clk3A"
        params.password = "opusone1004"
        params.birthdate = "830415"
        params.picture = "https://t1.daumcdn.net/cfile/tistory/99945F4C5BB591F330"
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
        params.deviceModel = "SM-t595"
        params.deviceVersion = "Pie"

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

        //OoDeviceWrapper 활용
//        OoDeviceWrapper.type = "1"
//        OoDeviceWrapper.token = "testToken"
//        params.deviceType= OoDeviceWrapper.type
//        params.deviceOs = OoDeviceWrapper.os
//        params.deviceToken = OoDeviceWrapper.token
//        params.deviceModel = OoDeviceWrapper.model
//        params.deviceVersion = OoDeviceWrapper.version

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

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNDSXNJbVJsZG1salpWUjVjR1VpT2lJeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKMFpYTjBJaXdpYVdGMElqb3hOVFk1TURNNU5qVTVmUS5QRlZmSXZfcFk5cENsMmN4QUFJOFJFbFlmNjRDT1pHZkY5dlNNbnRvVWk0IiwidXNlcklkIjoieG1QalZMQ3RRcjJsTXduODJyd0kiLCJpYXQiOjE1NjkwMzk2NTl9.7elAdi0VrV-W-7rqMhf6SGhco5oZX0U3dWRb9CWC3dk"
        OoRestManager.signoutUser(userToken) { error, response ->
            Assert.assertEquals(null, error)
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

        OoRestManager.readUser("xmPjVLCtQr2lMwn82rwI") { error, response ->
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
                        OoRestManager.readUser("xmPjVLCtQr2lMwn82rwI") { error, response ->
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