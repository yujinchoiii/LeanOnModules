package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.params.OoParamRegisterMedication
import com.opusone.leanon.oorestmanager.params.OoParamResultMedication
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseMedications
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiMedication {

    fun registerMedication(service: OoRestService, param: OoParamRegisterMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.registerMedicationReminder(it, param).enqueue(object : Callback<OoResponse> {
                override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body())
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                    OoRestManager.printError("registerReminder Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun resultMedication(service: OoRestService, param: OoParamResultMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.resultMedicationReminder(it, param).enqueue(object : Callback<OoResponse> {
                override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body())
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                    OoRestManager.printError("resultReminder Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }


    fun getMedicationList(service: OoRestService, seniorId: String, completion: (OoErrorResponse?, OoResponseMedications?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.getMedications(it, seniorId).enqueue(object : Callback<OoDataResponse<OoResponseMedications>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMedications>>, response: Response<OoDataResponse<OoResponseMedications>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMedications>>, t: Throwable) {
                    OoRestManager.printError("getMedicationList Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun deleteMedication(service: OoRestService, seniorId: String, medicationId: String, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.deleteMedication(it, seniorId, medicationId).enqueue(object : Callback<OoResponse> {
                override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body())
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                    OoRestManager.printError("deleteMedication Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}