package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoCompactUser
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

class OoResponseRequestSeniorList(val requestSeniors: List<OoCompactUser>?) : Serializable {
    override fun toString(): String {
        return "OoResponseRequestSeniorList(requestSeniors=$requestSeniors)"
    }
}

class OoResponseSeniorList(val seniors: List<OoCompactUser>?) : Serializable {
    override fun toString(): String {
        return "OoResponseSeniorList(seniors=$seniors)"
    }
}

class OoResponseRequestGuardianList(val requestGuaridnas: List<OoCompactUser>?) : Serializable {
    override fun toString(): String {
        return "OoResponseRequestGuardianList(requestGuaridnas=$requestGuaridnas)"
    }
}

class OoResponseGuardianList(val guaridnas: List<OoCompactUser>?) : Serializable {
    override fun toString(): String {
        return "OoResponseGuardianList(guaridnas=$guaridnas)"
    }
}
