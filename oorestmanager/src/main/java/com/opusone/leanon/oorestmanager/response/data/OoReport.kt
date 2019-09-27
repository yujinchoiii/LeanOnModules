package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.*
import java.io.Serializable

class OoResponseLocation(val location: OoReportLocation) : Serializable {
    override fun toString(): String {
        return "OoResponseLocation(location=$location)"
    }
}

class OoResponseScale(val scale: OoReportSclae? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseScale(scale=$scale)"
    }
}

class OoResponseDaily(val appUse: OoReportAppUse? = null,
                      val location: OoReportLocation? = null,
                      val brainDoctor: OoReportBrainDoctor? = null,
                      val scale: OoReportSclae? = null,
                      val greeting: OoReportGreeting? = null,
                      val medication: List<OoMedication>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseDaily(appUse=$appUse, location=$location, brainDoctor=$brainDoctor, " +
                "greeting=$greeting, medication=$medication, scale=$scale)"
    }
}


class OoResponseDailyReport(val daily: OoResponseDaily? = null) : Serializable {

    override fun toString(): String {
        return "OoResponseDailyReport(daily=$daily"
    }
}

