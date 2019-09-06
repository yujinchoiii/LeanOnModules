package com.opusone.leanon.oorestmanager.retrofitmanager

import android.util.Log
import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.retrofitmanager.apis.*
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import okhttp3.ResponseBody
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object OoRestManager {
    internal val TAG = "OoRestManager"

    private val PRODCUT_BASE_URL = "https://us-central1-leanontab.cloudfunctions.net"
    private val DEV_BASE_URL = "http://192.168.0.88:5000/leanontab/us-central1/"
    private val BASE_URL = DEV_BASE_URL
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

    fun findUser(email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        ApiUser.find(ooRestService, email, completion)
    }

    fun updateUser(param: OoUser, completion:(OoErrorResponse?, OoResponseSigninUser?) -> Unit) {
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

    fun getMMSE(userId: String, completion: (OoErrorResponse?, OoResponseMMSE?) -> Unit) {
        ApiReport.getMmse(ooRestService, userId, completion)
    }

    fun createAppUseReport(param: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.appUse(ooRestService, param, completion)
    }

    fun sendMessage(param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        ApiChat.sendMessage(ooRestService, param, completion)
    }

    fun sendGroupMessage(param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        ApiChat.sendGroupMessage(ooRestService, param, completion)
    }

    fun requestGuardian(param : OoParamRequestGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.requestGuardian(ooRestService, param, completion)
    }

    fun acceptGuardian(param : OoParamAcceptGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.acceptGuardian(ooRestService, param, completion)
    }

    fun rejectGuardian(seniorId: String, guardian: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.rejectGuardian(ooRestService, seniorId, guardian, completion)
    }

    fun createChannel(param: OoParamCreateChannel, completion: (OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        ApiVoip.create(ooRestService, param, completion)
    }

    fun readChannel(channelId : String, completion:(OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        ApiVoip.read(ooRestService, channelId, completion)
    }

    fun deleteChannel(channelId : String, caller: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.delete(ooRestService, channelId, caller, completion)
    }

    fun voipBusy(channelId : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.busy(ooRestService, channelId, completion)
    }

    fun voipReject(channelId : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.reject(ooRestService, channelId, completion)
    }

    fun turnUrl(roomId: String,  completion:(OoErrorResponse?, OoResponseTurnUrl?) -> Unit) {
        ApiVoip.turnUrl(ooRestService, roomId, completion)
    }

    fun scaleReport(param: OoParamScale, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.scale(ooRestService, param, completion)
    }

    fun getScaleReport(userId: String, completion: (OoErrorResponse?, OoResponseScale?) -> Unit) {
        ApiReport.getScale(ooRestService, userId, completion)
    }

    fun locationReport(param: OoParamLocation, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.location(ooRestService, param, completion)
    }

    fun getLocationReport(userId: String, completion: (OoErrorResponse?, OoResponseLocation?) -> Unit) {
        ApiReport.getLocation(ooRestService, userId, completion)
    }

    fun getDailyReport(seniorId: String,  completion: (OoErrorResponse?, OoResponseDailyReport?) -> Unit) {
        ApiReport.getDaily(ooRestService, seniorId, completion)
    }

    fun registerMedication(param: OoParamRegisterMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.registerMedication(ooRestService, param, completion)
    }

    fun resultMedication(param: OoParamResultMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.resultMedication(ooRestService, param, completion)
    }

    fun getMedications(seniorId: String, completion: (OoErrorResponse?, OoResponseMedications?) -> Unit) {
        ApiMedication.getMedicationList(ooRestService, seniorId, completion)
    }

    fun deleteMedications(seniorId: String, medicationId: String,  completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.deleteMedication(ooRestService, seniorId,  medicationId, completion)
    }
}

