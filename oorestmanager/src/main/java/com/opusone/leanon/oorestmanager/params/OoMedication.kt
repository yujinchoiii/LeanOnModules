package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamRegisterMedication(
    var userToken: String?= null,
    var seniorId: String?= null,
    var alarmId: String?= null,
    var alarmName: String?= null,
    var picture: String?= null,
    var hour: String?= null,
    var min: String?= null,
    var weekdaysInfo: String?= null) : Serializable {

    override fun toString(): String {
        return "OoParamRegisterMedication(userToken='$userToken', seniorId='$seniorId'" +
                ", alarmId='$alarmId', alarmName='$alarmName', picture='$picture', " +
                "hour='$hour', min='$min', weekdaysInfo='$weekdaysInfo')"
    }
}

class OoParamResultMedication(
    var userToken: String?= null,
    var medicationId: String?= null,
    var isTaken: String?= null) : Serializable {

    override fun toString(): String {
        return "OoParamResultMedication(userToken='$userToken', " +
                "medicationId='$medicationId', isTaken='$isTaken'"
    }
}