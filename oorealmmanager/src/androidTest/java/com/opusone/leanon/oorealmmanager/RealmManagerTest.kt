package com.opusone.leanon.oorealmmanager

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import com.opusone.leanon.realmprovider.OoDataManager.model.OoUser
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
        val user = OoUser()
        user.id = "Rosi"
        user.email = "Rosi@gmail.com"
        user.password = "1234"

        OoRealmManager.createUser(user)
        Assert.assertEquals(OoRealmManager.readUser("Rosi")?.id, user.id)
    }

    @Test
    fun readUser() {
        val user = OoRealmManager.readUser("Rosi")
        Assert.assertEquals(user?.id, "Rosi")
        Assert.assertEquals(user?.email, "Rosi@gmail.com")
    }

    @Test
    fun updateUser() {
        val updatedUser = OoRealmManager.readUser("Rosi")
        updatedUser?.let {
            val user = it.clone() as OoUser
            Log.i("test", "id is ${user.id}, password is ${user.password}, email is ${user.email}")
            user.email = "salazar@gmail.com"
            OoRealmManager.updateUser("Rosi", user)

            val test = OoRealmManager.readUser("Rosi")
            Assert.assertEquals(test?.email, user.email)
            Assert.assertEquals(test?.password, "1234")
            Assert.assertEquals(test?.id, "Rosi")
        }
    }

    @Test
    fun deleteUser() {
        OoRealmManager.deleteUser("Rosi")

        Assert.assertEquals(null, OoRealmManager.readUser("Rosi"))
    }
}