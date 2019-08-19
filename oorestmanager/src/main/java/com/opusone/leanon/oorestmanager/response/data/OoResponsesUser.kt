package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoUser
import java.io.Serializable

class OoResponseCreateUser(val userToken: String?, val userId: String?, val webrtcToken: String?) : Serializable {
    override fun toString(): String {
        return "OoUserCreatedData(userToken=$userToken, userId=$userId, webrtcToken=$webrtcToken)"
    }
}

class OoResponseUser(val user: OoUser?) : Serializable {
    override fun toString(): String {
        return "OoUserData(user=$user)"
    }
}

class OoResponseSigninUser(val userToken: String?, val userId: String?, val webrtcToken: String?) : Serializable{
    override fun toString(): String {
        return "OoUserSignInData(userToken=$userToken, userId=$userId, webrtcToken=$webrtcToken)"
    }
}