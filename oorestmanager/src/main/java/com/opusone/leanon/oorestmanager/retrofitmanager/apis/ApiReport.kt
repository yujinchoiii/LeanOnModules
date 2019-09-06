package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.params.OoParamAppUseReport
import com.opusone.leanon.oorestmanager.params.OoParamLocation
import com.opusone.leanon.oorestmanager.params.OoParamMMSE
import com.opusone.leanon.oorestmanager.params.OoParamScale
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiReport {
    fun mmse(service: OoRestService, param: OoParamMMSE, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.createMMSE(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("createMMSE Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getMmse(service: OoRestService, userId : String, completion: (OoErrorResponse?, OoResponseMMSE?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.getMMSE(it, userId).enqueue(object : Callback<OoDataResponse<OoResponseMMSE>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMMSE>>, response: Response<OoDataResponse<OoResponseMMSE>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMMSE>>, t: Throwable) {
                    OoRestManager.printError("getMmse Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun appUse(service: OoRestService, param: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun scale(service: OoRestService, param: OoParamScale, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun getScale(service: OoRestService, userId : String, completion: (OoErrorResponse?, OoResponseScale?) -> Unit){
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

    fun location(service: OoRestService, param: OoParamLocation, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun getLocation(service: OoRestService, userId : String, completion: (OoErrorResponse?, OoResponseLocation?) -> Unit){
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

    fun getDaily(service: OoRestService, userId : String, completion: (OoErrorResponse?, OoResponseDailyReport?) -> Unit){
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
}