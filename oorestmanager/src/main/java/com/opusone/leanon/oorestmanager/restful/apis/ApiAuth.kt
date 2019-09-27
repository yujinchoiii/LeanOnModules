package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.OoParamPartnerAuth
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseAuth
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiAuth {
    fun auth(service: OoRestServiceAuth, param : OoParamPartnerAuth, completion: (OoErrorResponse?, OoResponseAuth?) -> Unit) {
        service.partnerAuth(param).enqueue(object : Callback<OoDataResponse<OoResponseAuth>> {
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