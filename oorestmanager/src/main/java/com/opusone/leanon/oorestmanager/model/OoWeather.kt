package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoFineDust(
    var dataTime: String? = null,
    var o3Value: String? = null,
    var khaiValue: String? = null,
    var so2Value: String? = null,
    var resultMsg: String? = null,
    var sidoName: String? = null,
    var pm10Value: String? = null,
    var districtCode: String? = null,
    var searchCondition: String? = null,
    var districtNumSeq: String? = null,
    var no2Value: String? = null,
    var itemCode: String? = null,
    var resultCode: String? = null,
    var pm25Value: String? = null,
    var serviceKey: String? = null,
    var coValue: String? = null,
    var cityName: String? = null): Serializable {

    override fun toString(): String {
        return "OoFineDust(dataTime=$dataTime, o3Value=$o3Value, khaiValue=$khaiValue, so2Value=$so2Value, resultMsg=$resultMsg, " +
                "sidoName=$sidoName, pm10Value=$pm10Value, districtCode=$districtCode, searchCondition=$searchCondition) " +
                "districtNumSeq=$districtNumSeq, no2Value=$no2Value,  itemCode=$itemCode, resultCode=$resultCode, " +
                "pm25Value=$pm25Value, serviceKey=$serviceKey, coValue=$coValue, cityName=$cityName"
    }

}

class OoWeather(
    var date: String? = null,
    var time: String? = null,
    var temp: String? = null,
    var minTemp: String? = null,
    var maxTemp: String? = null,
    var sky: String? = null,
    var rain: String? = null,
    var sidoName: String? = null,
    var cityName: String? = null): Serializable {

    override fun toString(): String {
        return "OoWeather(date=$date, time=$time, temp=$temp, minTemp=$minTemp, maxTemp=$maxTemp, sky=$sky, rain=$rain sidoName=$sidoName, cityName=$cityName"
    }
}