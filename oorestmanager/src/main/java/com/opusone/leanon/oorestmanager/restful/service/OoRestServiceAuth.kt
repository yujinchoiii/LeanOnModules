package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface OoRestServiceAuth {
    @POST("auth/signin")
    fun partnerAuth(@Body authOoParam: OoParamPartnerAuth): Call<OoDataResponse<OoResponseAuth>>
}