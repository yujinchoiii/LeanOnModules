package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamMessage
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseMessage
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiNotification {

    fun sendMessage(service: OoRestService, param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.message(it, param).enqueue(object : Callback<OoDataResponse<OoResponseMessage>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMessage>>, response: Response<OoDataResponse<OoResponseMessage>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMessage>>, t: Throwable) {
                    OoRestManager.printError("sendMessage Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun sendGroupMessage(service: OoRestService, param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.groupMessage(it, param).enqueue(object : Callback<OoDataResponse<OoResponseMessage>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMessage>>, response: Response<OoDataResponse<OoResponseMessage>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMessage>>, t: Throwable) {
                    OoRestManager.printError("sendGroupMessage Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun requestGuardian(service: OoRestService, param : OoParamRequestGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.requestGuardian(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("requestGuardian Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun acceptGuardian(service: OoRestService, param : OoParamAcceptGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.acceptGuardian(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("acceptGuardian Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}