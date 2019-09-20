package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoUser
import java.io.Serializable

class OoResponseUserSign(val userId: String?,
                           val userToken: String?,
                           val webrtcToken: String?) : Serializable {
    override fun toString(): String {
        return "OoResponseUserSign(userId=$userId, userToken=$userToken, webrtcToken=$webrtcToken)"
    }
}

class OoResponseUser(val user: OoUser?) : Serializable {
    override fun toString(): String {
        return "OoUserData(user=$user)"
    }
}

class OoResponseUserDevice(val isExist: String?) : Serializable {
    fun isExist(): Boolean {
        return isExist?.equals("true") ?: false
    }

    override fun toString(): String {
        return "OoResponseUserDevice(isExist=$isExist)"
    }
}
