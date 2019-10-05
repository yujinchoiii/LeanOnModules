package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmUser(
    var id : String = "",
    var userToken : String = "",
    var email: String = "",
    var password : String = "",
    var name : String = "",
    var birthdate : String = "",
    var gender : String = "",
    var address1 : String = "",
    var address2 : String = "",
    var tel : String = "",
    var mobile : String = "",
    var height : String = "",
    var weight: String = "",
    var deviceType : String = "",
    var deviceToken : String = "",
    var deviceOs : String = "",
    var deviceModel : String = "",
    var deviceVersion : String = "",
    var partner : String = "",
    var picture : String = "") : RealmObject() {

    override fun toString(): String {
        return "OoRmUser(id='$id', userToken='$userToken', email='$email', password='$password', name='$name', " +
                "birthdate='$birthdate', gender='$gender', address1='$address1', address2='$address2', tel='$tel', " +
                "mobile='$mobile', height='$height', weight='$weight', deviceToken='$deviceToken', " +
                "deviceOS='$deviceOs', deviceModel='$deviceModel', deviceType='$deviceType', partner='$partner', " +
                "picture='$picture', deviceVersion='$deviceVersion'"
    }

    fun getIsLauncher(): Boolean {
        var type = 0
        try {
            type = deviceType.toInt()
        } catch (e: Exception) {
        }
        return ((type > 0) and (type < 11))
    }
}

open class OoRmGuardian(var id: String?= null, var deviceToken: String?= null, var deviceOS:String?= null) : RealmObject() {
    override fun toString(): String {
        return "OoRmGuardian(id='$id', deviceToken='$deviceToken', deviceOS='$deviceOS')"
    }
}

open class OoRmSenior(var id: String?= null, var name: String?=null) : RealmObject() {
    override fun toString(): String {
        return "OoRmSenior(id=$id, name=$name)"
    }
}
