package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmList
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
    var deviceToken : String = "",
    var deviceOS : String = "",
    var deviceModel : String = "",
    var deviceSerial : String = "",
    var partner : String = "",
    var picture : String = "",
    var seniors : RealmList<OoSenior> = RealmList(),
    var requestSeniors : RealmList<String> = RealmList(),
    var guardians : RealmList<OoGuardian> = RealmList(),
    var requestGuardians : RealmList<String> = RealmList(),
    var isLauncher : String = "false") : RealmObject() {

    override fun toString(): String {
        return "OoRmUser(id='$id', userToken='$userToken', email='$email', password='$password', name='$name', " +
                "birthdate='$birthdate', gender='$gender', address1='$address1', address2='$address2', tel='$tel', " +
                "mobile='$mobile', height='$height', weight='$weight', deviceToken='$deviceToken', " +
                "deviceOS='$deviceOS', deviceModel='$deviceModel', deviceSerial='$deviceSerial', partner='$partner', " +
                "picture='$picture', seniors=$seniors, requestSeniors=$requestSeniors, guardians=$guardians, " +
                "requestGuardians=$requestGuardians, isLauncher=$isLauncher"
    }

    fun getIsLauncher(): Boolean {
        return isLauncher != "false"
    }
}

open class OoGuardian(var id: String?= null, var deviceToken: String?= null, var deviceOS:String?= null) : RealmObject() {
    override fun toString(): String {
        return "OoGuardian(id='$id', deviceToken='$deviceToken', deviceOS='$deviceOS')"
    }
}

open class OoSenior(var id: String?= null, var name: String?=null) : RealmObject() {
    override fun toString(): String {
        return "OoSenior(id=$id, name=$name)"
    }
}
