package com.opusone.leanon.oorealmmanager

import android.content.ContentValues
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import com.opusone.leanon.oorealmmanager.model.OoRmPartner
import com.opusone.leanon.oorealmmanager.model.OoRmScaleDevice
import com.opusone.leanon.oorealmmanager.model.OoRmUser
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
        val user = OoRmUser("Rosi3","", "Rosi@gmail.com","1234")

        OoRealmManager.create(user)

        OoRealmManager.findOneById("Rosi3", OoRmUser::class.java) {found ->
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
        OoRealmManager.findOneById("Rosi", OoRmUser::class.java) { found ->
            found?.let {
                OoRealmManager.update {
                    it.email = "salaza43344@gmail.com"
                }
            }
            OoRealmManager.findOneById("Rosi", OoRmUser::class.java) { test ->
                Assert.assertEquals(test?.email, "salaza43344@gmail.com")
                Assert.assertEquals(test?.password, "1234")
                Assert.assertEquals(test?.id, "Rosi")
            }
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
        val partner = OoRmPartner("dev@theopsone", "", "testToken")

        val ret = OoRealmManager.create(partner)
        Assert.assertEquals(true, ret)
    }

    @Test
    fun readPartner() {
        OoRealmManager.findOneByEmail("dev@theopsone", OoRmPartner::class.java) { found ->
            Assert.assertEquals(found?.email, "dev@theopsone")
        }
    }

    @Test
    fun updateMessage() {
        OoRealmManager.findMessageByIndex(1) {
            it?.let {
                OoRealmManager.update {
                    it.message = "update completed"
                }
                OoRealmManager.findMessageByIndex(1) {
                    Assert.assertEquals("update completed", it?.message)
                }
            }
        }
    }
}