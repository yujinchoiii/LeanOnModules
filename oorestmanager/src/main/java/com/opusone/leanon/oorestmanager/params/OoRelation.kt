package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamRequestGuardian(var userToken: String?= null, var seniorId: String?= null) :
    Serializable {
    override fun toString(): String {
        return "OoParamRequestGuardian(userToken='$userToken', seniorId='$seniorId')"
    }
}

class OoParamAcceptGuardian(var userToken: String?= null, var guardianId: String?= null) :
    Serializable {
    override fun toString(): String {
        return "OoParamRequestGuardian(userToken='$userToken', guardianId='$guardianId')"
    }
}
class OoParamRejectGuardian(var userToken: String?= null, var guardianId: String?= null) :
    Serializable {
    override fun toString(): String {
        return "OoParamRejectGuardian(userToken='$userToken', guardianId='$guardianId')"
    }
}
