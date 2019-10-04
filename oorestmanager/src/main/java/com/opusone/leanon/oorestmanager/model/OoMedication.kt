package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoMedication(
    var id: String?= null,
    var taken: String? = null,
    var guardian: String?= null,
    var alarmId: String?= null,
    var hour: String?= null,
    var min: String?= null,
    var name: String?= null,
    var picture: String?= null,
    var timestamp: Long = 0,
    var weekdaysInfo: MutableList<Boolean>?= null) : Serializable {
    override fun toString(): String {
        return "OoMedication(id='$id', taken='$taken', timestamp='$timestamp', guardian='$guardian' ,alarmId='$alarmId', " +
                "guardian='$guardian', hour='$hour', min='$min', name='$name', " +
                "picture='$picture', weekdaysInfo='$weekdaysInfo')"
    }
}
