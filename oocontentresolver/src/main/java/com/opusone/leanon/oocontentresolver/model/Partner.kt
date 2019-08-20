package com.opusone.leanon.oocontentresolver.model

class Partner : Any(){
    var email : String = ""
    var token : String = ""

    override fun toString(): String {
        return "Partner(email='$email', token='$token')"
    }
}