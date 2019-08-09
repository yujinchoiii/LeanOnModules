package com.opusone.leanon.oorestmanager.RetrofitManager.apis

import com.opusone.leanon.restmanager.RetrofitManager.OoRestManager
import com.opusone.leanon.restmanager.RetrofitManager.OoRestService
import com.opusone.leanon.restmanager.response.OoErrorResponse
import com.opusone.leanon.restmanager.response.OoResponse
import com.opusone.oorestmanager.params.OoParamAppUseReport
import com.opusone.oorestmanager.params.OoParamMMSE
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
}