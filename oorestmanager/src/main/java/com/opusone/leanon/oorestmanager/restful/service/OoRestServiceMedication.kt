package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamRegisterMedication
import com.opusone.leanon.oorestmanager.params.OoParamResultMedication
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseMedications
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceMedication {
    @POST("medication/reminder/register")
    fun registerMedicationReminder(@Header("authorization") authorization : String, @Body param: OoParamRegisterMedication): Call<OoResponse>

    @POST("medication/reminder/result")
    fun resultMedicationReminder(@Header("authorization") authorization : String, @Body param: OoParamResultMedication): Call<OoResponse>

    @GET("medication/reminder/list/{seniorId}")
    fun getMedications(@Header("authorization") authorization : String, @Path("seniorId") seniorId: String): Call<OoDataResponse<OoResponseMedications>>

    @DELETE("medication/reminder/delete/{seniorId}/{medicationId}")
    fun deleteMedication(@Header("authorization") authorization : String, @Path("seniorId") seniorId: String, @Path("medicationId") medicationId: String): Call<OoResponse>
}