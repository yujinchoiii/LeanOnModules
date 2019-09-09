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


class OoBrainDoctor(var userId: String? = null,
                    var timespace: String? = null,
                    var name: String? = null,
                    var type: String? = null,
                    var attention: String? = null,
                    var memory: String? = null,
                    var enforce: String? = null,
                    var speech: String? = null,
                    var compute: String? = null,
                    var sound: String? = null,
                    var bq: String? = null): Serializable {

    override fun toString(): String {
        return "OoBrainDoctor (userId='$userId', timespace='$timespace', 'name=$name', " +
                "'type=$type', 'attention=$attention', 'memory=$memory', 'enforce=$enforce', " +
                "'speech=$speech', 'compute=$compute', 'sound=$sound', 'bq=$bq')"
    }
}

class OoAppUse(var name: String? = null,
               var diaplayName: String? = null,
               var packageName: String? = null,
               var link: String? = null,
               var version: String? = null,
               var category: String? = null,
               var runCount: String? = null): Serializable {

    override fun toString(): String {
        return "OoAppUse(name='$name', diaplayName='$diaplayName', packageName='$packageName', " +
                "link='$link', version='$version', category='$category', runCount='$runCount')"
    }
}

class OoAppRunCount(var userId: String? = null,
                    var report: List<OoAppUse>? = null,
                    var timestamp: String? = null): Serializable {

    override fun toString(): String {
        return "OoAppRunCount (report='$report')"
    }
}