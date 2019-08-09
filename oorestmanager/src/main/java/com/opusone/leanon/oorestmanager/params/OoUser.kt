package com.opusone.leanon.restmanager.params

import java.io.Serializable

class OoParamCreateUser( var password: String?= null,
                         var age: String?= null,
                         var gender: String?= null,
                         var address1: String?= null,
                         var address2: String?= null,
                         var tel: String?= null,
                         var mobile: String?= null,
                         var height: String?= null,
                         var weight: String?= null,
                         var deviceToken: String?= null,
                         var deviceOS: String?= null,
                         var deviceModel: String?= null,
                         var deviceSerial: String?= null,
                         var idToken: String?= null,
                         var picture: String?= null,
                         var isLauncher: String?= null) : Serializable {

    override fun toString(): String {
        return "OoUserCreateModel(password=$password, age=$age, gender=$gender, address1=$address1, address2=$address2, " +
                "tel=$tel, mobile=$mobile, height=$height, weight=$weight, deviceToken=$deviceToken, deviceOS=$deviceOS," +
                " deviceModel=$deviceModel, deviceSerial=$deviceSerial, idToken=$idToken, picture=$picture, isLauncher=$isLauncher"
    }
}


class OoParamSigninUser(val email : String?, val password : String?) : Serializable{
    override fun toString(): String {
        return "OoUserSignInModel(email=$email, password=$password)"
    }
}