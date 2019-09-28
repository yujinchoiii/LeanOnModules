package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.OoParamRegisterMedication
import com.opusone.leanon.oorestmanager.params.OoParamResultMedication
import com.opusone.leanon.oorestmanager.params.OoParamUpdateMedication
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseMedications
import com.opusone.leanon.oorestmanager.response.data.OoResponseRegisterMedication
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceMedication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiMedication {

    fun registerMedication(service: OoRestServiceMedication, param: OoParamRegisterMedication, completion: (OoErrorResponse?, OoResponseRegisterMedication?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.registerMedicationReminder(it, param).enqueue(object : Callback<OoDataResponse<OoResponseRegisterMedication>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRegisterMedication>>, response: Response<OoDataResponse<OoResponseRegisterMedication>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRegisterMedication>>, t: Throwable) {
                    OoRestManager.printError("registerReminder Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun updateMedication(service: OoRestServiceMedication, param: OoParamUpdateMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.updateMedicationReminder(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("updateMedication Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun resultMedication(service: OoRestServiceMedication, param: OoParamResultMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
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


    fun getMedicationList(service: OoRestServiceMedication, seniorId: String, completion: (OoErrorResponse?, OoResponseMedications?) -> Unit) {
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

    fun deleteMedication(service: OoRestServiceMedication, seniorId: String, medicationId: String, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
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