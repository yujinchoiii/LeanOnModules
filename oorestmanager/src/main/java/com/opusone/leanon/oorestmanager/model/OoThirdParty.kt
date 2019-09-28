package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoSingitReply(val leanonId: String? = null, val singitId: String? = null): Serializable {
    override fun toString(): String {
        return "OoSingitReply (leanonId='$leanonId', singitId='$singitId')"
    }
}

class OoPushSingitReply(var singit: OoSingitReply? = null): Serializable {
    override fun toString(): String {
        return "OoPushSingitReply (singit='$singit')"
    }
}