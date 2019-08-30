package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseCreateChannel
import com.opusone.leanon.oorestmanager.response.data.OoResponseTurnUrl
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import com.opusone.leanon.oorestmanager.params.OoParamCreateChannel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiVoip {
    fun create(service: OoRestService, param: OoParamCreateChannel, completion: (OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.createChannel(it, param).enqueue(object :
                Callback<OoDataResponse<OoResponseCreateChannel>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseCreateChannel>>, response: Response<OoDataResponse<OoResponseCreateChannel>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }

                override fun onFailure(call: Call<OoDataResponse<OoResponseCreateChannel>>, t: Throwable) {
                    OoRestManager.printError("createChannel Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun delete(service: OoRestService, channelId: String, caller: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.deleteChannel(it, channelId, caller).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("DeleteChannel Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun busy(service: OoRestService, channelId: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.voipBusy(it, channelId).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("VoipBusy Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun reject(service: OoRestService, channelId: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.voipReject(it, channelId).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("VoipReject Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun turnUrl(service: OoRestService, roomId: String, completion:(OoErrorResponse?, OoResponseTurnUrl?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.turnUrl(it, roomId).enqueue(object : Callback<OoDataResponse<OoResponseTurnUrl>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseTurnUrl>>, response: Response<OoDataResponse<OoResponseTurnUrl>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseTurnUrl>>, t: Throwable) {
                    OoRestManager.printError("turnUrl Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}