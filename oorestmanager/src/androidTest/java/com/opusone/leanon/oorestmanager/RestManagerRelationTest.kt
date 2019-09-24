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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNsbGNHRnVMbTVsZEM5a1lYUmhMMlpwYkdVdmJtVjNjeTkwYUhWdFlpODNNakI0TUY4NU1DOHpOalkzTlRrMU5USTRYelZrTUdFell6UXlYekV1YW5Cbklpd2laR1YyYVdObFZIbHdaU0k2SWpFeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKbFFrOWlVMUZWTWxsQmJ6cEJVRUU1TVdKSFEyUkdUMGxsT1dSTU1Fa3Rja0pWYlVsVmFtSjVaalExUjFKRWVFRmpPR3AxVTJoTFF6aHNlWEZJTmpsRU9HVkNhWGRwTXpsdlJIbEdRM2RpZERGYVJVVmxXVTl5VnpWVFh6UTVaMDFEZEc0dE9ETTFORTUwWlhsUFNFZFFiMmhXUTJKWFFsZFFUWFZHYW5CR2NVdHlTRVZOUm1RM01tMU5hVlZSWmpsVGRHTlBPVmRHVHlJc0ltbGhkQ0k2TVRVMk9UTXdNVFUzTTMwLnN4dnFpcTRPS21uS21QN3RsZW44d3FzUlcyYVBXbHpVSHdCdWR1SDI0cU0iLCJ1c2VySWQiOiJPa2lNZHV4OG5PWk9mWXRYcUNObiIsImlhdCI6MTU2OTMwMTU3M30.TqR52J-5ODiPdnRLA8t2FxumpyXH8HL28IlRjO8-i8I"
        params.seniorId = "bzT8GybqLYyyRJdXlyJR"

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDJ4b05pNW5iMjluYkdWMWMyVnlZMjl1ZEdWdWRDNWpiMjB2TFVGTVZuZGFTa0pRVjBnNEwwRkJRVUZCUVVGQlFVRkpMMEZCUVVGQlFVRkJRVUZCTDBGRFNHa3pjbVZ2TVc5NU9VbGxWSE5YVUUxRWNUVkxkazl5ZG5wbFNFSkVNa0V2Y3prMkxXTXZjR2h2ZEc4dWFuQm5JaXdpWkdWMmFXTmxWSGx3WlNJNklqRWlMQ0prWlhacFkyVlViMnRsYmlJNkltUkpaVTVKVkVkSlYyRnpPa0ZRUVRreFlraDBUMEV6V1dobFZtNXRUVW80VjJoMFpWZElRV05qVW1JeWNITmhibHB6V1ROcFYza3hkbEUyWnpSaVgwMWFZMFpyVTBKVFdYRTVSMFF5U1hKa1NIQlJWRTVHTUVSNFVXbDNaMmswUW5CdFJuQXRNbVpMVjFCTVVVb3RPR2h6Y2pGdU5tSXhhR1pDVFRReVZFUnBRazlUY21WWGFFUjBRalF5Um14NFdWUlVRbTVZYzFKRUlpd2lhV0YwSWpveE5UWTVNams0TURremZRLndvcTNySG1Qb2ZURlZneDJKbWVpQVNTVVc5UzNYX2s0RFVlS0RuX1UzcmciLCJ1c2VySWQiOiJielQ4R3licUxZeXlSSmRYbHlKUiIsImlhdCI6MTU2OTI5ODA5M30.ipNs_Gt1-Dsf7nnsD3p__hRU_tR8899hl0pnRvb8Y-c"
        params.guardianId = "OkiMdux8nOZOfYtXqCNn"

        OoRestManager.acceptGuardian(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getRequestSeniorList() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNsbGNHRnVMbTVsZEM5a1lYUmhMMlpwYkdVdmJtVjNjeTkwYUhWdFlpODNNakI0TUY4NU1DOHpOalkzTlRrMU5USTRYelZrTUdFell6UXlYekV1YW5Cbklpd2laR1YyYVdObFZIbHdaU0k2SWpFeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKbFFrOWlVMUZWTWxsQmJ6cEJVRUU1TVdKSFEyUkdUMGxsT1dSTU1Fa3Rja0pWYlVsVmFtSjVaalExUjFKRWVFRmpPR3AxVTJoTFF6aHNlWEZJTmpsRU9HVkNhWGRwTXpsdlJIbEdRM2RpZERGYVJVVmxXVTl5VnpWVFh6UTVaMDFEZEc0dE9ETTFORTUwWlhsUFNFZFFiMmhXUTJKWFFsZFFUWFZHYW5CR2NVdHlTRVZOUm1RM01tMU5hVlZSWmpsVGRHTlBPVmRHVHlJc0ltbGhkQ0k2TVRVMk9UTXdNVFUzTTMwLnN4dnFpcTRPS21uS21QN3RsZW44d3FzUlcyYVBXbHpVSHdCdWR1SDI0cU0iLCJ1c2VySWQiOiJPa2lNZHV4OG5PWk9mWXRYcUNObiIsImlhdCI6MTU2OTMwMTU3M30.TqR52J-5ODiPdnRLA8t2FxumpyXH8HL28IlRjO8-i8I"
        OoRestManager.getRequestSeniorList(userToken) { error, response ->
            Assert.assertEquals(null, error)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getSeniorList() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNsbGNHRnVMbTVsZEM5a1lYUmhMMlpwYkdVdmJtVjNjeTkwYUhWdFlpODNNakI0TUY4NU1DOHpOalkzTlRrMU5USTRYelZrTUdFell6UXlYekV1YW5Cbklpd2laR1YyYVdObFZIbHdaU0k2SWpFeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKbFFrOWlVMUZWTWxsQmJ6cEJVRUU1TVdKSFEyUkdUMGxsT1dSTU1Fa3Rja0pWYlVsVmFtSjVaalExUjFKRWVFRmpPR3AxVTJoTFF6aHNlWEZJTmpsRU9HVkNhWGRwTXpsdlJIbEdRM2RpZERGYVJVVmxXVTl5VnpWVFh6UTVaMDFEZEc0dE9ETTFORTUwWlhsUFNFZFFiMmhXUTJKWFFsZFFUWFZHYW5CR2NVdHlTRVZOUm1RM01tMU5hVlZSWmpsVGRHTlBPVmRHVHlJc0ltbGhkQ0k2TVRVMk9UTXdNVFUzTTMwLnN4dnFpcTRPS21uS21QN3RsZW44d3FzUlcyYVBXbHpVSHdCdWR1SDI0cU0iLCJ1c2VySWQiOiJPa2lNZHV4OG5PWk9mWXRYcUNObiIsImlhdCI6MTU2OTMwMTU3M30.TqR52J-5ODiPdnRLA8t2FxumpyXH8HL28IlRjO8-i8I"
        OoRestManager.getSeniorList(userToken) { error, response ->
            Assert.assertEquals(null, error)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getRequestGuaridanList() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDJ4b05pNW5iMjluYkdWMWMyVnlZMjl1ZEdWdWRDNWpiMjB2TFVGTVZuZGFTa0pRVjBnNEwwRkJRVUZCUVVGQlFVRkpMMEZCUVVGQlFVRkJRVUZCTDBGRFNHa3pjbVZ2TVc5NU9VbGxWSE5YVUUxRWNUVkxkazl5ZG5wbFNFSkVNa0V2Y3prMkxXTXZjR2h2ZEc4dWFuQm5JaXdpWkdWMmFXTmxWSGx3WlNJNklqRWlMQ0prWlhacFkyVlViMnRsYmlJNkltUkpaVTVKVkVkSlYyRnpPa0ZRUVRreFlraDBUMEV6V1dobFZtNXRUVW80VjJoMFpWZElRV05qVW1JeWNITmhibHB6V1ROcFYza3hkbEUyWnpSaVgwMWFZMFpyVTBKVFdYRTVSMFF5U1hKa1NIQlJWRTVHTUVSNFVXbDNaMmswUW5CdFJuQXRNbVpMVjFCTVVVb3RPR2h6Y2pGdU5tSXhhR1pDVFRReVZFUnBRazlUY21WWGFFUjBRalF5Um14NFdWUlVRbTVZYzFKRUlpd2lhV0YwSWpveE5UWTVNams0TURremZRLndvcTNySG1Qb2ZURlZneDJKbWVpQVNTVVc5UzNYX2s0RFVlS0RuX1UzcmciLCJ1c2VySWQiOiJielQ4R3licUxZeXlSSmRYbHlKUiIsImlhdCI6MTU2OTI5ODA5M30.ipNs_Gt1-Dsf7nnsD3p__hRU_tR8899hl0pnRvb8Y-c"
        OoRestManager.getRequestGuardianList(userToken) { error, response ->
            Assert.assertEquals(null, error)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun getGuardianList() {
        val signal = CountDownLatch(1)

        val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDJ4b05pNW5iMjluYkdWMWMyVnlZMjl1ZEdWdWRDNWpiMjB2TFVGTVZuZGFTa0pRVjBnNEwwRkJRVUZCUVVGQlFVRkpMMEZCUVVGQlFVRkJRVUZCTDBGRFNHa3pjbVZ2TVc5NU9VbGxWSE5YVUUxRWNUVkxkazl5ZG5wbFNFSkVNa0V2Y3prMkxXTXZjR2h2ZEc4dWFuQm5JaXdpWkdWMmFXTmxWSGx3WlNJNklqRWlMQ0prWlhacFkyVlViMnRsYmlJNkltUkpaVTVKVkVkSlYyRnpPa0ZRUVRreFlraDBUMEV6V1dobFZtNXRUVW80VjJoMFpWZElRV05qVW1JeWNITmhibHB6V1ROcFYza3hkbEUyWnpSaVgwMWFZMFpyVTBKVFdYRTVSMFF5U1hKa1NIQlJWRTVHTUVSNFVXbDNaMmswUW5CdFJuQXRNbVpMVjFCTVVVb3RPR2h6Y2pGdU5tSXhhR1pDVFRReVZFUnBRazlUY21WWGFFUjBRalF5Um14NFdWUlVRbTVZYzFKRUlpd2lhV0YwSWpveE5UWTVNams0TURremZRLndvcTNySG1Qb2ZURlZneDJKbWVpQVNTVVc5UzNYX2s0RFVlS0RuX1UzcmciLCJ1c2VySWQiOiJielQ4R3licUxZeXlSSmRYbHlKUiIsImlhdCI6MTU2OTI5ODA5M30.ipNs_Gt1-Dsf7nnsD3p__hRU_tR8899hl0pnRvb8Y-c"
        OoRestManager.getGuardianList(userToken) { error, response ->
            Assert.assertEquals(null, error)
            signal.countDown()
        }
        signal.await()
    }

}