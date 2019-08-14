package com.opusone.leanon.oorealmmanager

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

        val found = OoRealmManager.findOneById("Rosi3", OoRmUser::class.java)
        Assert.assertEquals(found?.id, user.id)
    }

    @Test
    fun readUser() {
        val found = OoRealmManager.findOneById("Rosi3", OoRmUser::class.java)
        Assert.assertEquals(found?.id, "Rosi3")
        Assert.assertEquals(found?.email, "Rosi@gmail.com")
    }

    @Test
    fun updateUser() {
        val found = OoRealmManager.findOneById("Rosi", OoRmUser::class.java)
        found?.let {
            OoRealmManager.update {
                it.email = "salaza43344@gmail.com"
            }

            val test = OoRealmManager.findOneById("Rosi", OoRmUser::class.java)
            Assert.assertEquals(test?.email, it.email)
            Assert.assertEquals(test?.password, "1234")
            Assert.assertEquals(test?.id, "Rosi")
        }
    }

    @Test
    fun deleteUser() {
        var user = OoRealmManager.findOneById("Rosi2", OoRmUser::class.java)
        user?.let {
            OoRealmManager.delete(user as RealmObject)

            user = OoRealmManager.findOneById("Rosi2", OoRmUser::class.java)
            Assert.assertEquals(null, user)
        }
    }

    @Test
    fun createScaleDevice() {
        val scaleDevice = OoRmScaleDevice("01", "asdasdassadasdasdadadadasdsada")

        OoRealmManager.create(scaleDevice)

        val found = OoRealmManager.findOneById("01", OoRmScaleDevice::class.java)
        Assert.assertEquals(found?.id, scaleDevice.id)
    }

    @Test
    fun createPartner() {
        val partner = OoRmPartner("dev@theopsone", "", "testToken")

        val ret = OoRealmManager.create(partner)
        Assert.assertEquals(true, ret)
    }

    @Test
    fun readPartner() {
        val found = OoRealmManager.findOneByEmail("dev@theopsone", OoRmPartner::class.java)
        Assert.assertEquals(found?.email, "dev@theopsone")
    }
}