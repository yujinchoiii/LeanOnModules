package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.*
import java.io.Serializable

class OoResponseLocation(val location: OoLocation) : Serializable {
    override fun toString(): String {
        return "OoResponseLocation(location=$location)"
    }
}

class OoResponseScale(val scale: OoScale) : Serializable {
    override fun toString(): String {
        return "OoResponseScale(scale=$scale)"
    }
}

class OoResponseMMSE(val mmse: OoMMSE) : Serializable {
    override fun toString(): String {
        return "OoResponseMMSE(mmse=$mmse)"
    }
}

class OoResponseDaily(val appRunCount: OoAppRunCount? = null,
                      val location: OoLocation? = null,
                      val medication: List<OoMedication>? = null,
                      val mmse: OoMMSE? = null,
                      val scale: OoScale? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseDaily(appRunCount=$appRunCount, location=$location, " +
                "medication=$medication, mmse=$mmse, scale=$scale)"
    }
}


class OoResponseDailyReport(val daily: OoResponseDaily? = null) : Serializable {

    override fun toString(): String {
        return "OoResponseDailyReport(daily=$daily"
    }
}

