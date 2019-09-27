package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.OoRestService
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceAccount
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiUser {

    fun signup(service: OoRestServiceAccount, param : OoParamUserSignup, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userSignup(it, param).enqueue(object : Callback<OoDataResponse<OoResponseUserSign>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUserSign>>, response: Response<OoDataResponse<OoResponseUserSign>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUserSign>>, t: Throwable) {
                    OoRestManager.printError("Create Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun signin(service: OoRestServiceAccount, param : OoParamUserSignin, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userSignin(it, param).enqueue(object : Callback<OoDataResponse<OoResponseUserSign>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUserSign>>, response: Response<OoDataResponse<OoResponseUserSign>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUserSign>>, t: Throwable) {
                    OoRestManager.printError("UserSignIn Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun signout(service: OoRestServiceAccount, userToken: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userSignout(it, userToken).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("signout Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun device(service: OoRestServiceAccount, userToken: String, completion:(OoErrorResponse?, OoResponseUserDevice?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userDevice(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseUserDevice>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUserDevice>>, response: Response<OoDataResponse<OoResponseUserDevice>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUserDevice>>, t: Throwable) {
                    OoRestManager.printError("signout Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun read(service: OoRestServiceAccount, id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.userRead(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
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

    fun find(service: OoRestServiceAccount, email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        OoRestManager.bearerToken?.let {
            service.userFind(it, email).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
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

    fun update(service: OoRestServiceAccount, param: OoUser, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userUpdate(it, param).enqueue(object : Callback<OoDataResponse<OoResponseUserSign>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUserSign>>, response: Response<OoDataResponse<OoResponseUserSign>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUserSign>>, t: Throwable) {
                    OoRestManager.printError("UpdateUserFailed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun delete(service: OoRestServiceAccount, id : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.userDelete(it, id).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("DeleteUser Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}


