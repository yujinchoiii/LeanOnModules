package com.opusone.leanon.oorealmmanager

import android.content.Context
import android.util.Log
import com.opusone.leanon.oorealmmanager.model.OoRealmModule
import com.opusone.leanon.oorealmmanager.model.OoRmMessage
import io.realm.*
import io.realm.exceptions.RealmMigrationNeededException
import java.lang.reflect.Type

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
            } finally {
                it.close()
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
            } finally {
                it.close()
            }
        }
        return result
    }

    fun update(f: () -> Unit) {
        Realm.getDefaultInstance().executeTransaction {
            f()
            it.close()
        }
    }


    fun <T: RealmObject> findOneById(id : String, type: Class<T>) : T? {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            val ret = it.where(type).equalTo("id", id).findFirst()
            it.close()
            return ret
        }
        return null
    }

    fun <T: RealmObject> findOneByEmail(email : String, type: Class<T>) : T? {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            val ret =  it.where(type).equalTo("email", email).findFirst()
            it.close()
            return ret
        }
        return null
    }

    fun getMessageCount() : Long {
        val realm = Realm.getDefaultInstance()
        var count : Long = 0
        realm?.let {
            count = it.where(OoRmMessage::class.java).count()
            it.close()
        }
        return count
    }

    fun findMessageList(index : Long, completion: (RealmResults<OoRmMessage>?) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            if(index > 99) {
                completion(it.where(OoRmMessage::class.java).between("index", index - 99, index).findAll())
            } else {
                completion(it.where(OoRmMessage::class.java).between("index", 0, index).findAll())
            }
            it.close()
        }
    }
}