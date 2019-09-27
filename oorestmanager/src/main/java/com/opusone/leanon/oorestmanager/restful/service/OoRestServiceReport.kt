package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamAppUseReport
import com.opusone.leanon.oorestmanager.params.OoParamLocation
import com.opusone.leanon.oorestmanager.params.OoParamRegisterGreeting
import com.opusone.leanon.oorestmanager.params.OoParamScale
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseDailyReport
import com.opusone.leanon.oorestmanager.response.data.OoResponseLocation
import com.opusone.leanon.oorestmanager.response.data.OoResponseScale
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceReport {
    @POST("report/appuse")
    fun createAppUseReport(@Header("authorization") authorization : String, @Body param: OoParamAppUseReport): Call<OoResponse>

    @POST("report/scale")
    fun scaleReport(@Header("authorization") authorization : String, @Body param: OoParamScale): Call<OoResponse>

    @GET("report/scale/{userId}")
    fun getScaleReport(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseScale>>

    @POST("report/location")
    fun locationReport(@Header("authorization") authorization : String, @Body param: OoParamLocation): Call<OoResponse>

    @GET("report/location/{userId}")
    fun getLocation(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseLocation>>

    @POST("report/greeting")
    fun registerGreetingReminer(@Header("authorization") authorization : String, @Body param: OoParamRegisterGreeting): Call<OoResponse>

    @FormUrlEncoded
    @POST("report/greeted")
    fun resultGreetingReminer(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoResponse>

    @GET("report/daily/{userId}")
    fun getDaily(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseDailyReport>>

}