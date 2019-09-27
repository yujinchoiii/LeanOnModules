package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.OoRestService
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceReport
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiReport {
    fun appUse(service: OoRestServiceReport, param: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.createAppUseReport(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("createAppUseReport Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun scale(service: OoRestServiceReport, param: OoParamScale, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.scaleReport(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("scaleReport Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getScale(service: OoRestServiceReport, userId : String, completion: (OoErrorResponse?, OoResponseScale?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.getScaleReport(it, userId).enqueue(object : Callback<OoDataResponse<OoResponseScale>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseScale>>, response: Response<OoDataResponse<OoResponseScale>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseScale>>, t: Throwable) {
                    OoRestManager.printError("getScale Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun location(service: OoRestServiceReport, param: OoParamLocation, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.locationReport(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("locationReport Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getLocation(service: OoRestServiceReport, userId : String, completion: (OoErrorResponse?, OoResponseLocation?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.getLocation(it, userId).enqueue(object : Callback<OoDataResponse<OoResponseLocation>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseLocation>>, response: Response<OoDataResponse<OoResponseLocation>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseLocation>>, t: Throwable) {
                    OoRestManager.printError("getLocation Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getDaily(service: OoRestServiceReport, userId : String, completion: (OoErrorResponse?, OoResponseDailyReport?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.getDaily(it, userId).enqueue(object : Callback<OoDataResponse<OoResponseDailyReport>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseDailyReport>>, response: Response<OoDataResponse<OoResponseDailyReport>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseDailyReport>>, t: Throwable) {
                    OoRestManager.printError("getDaily Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun registerGreeting(service: OoRestServiceReport, param: OoParamRegisterGreeting, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.registerGreetingReminer(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("registerGreeting Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun resultGreeting(service: OoRestServiceReport, userToken: String, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.resultGreetingReminer(it, userToken).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("resultGreeting Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}