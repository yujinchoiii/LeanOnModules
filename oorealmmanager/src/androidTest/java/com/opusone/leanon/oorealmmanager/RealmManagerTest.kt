package com.opusone.leanon.oorealmmanager

import androidx.test.platform.app.InstrumentationRegistry
import com.opusone.leanon.realmprovider.OoDataManager.model.OoRmPartner
import com.opusone.leanon.realmprovider.OoDataManager.model.OoRmUser
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
        val user = OoRmUser()
        user.id = "Rosi2"
        user.email = "Rosi@gmail.com"
        user.password = "1234"

        OoRealmManager.create(user)

        val found = OoRealmManager.findOneById("Rosi2", OoRmUser())
        Assert.assertEquals(found?.id, user.id)
    }

    @Test
    fun readUser() {
        val found = OoRealmManager.findOneById("Rosi2", OoRmUser())
        Assert.assertEquals(found?.id, "Rosi2")
        Assert.assertEquals(found?.email, "Rosi@gmail.com")
    }

    @Test
    fun updateUser() {
        val found = OoRealmManager.findOneById("Rosi", OoRmUser())
        found?.let {
            OoRealmManager.update {
                it.email = "salaza43344@gmail.com"
            }

            val test = OoRealmManager.findOneById("Rosi", OoRmUser())
            Assert.assertEquals(test?.email, it.email)
            Assert.assertEquals(test?.password, "1234")
            Assert.assertEquals(test?.id, "Rosi")
        }
    }

    @Test
    fun deleteUser() {
        var user = OoRealmManager.findOneById("Rosi2", OoRmUser())
        user?.let {
            OoRealmManager.delete(user as RealmObject)

            user = OoRealmManager.findOneById("Rosi2", OoRmUser())
            Assert.assertEquals(null, user)
        }
    }


    @Test
    fun createPartner() {
        val partner = OoRmPartner()
        partner.email = "dev@theopsone"
        partner.password = ""
        partner.token = "testToken"

        val ret = OoRealmManager.create(partner)
        Assert.assertEquals(true, ret)
    }

    @Test
    fun readPartner() {
        val found = OoRealmManager.findOneByEmail("dev@theopsone", OoRmPartner())
        Assert.assertEquals(found?.email, "dev@theopsone")
    }
}