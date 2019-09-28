package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamRegisterMedication(
    var userToken: String?= null,
    var seniorId: String?= null,
    var alarmId: String?= null,
    var name: String?= null,
    var picture: String?= null,
    var hour: String?= null,
    var min: String?= null,
    var weekdaysInfo: MutableList<Boolean>?= null) : Serializable {

    override fun toString(): String {
        return "OoParamRegisterMedication(userToken='$userToken', seniorId='$seniorId'" +
                ", alarmId='$alarmId', name='$name', picture='$picture', " +
                "hour='$hour', min='$min', weekdaysInfo='$weekdaysInfo')"
    }
}

class OoParamUpdateMedication(
    var userToken: String?= null,
    var seniorId: String?= null,
    var medicationId: String?= null,
    var alarmId: String?= null,
    var name: String?= null,
    var picture: String?= null,
    var hour: String?= null,
    var min: String?= null,
    var weekdaysInfo: MutableList<Boolean>?= null) : Serializable {

    override fun toString(): String {
        return "OoParamUpdateMedication(userToken='$userToken', seniorId='$seniorId' medicationId='$medicationId" +
                ", alarmId='$alarmId', name='$name', picture='$picture', " +
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