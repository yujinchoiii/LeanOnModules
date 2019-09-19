package com.opusone.leanon.oorealmmanager

import android.content.Context
import android.util.Log
import com.opusone.leanon.oorealmmanager.model.OoRealmModule
import com.opusone.leanon.oorealmmanager.model.OoRmMessage
import com.opusone.leanon.oorealmmanager.model.OoRmUser
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

    fun updateByIndex(index : Long, f: (OoRmMessage) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {realm ->
            val result = realm.where(OoRmMessage::class.java).equalTo("index", index).findFirst()
            result?.let {message ->
                realm.executeTransaction {
                    f(message)
                }
            }
            realm.close()
        }
    }

    fun updateByTag(tag : String, f: (OoRmMessage) -> Unit) {
        val realm = Realm.getDefaultInstance()
        val selected = 4
        realm?.let {realm ->
            val result = realm.where(OoRmMessage::class.java).notEqualTo("dataType", selected).equalTo("question", tag).findFirst()
            Log.i(TAG, "found $result")
            result?.let {message ->
                realm.executeTransaction {
                    f(message)
                }
            }
            realm.close()
        }
    }


    fun <T: RealmObject> updateById(id : String, type : Class<T>, f: (T) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {realm ->
            val result = realm.where(type).equalTo("id", id).findFirst()
            result?.let {t ->
                realm.executeTransaction {
                    f(t)
                }
            }
            realm.close()
        }
    }

    fun <T: RealmObject> updateByEmail(email : String, type : Class<T>, f: (T) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {realm ->
            val result = realm.where(type).equalTo("email", email).findFirst()
            result?.let {t ->
                realm.executeTransaction {
                    f(t)
                }
            }
            realm.close()
        }
    }


    fun <T: RealmObject> findOneById(id : String, type: Class<T>, completion: (T?) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            val one = it.where(type).equalTo("id", id).findFirst()
            if (one != null) {
                completion(it.copyFromRealm(one))
            } else {
                completion(null)
            }
        }
        realm.close()
    }

    fun <T: RealmObject> findOneByEmail(email : String, type: Class<T>, completion: (T?) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            val one = it.where(type).equalTo("email", email).findFirst()
            if (one != null) {
                completion(it.copyFromRealm(one))
            } else {
                completion(null)
            }
        }
        realm.close()
    }

    fun findMessageByIndex(index : Long, completion: (OoRmMessage?) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            completion(it.copyFromRealm(it.where(OoRmMessage::class.java).equalTo("index", index).findFirst()))
        }
        realm.close()
    }

    fun getMessageCount() : Long {
        val realm = Realm.getDefaultInstance()
        var count : Long = 0
        realm?.let {
            count = it.where(OoRmMessage::class.java).count()
        }
        realm.close()
        return count
    }

    fun findMessageList(index : Long, completion: (List<OoRmMessage>?) -> Unit) {
        val realm = Realm.getDefaultInstance()
        realm?.let {
            if(index > 20) {
                completion(it.copyFromRealm(it.where(OoRmMessage::class.java).between("index", index - 20, index).sort("index", Sort.ASCENDING).findAll()))
            } else {
                completion(it.copyFromRealm(it.where(OoRmMessage::class.java).between("index", 0, index).sort("index", Sort.ASCENDING).findAll()))
            }
        }
        realm.close()
    }
}