package com.opusone.oorestmanager.params

import java.io.Serializable

class OoParamMMSE(var userToken : String? = null,
                  val result: String? = null) : Serializable {

    override fun toString(): String {
        return "OoParamMMSE(userToken='$userToken', result='$result')"
    }
}

class OoParamAppUse(
    var name: String? = null,
    var diaplayName: String? = null,
    var packageName: String? = null,
    var link: String? = null,
    var version: String? = null,
    var category: String? = null,
    var runCount: String = "0") : Serializable {
    override fun toString(): String {
        return "OoAppUse(packageName='$packageName', runCount='$runCount')"
    }
}

class OoParamAppUseReport(var userToken: String? = null, var report: List<OoParamAppUse>) {
    override fun toString(): String {
        return "OoAppUseReport(userToken='$userToken', report='$report')"
    }
}
