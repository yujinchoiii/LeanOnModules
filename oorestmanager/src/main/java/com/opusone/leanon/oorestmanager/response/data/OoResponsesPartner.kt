package com.opusone.leanon.restmanager.response.data

import java.io.Serializable

class OoResponseAuth(val accessToken : String) : Serializable {
    override fun toString(): String {
        return "OoResponseAuth(accessToken=$accessToken)"
    }
}
