package com.opusone.leanon.restmanager.RetrofitManager

import android.util.Log
import com.opusone.leanon.restmanager.model.*
import com.opusone.leanon.restmanager.params.OoParamCreateUser
import com.opusone.leanon.restmanager.params.OoParamPartnerAuth
import com.opusone.leanon.restmanager.params.OoParamSigninUser
import com.opusone.leanon.restmanager.response.OoDataResponse
import com.opusone.leanon.restmanager.response.OoErrorResponse
import com.opusone.leanon.restmanager.response.OoResponse
import com.opusone.leanon.restmanager.response.data.*
import com.opusone.oorestmanager.params.OoParamAppUseReport
import com.opusone.oorestmanager.params.OoParamMMSE
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object OoRestManager {
    private val TAG = "OoRestManager"

    private val PRODCUT_BASE_URL = "https://us-central1-leanontab.cloudfunctions.net"
    private val DEV_BASE_URL = "http://192.168.0.88:5000/leanontab/us-central1/"
    private val BASE_URL = PRODCUT_BASE_URL
    private var bearerToken: String? = null

    private lateinit var ooRestService : OoRestService
    private lateinit var retrofit : Retrofit
    private lateinit var errorConverter: Converter<ResponseBody, OoErrorResponse?>


    private fun parseError(response: ResponseBody?): OoErrorResponse? {
        var error: OoErrorResponse? = null
        response?.let {
            try {
                error = errorConverter.convert(it)
            } catch (e: IOException) {
                error = OoErrorResponse(null, null, null)
            }
        }
        return error
    }

    fun setBearerToken(token: String?) {
        bearerToken = "Bearer ${token ?: ""}"
    }

    fun retrofitInit() {
        retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        ooRestService = retrofit.create(OoRestService::class.java)
        errorConverter = OoRestManager.retrofit
            .responseBodyConverter<OoErrorResponse?>(OoErrorResponse::class.java, arrayOfNulls<Annotation>(0))
    }

    fun hello(completion: (OoResponse?) -> Unit) {
        ooRestService.hello().enqueue(object : Callback<OoResponse> {
            override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                completion(response.body())
            }
            override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                Log.d(TAG, "PartnerSignIn Failed")
                completion(null)
            }
        })
    }

    fun auth(param : OoParamPartnerAuth, completion: (OoErrorResponse?, OoResponseAuth?) -> Unit) {
        ooRestService.postAuth(param).enqueue(object : Callback<OoDataResponse<OoResponseAuth>> {
            override fun onResponse(call: Call<OoDataResponse<OoResponseAuth>>, response: Response<OoDataResponse<OoResponseAuth>>) {
                if (response.isSuccessful) {
                    completion(null, response.body()?.data)
                } else {
                    completion(parseError(response.errorBody()), null)
                }
            }
            override fun onFailure(call: Call<OoDataResponse<OoResponseAuth>>, t: Throwable) {
                Log.d(TAG, "PartnerSignIn Failed")
                completion(null, null)
            }
        })
    }

    fun signinUser(param : OoParamSigninUser, completion:(OoErrorResponse?, OoResponseSigninUser?) -> Unit) {
        bearerToken?.let {
            ooRestService.postUserSignIn(it, param).enqueue(object : Callback<OoDataResponse<OoResponseSigninUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseSigninUser>>, response: Response<OoDataResponse<OoResponseSigninUser>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseSigninUser>>, t: Throwable) {
                    Log.i(TAG, "UserSignIn Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun createUser(param : OoParamCreateUser, completion:(OoErrorResponse?, OoResponseCreateUser?) -> Unit) {
        bearerToken?.let {
            ooRestService.createUser(it, param).enqueue(object : Callback<OoDataResponse<OoResponseCreateUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseCreateUser>>, response: Response<OoDataResponse<OoResponseCreateUser>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseCreateUser>>, t: Throwable) {
                    Log.d(TAG, "Create Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun readUser(id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        bearerToken?.let {
            ooRestService.readUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    Log.d(TAG, "ReadUser Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun updateUser(param: OoUser, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        bearerToken?.let {
            ooRestService.updateUser(it, param).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    completion(null, null)
                    Log.d(TAG, "ReadUser Failed")
                }
            })
        }
    }

    fun deleteUser(id : String, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        bearerToken?.let {
            ooRestService.deleteUser(it, id).enqueue(object : Callback<OoDataResponse<OoResponseUser>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseUser>>, response: Response<OoDataResponse<OoResponseUser>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseUser>>, t: Throwable) {
                    completion(null, null)
                    Log.d(TAG, "ReadUser Failed")
                }
            })
        }
    }

    fun fineDust(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseFineDust?) -> Unit) {
        bearerToken?.let {
            ooRestService.fineDust(it, admin, locality).enqueue(object : Callback<OoDataResponse<OoResponseFineDust>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseFineDust>>, response: Response<OoDataResponse<OoResponseFineDust>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseFineDust>>, t: Throwable) {
                    Log.d(TAG, "fineDust Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun weather(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseWeather?) -> Unit) {
        bearerToken?.let {
            ooRestService.weather(it, admin, locality).enqueue(object : Callback<OoDataResponse<OoResponseWeather>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseWeather>>, response: Response<OoDataResponse<OoResponseWeather>>) {
                    if (response.isSuccessful) {
                        completion(null, response.body()?.data)
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseWeather>>, t: Throwable) {
                    Log.d(TAG, "fineDust Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun createMMSE(mmse: OoParamMMSE, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        bearerToken?.let {
            ooRestService.createMMSE(it, mmse).enqueue(object : Callback<OoResponse> {
                override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                    if (response.isSuccessful) {
                        completion(null, response.body())
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                    Log.d(TAG, "fineDust Failed")
                    completion(null, null)
                }
            })
        }
    }

    fun createAppUseReport(appUserReport: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        bearerToken?.let {
            ooRestService.createAppUseReport(it, appUserReport).enqueue(object : Callback<OoResponse> {
                override fun onResponse(call: Call<OoResponse>, response: Response<OoResponse>) {
                    if (response.isSuccessful) {
                        completion(null, response.body())
                    } else {
                        completion(parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                    Log.d(TAG, "fineDust Failed")
                    completion(null, null)
                }
            })
        }
    }
}

