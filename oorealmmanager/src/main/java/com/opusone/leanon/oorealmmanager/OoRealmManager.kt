package com.opusone.leanon.oorealmmanager

import android.content.Context
import com.opusone.leanon.realmprovider.OoDataManager.model.OoPartners
import com.opusone.leanon.realmprovider.OoDataManager.model.OoRealmModule
import com.opusone.leanon.realmprovider.OoDataManager.model.OoUser
import io.realm.*

object OoRealmManager {
    private val TAG = "OoRealmManager"

    fun initRealm(context: Context) {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration.Builder().modules(OoRealmModule()).build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    fun destroyRealm() {
        Realm.getDefaultInstance()?.let {
            it.removeAllChangeListeners()
            it.close()
        }
    }

    fun createUser(user: OoUser) : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction{
                    val realmUser = it.createObject(OoUser::class.java)
                    realmUser.apply {
                        this.id = user.id
                        this.userToken = user.userToken
                        this.email = user.email
                        this.password = user.password
                        this.name = user.name
                        this.age = user.age
                        this.gender = user.gender
                        this.address1 = user.address1
                        this.address2 = user.address2
                        this.tel = user.tel
                        this.mobile = user.mobile
                        this.height = user.height
                        this.weight = user.weight
                        this.deviceToken = user.deviceToken
                        this.deviceOS = user.deviceOS
                        this.deviceModel = user.deviceModel
                        this.deviceSerial = user.deviceSerial
                        this.guardians = user.guardians
                        this.partner = user.partner
                        this.picture = user.picture
                        this.seniors = user.seniors
                        this.requestGuardians = user.requestGuardians
                        this.isLauncher = user.isLauncher
                        result = true
                     }
                }
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun readUser(id : String) : OoUser? {
        val realm = Realm.getDefaultInstance()

        realm?.let {
            return it.where(OoUser::class.java).equalTo("id", id).findFirst()
        }
        return null
    }

    fun updateUser(id: String, updatedUser: OoUser) : Boolean{
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction {
                    val realmUser = readUser(id)
                    realmUser?.apply {
                        this.let {
                            it.id = id
                            it.userToken = updatedUser.userToken
                            it.email = updatedUser.email
                            it.password = updatedUser.password
                            it.name = updatedUser.name
                            it.age = updatedUser.age
                            it.gender = updatedUser.gender
                            it.address1 = updatedUser.address1
                            it.address2 = updatedUser.address2
                            it.tel = updatedUser.tel
                            it.mobile = updatedUser.mobile
                            it.height = updatedUser.height
                            it.weight = updatedUser.weight
                            it.deviceToken = updatedUser.deviceToken
                            it.deviceOS = updatedUser.deviceOS
                            it.deviceModel = updatedUser.deviceModel
                            it.deviceSerial = updatedUser.deviceSerial
                            it.guardians = updatedUser.guardians
                            it.partner = updatedUser.partner
                            it.picture = updatedUser.picture
                            it.seniors = updatedUser.seniors
                            it.requestGuardians = updatedUser.requestGuardians
                            it.isLauncher = updatedUser.isLauncher
                            result = true
                        }
                    }
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun deleteUser(id: String) : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction {
                    val realmUser = readUser(id)
                    realmUser?.let {
                        it.deleteFromRealm()
                        result = true
                    }
                }
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun createPartner() : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction {
                    it.createObject(OoPartners::class.java)
                }
                result = true
            } catch (e : Error) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun readPartner() : OoPartners? {
        val realm = Realm.getDefaultInstance()

        realm?.let {
            return it.where(OoPartners::class.java).equalTo("email", "dev@theopusone.com").findFirst()
        }
        return null
    }

    fun updatePartner(updatedPartners: OoPartners) : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction {
                    val realmPartner = readPartner()
                    realmPartner?.apply {
                        this.let {
                            it.email = "dev@theopusone.com"
                            it.password = ""
                            it.token = updatedPartners.token
                        }
                    }
                }
                result = true
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun deletePartner() : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                val realmPartners = readPartner()
                it.executeTransaction {
                    realmPartners?.deleteFromRealm()
                }
                result = true
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }
}