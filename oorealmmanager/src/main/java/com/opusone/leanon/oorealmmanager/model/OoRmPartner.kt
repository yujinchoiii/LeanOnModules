package com.opusone.leanon.realmprovider.OoDataManager.model

import io.realm.RealmObject

open class OoRmPartner : RealmObject(), Cloneable {
    var email: String = ""
    var password: String = ""
    var token: String = ""

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