package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmScaleDevice(
    var id: String = "",
    var info: String = ""
) : RealmObject() {

    override fun toString(): String {
        return "OoRmScaleDevice(id='$id', info='$info')"
    }
}