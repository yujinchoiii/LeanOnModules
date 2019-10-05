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

    val assessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRoVG9rZW4iOiJleUpoYkdjaU9pSklVekkxTmlJc0luUjVjQ0k2SWtwWFZDSjkuZXlKcFpDSTZJa05VVWtGUFpFWmlabWRSYjFCNldqWnRSamxNSWl3aVpXMWhhV3dpT2lKa1pYWkFkR2hsYjNCMWMyOXVaUzVqYjIwaUxDSnVZVzFsSWpvaWIzQjFjMjl1WlNJc0luTm9ZV1J2ZHlJNkltUm1OV00yWTJVd1pEVXpZelkwT1daallURmtNVEJqT1RFMU16UmtNRGRtTnprMFlUYzVZVEJqTlRWaE1qWTBNbVpoTm1Zd05HVTBZVEpqTkRJeE4yRXlPV1l4TkRJNVpqQTFOMkkwWmpFMU5qazJORGxpWTJRME56TXlNamRrTVdZd1l6SXdOV0ZsTUdGbU9EVmxPVEF4TURVeU16QmhZMlkyTlRnM1pXTTBJaXdpWlhod2FYSmxJam9pTUNJc0ltbGhkQ0k2TVRVMk9USTVOakV3TjMwLmdtR1BlcTJFV3Y1UTJDMVRSQm5IbDRnVFhReEJGMDZ4blRFWHVTS1JONE0iLCJwYXJ0bmVySWQiOiJDVFJBT2RGYmZnUW9Qelo2bUY5TCIsImlhdCI6MTU2OTI5NjEwN30.VswXXj49no5YgCErUbmEawR7HuOwrMoSWAi2jmqCG6g"
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
                "userToken=$userToken, assessToken=$assessToken)"
    }
}

enum class OoLeanonDeviceType(val type: String) {
    UNKNOWN("0"),

    SENIOR_TABLET("1"),
    SENIOR_MOBILE("2"),

    GUARDIAN_TABLET("11"),
    GUARDIAN_MOBILE("12"),
}