package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamChat
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseChat
import com.opusone.leanon.oorestmanager.response.data.OoResponseRecentChatList
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceChat {
    @POST("chat/groupChat")
    fun groupChat(@Header("authorization") authorization : String, @Body param: OoParamChat): Call<OoDataResponse<OoResponseChat>>

    @GET("chat/recentGroupChat/{roomId}/{timestamp}")
    fun getRecentGroupChat(@Header("authorization") authorization : String, @Path("roomId") roomId: String, @Path("timestamp") timestamp: Long): Call<OoDataResponse<OoResponseRecentChatList>>

}