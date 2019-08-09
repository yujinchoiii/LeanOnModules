package com.opusone.leanon.oorestmanager.RetrofitManager.apis

import com.opusone.leanon.restmanager.RetrofitManager.OoRestManager
import com.opusone.leanon.restmanager.RetrofitManager.OoRestService
import com.opusone.leanon.restmanager.params.OoParamPartnerAuth
import com.opusone.leanon.restmanager.response.OoDataResponse
import com.opusone.leanon.restmanager.response.OoErrorResponse
import com.opusone.leanon.restmanager.response.data.OoResponseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiAuth {
    fun auth(service: OoRestService, param : OoParamPartnerAuth, completion: (OoErrorResponse?, OoResponseAuth?) -> Unit) {
        service.postAuth(param).enqueue(object : Callback<OoDataResponse<OoResponseAuth>> {
            override fun onResponse(call: Call<OoDataResponse<OoResponseAuth>>, response: Response<OoDataResponse<OoResponseAuth>>) {
                if (response.isSuccessful) {
                    OoRestManager.printLog(response.body()?.data.toString())
                    completion(null, response.body()?.data)
                } else {
                    OoRestManager.printError(response.errorBody().toString())
                    completion(OoRestManager.parseError(response.errorBody()), null)
                }
            }
            override fun onFailure(call: Call<OoDataResponse<OoResponseAuth>>, t: Throwable) {
                OoRestManager.printError("PartnerSignIn Failed. ${t.message}")
                completion(null, null)
            }
        })
    }

}