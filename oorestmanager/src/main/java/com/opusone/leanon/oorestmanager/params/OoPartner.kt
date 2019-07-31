package com.opusone.leanon.restmanager.params

import java.io.Serializable

class OoParamPartnerAuth (val email : String = "dev@theopusone.com",
                          val password : String = "opusone1004") : Serializable {

    override fun toString(): String {
        return "OoParamPartnerAuth(email='$email', password='$password')"
    }
}
