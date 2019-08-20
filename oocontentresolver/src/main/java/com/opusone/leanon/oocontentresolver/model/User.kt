package com.opusone.leanon.oocontentresolver.model

class User : Any() {
    var id: String = ""
    var email: String = ""
    var name: String = ""
    var userToken: String = ""
    var deviceToken: String = ""

    override fun toString(): String {
        return "User(id='$id', email='$email', name='$name', " +
                "userToken='$userToken', deviceToken='$deviceToken')"
    }
}