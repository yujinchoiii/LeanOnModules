package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseFineDust
import com.opusone.leanon.oorestmanager.response.data.OoResponseWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface OoRestServiceWeather {
    @GET("weather/fineDust/{admin}/{locality}")
    fun fineDust(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseFineDust>>

    @GET("weather/weather/{admin}/{locality}")
    fun weather(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseWeather>>
}