package com.opusone.leanon.oorestmanager.restful

import android.os.Build
import com.opusone.leanon.oorestmanager.model.OoUser

object OoLeanOnDevice {
    var type = OoLeanonDeviceType.UNKNOWN.type
    var deviceToken = ""
    var nationalCode = ""

    var userId = ""
    var userToken = ""
    var user: OoUser? = null

    val os = "android"
    val model = "${Build.BRAND}, ${Build.MODEL}"
    val version = Build.VERSION.RELEASE

    fun clear() {
        nationalCode = ""

        userId = ""
        userToken = ""
        user = null
    }

    override fun toString(): String {
        return "OoLeanOnDevice (type=$type, deviceToken =$deviceToken , nationalCode=$nationalCode, " +
                "os=$os, model=$model, version=$version, userId=$userId, user=$user" +
                "userToken=$userToken"
    }
}

enum class OoLeanonDeviceType(val type: String) {
    UNKNOWN("0"),

    SENIOR_TABLET("1"),
    SENIOR_MOBILE("2"),

    GUARDIAN_TABLET("11"),
    GUARDIAN_MOBILE("12"),
}