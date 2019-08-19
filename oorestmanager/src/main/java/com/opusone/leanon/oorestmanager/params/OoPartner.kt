package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamPartnerAuth (var email: String? = null,
                          var password: String? = null) : Serializable {

    override fun toString(): String {
        return "OoParamPartnerAuth(email='$email', password='$password')"
    }
}
