package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoLocation(var userId: String? = null,
                 var geoCoding: String? = null,
                 var latitude: String? = null,
                 var longitude: String? = null,
                 var timestamp: String? = null): Serializable {

    override fun toString(): String {
        return "OoLocation (userId='$userId', geoCoding='$geoCoding', 'latitude=$latitude'," +
                " 'longitude=$longitude', 'timestamp=$timestamp')"
    }
}

class OoScale(var userId: String? = null,
              var weight: String? = null,
              var bmi: String? = null,
              var bmr: String? = null,
              var bodyFatRate: String? = null,
              var bodyWaterRate: String? = null,
              var boneMass: String? = null,
              var heartRate: String? = null,
              var muscleRate: String? = null,
              var subcutaneousFat: String? = null,
              var visceralFat: String? = null,
              var timestamp: String? = null): Serializable {

    override fun toString(): String {
        return "OoScale (userId='$userId', weight='$weight', 'bmi=$bmi', 'bmr=$bmr', " +
                "'bodyFatRate=$bodyFatRate', 'bodyWaterRate=$bodyWaterRate', " +
                "'boneMass=$boneMass', 'heartRate=$heartRate', 'muscleRate=$muscleRate', " +
                "'subcutaneousFat=$subcutaneousFat', 'visceralFat=$visceralFat', 'timestamp=$timestamp')"
    }
}


class OoMMSE(var userId: String? = null,
             var result: String? = null,
             var timestamp: String? = null): Serializable {

    override fun toString(): String {
        return "OoMMSE (userId='$userId', result='$result', 'timestamp=$timestamp')"
    }
}


class OoAppUse(var name: String? = null,
                    var runCount: String? = null): Serializable {

    override fun toString(): String {
        return "OoAppUse (name='$name', runCount='$runCount')"
    }
}

class OoAppRunCount(var userId: String? = null,
                    var report: List<OoAppUse>? = null,
                    var timestamp: String? = null): Serializable {

    override fun toString(): String {
        return "OoAppRunCount (report='$report')"
    }
}