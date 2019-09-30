package com.opusone.leanon.oorestmanager.restful

import android.util.Log
import com.opusone.leanon.oorestmanager.model.OoUser
import com.opusone.leanon.oorestmanager.params.*
import com.opusone.leanon.oorestmanager.restful.apis.*
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.*
import com.opusone.leanon.oorestmanager.restful.service.*
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
    private lateinit var ooRestServiceWeather: OoRestServiceWeather
    private lateinit var ooRestServiceAuth: OoRestServiceAuth
    private lateinit var ooRestServiceAccount: OoRestServiceAccount
    private lateinit var ooRestServiceRelation: OoRestServiceRelation
    private lateinit var ooRestServiceVOIP: OoRestServiceVOIP
    private lateinit var ooRestServiceChat: OoRestServiceChat
    private lateinit var ooRestServiceMedication: OoRestServiceMedication
    private lateinit var ooRestServiceReport: OoRestServiceReport

    private  lateinit var retrofit : Retrofit
    internal lateinit var errorConverter: Converter<ResponseBody, OoErrorResponse?>

    var enableLog = true

    internal fun parseError(response: ResponseBody?): OoErrorResponse? {
        var error: OoErrorResponse? = null
        response?.let {
            try {
                error = errorConverter.convert(it)
            } catch (e: IOException) {
                error = OoErrorResponse(null, 0, null)
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

    fun init() {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        initServices()
        errorConverter = retrofit.responseBodyConverter(OoErrorResponse::class.java, arrayOfNulls<Annotation>(0))
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

    private fun initServices() {
        ooRestService = retrofit.create(OoRestService::class.java)
        ooRestServiceWeather = retrofit.create(OoRestServiceWeather::class.java)
        ooRestServiceAuth = retrofit.create(OoRestServiceAuth::class.java)
        ooRestServiceAccount = retrofit.create(OoRestServiceAccount::class.java)
        ooRestServiceRelation = retrofit.create(OoRestServiceRelation::class.java)
        ooRestServiceVOIP = retrofit.create(OoRestServiceVOIP::class.java)
        ooRestServiceChat = retrofit.create(OoRestServiceChat::class.java)
        ooRestServiceMedication = retrofit.create(OoRestServiceMedication::class.java)
        ooRestServiceReport = retrofit.create(OoRestServiceReport::class.java)
    }

    fun auth(param : OoParamPartnerAuth, completion: (OoErrorResponse?, OoResponseAuth?) -> Unit) {
        ApiAuth.auth(ooRestServiceAuth, param, completion)
    }

    fun fineDust(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseFineDust?) -> Unit) {
        ApiWeahter.fineDust(ooRestServiceWeather, admin, locality, completion)
    }

    fun weather(admin : String, locality: String,  completion:(OoErrorResponse?, OoResponseWeather?) -> Unit) {
        ApiWeahter.weather(ooRestServiceWeather, admin, locality, completion)
    }

    fun signupUser(param : OoParamUserSignup, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        ApiAccount.signup(ooRestServiceAccount, param, completion)
    }

    fun signinUser(param : OoParamUserSignin, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        ApiAccount.signin(ooRestServiceAccount, param, completion)
    }

    fun signoutUser(userToken : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiAccount.signout(ooRestServiceAccount, userToken, completion)
    }

    fun device(userToken : String, completion:(OoErrorResponse?, OoResponseUserDevice?) -> Unit) {
        ApiAccount.device(ooRestServiceAccount, userToken, completion)
    }

    fun readUser(id : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        ApiAccount.read(ooRestServiceAccount, id, completion)
    }

    fun findUser(email : String, completion: (OoErrorResponse?, OoResponseUser?) -> Unit){
        ApiAccount.find(ooRestServiceAccount, email, completion)
    }

    fun updateUser(param: OoUser, completion:(OoErrorResponse?, OoResponseUserSign?) -> Unit) {
        ApiAccount.update(ooRestServiceAccount, param, completion)
    }

    fun deleteUser(id : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiAccount.delete(ooRestServiceAccount, id, completion)
    }

    fun getRequestSeniorList(userToken: String, completion:(OoErrorResponse?, OoResponseRequestSeniorList?) -> Unit) {
        ApiRelation.getRequestSeniorList(ooRestServiceRelation, userToken, completion)
    }

    fun getSeniorList(userToken: String, completion:(OoErrorResponse?, OoResponseSeniorList?) -> Unit) {
        ApiRelation.getSeniorList(ooRestServiceRelation, userToken, completion)
    }

    fun getRequestGuardianList(userToken: String, completion:(OoErrorResponse?, OoResponseRequestGuardianList?) -> Unit) {
        ApiRelation.getRequestGuardianList(ooRestServiceRelation, userToken, completion)
    }

    fun getGuardianList(userToken: String, completion:(OoErrorResponse?, OoResponseGuardianList?) -> Unit) {
        ApiRelation.getGuardianList(ooRestServiceRelation, userToken, completion)
    }

    fun sendGroupChat(param: OoParamChat, completion: (OoErrorResponse?, OoResponseChat?) -> Unit) {
        ApiChat.sendGroupChat(ooRestServiceChat, param, completion)
    }

    fun getRecentGroupChatList(roomId: String, timestamp: Long, completion: (OoErrorResponse?, OoResponseRecentChatList?) -> Unit) {
        ApiChat.getRecentGroupChatList(ooRestServiceChat, roomId, timestamp, completion)
    }

    fun requestGuardian(param : OoParamRequestGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.requestGuardian(ooRestServiceRelation, param, completion)
    }

    fun acceptGuardian(param : OoParamAcceptGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.acceptGuardian(ooRestServiceRelation, param, completion)
    }

    fun rejectGuardian(param: OoParamRejectGuardian, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiRelation.rejectGuardian(ooRestServiceRelation, param, completion)
    }

    fun createChannel(param: OoParamCreateChannel, completion: (OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        ApiVoip.create(ooRestServiceVOIP, param, completion)
    }

    fun readChannel(channelId : String, completion:(OoErrorResponse?, OoResponseCreateChannel?) -> Unit) {
        ApiVoip.read(ooRestServiceVOIP, channelId, completion)
    }

    fun deleteChannel(channelId : String, caller: String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.delete(ooRestServiceVOIP, channelId, caller, completion)
    }

    fun voipBusy(channelId : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.busy(ooRestServiceVOIP, channelId, completion)
    }

    fun voipReject(channelId : String, completion:(OoErrorResponse?, OoResponse?) -> Unit) {
        ApiVoip.reject(ooRestServiceVOIP, channelId, completion)
    }

    fun turnUrl(roomId: String,  completion:(OoErrorResponse?, OoResponseTurnUrl?) -> Unit) {
        ApiVoip.turnUrl(ooRestServiceVOIP, roomId, completion)
    }

    fun createAppUseReport(param: OoParamAppUseReport, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.appUse(ooRestServiceReport, param, completion)
    }

    fun scaleReport(param: OoParamScale, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.scale(ooRestServiceReport, param, completion)
    }

    fun getScaleReport(userId: String, completion: (OoErrorResponse?, OoResponseScale?) -> Unit) {
        ApiReport.getScale(ooRestServiceReport, userId, completion)
    }

    fun locationReport(param: OoParamLocation, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.location(ooRestServiceReport, param, completion)
    }

    fun getLocationReport(userId: String, completion: (OoErrorResponse?, OoResponseLocation?) -> Unit) {
        ApiReport.getLocation(ooRestServiceReport, userId, completion)
    }

    fun getDailyReport(seniorId: String,  completion: (OoErrorResponse?, OoResponseDailyReport?) -> Unit) {
        ApiReport.getDaily(ooRestServiceReport, seniorId, completion)
    }

    fun registerGreeting(param: OoParamRegisterGreeting, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.registerGreeting(ooRestServiceReport, param, completion)
    }

    fun resultGreeting(userToken: String, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiReport.resultGreeting(ooRestServiceReport, userToken, completion)
    }

    fun registerMedication(param: OoParamRegisterMedication, completion: (OoErrorResponse?, OoResponseRegisterMedication?) -> Unit) {
        ApiMedication.registerMedication(ooRestServiceMedication, param, completion)
    }

    fun updateMedication(param: OoParamUpdateMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.updateMedication(ooRestServiceMedication, param, completion)
    }

    fun resultMedication(param: OoParamResultMedication, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.resultMedication(ooRestServiceMedication, param, completion)
    }

    fun getMedications(seniorId: String, completion: (OoErrorResponse?, OoResponseMedications?) -> Unit) {
        ApiMedication.getMedicationList(ooRestServiceMedication, seniorId, completion)
    }

    fun deleteMedications(seniorId: String, medicationId: String,  completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        ApiMedication.deleteMedication(ooRestServiceMedication, seniorId,  medicationId, completion)
    }
}

