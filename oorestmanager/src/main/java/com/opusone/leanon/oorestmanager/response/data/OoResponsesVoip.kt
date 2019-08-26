package com.opusone.leanon.oorestmanager.response.data

import java.io.Serializable
import com.opusone.leanon.oorestmanager.model.OoVoipChannel
import com.opusone.leanon.oorestmanager.model.OoVoipIceServer

class OoResponseCreateChannel(var channel: OoVoipChannel? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseCreateChannel (channel=$channel)"
    }
}

class OoResponseTurnUrl(var iceServers: List<OoVoipIceServer>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseTurnUrl (iceServers=$iceServers)"
    }
}