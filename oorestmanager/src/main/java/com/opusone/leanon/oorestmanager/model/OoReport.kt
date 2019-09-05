package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoLocation(var userId: String? = null, var geoCoding: String? = null,
                 var latitude: String? = null, var longitude: String? = null,
                 var timestamp: String? = null): Serializable {
    override fun toString(): String {
        return "OoLocation (userId='$userId', geoCoding='$geoCoding', 'latitude=$latitude'," +
                " 'longitude=$longitude', 'timestamp=$timestamp')"
    }
}
