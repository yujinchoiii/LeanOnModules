package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.response.OoResponse
import retrofit2.Call
import retrofit2.http.*

interface OoRestService {

    @GET("hello")
    fun hello(): Call<OoResponse>
}