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

//    @POST("user/signin")
//    fun postUserSignIn(@Header("authorization") authorization : String, @Body param: OoParamSigninUser): Call<OoDataResponse<OoResponseSigninUser>>
//
//    @POST("user/create")
//    fun createUser(@Header("authorization") authorization : String, @Body param: OoParamCreateUser): Call<OoDataResponse<OoResponseCreateUser>>
//
//    @GET("user/read/{id}")
//    fun readUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>
//
//    @GET("user/find/{email}")
//    fun findUser(@Header("authorization") authorization : String, @Path("email") email: String): Call<OoDataResponse<OoResponseUser>>
//
//    @PUT("user/update")
//    fun updateUser(@Header("authorization") authorization : String, @Body param: OoUser): Call<OoDataResponse<OoResponseSigninUser>>
//
//    @DELETE("user/delete/{id}")
//    fun deleteUser(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @GET("weather/fineDust/{admin}/{locality}")
    fun fineDust(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseFineDust>>

    @GET("weather/weather/{admin}/{locality}")
    fun weather(@Header("authorization") authorization : String, @Path("admin") admin: String, @Path("locality") locality: String): Call<OoDataResponse<OoResponseWeather>>

    @POST("report/mmse")
    fun createMMSE(@Header("authorization") authorization : String, @Body param: OoParamMMSE): Call<OoResponse>

    @GET("report/mmse/{userId}")
    fun getMMSE(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseMMSE>>

    @POST("report/appuse")
    fun createAppUseReport(@Header("authorization") authorization : String, @Body param: OoParamAppUseReport): Call<OoResponse>

    @POST("chat/message")
    fun message(@Header("authorization") authorization : String, @Body param: OoParamMessage): Call<OoDataResponse<OoResponseMessage>>

    @POST("chat/groupMessage")
    fun groupMessage(@Header("authorization") authorization : String, @Body param: OoParamMessage): Call<OoDataResponse<OoResponseMessage>>

    @POST("chat/groupChat")
    fun groupChat(@Header("authorization") authorization : String, @Body param: OoParamChat): Call<OoDataResponse<OoResponseChat>>

    @GET("chat/recentGroupChat/{roomId}/{timestamp}")
    fun getRecentGroupChat(@Header("authorization") authorization : String, @Path("roomId") roomId: String, @Path("timestamp") timestamp: String): Call<OoDataResponse<OoResponseRecentChatList>>

    @POST("relation/request")
    fun requestGuardian(@Header("authorization") authorization : String, @Body param: OoParamRequestGuardian): Call<OoResponse>

    @POST("relation/accept")
    fun acceptGuardian(@Header("authorization") authorization : String, @Body param: OoParamAcceptGuardian): Call<OoDataResponse<OoResponseDailyReport>>

    @DELETE("relation/reject/{senior}/{guardian}")
    fun rejectGuardian(@Header("authorization") authorization : String, @Path("senior") senior: String, @Path("guardian") guardian: String): Call<OoResponse>

    @POST("voip/create")
    fun createChannel(@Header("authorization") authorization : String, @Body param: OoParamCreateChannel): Call<OoDataResponse<OoResponseCreateChannel>>

    @GET("voip/read/{id}")
    fun readChannel(@Header("authorization") authorization : String, @Path("id") channelId: String): Call<OoDataResponse<OoResponseCreateChannel>>

    @DELETE("voip/delete/{channelId}/{caller}")
    fun deleteChannel(@Header("authorization") authorization : String, @Path("channelId") channelId: String, @Path("caller") caller: String): Call<OoResponse>

    @DELETE("voip/busy/{channelId}")
    fun voipBusy(@Header("authorization") authorization : String, @Path("channelId") channelId: String): Call<OoResponse>

    @DELETE("voip/reject/{channelId}")
    fun voipReject(@Header("authorization") authorization : String, @Path("channelId") channelId: String): Call<OoResponse>

    @GET("voip/turnurl/{roomId}")
    fun turnUrl(@Header("authorization") authorization : String, @Path("roomId") roomId: String): Call<OoDataResponse<OoResponseTurnUrl>>

    @POST("report/scale")
    fun scaleReport(@Header("authorization") authorization : String, @Body param: OoParamScale): Call<OoResponse>

    @GET("report/scale/{userId}")
    fun getScaleReport(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseScale>>

    @POST("report/location")
    fun locationReport(@Header("authorization") authorization : String, @Body param: OoParamLocation): Call<OoResponse>

    @GET("report/location/{userId}")
    fun getLocation(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseLocation>>

    @POST("medication/reminder/register")
    fun registerMedicationReminder(@Header("authorization") authorization : String, @Body param: OoParamRegisterMedication): Call<OoResponse>

    @POST("medication/reminder/result")
    fun resultMedicationReminder(@Header("authorization") authorization : String, @Body param: OoParamResultMedication): Call<OoResponse>

    @GET("medication/reminder/list/{seniorId}")
    fun getMedications(@Header("authorization") authorization : String, @Path("seniorId") seniorId: String): Call<OoDataResponse<OoResponseMedications>>

    @DELETE("medication/reminder/delete/{seniorId}/{medicationId}")
    fun deleteMedication(@Header("authorization") authorization : String, @Path("seniorId") seniorId: String, @Path("medicationId") medicationId: String): Call<OoResponse>

    @GET("report/daily/{userId}")
    fun getDaily(@Header("authorization") authorization : String, @Path("userId") userId: String): Call<OoDataResponse<OoResponseDailyReport>>


    //V2
    @POST("account/signup")
    fun userSignup(@Header("authorization") authorization : String, @Body param: OoParamUserSignup): Call<OoDataResponse<OoResponseUserSign>>

    @POST("account/signin")
    fun userSignin(@Header("authorization") authorization : String, @Body param: OoParamUserSignin): Call<OoDataResponse<OoResponseUserSign>>

    @POST("account/signout")
    fun userSignout(@Header("authorization") authorization : String,  @Field("usetToken") usetToken: String): Call<OoResponse>
}