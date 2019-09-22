package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamRejectGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerRelationTest {

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
    fun requestGuardian() {
        val signal = CountDownLatch(1)

        val params = OoParamRequestGuardian()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNsbGNHRnVMbTVsZEM5a1lYUmhMMlpwYkdVdmJtVjNjeTkwYUhWdFlpODNNakI0TUY4NU1DOHpOalkzTlRrMU5USTRYelZrTUdFell6UXlYekV1YW5Cbklpd2laR1YyYVdObFZIbHdaU0k2SWpFeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKbE0xVmpOalpSVmtWYWF6cEJVRUU1TVdKRk5sazRXRzFaZVZGMVVYSmFOVVp3V2xBM05EaGlWVkZEYWsweVUxUTJjSGQ0WVU5Zk0wcEhkVFpzVm0xWmNHTlVabWhNVnpBeWMwNW9PR3BsTTFOZk9EZG9OMFpGV2paSU1UUmpSRlowTldwa2RXdGZUVUpXVHpKSFFra3RYemhhYTNCaWFFcENSMnR3TlV0VlFXOTVPRTVVWTJFNFMwWm5hMk54WTNKcGVVcDNPRjlhTXlJc0ltbGhkQ0k2TVRVMk9URXlOekF4T0gwLnhSR0RWcFRxbHFtZFc3dnBqQVEtSFJLVzVMR0YxUTB2cG4tLWVHNFp6Z28iLCJ1c2VySWQiOiJPa2lNZHV4OG5PWk9mWXRYcUNObiIsImlhdCI6MTU2OTEyNzAxOH0.eaNZX0ttgSXz3P7qanOwOJ0ACqa-zVTgQnJlw1qqo_E"
        params.seniorId = "iiaq4X8fTqsgrKLPa0Ii"

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNITTZMeTkwTVM1a1lYVnRZMlJ1TG01bGRDOWpabWxzWlM5MGFYTjBiM0o1THprNU9UUTFSalJETlVKQ05Ua3hSak16TUNJc0ltUmxkbWxqWlZSNWNHVWlPaUl4SWl3aVpHVjJhV05sVkc5clpXNGlPaUowWlhOMElpd2lhV0YwSWpveE5UWTVNVEkzTXpNNGZRLndkWkdERFRaMDdxSjZsMXF0WW1HVHVrWUNXOEFjR2d0VXpUa1ZiNTRLYnMiLCJ1c2VySWQiOiJpaWFxNFg4ZlRxc2dyS0xQYTBJaSIsImlhdCI6MTU2OTEyNzMzOH0.maeH6P5i6PMcR39Lxp0YYV04oo7EWfmx3lb5e6gMtbw"
        params.guardianId = "OkiMdux8nOZOfYtXqCNn"

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW1ONWFETTRNVE5BWjIxaGFXd3VZMjl0SWl3aWJtRnRaU0k2SWxsbGIyNW5JRWg1Wlc5dUlFTm9iMmtpTENKemFHRmtiM2NpT2lKa1pqVmpObU5sTUdRMU0yTTJORGxtWTJFeFpERXdZemt4TlRNMFpEQTNaamM1TkdFM09XRXdZelUxWVRJMk5ESm1ZVFptTURSbE5HRXlZelF5TVRkaE1qbG1NVFF5T1dZd05UZGlOR1l4TlRZNU5qUTVZbU5rTkRjek1qSTNaREZtTUdNeU1EVmhaVEJoWmpnMVpUa3dNVEExTWpNd1lXTm1OalU0TjJWak5DSXNJbkJwY21OMGRYSmxJam9pYUhSMGNITTZMeTkwTVM1a1lYVnRZMlJ1TG01bGRDOWpabWxzWlM5MGFYTjBiM0o1THprNU9UUTFSalJETlVKQ05Ua3hSak16TUNJc0ltUmxkbWxqWlZSNWNHVWlPaUl4SWl3aVpHVjJhV05sVkc5clpXNGlPaUowWlhOMElpd2lhV0YwSWpveE5UWTVNVEkzTXpNNGZRLndkWkdERFRaMDdxSjZsMXF0WW1HVHVrWUNXOEFjR2d0VXpUa1ZiNTRLYnMiLCJ1c2VySWQiOiJpaWFxNFg4ZlRxc2dyS0xQYTBJaSIsImlhdCI6MTU2OTEyNzMzOH0.maeH6P5i6PMcR39Lxp0YYV04oo7EWfmx3lb5e6gMtbw"
        params.guardianId = "OkiMdux8nOZOfYtXqCNn"

        OoRestManager.acceptGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

}