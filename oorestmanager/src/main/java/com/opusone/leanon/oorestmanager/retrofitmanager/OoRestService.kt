package com.opusone.leanon.oorestmanager.retrofitmanager

import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import retrofit2.Call
import retrofit2.http.*

interface OoRestService {
    @GET("hello")
    fun hello(): Call<OoResponse>

    @POST("auth/signin")
    fun postAuth(@Body authOoParam: OoParamPartnerAuth): Call<OoDataResponse<OoResponseAuth>>

    @POST("user/signin")
    fun postUserSignIn(@Header("authorization") authorization : String, @Body param: OoParamSigninUser): Call<OoDataResponse<OoResponseSigninUser>>

    @POST("user/create")
    fun createUser(@Header("authorization") authorization : String, @Body param: OoParamCreateUser): Call<OoDataResponse<OoResponseCreateUser>>

    @GET("user/read/{id}")
    fun readUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @GET("user/find/{email}")
    fun findUser(@Header("authorization") authorization : String, @Path("email") email: String): Call<OoDataResponse<OoResponseUser>>

    @PUT("user/update")
    fun updateUser(@Header("authorization") authorization : String, @Body param: OoUser): Call<OoDataResponse<OoResponseSigninUser>>

    @DELETE("user/delete/{id}")
    fun deleteUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @GET("weather/fineDust/{admin}/{locality}")
    fun fineDust(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseFineDust>>

    @GET("weather/weather/{admin}/{locality}")
    fun weather(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseWeather>>

    @POST("report/mmse")
    fun createMMSE(@Header("authorization") authorization : String, @Body param: OoParamMMSE): Call<OoResponse>

    @POST("report/appuse")
    fun createAppUseReport(@Header("authorization") authorization : String, @Body param: OoParamAppUseReport): Call<OoResponse>

    @POST("notification/message")
    fun message(@Header("authorization") authorization : String, @Body param: OoParamMessage): Call<OoResponse>

    @POST("notification/groupMessage")
    fun groupMessage(@Header("authorization") authorization : String, @Body param: OoParamMessage): Call<OoResponse>

    @POST("notification/requestGuardian")
    fun requestGuardian(@Header("authorization") authorization : String, @Body param: OoParamRequestGuardian): Call<OoResponse>

    @POST("notification/acceptGuardian")
    fun acceptGuardian(@Header("authorization") authorization : String, @Body param: OoParamAcceptGuardian): Call<OoResponse>

    @FormUrlEncoded
    @POST("voip/create")
    fun createChannel(@Header("authorization") authorization : String, @Field("toUserId") toUserId: String): Call<OoDataResponse<OoResponseCreateChannel>>

    @DELETE("voip/delete/{channelId}")
    fun deleteChannel(@Header("authorization") authorization : String, @Path("channelId") channelId: String): Call<OoResponse>

    @DELETE("voip/busy/{channelId}")
    fun voipBusy(@Header("authorization") authorization : String, @Path("channelId") channelId: String): Call<OoResponse>

    @GET("voip/turnurl/{roomId}")
    fun turnUrl(@Header("authorization") authorization : String, @Path("roomId") roomId: String): Call<OoDataResponse<OoResponseTurnUrl>>

    @POST("report/scale")
    fun scaleReport(@Header("authorization") authorization : String, @Body param: OoParamScale): Call<OoResponse>

}