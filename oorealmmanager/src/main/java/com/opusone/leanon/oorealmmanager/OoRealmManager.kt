package com.opusone.leanon.oorealmmanager

import android.content.Context
import com.opusone.leanon.realmprovider.OoDataManager.model.OoRealmModule
import io.realm.*
import io.realm.exceptions.RealmMigrationNeededException

object OoRealmManager {
    private val TAG = "OoRealmManager"

    private fun checkMigration(config: RealmConfiguration, context: Context) {
        try {
            Realm.getDefaultInstance()
        } catch (e: RealmMigrationNeededException) {
            e.printStackTrace()

            Realm.deleteRealm(config)
            initRealm(context)
        }
    }

    fun initRealm(context: Context) {
        Realm.init(context)

        val realmConfiguration = RealmConfiguration.Builder().modules(OoRealmModule()).build()
        if (BuildConfig.DEBUG) {
            RealmConfiguration.Builder().directory(context.getExternalFilesDir(null))
        }
        Realm.setDefaultConfiguration(realmConfiguration)

        context.run {
            checkMigration(realmConfiguration, context)
        }
    }

    fun relese() {
        Realm.getDefaultInstance()?.let {
            it.removeAllChangeListeners()
            it.close()
        }
    }
    fun create(data: RealmObject): Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction{
                    realm.copyToRealm(data)
                }
                result = true
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun delete(obj: RealmObject) : Boolean {
        val realm = Realm.getDefaultInstance()
        var result = false

        realm?.let {
            try {
                it.executeTransaction {
                    obj.deleteFromRealm()
                }
                result = true
            } catch (e : Throwable) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun update(f: () -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            f()
        }
    }


    fun <T: RealmObject> findOneById(id : String, type: T) : T? {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            return it.where(type::class.java).equalTo("id", id).findFirst()
        }
        return null
    }

    fun <T: RealmObject> findOneByEmail(email : String, type: T) : T? {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            return it.where(type::class.java).equalTo("email", email).findFirst()
        }
        return null
    }
}