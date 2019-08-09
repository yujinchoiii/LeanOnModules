package com.opusone.leanon.oorestmanager.RetrofitManager.apis

import com.opusone.leanon.oorestmanager.params.OoParamMessage
import com.opusone.leanon.restmanager.RetrofitManager.OoRestManager
import com.opusone.leanon.restmanager.RetrofitManager.OoRestService
import com.opusone.leanon.restmanager.response.OoErrorResponse
import com.opusone.leanon.restmanager.response.OoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiNotification {

    fun sendMessage(service: OoRestService, param: OoParamMessage, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.message(it, param).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("sendMessage Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}