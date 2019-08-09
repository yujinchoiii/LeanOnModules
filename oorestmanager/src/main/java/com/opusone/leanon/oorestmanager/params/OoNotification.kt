package com.opusone.leanon.oorestmanager.params

class OoParamMessage(var userToken: String? = null, var to: String?, var message: String? = null, var timestamp: String? = null) {
    override fun toString(): String {
        return "OoParamMessage(userToken='$userToken', to='$to', message='$message', timestamp='$timestamp')"
    }
}