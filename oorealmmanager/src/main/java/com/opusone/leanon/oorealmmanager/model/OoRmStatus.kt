package com.opusone.leanon.oorealmmanager.model

import android.provider.Contacts.SettingsColumns.KEY
import io.realm.RealmObject

open class OoRmStatus : RealmObject() {
    var userId: String= ""
    var key : String = ""
    var status : Boolean = false
    override fun toString(): String {
        return "OoRmStatus(userId='$userId', key='$key', status=$status)"
    }
}