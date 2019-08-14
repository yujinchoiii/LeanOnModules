package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmPartner(
    var email: String = "",
    var password: String = "",
    var token: String = ""
) : RealmObject(), Cloneable {

    override public fun clone(): Any {
        val result = OoRmPartner()
        result.email = this.email
        result.password = this.password
        result.token = this.token
        return result
    }

    override fun toString(): String {
        return "OoRmPartner(email=$email, password=$password, token=$token)"
    }
}