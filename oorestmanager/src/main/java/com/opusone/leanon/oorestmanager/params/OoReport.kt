package com.opusone.oorestmanager.params

import java.io.Serializable

class OoParamMMSE(var userToken : String? = null,
                  val result: String? = null) : Serializable {

    override fun toString(): String {
        return "OoParamMMSE(userToken='$userToken', result='$result')"
    }
}
