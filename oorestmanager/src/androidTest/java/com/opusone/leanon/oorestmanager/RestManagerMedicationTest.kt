package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.params.OoParamRegisterMedication
import com.opusone.leanon.oorestmanager.params.OoParamResultMedication
import com.opusone.leanon.oorestmanager.params.OoParamUpdateMedication
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerMedicationTest {

    @Before
    fun setUp() {
        OoRestManager.init()

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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDNCa2N5NXFiMmx1Y3k1amIyMHZMMjVsZDNNdlkyOXRjRzl1Wlc1MEwyaDBiV3h3YUc5MGIxOXRiV1JoZEdFdk1qQXhPREEwTHpJeUwyUXhaVE01T0dJNUxUSTRNVE10TkRNek55MDRPVEUwTFRrNE5EZGpaR1ExWXpjM1pTNXFjR2NpTENKa1pYWnBZMlZVZVhCbElqb2lNU0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laalZLU0VGU1UyaGpValE2UVZCQk9URmlSV0k0UlVaU2QzbHlUMlJ3Y2pCRlkwZHBaRTFJUzFaRlFYTmFXa1YyVkZVeVFWOVFjVzVtVlhkdlpIUlFkMDl5VjJoMU5FRm5USGRvYVhOemFFczBiemxUV0ZSaFowcHVNRmhpWjJWRFQzUldOWGQ1TjE5SE9GSTNjbXhrZWxGaVIwVmpZMU4xYzFkd1pYTlZOVkJKYUVsUmNrZEViblJ2YXpnM2R6ZFdORFZ5V0ZSNmRWZ2lMQ0pwWVhRaU9qRTFOamsyTkRJeE9UUjkuU0JselFkR2VlTVpxdm9qcFVqVmtvTUpZajk4N3NVRVVLejJMZTJqSnZQZyIsInVzZXJJZCI6ImJ6VDhHeWJxTFl5eVJKZFhseUpSIiwiaWF0IjoxNTY5NjQyMTk0fQ.xqQgGjpAycHrDSYCRAlvWmO5iYwFBr_QjgFViqMJxS0"
        params.seniorId = "bzT8GybqLYyyRJdXlyJR"
        params.alarmId = "1010"
        params.name = "감기약스"
        params.hour = "8"
        params.min = "20"
        params.picture = ""
        params.weekdaysInfo = mutableListOf(true, true, true, true, true, true, true, true)

        OoRestManager.registerMedication(params) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.medication)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun updateMedication() {
        val signal = CountDownLatch(1)
        val params = OoParamUpdateMedication()
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDNCa2N5NXFiMmx1Y3k1amIyMHZMMjVsZDNNdlkyOXRjRzl1Wlc1MEwyaDBiV3h3YUc5MGIxOXRiV1JoZEdFdk1qQXhPREEwTHpJeUwyUXhaVE01T0dJNUxUSTRNVE10TkRNek55MDRPVEUwTFRrNE5EZGpaR1ExWXpjM1pTNXFjR2NpTENKa1pYWnBZMlZVZVhCbElqb2lNU0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laalZLU0VGU1UyaGpValE2UVZCQk9URmlSV0k0UlVaU2QzbHlUMlJ3Y2pCRlkwZHBaRTFJUzFaRlFYTmFXa1YyVkZVeVFWOVFjVzVtVlhkdlpIUlFkMDl5VjJoMU5FRm5USGRvYVhOemFFczBiemxUV0ZSaFowcHVNRmhpWjJWRFQzUldOWGQ1TjE5SE9GSTNjbXhrZWxGaVIwVmpZMU4xYzFkd1pYTlZOVkJKYUVsUmNrZEViblJ2YXpnM2R6ZFdORFZ5V0ZSNmRWZ2lMQ0pwWVhRaU9qRTFOamsyTkRJeE9UUjkuU0JselFkR2VlTVpxdm9qcFVqVmtvTUpZajk4N3NVRVVLejJMZTJqSnZQZyIsInVzZXJJZCI6ImJ6VDhHeWJxTFl5eVJKZFhseUpSIiwiaWF0IjoxNTY5NjQyMTk0fQ.xqQgGjpAycHrDSYCRAlvWmO5iYwFBr_QjgFViqMJxS0"
        params.seniorId = "bzT8GybqLYyyRJdXlyJR"
        params.medicationId = "-LprSvZNpZvnyQoKjlD8"
        params.alarmId = "1010"
        params.name = "뽕"
        params.hour = "8"
        params.min = "20"
        params.picture = ""
        params.weekdaysInfo = arrayListOf(true, true, true, false, true, true, true, true)

        OoRestManager.updateMedication(params) { error, response ->
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
        params.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW05d2RYTnZibVYwWlhOME1ERkFaMjFoYVd3dVkyOXRJaXdpYm1GdFpTSTZJdXE1Z095WXBPMk52T3lLcENJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpY0dseVkzUjFjbVVpT2lKb2RIUndjem92TDNCa2N5NXFiMmx1Y3k1amIyMHZMMjVsZDNNdlkyOXRjRzl1Wlc1MEwyaDBiV3h3YUc5MGIxOXRiV1JoZEdFdk1qQXhPREEwTHpJeUwyUXhaVE01T0dJNUxUSTRNVE10TkRNek55MDRPVEUwTFRrNE5EZGpaR1ExWXpjM1pTNXFjR2NpTENKa1pYWnBZMlZVZVhCbElqb2lNU0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2laalZLU0VGU1UyaGpValE2UVZCQk9URmlSV0k0UlVaU2QzbHlUMlJ3Y2pCRlkwZHBaRTFJUzFaRlFYTmFXa1YyVkZVeVFWOVFjVzVtVlhkdlpIUlFkMDl5VjJoMU5FRm5USGRvYVhOemFFczBiemxUV0ZSaFowcHVNRmhpWjJWRFQzUldOWGQ1TjE5SE9GSTNjbXhrZWxGaVIwVmpZMU4xYzFkd1pYTlZOVkJKYUVsUmNrZEViblJ2YXpnM2R6ZFdORFZ5V0ZSNmRWZ2lMQ0pwWVhRaU9qRTFOamsyTkRJeE9UUjkuU0JselFkR2VlTVpxdm9qcFVqVmtvTUpZajk4N3NVRVVLejJMZTJqSnZQZyIsInVzZXJJZCI6ImJ6VDhHeWJxTFl5eVJKZFhseUpSIiwiaWF0IjoxNTY5NjQyMTk0fQ.xqQgGjpAycHrDSYCRAlvWmO5iYwFBr_QjgFViqMJxS0"
        params.medicationId = "-LprO7UNjPat40NfI2nF"
        params.taken = "true"

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
        OoRestManager.getMedications("bzT8GybqLYyyRJdXlyJR") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.medications)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun deleteMedication() {
        val signal = CountDownLatch(1)
        OoRestManager.deleteMedications("bzT8GybqLYyyRJdXlyJR", "-LprAEf-CMCm_TqeA6jq") { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            signal.countDown()
        }
        signal.await()
    }
}