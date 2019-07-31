package com.opusone.leanon.restmanager.response.data

import com.opusone.leanon.restmanager.model.OoFineDust
import com.opusone.leanon.restmanager.model.OoWeather
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