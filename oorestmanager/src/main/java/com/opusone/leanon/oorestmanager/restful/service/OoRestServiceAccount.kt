package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseUser
import com.opusone.leanon.oorestmanager.response.data.OoResponseUserDevice
import com.opusone.leanon.oorestmanager.response.data.OoResponseUserSign
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceAccount {
    @POST("account/signup")
    fun userSignup(@Header("authorization") authorization : String, @Body param: OoParamUserSignup): Call<OoDataResponse<OoResponseUserSign>>

    @POST("account/signin")
    fun userSignin(@Header("authorization") authorization : String, @Body param: OoParamUserSignin): Call<OoDataResponse<OoResponseUserSign>>

    @FormUrlEncoded
    @POST("account/signout")
    fun userSignout(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoResponse>

    @FormUrlEncoded
    @POST("account/device")
    fun userDevice(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoDataResponse<OoResponseUserDevice>>

    @GET("account/read/{id}")
    fun userRead(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoDataResponse<OoResponseUser>>

    @GET("account/find/{email}")
    fun userFind(@Header("authorization") authorization : String, @Path("email") email: String): Call<OoDataResponse<OoResponseUser>>

    @PUT("account/update")
    fun userUpdate(@Header("authorization") authorization : String, @Body param: OoUser): Call<OoDataResponse<OoResponseUserSign>>

    @DELETE("account/delete/{id}")
    fun userDelete(@Header("authorization") authorization : String, @Path("id") id: String): Call<OoResponse>
}