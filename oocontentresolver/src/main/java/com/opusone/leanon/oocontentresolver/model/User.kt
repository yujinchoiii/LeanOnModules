package com.opusone.leanon.oocontentresolver.model

class User : Any() {
    var id: String = ""
    var email: String = ""
    var name: String = ""
    var userToken: String = ""
    var deviceToken: String = ""
    var birthdate: String= ""
    var gender: String= ""
    var weight: String= ""
    var height: String= ""
    var seniors : ArrayList<OoSenior> = java.util.ArrayList<OoSenior>()
    var guardians : ArrayList<OoGuardian> = java.util.ArrayList<OoGuardian>()

    override fun toString(): String {
        return "User(id='$id', email='$email', name='$name', " +
                ", birthdate='$birthdate', gender='$gender', weight='$weight', height='$height'" +
                "userToken='$userToken', deviceToken='$deviceToken')"
    }
}

class OoGuardian(var id: String?= null, var deviceToken: String?= null, var deviceOS:String?= null) {
    override fun toString(): String {
        return "OoGuardian(id='$id', deviceToken='$deviceToken', deviceOS='$deviceOS')"
    }
}

class OoSenior(var id: String?= null) {
    override fun toString(): String {
        return "OoSenior(id='$id')"
    }
}