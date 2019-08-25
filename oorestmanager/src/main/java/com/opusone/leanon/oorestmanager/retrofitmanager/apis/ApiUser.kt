package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.OoParamCreateUser
import com.opusone.leanon.oorestmanager.params.OoParamRequestGuardian
import com.opusone.leanon.oorestmanager.params.OoParamSigninUser
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseCreateUser
import com.opusone.leanon.oorestmanager.response.data.OoResponseSigninUser
import com.opusone.leanon.oorestmanager.response.data.OoResponseUser
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiUser {

    fun signin(service: OoRestService, param : OoParamSigninUser, completion:(OoErrorResponse?, OoResponseSigninUser?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.postUserSignIn(it, param).enqueue(object : Callback<OoDataResponse<OoResponseSigninUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseSigninUser>>, response: Response<OoDataResponse<OoResponseSigninUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseSigninUser>>, t: Throwable) {
                    OoRestManager.printError("UserSignIn Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun create(service: OoRestService, param : OoParamCreateUser, completion:(OoErrorResponse?, OoResponseCreateUser?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.createUser(it, param).enqueue(object : Callback<OoDataResponse<OoResponseCreateUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseCreateUser>>, response: Response<OoDataResponse<OoResponseCreateUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseCreateUser>>, t: Throwable) {
                    OoRestManager.printError("Create Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun read(service: OoRestService, id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.readUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    OoRestManager.printError("ReadUser Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun find(service: OoRestService, email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.findUser(it, email).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    OoRestManager.printError("FindUser Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun update(service: OoRestService, param: OoUser, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.updateUser(it, param).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    OoRestManager.printError("UpdateUserFailed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun delete(service: OoRestService, id : String, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.deleteUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    OoRestManager.printError("DeleteUser Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}

