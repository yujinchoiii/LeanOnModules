package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

open class OoPushRequestGuardian(var user: OoCompactUser? = null) : Serializable {
    override fun toString(): String {
        return "OoPushRequestGuardian (user='$user')"
    }
}

class OoPushAcceptGuardian(user: OoCompactUser? = null): OoPushRequestGuardian(user) {
    override fun toString(): String {
        return "OoPushAcceptGuardian (user='$user')"
    }
}

class OoPushRejectGuardian(user: OoCompactUser? = null): OoPushRequestGuardian(user) {
    override fun toString(): String {
        return "OoPushRejectGuardian (user='$user')"
    }
}
