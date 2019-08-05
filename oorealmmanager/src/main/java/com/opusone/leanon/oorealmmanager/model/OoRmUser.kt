package com.opusone.leanon.realmprovider.OoDataManager.model

import io.realm.RealmList
import io.realm.RealmObject

//open class OoRmUser : RealmObject(), Cloneable{
//    var id : String = ""
//    var userToken : String = ""
//    var email : String = ""
//    var password : String = ""
//    var name : String = ""
//    var age : String = ""
//    var gender : String = ""
//    var address1 : String = ""
//    var address2 : String = ""
//    var tel : String = ""
//    var mobile : String = ""
//    var height : String = ""
//    var weight: String = ""
//    var deviceToken : String = ""
//    var deviceOS : String = ""
//    var deviceModel : String = ""
//    var deviceSerial : String = ""
//    var partner : String = ""
//    var picture : String = ""
//    var seniors : RealmList<String> = RealmList()
//    var guardians : RealmList<String> = RealmList()
//    var requestGuardians : RealmList<String> = RealmList()
//    var isLauncher : Boolean = false
//
//    override public fun clone(): Any {
//        val result = OoRmUser()
//        result.id = this.id
//        result.userToken = this.userToken
//        result.email = this.email
//        result.password = this.password
//        result.name = this.name
//        result.age = this.age
//        result.gender = this.gender
//        result.address1 = this.address1
//        result.address2 = this.address2
//        result.tel = this.tel
//        result.mobile = this.mobile
//        result.height = this.height
//        result.weight = this.weight
//        result.deviceToken = this.deviceToken
//        result.deviceOS = this.deviceOS
//        result.deviceModel = this.deviceModel
//        result.deviceSerial = this.deviceSerial
//        result.partner = this.partner
//        result.picture = this.picture
//        result.seniors = this.seniors
//        result.guardians = this.guardians
//        result.requestGuardians = this.requestGuardians
//        result.isLauncher = this.isLauncher
//
//        return result
//    }
//
//    override fun toString(): String {
//        return "OoRmUser(id='$id', userToken='$userToken', email='$email', password='$password', name='$name', " +
//                "age='$age', gender='$gender', address1='$address1', address2='$address2', tel='$tel', " +
//                "mobile='$mobile', height='$height', weight='$weight', deviceToken='$deviceToken', " +
//                "deviceOS='$deviceOS', deviceModel='$deviceModel', deviceSerial='$deviceSerial', partner='$partner', " +
//                "picture='$picture', seniors=$seniors, guardians=$guardians, " +
//                "requestGuardians=$requestGuardians, isLauncher=$isLauncher)"
//    }
//
//
//}

open class OoRmUser : RealmObject() {
    var id : String = ""
    var userToken : String = ""
    var email : String = ""
    var password : String = ""
    var name : String = ""
    var age : String = ""
    var gender : String = ""
    var address1 : String = ""
    var address2 : String = ""
    var tel : String = ""
    var mobile : String = ""
    var height : String = ""
    var weight: String = ""
    var deviceToken : String = ""
    var deviceOS : String = ""
    var deviceModel : String = ""
    var deviceSerial : String = ""
    var partner : String = ""
    var picture : String = ""
    var seniors : RealmList<String> = RealmList()
    var guardians : RealmList<String> = RealmList()
    var requestGuardians : RealmList<String> = RealmList()
    var isLauncher : Boolean = false

    override fun toString(): String {
        return "OoRmUser(id='$id', userToken='$userToken', email='$email', password='$password', name='$name', " +
                "age='$age', gender='$gender', address1='$address1', address2='$address2', tel='$tel', " +
                "mobile='$mobile', height='$height', weight='$weight', deviceToken='$deviceToken', " +
                "deviceOS='$deviceOS', deviceModel='$deviceModel', deviceSerial='$deviceSerial', partner='$partner', " +
                "picture='$picture', seniors=$seniors, guardians=$guardians, " +
                "requestGuardians=$requestGuardians, isLauncher=$isLauncher)"
    }

}