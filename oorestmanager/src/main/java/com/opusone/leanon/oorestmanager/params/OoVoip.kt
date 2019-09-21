package com.opusone.leanon.oorestmanager.params

import java.io.Serializable


class OoParamCreateChannel(val userToken : String?,
                           val callee : String?,
                           val calleeDeviceType : String?) : Serializable {
    override fun toString(): String {
        return "OoParamCreateChannel(userToken=$userToken, callee=$callee, calleeDeviceType=$calleeDeviceType)"
    }
}
