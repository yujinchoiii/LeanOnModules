package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerAccountTest {

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
    fun signup() {
        val signal = CountDownLatch(1)

        val params = OoParamUserSignup()
        params.idToken = "eyJhbGciOiJSUzI1NiIsImtpZCI6ImVlMjc0MWQ0MWY5ZDQzZmFiMWU2MjhhODVlZmI0MmE4OGVmMzIyOWYiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiWWVvbmcgSHllb24gQ2hvaSIsInBpY3R1cmUiOiJodHRwczovL2xoNS5nb29nbGV1c2VyY29udGVudC5jb20vLW9SM0dmalhieUpvL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FDSGkzcmVaNU1JRXJFMThrbEJJMl9YZmZQSVMyOGdnZFEvcGhvdG8uanBnIiwiaXNzIjoiaHR0cHM6Ly9zZWN1cmV0b2tlbi5nb29nbGUuY29tL2xlYW5vbnRhYiIsImF1ZCI6ImxlYW5vbnRhYiIsImF1dGhfdGltZSI6MTU2OTAzOTM4NiwidXNlcl9pZCI6IkZTeHFTRkxMOVdZMDhrZlJscVNiNENUTWR3NzIiLCJzdWIiOiJGU3hxU0ZMTDlXWTA4a2ZSbHFTYjRDVE1kdzcyIiwiaWF0IjoxNTY5MDM5Mzg3LCJleHAiOjE1NjkwNDI5ODcsImVtYWlsIjoiY3loMzgxM0BnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJnb29nbGUuY29tIjpbIjEwODk0MjE2OTUxMjUzNjI4MzYzOSJdLCJlbWFpbCI6WyJjeWgzODEzQGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6Imdvb2dsZS5jb20ifX0.GhtT_1Gp4kWsvj17DkmJ_uGLjNfTP3a3uggiCDTacLne8Mvo2DWDaJikxBqtUUbG3EO2lLME4UVBzdMwMEwRkYTbjthDuOFPdkEhuy-55ZJxWiUBZN5P2s8-1D7vW9zD1XDtJmZifsay1Ifokdzhbuiooj99yLB9rs7APzzoN3dZxyUR1w56O3Lr56TL0vv90KKRMLpR5uAHKncVrCdLlNCetfscYKq0WU4UXHAI8zJk9P1pW3ixmtkisSqYt-iayIb07n7xQYElPa0NuFQisW_4BMZnDemS80aurFlFIKnxXtAy2bVjT8yEGDr5cEmhykrHVXcN_E-v5E1SCwhM8Q"
        params.password = "opusone1004"
        params.birthdate = "810122"
        params.picture = "http"
        params.gender = "male"
        params.address1 = "경기도"
        params.address2 = "안양시"
        params.tel = "031-382-7992"
        params.mobile = "010-2000-0000"
        params.height = "175"
        params.weight = "75"
        params.nationalCode = "82"
        params.deviceType= "1" //tablet
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
        params.deviceType= "2" //tablet
        params.deviceOs = "ios"
        params.deviceToken = "test"
        params.deviceModel = "iphone xs"
        params.deviceVersion = "11"

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