package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmPartner(var email: String = "", var password: String = "", var token: String = "") : RealmObject() {
    override fun toString(): String {
        return "OoRmPartner(email=$email, password=$password, token=$token)"
    }
}