package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmScale : RealmObject() {
    var bmi: String? = null                 //bmi
    var bmr: String? = null                 //기초대사량
    var bodyFatRate: String? = null         //체지방
    var bodyWaterRate: String? = null       //체수분
    var boneMass: String? = null            //뼈무게
    var heartRate: String? = null           //심박수
    var muscleRate: String? = null          //근육량
    var subcutaneousFat: String? = null     //피하지방
    var visceralFat: String? = null         //내장지방
    var weight: String? = null              //몸부게

    var bodyAge: String? = null             //신체나이
    var bodyShape: String? = null           //체형
    var protein: String? = null             //단백질
    var mucsleMass: String? = null          //골근격량?
    var lbm: String? = null                 //무지방 체중

    var timestamp: Long = 0
}
