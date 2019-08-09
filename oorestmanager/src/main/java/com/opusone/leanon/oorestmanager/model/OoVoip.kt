package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoVoipChannel(var id: String? = null,
                    var roomId: String? = null,
                    var turnRestUrl: String? = null,
                    var signal: OoSignal? = null,
                    var iceServers: List<OoVoipIceServer> = arrayListOf()): Serializable {

    override fun toString(): String {
        return "OoVoipChannel (id='$id', 'roomId='$roomId', 'turnRestUrl=$turnRestUrl', 'signal=$signal', 'iceServers=$iceServers')"
    }
}

class OoVoipIceServer (var credential: String? = null,
                       var urls: List<String>? = null,
                       var username: String? = null): Serializable {

    override fun toString(): String {
        return "OoVoipIceServer (credential='$credential', 'urls='$urls', 'username=$username')"
    }
}

class OoSignal (var wshpp: String? = null,
                var wstls: Boolean = false): Serializable {

    override fun toString(): String {
        return "OoSignal (wshpp='$wshpp', 'wstls='$wstls')"
    }
}