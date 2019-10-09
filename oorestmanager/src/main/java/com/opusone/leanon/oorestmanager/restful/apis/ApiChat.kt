package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.OoParamChat
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseChat
import com.opusone.leanon.oorestmanager.response.data.OoResponseRecentChatList
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceChat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiChat {
    private val bearer = OoRestManager.bearerToken

    fun sendGroupChat(service: OoRestServiceChat, param: OoParamChat, completion: (OoErrorResponse?, OoResponseChat?) -> Unit) {
        service.groupChat(bearer, param).enqueue(object : Callback<OoDataResponse<OoResponseChat>> {
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

    fun getRecentGroupChatList(service: OoRestServiceChat, roomId: String, timestamp: Long, completion: (OoErrorResponse?, OoResponseRecentChatList?) -> Unit) {
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
