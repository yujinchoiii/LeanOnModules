package com.opusone.leanon.oorestmanager.model

import java.io.Serializable


class OoMessage (var user: OoCompactUser? = null,
                 var index: String? = null,
                 var dataType: String? = null,
                 var message: String? = null,
                 var timestamp: String? = null,
                 var messageAnswer: List<String>?= null): Serializable {

    override fun toString(): String {
        return "OoMessage (user='$user', 'index=$index'," +
                " 'dataType=$dataType', 'message=$message', 'timestamp=$timestamp', 'messageAnswer=$messageAnswer')"
    }
}

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
