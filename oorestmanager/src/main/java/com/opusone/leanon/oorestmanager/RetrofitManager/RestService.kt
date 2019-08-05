package com.opusone.leanon.restmanager.RetrofitManager

import com.opusone.leanon.restmanager.model.*
import com.opusone.leanon.restmanager.params.OoParamCreateUser
import com.opusone.leanon.restmanager.params.OoParamPartnerAuth
import com.opusone.leanon.restmanager.params.OoParamSigninUser
import com.opusone.leanon.restmanager.response.OoDataResponse
import com.opusone.leanon.restmanager.response.OoResponse
import com.opusone.leanon.restmanager.response.data.*
import com.opusone.oorestmanager.params.OoParamAppUseReport
import com.opusone.oorestmanager.params.OoParamMMSE
import retrofit2.Call
import retrofit2.http.*

interface RestService {
    @GET("hello")
    fun hello(): Call<OoResponse>

    @POST("auth/signin")
    fun postAuth(@Body authOoParam: OoParamPartnerAuth): Call<OoDataResponse<OoResponseAuth>>

    @POST("user/signin")
    fun postUserSignIn(@Header("authorization") authorization : String, @Body auth: OoParamSigninUser): Call<OoDataResponse<OoResponseSigninUser>>

    @POST("user/create")
    fun createUser(@Header("authorization") authorization : String, @Body user: OoParamCreateUser): Call<OoDataResponse<OoResponseCreateUser>>

    @GET("user/read/{id}")
    fun readUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @PUT("user/update")
    fun updateUser(@Header("authorization") authorization : String, @Body user: OoUser): Call<OoDataResponse<OoResponseUser>>

    @DELETE("user/delete/{id}")
    fun deleteUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @GET("weather/fineDust/{admin}/{locality}")
    fun fineDust(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseFineDust>>

    @GET("weather/weather/{admin}/{locality}")
    fun weather(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseWeather>>

    @POST("report/mmse")
    fun createMMSE(@Header("authorization") authorization : String, @Body mmse: OoParamMMSE): Call<OoResponse>

    @POST("report/appuse")
    fun createAppUseReport(@Header("authorization") authorization : String, @Body appUseRepot: OoParamAppUseReport): Call<OoResponse>
}