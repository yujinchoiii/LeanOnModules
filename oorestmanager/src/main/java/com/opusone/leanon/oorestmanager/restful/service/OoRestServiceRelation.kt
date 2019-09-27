package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRejectGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseGuardianList
import com.opusone.leanon.oorestmanager.response.data.OoResponseRequestGuardianList
import com.opusone.leanon.oorestmanager.response.data.OoResponseRequestSeniorList
import com.opusone.leanon.oorestmanager.response.data.OoResponseSeniorList
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceRelation {
    @POST("relation/request")
    fun requestGuardian(@Header("authorization") authorization : String, @Body param: OoParamRequestGuardian): Call<OoResponse>

    @POST("relation/accept")
    fun acceptGuardian(@Header("authorization") authorization : String, @Body param: OoParamAcceptGuardian): Call<OoResponse>

    @POST("relation/reject")
    fun rejectGuardian(@Header("authorization") authorization : String, @Body param: OoParamRejectGuardian): Call<OoResponse>

    @FormUrlEncoded
    @POST("relation/requestSeniorList")
    fun requestSeniorList(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoDataResponse<OoResponseRequestSeniorList>>

    @FormUrlEncoded
    @POST("relation/seniorList")
    fun seniorList(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoDataResponse<OoResponseSeniorList>>

    @FormUrlEncoded
    @POST("relation/requestGuardianList")
    fun requestGuardianList(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoDataResponse<OoResponseRequestGuardianList>>

    @FormUrlEncoded
    @POST("relation/guardianList")
    fun guardianList(@Header("authorization") authorization : String, @Field("userToken") userToken: String): Call<OoDataResponse<OoResponseGuardianList>>
}