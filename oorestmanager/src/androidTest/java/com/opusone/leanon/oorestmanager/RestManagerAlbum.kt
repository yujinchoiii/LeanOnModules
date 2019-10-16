package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamAlbumPictureUpload
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerAlbumTest {

    @Before
    fun setUp() {
        OoRestManager.init(false)
    }

    @Test
    fun uploadAlbumPiture() {
        val signal = CountDownLatch(1)

        val param = OoParamAlbumPictureUpload()
        param.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcFkzUjFjbVVpT2lKb2RIUndjem92TDJacGNtVmlZWE5sYzNSdmNtRm5aUzVuYjI5bmJHVmhjR2x6TG1OdmJTOTJNQzlpTDJ4bFlXNXZiaTVoY0hCemNHOTBMbU52YlM5dkwzQnliMlpwYkdWSmJXRm5aWE1sTWtZNFZIbEJSMGh0Y2tKRWQyOHdWVlZGV25ka01pVXlSamhVZVVGSFNHMXlRa1IzYnpCVlZVVmFkMlF5TG1wd1p6OWhiSFE5YldWa2FXRW1kRzlyWlc0OU9XSTRabVk0WVRVdE1EbGhZaTAwTWpOakxXSmlZakV0TXpjNFptTTNaVEpqTW1Jd0lpd2laR1YyYVdObFZIbHdaU0k2SWpFeUlpd2laR1YyYVdObFZHOXJaVzRpT2lKbU1sZERNREJPUmt4NWN6cEJVRUU1TVdKR1ltWTJMVFpyTldOd2VHWTVPV3BuWjNoRlFWcElVRmhIWjJkWWFWaE1URUZDUjAxMVRsQlNNRXgwTlc1UFdFeDFSRVYxT0VadE1ISm5MVUpzZEZCNVlraG9RWFJRYkc1UGEyY3dVMG93VjNkMWJXRkNSbmxmUW1aZmIzSnNTVlpPWlZGNWFqaGhjRzlzVEdSTlp6aFFlRFpHTjB4eWJWTjZSVmh0V1RFdFUxRTVRME0xUVNJc0ltbGhkQ0k2TVRVM01URXpPVGcwTkgwLnRLaWN5bWduZ0E1Nm03S183aVVBU082SE5tZFd4RU1JUTE2UkZoMzhJUkEiLCJ1c2VySWQiOiI4VHlBR0htckJEd28wVVVFWndkMiIsImlhdCI6MTU3MTEzOTg0NH0.xjj0pnxBKK8A6tZF-hqTEdI3g5M2xDJf1BRXgLbEcK8"
        param.albumId = "u64Bs0Xl1jigtN3RkHCe"
        param.author = "8TyAGHmrBDwo0UUEZwd2"
        param.url = "https://spnimage.edaily.co.kr/images/Photo/files/NP/S/2019/03/PS19032600014.jpg"
        param.comment = "아들놈과 찍은 사진"
        param.filename = "PS19032600014.jpg"

        OoRestManager.uploadAlbumPicture(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.picture)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun recentAlbumList() {
        val signal = CountDownLatch(1)

        OoRestManager.getRecentAlbumlList("bzT8GybqLYyyRJdXlyJR", 0) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response?.albumList)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun deleteAlbumPicture() {
        val signal = CountDownLatch(1)

        OoRestManager.deleteAlbumPicture("bzT8GybqLYyyRJdXlyJR", 1569832794708) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertEquals(true, response?.isSuccess())
            signal.countDown()
        }
        signal.await()
    }
}
