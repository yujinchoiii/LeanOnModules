package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.params.OoParamAcceptGuardian
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseDailyReport
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiRelation {
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

    fun acceptGuardian(service: OoRestService, param : OoParamAcceptGuardian, completion:(OoErrorResponse?, OoResponseDailyReport?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.acceptGuardian(it, param).enqueue(object : Callback<OoDataResponse<OoResponseDailyReport>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseDailyReport>>, response: Response<OoDataResponse<OoResponseDailyReport>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseDailyReport>>, t: Throwable) {
                    OoRestManager.printError("acceptGuardian Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun rejectGuardian(service: OoRestService, seniorId : String, guardianId: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.rejectGuardian(it, seniorId, guardianId).enqueue(object : Callback<OoResponse> {
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
}