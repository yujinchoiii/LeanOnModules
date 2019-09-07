package com.opusone.leanon.oorestmanager.retrofitmanager.apis

import com.opusone.leanon.oorestmanager.params.OoParamChat
import com.opusone.leanon.oorestmanager.params.OoParamMessage
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseChat
import com.opusone.leanon.oorestmanager.response.data.OoResponseMessage
import com.opusone.leanon.oorestmanager.response.data.OoResponseRecentChatList
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestManager
import com.opusone.leanon.oorestmanager.retrofitmanager.OoRestService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiChat {
    fun sendMessage(service: OoRestService, param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.message(it, param).enqueue(object :
                Callback<OoDataResponse<OoResponseMessage>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMessage>>, response: Response<OoDataResponse<OoResponseMessage>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMessage>>, t: Throwable) {
                    OoRestManager.printError("sendMessage Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun sendGroupMessage(service: OoRestService, param: OoParamMessage, completion: (OoErrorResponse?, OoResponseMessage?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.groupMessage(it, param).enqueue(object :
                Callback<OoDataResponse<OoResponseMessage>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseMessage>>, response: Response<OoDataResponse<OoResponseMessage>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseMessage>>, t: Throwable) {
                    OoRestManager.printError("sendGroupMessage Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun sendGroupChat(service: OoRestService, param: OoParamChat, completion: (OoErrorResponse?, OoResponseChat?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.groupChat(it, param).enqueue(object : Callback<OoDataResponse<OoResponseChat>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseChat>>, response: Response<OoDataResponse<OoResponseChat>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseChat>>, t: Throwable) {
                    OoRestManager.printError("sendGroupChat Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getRecentGroupChatList(service: OoRestService, roomId: String, timestamp: String, completion: (OoErrorResponse?, OoResponseRecentChatList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.getRecentGroupChat(it, roomId, timestamp).enqueue(object :
                Callback<OoDataResponse<OoResponseRecentChatList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRecentChatList>>, response: Response<OoDataResponse<OoResponseRecentChatList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRecentChatList>>, t: Throwable) {
                    OoRestManager.printError("getRecentGroupChatList Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}
