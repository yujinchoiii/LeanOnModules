package com.opusone.leanon.restmanager.RetrofitManager

import android.util.Log
import com.opusone.leanon.oorestmanager.RetrofitManager.apis.*
import com.opusone.leanon.oorestmanager.params.OoParamMessage
import com.opusone.leanon.oorestmanager.response.data.OoResponseCreateChannel
import com.opusone.leanon.oorestmanager.response.data.OoResponseTurnUrl
import com.opusone.leanon.restmanager.model.*
import com.opusone.leanon.restmanager.params.OoParamCreateUser
import com.opusone.leanon.restmanager.params.OoParamPartnerAuth
import com.opusone.leanon.restmanager.params.OoParamSigninUser
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
    internal val TAG = "OoRestManager"

    private val PRODCUT_BASE_URL = "https://us-central1-leanontab.cloudfunctions.net"
    private val DEV_BASE_URL = "http://192.168.0.88:5000/leanontab/us-central1/"
    private val BASE_URL = PRODCUT_BASE_URL
    internal var bearerToken: String? = null

    private lateinit var ooRestService : OoRestService
    private  lateinit var retrofit : Retrofit
    internal lateinit var errorConverter: Converter<ResponseBody, OoErrorResponse?>

    var enableLog = true

    internal fun parseError(response: ResponseBody?): OoErrorResponse? {
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

    internal fun printError(message: String?) {
        if (enableLog) {
            message?.let {
                Log.e(TAG, message)
            }
        }
    }

    internal fun printLog(message: String?) {
        if (enableLog) {
            message?.let {
                Log.d(TAG, message)
            }
        }
    }

    fun setBearerToken(token: String?) {
        bearerToken = "Bearer ${token ?: ""}"
        printLog(bearerToken)
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
                printLog(response.body().toString())
                completion(response.body())
            }
            override fun onFailure(call: Call<OoResponse>, t: Throwable) {
                printError("PartnerSignIn Failed. ${t.message}")
                completion(null)
            }
        })
    }

    fun auth(param : OoParamPartnerAuth, completion: (OoErrorResponse?, OoResponseAuth?) -> Unit) {
        ApiAuth.auth(ooRestService, param, completion)
    }

    fun signinUser(param : OoParamSigninUser, completion:(OoErrorResponse?, OoResponseSigninUser?) -> Unit) {
        ApiUser.signin(ooRestService, param, completion)
    }

    fun createUser(param : OoParamCreateUser, completion:(OoErrorResponse?, OoResponseCreateUser?) -> Unit) {
        ApiUser.create(ooRestService, param, completion)
    }

    fun readUser(id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        ApiUser.read(ooRestService, id, completion)
    }
    fun updateUser(param: OoUser, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        ApiUser.update(ooRestService, param, completion)
    }

    fun deleteUser(id : String, completion:(OoErrorResponse?, OoResponseUser?) -> Unit) {
        ApiUser.delete(ooRestService, id, completion)
    }

    fun fineDust(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseFineDust?) -> Unit) {
        ApiWeahter.fineDust(ooRestService, admin, locality, completion)
    }

    fun weather(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseWeather?) -> Unit) {
        ApiWeahter.weather(ooRestService, admin, locality, completion)
    }

    fun createMMSE(param: OoParamMMSE, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.mmse(ooRestService, param, completion)
    }

    fun createAppUseReport(param: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.appUse(ooRestService, param, completion)
    }

    fun sendMessage(param: OoParamMessage, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiNotification.sendMessage(ooRestService, param, completion)
    }

    fun createChannel(toUserId: String, completion: (OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        ApiVoip.create(ooRestService, toUserId, completion)
    }

    fun deleteChannel(roomId : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.delete(ooRestService, roomId, completion)
    }

    fun turnUrl(roomId: String,  completion:(OoErrorResponse?, OoResponseTurnUrl?) -> Unit) {
        ApiVoip.turnUrl(ooRestService, roomId, completion)
    }
}

