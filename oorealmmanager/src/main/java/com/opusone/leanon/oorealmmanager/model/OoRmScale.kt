package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmScale : RealmObject() {
    var bmi: String? = null
    var bmr: String? = null
    var bodyFatRate: String? = null
    var bodyWaterRate: String? = null
    var boneMass: String? = null
    var heartRate: String? = null
    var muscleRate: String? = null
    var subcutaneousFat: String? = null
    var visceralFat: String? = null
    var weight: String? = null
}
