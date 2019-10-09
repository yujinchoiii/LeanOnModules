package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseFineDust
import com.opusone.leanon.oorestmanager.response.data.OoResponseWeather
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiWeahter {
    private val bearer = OoRestManager.bearerToken

    fun fineDust(service: OoRestServiceWeather, admin : String, locality: String, completion:(OoErrorResponse?, OoResponseFineDust?) -> Unit) {
        service.fineDust(bearer, admin, locality).enqueue(object :
            Callback<OoDataResponse<OoResponseFineDust>> {
            override fun onResponse(call: Call<OoDataResponse<OoResponseFineDust>>, response: Response<OoDataResponse<OoResponseFineDust>>) {
                if (response.isSuccessful) {
                    OoRestManager.printLog(response.body()?.data.toString())
                    completion(null, response.body()?.data)
                } else {
                    OoRestManager.printError(response.errorBody().toString())
                    completion(OoRestManager.parseError(response.errorBody()), null)
                }
            }
            override fun onFailure(call: Call<OoDataResponse<OoResponseFineDust>>, t: Throwable) {
                OoRestManager.printError("fineDust Failed. ${t.message}")
                completion(null, null)
            }
        })
    }

    fun weather(service: OoRestServiceWeather, admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseWeather?) -> Unit) {
        service.weather(bearer, admin, locality).enqueue(object : Callback<OoDataResponse<OoResponseWeather>> {
            override fun onResponse(call: Call<OoDataResponse<OoResponseWeather>>, response: Response<OoDataResponse<OoResponseWeather>>) {
                if (response.isSuccessful) {
                    OoRestManager.printLog(response.body()?.data.toString())
                    completion(null, response.body()?.data)
                } else {
                    OoRestManager.printError(response.errorBody().toString())
                    completion(OoRestManager.parseError(response.errorBody()), null)
                }
            }
            override fun onFailure(call: Call<OoDataResponse<OoResponseWeather>>, t: Throwable) {
                OoRestManager.printError("Weather Failed. ${t.message}")
                completion(null, null)
            }
        })
    }
}