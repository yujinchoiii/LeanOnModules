package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoFineDust
import com.opusone.leanon.oorestmanager.model.OoWeather
import java.io.Serializable

class OoResponseFineDust(val fineDust: OoFineDust?) : Serializable {
    override fun toString(): String {
        return "OoResponseFineDust(fineDust=$fineDust)"
    }
}

class OoResponseWeather(val weather: OoWeather?) : Serializable {
    override fun toString(): String {
        return "OoResponseFineDust(weather=$weather)"
    }
}