package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamRejectGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerRelationTest {

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
    fun requestGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamRequestGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjSE02THk5ME1TNWtZWFZ0WTJSdUxtNWxkQzlqWm1sc1pTOTBhWE4wYjNKNUx6azVPVFExUmpSRE5VSkNOVGt4UmpNek1DSXNJbVJsZG1salpWUjVjR1VpT2lJeE1pSXNJbVJsZG1salpWUnZhMlZ1SWpvaVpsUnBXUzFYVFZkdVZUUTZRVkJCT1RGaVJ6TnFTbTF2YnpseWJHTkhhR0paYjJacU9FSjBiVGxDZEhsbVZVd3laRGhzYm5jdFdXSnplR2gyYVU5U1oxSlllSEJOZVZRMmEzWlNiVlZGTm1rMFpVVlpVazVLTnpaSWNVRmZSMGQ2TkZwM1pGYzVSMkZWYUU4eWMyUndiV1pRUkhJd1pVOXJXSFJLVW5KVVMxQlVMVXRJVlVwUE1GbE1jVFpoVFhocmMxWmZNa05TZFdnaUxDSnBZWFFpT2pFMU5qa3dOVEE0TmpoOS54cnEwMHo1UTltSFQzZ2kwcFp2N0stVjA1YWVJVDVLMzJnTnRMb2ItMURnIiwidXNlcklkIjoic0JrMVMzZndGcWE5WHpjZ2RIYkkiLCJpYXQiOjE1NjkwNTA4Njh9.O1w2A6WlUpDp2eIIh3eAGxxfj4D9SzXMRBOCfv7kC-k"
        params.seniorId = "xmPjVLCtQr2lMwn82rwI"

        OoRestManager.requestGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun rejectGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamRejectGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNDSXNJbVJsZG1salpWUjVjR1VpT2lJeElpd2laR1YyYVdObFZHOXJaVzRpT2lKMFpYTjBJaXdpYVdGMElqb3hOVFk1TURVd01qazNmUS5ON1NwdWJJVWY4OS1Bd3B4WmMyS1ZDeGpWLTNnbnhxU1pWOV9kYko4TEVrIiwidXNlcklkIjoieG1QalZMQ3RRcjJsTXduODJyd0kiLCJpYXQiOjE1NjkwNTAyOTd9.iuZseXwXnhQ8Yy_mboqfHz7cyBi-rJZWyUaNMbKH3mo"
        params.guardianId = "sBk1S3fwFqa9XzcgdHbI"

        OoRestManager.rejectGuardian(params) { error, response ->
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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNDSXNJbVJsZG1salpWUjVjR1VpT2lJeElpd2laR1YyYVdObFZHOXJaVzRpT2lKMFpYTjBJaXdpYVdGMElqb3hOVFk1TURVd01qazNmUS5ON1NwdWJJVWY4OS1Bd3B4WmMyS1ZDeGpWLTNnbnhxU1pWOV9kYko4TEVrIiwidXNlcklkIjoieG1QalZMQ3RRcjJsTXduODJyd0kiLCJpYXQiOjE1NjkwNTAyOTd9.iuZseXwXnhQ8Yy_mboqfHz7cyBi-rJZWyUaNMbKH3mo"
        params.guardianId = "sBk1S3fwFqa9XzcgdHbI"

        OoRestManager.acceptGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

}