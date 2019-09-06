package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoMedication(
    var id: String?= null,
    var userId: String?= null,
    var guardian: String?= null,
    var alarmId: String?= null,
    var hour: String?= null,
    var min: String?= null,
    var name: String?= null,
    var picture: String?= null,
    var weekdaysInfo: String?= null) : Serializable {
    override fun toString(): String {
        return "OoMedication(id='$id', userId='$userId', guardian='$guardian' ,alarmId='$alarmId', " +
                "guardian='$guardian', hour='$hour', min='$min', name='$name', " +
                "picture='$picture', weekdaysInfo='$weekdaysInfo')"
    }
}