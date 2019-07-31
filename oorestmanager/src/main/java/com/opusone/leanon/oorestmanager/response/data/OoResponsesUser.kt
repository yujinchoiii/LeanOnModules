package com.opusone.leanon.restmanager.response.data

import com.opusone.leanon.restmanager.model.OoUser
import java.io.Serializable

class OoResponseCreateUser(val userToken: String?, val userId: String?) : Serializable {
    override fun toString(): String {
        return "OoUserCreatedData(userToken=$userToken, userId=$userId)"
    }
}

class OoResponseUser(val user: OoUser?) : Serializable {
    override fun toString(): String {
        return "OoUserData(user=$user)"
    }
}

class OoResponseSigninUser(val userToken: String?, val userId: String?) : Serializable{
    override fun toString(): String {
        return "OoUserSignInData(userToken=$userToken, userId=$userId)"
    }
}