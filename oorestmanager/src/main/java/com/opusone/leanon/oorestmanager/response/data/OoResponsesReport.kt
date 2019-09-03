package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoLocation
import java.io.Serializable

class OoResponseLocation(val location: OoLocation) : Serializable {
    override fun toString(): String {
        return "OoResponseLocation(location=$location)"
    }
}
