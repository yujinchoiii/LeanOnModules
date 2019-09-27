package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamCreateChannel
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseCreateChannel
import com.opusone.leanon.oorestmanager.response.data.OoResponseTurnUrl
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceVOIP {
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
}