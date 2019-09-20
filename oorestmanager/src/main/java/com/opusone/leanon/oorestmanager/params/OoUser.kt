package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamUserSignup( var idToken: String?= null,
                         var password: String?= null,
                         var picture: String?= null,
                         var birthdate: String?= null,
                         var gender: String?= null,
                         var address1: String?= null,
                         var address2: String?= null,
                         var tel: String?= null,
                         var mobile: String?= null,
                         var height: String?= null,
                         var weight: String?= null,
                         var nationalCode: String?= null) : Serializable {

    override fun toString(): String {
        return "OoParamUserSignup(idToken=$idToken, password=$password, birthDate=$birthdate, " +
                "gender=$gender, address1=$address1, address2=$address2, " +
                "tel=$tel, mobile=$mobile, height=$height, weight=$weight, picture=$picture, nationalCode=$nationalCode"
    }
}


class OoParamUserSignin( var email: String?= null,
                         var password: String?= null,
                         var deviceOs: String?= null,
                         var deviceType: String?= null,
                         var deviceToken: String?= null,
                         var deviceVersion: String?= null,
                         var deviceModel: String?= null) : Serializable {

    override fun toString(): String {
        return "OoParamUserSignin(email=$email, password=$password, deviceOs=$deviceOs, " +
                "deviceType=$deviceType, deviceType=$deviceType, deviceToken=$deviceToken, " +
                "deviceVersion=$deviceVersion, deviceModel=$deviceModel"
    }
}
