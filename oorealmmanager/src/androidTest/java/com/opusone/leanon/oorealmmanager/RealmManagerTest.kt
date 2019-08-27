package com.opusone.leanon.oorealmmanager

import android.content.ContentValues
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import com.opusone.leanon.oorealmmanager.model.*
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RealmManagerTest {

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        OoRealmManager.initRealm(context)
    }

    @Test
    fun createUser() {

        val g = OoGuardian("test1", "testtoken")

        val user = OoRmUser("Rosi4",
            "", "Rosi@gmail.com","1234", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", RealmList(), RealmList(), RealmList(g))

        OoRealmManager.create(user)

        OoRealmManager.findOneById("Rosi4", OoRmUser::class.java) {found ->
            Assert.assertEquals(found?.id, user.id)
        }
    }

    @Test
    fun readUser() {
        OoRealmManager.findOneById("Rosi3", OoRmUser::class.java) { found ->   Assert.assertEquals(found?.id, "Rosi3")
            Assert.assertEquals(found?.email, "Rosi@gmail.com")
        }
    }

    @Test
    fun updateUser() {

        OoRealmManager.updateById("Rosi3", OoRmUser::class.java) {
            it.email = "salaza433445@gmail.com"
        }

        OoRealmManager.updateById("Rosi3", OoRmUser::class.java) {
            it.email = "salaza4334456@gmail.com"
        }

        OoRealmManager.findOneById("Rosi3", OoRmUser::class.java) { test ->
            Assert.assertEquals(test?.email, "salaza4334456@gmail.com")
            Assert.assertEquals(test?.password, "1234")
        }
    }

    @Test
    fun deleteUser() {
        OoRealmManager.findOneById("Rosi2", OoRmUser::class.java) { found ->
            found?.let {
                OoRealmManager.delete(it as RealmObject)

                OoRealmManager.findOneById("Rosi2", OoRmUser::class.java) { user ->
                    Assert.assertEquals(null, user)
                }
            }
        }
    }

    @Test
    fun createScaleDevice() {
        val scaleDevice = OoRmScaleDevice("01", "asdasdassadasdasdadadadasdsada")

        OoRealmManager.create(scaleDevice)

        OoRealmManager.findOneById("01", OoRmScaleDevice::class.java) {
            Assert.assertEquals(it?.id, scaleDevice.id)
        }
    }

    @Test
    fun createPartner() {
        val partner = OoRmPartner("test1@theopsone", "", "testToken")

        val ret = OoRealmManager.create(partner)
        Assert.assertEquals(true, ret)
    }

    @Test
    fun readPartner() {
        OoRealmManager.findOneByEmail("test1@theopsone", OoRmPartner::class.java) { found ->
            Assert.assertEquals(found?.email, "dev@theopsone")
        }
    }

    @Test
    fun createMessage() {
        val message = OoRmMessage()
        message.dataType = 1
        message.message = "hello world"
        message.messageAnswer = RealmList("yes", "no")
        OoRealmManager.create(message)

        OoRealmManager.findMessageByIndex(1) {
            Assert.assertEquals("hello world", it?.message)
        }
    }

    @Test
    fun updateMessage() {
        OoRealmManager.updateByIndex(1) {
            it.message = "update completed"
        }
        OoRealmManager.findMessageByIndex(1) {
            Assert.assertEquals("update completed", it?.message)
        }
    }
}