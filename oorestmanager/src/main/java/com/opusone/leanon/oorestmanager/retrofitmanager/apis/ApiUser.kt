package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.OoParamUserSignin
import com.opusone.leanon.oorestmanager.params.OoParamUserSignup
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseUser
import com.opusone.leanon.oorestmanager.response.data.OoResponseUserSign
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
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

//    fun read(service: OoRestService, id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
//        OoRestManager.bearerToken?.let {
//            service.readUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
//                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
//                    if (response.isSuccessful) {
//                        OoRestManager.printLog(response.body()?.data.toString())
//                        completion(null, response.body()?.data)
//                    } else {
//                        OoRestManager.printError(response.errorBody().toString())
//                        completion(OoRestManager.parseError(response.errorBody()), null)
//                    }
//                }
//                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
//                    OoRestManager.printError("ReadUser Failed. ${t.message}")
//                    completion(null, null)
//                }
//            })
//        }
//    }
//
//    fun find(service: OoRestService, email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
//        OoRestManager.bearerToken?.let {
//            service.findUser(it, email).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
//                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
//                    if (response.isSuccessful) {
//                        OoRestManager.printLog(response.body()?.data.toString())
//                        completion(null, response.body()?.data)
//                    } else {
//                        OoRestManager.printError(response.errorBody().toString())
//                        completion(OoRestManager.parseError(response.errorBody()), null)
//                    }
//                }
//                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
//                    OoRestManager.printError("FindUser Failed. ${t.message}")
//                    completion(null, null)
//                }
//            })
//        }
//    }
//
//    fun update(service: OoRestService, param: OoUser, completion:(OoErrorResponse?, OoResponseSigninUser?) -> Unit) {
//        OoRestManager.bearerToken?.let {
//            service.updateUser(it, param).enqueue(object : Callback<OoDataResponse<OoResponseSigninUser>> {
//                override fun onResponse(call: Call<OoDataResponse<OoResponseSigninUser>>, response: Response<OoDataResponse<OoResponseSigninUser>>) {
//                    if (response.isSuccessful) {
//                        OoRestManager.printLog(response.body()?.data.toString())
//                        completion(null, response.body()?.data)
//                    } else {
//                        OoRestManager.printError(response.errorBody().toString())
//                        completion(OoRestManager.parseError(response.errorBody()), null)
//                    }
//                }
//                override fun onFailure(call: Call<OoDataResponse<OoResponseSigninUser>>, t: Throwable) {
//                    OoRestManager.printError("UpdateUserFailed. ${t.message}")
//                    completion(null, null)
//                }
//            })
//        }
//    }
//
//    fun delete(service: OoRestService, id : String, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
//        OoRestManager.bearerToken?.let {
//            service.deleteUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
//                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
//                    if (response.isSuccessful) {
//                        OoRestManager.printLog(response.body()?.data.toString())
//                        completion(null, response.body()?.data)
//                    } else {
//                        OoRestManager.printError(response.errorBody().toString())
//                        completion(OoRestManager.parseError(response.errorBody()), null)
//                    }
//                }
//                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
//                    OoRestManager.printError("DeleteUser Failed. ${t.message}")
//                    completion(null, null)
//                }
//            })
//        }
//    }
}

