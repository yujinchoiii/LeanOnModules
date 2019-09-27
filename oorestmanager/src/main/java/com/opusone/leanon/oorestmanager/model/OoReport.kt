package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoLocation(var geoCoding: String? = null,
                 var latitude: String? = null,
                 var longitude: String? = null): Serializable {

    override fun toString(): String {
        return "OoLocation (geoCoding='$geoCoding', 'latitude=$latitude'," +
                " 'longitude=$longitude')"
    }
}

class OoReportLocation(var location: OoLocation? = null, val timestamp: Long = 0): Serializable {
    override fun toString(): String {
        return "OoReportLocation (location='$location', 'timestamp=$timestamp')"
    }
}

class OoScale(var weight: String? = null,
              var bmi: String? = null,
              var bmr: String? = null,
              var bodyFatRate: String? = null,
              var bodyWaterRate: String? = null,
              var boneMass: String? = null,
              var heartRate: String? = null,
              var muscleRate: String? = null,
              var subcutaneousFat: String? = null,
              var visceralFat: String? = null): Serializable {

    override fun toString(): String {
        return "OoScale (weight='$weight', 'bmi=$bmi', 'bmr=$bmr', " +
                "'bodyFatRate=$bodyFatRate', 'bodyWaterRate=$bodyWaterRate', " +
                "'boneMass=$boneMass', 'heartRate=$heartRate', 'muscleRate=$muscleRate', " +
                "'subcutaneousFat=$subcutaneousFat', 'visceralFat=$visceralFat')"
    }
}

class OoReportSclae(val scale: OoScale? = null, val timestamp: Long = 0) {
    override fun toString(): String {
        return "OoReportSclae (scale='$scale', timestamp='$timestamp')"
    }
}

class OoBrainDoctor(var timespace: String? = null,
                    var name: String? = null,
                    var attention: String? = null,
                    var memory: String? = null,
                    var enforce: String? = null,
                    var speech: String? = null,
                    var compute: String? = null,
                    var sound: String? = null,
                    var bq: String? = null): Serializable {
    override fun toString(): String {
        return "OoBrainDoctor (timespace='$timespace', 'name=$name', " +
                "'attention=$attention', 'memory=$memory', 'enforce=$enforce', " +
                "'speech=$speech', 'compute=$compute', 'sound=$sound', 'bq=$bq')"
    }
}

class OoBrainDoctorDiagnosis(var result: OoBrainDoctor? = null, var timestamp: Long = 0) {
    override fun toString(): String {
        return "OoBrainDoctorDiagnosis (result='$result', timestamp='$timestamp')"
    }
}

class OoBrainDoctorDaily(var result: OoBrainDoctor? = null, var timestamp: Long = 0) {
    override fun toString(): String {
        return "OoBrainDoctorDaily (result='$result', timestamp='$timestamp')"
    }
}

class OoReportBrainDoctor(val diagnosis: OoBrainDoctorDiagnosis? = null, val daily: OoBrainDoctorDaily? = null) {
    override fun toString(): String {
        return "OoReportBrainDoctor (diagnosis='$diagnosis, daily='$daily'')"
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

class OoReportAppUse(var appUse: List<OoAppUse>? = null,
                     var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoReportAppUse (appUse='$appUse', timestamp='$timestamp')"
    }
}


class OoGreeting(var ampm: String? = null,
                 var hour: String? = null,
                 var minute: String? = null,
                 var message: String? = null,
                 var on: String? = null,
                 var greeted: String? = null): Serializable {

    override fun toString(): String {
        return "OoGreeting(ampm='$ampm', hour='$hour', minute='$minute', " +
                "message='$message', on='$on', greeted='$greeted')"
    }
}

class OoReportGreeting(var greeting: OoGreeting? = null,
                       var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoReportGreeting (greeting='$greeting', timestamp='$timestamp')"
    }
}