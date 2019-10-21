package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmNoti : RealmObject() {
    var notiTo : String = ""
    var key : String = ""
    var isNew : Boolean = false
    var count : Int? = 0

    override fun toString(): String {
        return "OoRmNoti(notiTo='$notiTo', key='$key', isNew=$isNew, count=$count)"
    }
}