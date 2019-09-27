package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRejectGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseGuardianList
import com.opusone.leanon.oorestmanager.response.data.OoResponseRequestGuardianList
import com.opusone.leanon.oorestmanager.response.data.OoResponseRequestSeniorList
import com.opusone.leanon.oorestmanager.response.data.OoResponseSeniorList
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceRelation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiRelation {
    fun requestGuardian(service: OoRestServiceRelation, param : OoParamRequestGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun acceptGuardian(service: OoRestServiceRelation, param : OoParamAcceptGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun rejectGuardian(service: OoRestServiceRelation, param: OoParamRejectGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.rejectGuardian(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("rejectGuardian Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getRequestSeniorList(service: OoRestServiceRelation, userToken: String, completion:(OoErrorResponse?, OoResponseRequestSeniorList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.requestSeniorList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseRequestSeniorList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRequestSeniorList>>, response: Response<OoDataResponse<OoResponseRequestSeniorList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRequestSeniorList>>, t: Throwable) {
                    OoRestManager.printError("getRequestSeniorList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getSeniorList(service: OoRestServiceRelation, userToken: String, completion:(OoErrorResponse?, OoResponseSeniorList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.seniorList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseSeniorList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseSeniorList>>, response: Response<OoDataResponse<OoResponseSeniorList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseSeniorList>>, t: Throwable) {
                    OoRestManager.printError("getSeniorList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getRequestGuardianList(service: OoRestServiceRelation, userToken: String, completion:(OoErrorResponse?, OoResponseRequestGuardianList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.requestGuardianList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseRequestGuardianList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRequestGuardianList>>, response: Response<OoDataResponse<OoResponseRequestGuardianList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRequestGuardianList>>, t: Throwable) {
                    OoRestManager.printError("getRequestGuardianList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getGuardianList(service: OoRestServiceRelation, userToken: String, completion:(OoErrorResponse?, OoResponseGuardianList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.guardianList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseGuardianList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseGuardianList>>, response: Response<OoDataResponse<OoResponseGuardianList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseGuardianList>>, t: Throwable) {
                    OoRestManager.printError("getGuardianList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}