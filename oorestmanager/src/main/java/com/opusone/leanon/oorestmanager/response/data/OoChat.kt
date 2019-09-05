package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoMessage
import java.io.Serializable

class OoResponseMessage(val message: OoMessage? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseMessage(message=$message)"
    }
}