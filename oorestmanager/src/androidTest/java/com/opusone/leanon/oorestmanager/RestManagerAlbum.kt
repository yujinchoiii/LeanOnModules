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
    fun uploadAlbumPiture() {
        val signal = CountDownLatch(1)

        val param = OoParamAlbumPictureUpload()
        param.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKbGJXRnBiQ0k2SW5OaGJtRnBhSGxsYjI1QVoyMWhhV3d1WTI5dElpd2libUZ0WlNJNklsbGxiMjVuSUVoNVpXOXVJRU5JVDBraUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW5CcGNtTjBkWEpsSWpvaWFIUjBjRG92TDNkM2R5NW1iMk4xYzI1bGQzTXhMbU52YlM5dVpYZHpMM0JvYjNSdkx6SXdNVGt3TXk4eU5UY3dNRjh4TkRVeU1GOHpNekUwTG1wd1p5SXNJbVJsZG1salpWUjVjR1VpT2lJeE1pSXNJbVJsZG1salpWUnZhMlZ1SWpvaVptcFBRM2Q1VDJsMlluYzZRVkJCT1RGaVJrMHhiVmR6VHpabmRYYzVOM1JYWlVGYWNGUlVUREZLWlZkQ1pXbzBVMmxUZW1odFpXdEJOMDV4ZUVOMGFtczVlalJNU1VaVlEyTmpjMGRNVGxWUmNuaHNkRmxMYm10Wk5sOUVUR2xMWm5rM2J5MVdkM2h2UWpZNGFHTkhaR3hIYmt4cGFrOWhiVjlPWjFjd2NuQndiR2MxT0U5Q1FWZFRjRE15T0d4RFRuRlNTR3BvZG5RaUxDSnBZWFFpT2pFMU5qazRNekkxTWpWOS4zZ3R5WXZKX19YTE1JM1hrQVdreUljMjJKREFuR2NQZjdXWFdTM1dBTDMwIiwidXNlcklkIjoiR1VleE10ZWVNbXFVQTBRcDVIcmMiLCJpYXQiOjE1Njk4MzI1MjV9.whbiCPUUeKMd6V3fh-U8KUaQB0NTLh9tL2GXkgIS0_A"
        param.albumId = "bzT8GybqLYyyRJdXlyJR"
        param.author = "GUexMteeMmqUA0Qp5Hrc"
        param.url = "https://spnimage.edaily.co.kr/images/Photo/files/NP/S/2019/03/PS19032600014.jpg"
        param.comment = "아들놈과 찍은 사진"

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
