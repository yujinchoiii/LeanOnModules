package com.opusone.leanon.oorestmanager.response.data

import java.io.Serializable

class OoResponseAuth(val accessToken : String) : Serializable {
    override fun toString(): String {
        return "OoResponseAuth(accessToken=$accessToken)"
    }
}
