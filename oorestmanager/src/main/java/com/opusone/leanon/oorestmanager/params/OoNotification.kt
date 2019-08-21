package com.opusone.leanon.oorestmanager.params

class OoParamMessage(var userToken: String? = null, var to: String?, var index: String?, var dataType : String?, var message: String? = null, var messageAnswer: MutableList<String?>, var timestamp: String? = null) {
    override fun toString(): String {
        return "OoParamMessage(userToken=$userToken, to=$to, index=$index, dataType=$dataType, message=$message, messageAnswer=$messageAnswer, timestamp=$timestamp)"
    }
}