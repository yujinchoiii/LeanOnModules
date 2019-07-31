package com.opusone.leanon.realmprovider.OoDataManager.model

import io.realm.RealmObject

open class OoPartners : RealmObject(), Cloneable {
    var email: String = "dev@theopusone.com"
    var password : String = "opusone1004"
    var token : String = ""

    override public fun clone(): Any {
        val result = OoPartners()
        result.email = this.email
        result.password = this.password
        result.token = this.token

        return result
    }

    override fun toString(): String {
        return "OoPartners(email=$email, password=$password, token=$token)"
    }
}