package com.opusone.leanon.oorestmanager

import com.opusone.leanon.oorestmanager.params.OoParamChat
import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch

class RestManagerChatTest {

    @Before
    fun setUp() {
        OoRestManager.init(false)
    }

    @Test
    fun getGroupChatList() {
        val signal = CountDownLatch(1)

        OoRestManager.getRecentGroupChatList("UFWvQ1OV2gpuBaSj4Wnd", 1567837188260) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendNormalMessage() {
        val signal = CountDownLatch(1)

        val param = OoParamChat()
        param.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkluUnlkV1VpTENKd2FYSmpkSFZ5WlNJNkltaDBkSEE2THk5M2QzY2lMQ0pwWVhRaU9qRTFOamM0TXpZeE5URjkuMWpFdUdHY3FxNVB3UG1fVG9Cd2N0Ukw4YXlxaUI1NkZuWE1idU1VSVRLQSIsInVzZXJJZCI6IlVGV3ZRMU9WMmdwdUJhU2o0V25kIiwiaWF0IjoxNTY3ODM2MTUxfQ.f3SmHfdcwwOUJ2PBNadaY4ANEsilQfgRrodqY7IJFAE"
        param.roomId = "UFWvQ1OV2gpuBaSj4Wnd"
        param.message = "일반 메시지 테스트"
        param.type = "0"

        OoRestManager.sendGroupChat(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            Assert.assertEquals(param.roomId, response?.chat?.roomId)
            Assert.assertEquals(param.type, response?.chat?.type)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendQuestionMessage() {
        val signal = CountDownLatch(1)

        val param = OoParamChat()
        param.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkluUnlkV1VpTENKd2FYSmpkSFZ5WlNJNkltaDBkSEE2THk5M2QzY2lMQ0pwWVhRaU9qRTFOamM0TXpZeE5URjkuMWpFdUdHY3FxNVB3UG1fVG9Cd2N0Ukw4YXlxaUI1NkZuWE1idU1VSVRLQSIsInVzZXJJZCI6IlVGV3ZRMU9WMmdwdUJhU2o0V25kIiwiaWF0IjoxNTY3ODM2MTUxfQ.f3SmHfdcwwOUJ2PBNadaY4ANEsilQfgRrodqY7IJFAE"
        param.roomId = "UFWvQ1OV2gpuBaSj4Wnd"
        param.message = "질문 메시지 테스트. 점심 메뉴는?"
        param.type = "1"
        param.answer = arrayListOf("스테이크", "초밥")

        OoRestManager.sendGroupChat(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            Assert.assertEquals(param.roomId, response?.chat?.roomId)
            Assert.assertEquals(param.type, response?.chat?.type)
            signal.countDown()
        }
        signal.await()
    }

    @Test
    fun sendAswerMessage() {
        val signal = CountDownLatch(1)

        val param = OoParamChat()
        param.userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJbFZHVjNaUk1VOVdNbWR3ZFVKaFUybzBWMjVrSWl3aVpXMWhhV3dpT2lKdmNIVnpiMjVsZEdWemREQXhRR2R0WVdsc0xtTnZiU0lzSW01aGJXVWlPaUxxdVlEc21LVHRqYnpzaXFRaUxDSnphR0ZrYjNjaU9pSmtaalZqTm1ObE1HUTFNMk0yTkRsbVkyRXhaREV3WXpreE5UTTBaREEzWmpjNU5HRTNPV0V3WXpVMVlUSTJOREptWVRabU1EUmxOR0V5WXpReU1UZGhNamxtTVRReU9XWXdOVGRpTkdZeE5UWTVOalE1WW1Oa05EY3pNakkzWkRGbU1HTXlNRFZoWlRCaFpqZzFaVGt3TVRBMU1qTXdZV05tTmpVNE4yVmpOQ0lzSW1SbGRtbGpaVlJ2YTJWdUlqb2lkR1Z6ZEZSdmEyVnVJaXdpYVhOTVlYVnVZMmhsY2lJNkluUnlkV1VpTENKd2FYSmpkSFZ5WlNJNkltaDBkSEE2THk5M2QzY2lMQ0pwWVhRaU9qRTFOamM0TXpZeE5URjkuMWpFdUdHY3FxNVB3UG1fVG9Cd2N0Ukw4YXlxaUI1NkZuWE1idU1VSVRLQSIsInVzZXJJZCI6IlVGV3ZRMU9WMmdwdUJhU2o0V25kIiwiaWF0IjoxNTY3ODM2MTUxfQ.f3SmHfdcwwOUJ2PBNadaY4ANEsilQfgRrodqY7IJFAE"
        param.roomId = "UFWvQ1OV2gpuBaSj4Wnd"
        param.type = "2"
        param.answer = arrayListOf("스테이크")
        param.question = "1567840232810"

        OoRestManager.sendGroupChat(param) { error, response ->
            Assert.assertEquals(null, error)
            Assert.assertNotNull(response)
            Assert.assertEquals(param.roomId, response?.chat?.roomId)
            Assert.assertEquals(param.type, response?.chat?.type)
            signal.countDown()
        }
        signal.await()
    }

}