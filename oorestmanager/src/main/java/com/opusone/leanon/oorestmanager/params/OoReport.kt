package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamMMSE(var userToken : String? = null,
                  val result: String? = null) : Serializable {

    override fun toString(): String {
        return "OoParamMMSE(userToken='$userToken', result='$result')"
    }
}

class OoParamAppUse(
    var name: String? = null,
    var displayName: String? = null,
    var packageName: String? = null,
    var link: String? = null,
    var version: String? = null,
    var category: String? = null,
    var runCount: String = "0") : Serializable {

    override fun toString(): String {
        return "OoParamAppUse(name='$name', displayName='$displayName', packageName='$packageName', " +
                "link='$link', version='$version', category='$category', runCount='$runCount')"
    }
}

class OoParamAppUseReport(var userToken: String? = null, var appUse: List<OoParamAppUse>) {
    override fun toString(): String {
        return "OoAppUseReport(userToken='$userToken', appUse='$appUse')"
    }
}

class OoParamScale(
    var userToken : String? = null,
    var weight: String? = null,
    var bmi: String? = null,
    var bodyFatRate: String? = null,
    var subcutaneousFat: String? = null,
    var visceralFat: String? = null,
    var bodyWaterRate: String? = null,
    var muscleRate: String? = null,
    var boneMass: String? = null,
    var bmr: String? = null,
    var heartRate: String? = null) : Serializable {
    override fun toString(): String {
        return "OoAppUse(userToken='$userToken', weight='$weight', bmi='$bmi', bodyFatRate='$bodyFatRate'" +
                ", subcutaneousFat='$subcutaneousFat', visceralFat='$visceralFat', bodyWaterRate='$bodyWaterRate'" +
                ", muscleRate='$muscleRate', boneMass='$boneMass', bmr='$bmr', heartRate='$heartRate')"
    }
}


class OoParamLocation(var userToken: String? = null,
                      var geoCoding: String? = null,
                      var latitude: String? = null,
                      var longitude: String? = null) : Serializable {
    override fun toString(): String {
        return "OoParamLocation(userToken='$userToken', geoCoding='$geoCoding', latitude='$latitude', longitude='$longitude'"
    }
}


class OoParamRegisterGreeting(
    var userToken: String? = null,
    var seniorId: String? = null,
    var hour: String? = null,
    var minute: String? = null,
    var ampm: String? = null,
    var message: String? = null,
    var on: String? = null) : Serializable {

    override fun toString(): String {
        return "OoParamRegisterGreeting(userToken='$userToken', seniorId='$seniorId', " +
                "hour='$hour', minute='$minute', ampm='$ampm', message='$message', on='$on')"
    }
}