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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiUser {

    fun signup(service: OoRestService, param : OoParamUserSignup, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
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

    fun signin(service: OoRestService, param : OoParamUserSignin, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
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

    fun signout(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun device(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponseUserDevice?) -> Unit) {
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

    fun read(service: OoRestService, id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
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

    fun find(service: OoRestService, email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
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

    fun update(service: OoRestService, param: OoUser, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
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

    fun delete(service: OoRestService, id : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
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

    fun getRequestSeniorList(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponseRequestSeniorList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.requestSeniorList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseRequestSeniorList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRequestSeniorList>>, response: Response<OoDataResponse<OoResponseRequestSeniorList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRequestSeniorList>>, t: Throwable) {
                    OoRestManager.printError("getRequestSeniorList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getSeniorList(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponseSeniorList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.seniorList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseSeniorList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseSeniorList>>, response: Response<OoDataResponse<OoResponseSeniorList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseSeniorList>>, t: Throwable) {
                    OoRestManager.printError("getSeniorList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getRequestGuardianList(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponseRequestGuardianList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.requestGuardianList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseRequestGuardianList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRequestGuardianList>>, response: Response<OoDataResponse<OoResponseRequestGuardianList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRequestGuardianList>>, t: Throwable) {
                    OoRestManager.printError("getRequestGuardianList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getGuardianList(service: OoRestService, userToken: String, completion:(OoErrorResponse?, OoResponseGuardianList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.guardianList(it, userToken).enqueue(object : Callback<OoDataResponse<OoResponseGuardianList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseGuardianList>>, response: Response<OoDataResponse<OoResponseGuardianList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.data.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseGuardianList>>, t: Throwable) {
                    OoRestManager.printError("getGuardianList. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}

