package com.opusone.leanon.oorestmanager.restful.apis

import com.opusone.leanon.oorestmanager.params.OoParamAlbumPictureUpload
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoErrorResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseAlbumUpload
import com.opusone.leanon.oorestmanager.response.data.OoResponseRecentAlbumList
import com.opusone.leanon.oorestmanager.restful.OoRestManager
import com.opusone.leanon.oorestmanager.restful.service.OoRestServiceAlbum
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiAlbum {
    fun uploadAlbumPicture(service: OoRestServiceAlbum, param: OoParamAlbumPictureUpload, completion: (OoErrorResponse?, OoResponseAlbumUpload?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.uploadAlbumPicture(it, param).enqueue(object : Callback<OoDataResponse<OoResponseAlbumUpload>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseAlbumUpload>>, response: Response<OoDataResponse<OoResponseAlbumUpload>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseAlbumUpload>>, t: Throwable) {
                    OoRestManager.printError("uploadAlbumPicture Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun getRecentAlbumList(service: OoRestServiceAlbum, albumId: String, timestamp: Long, completion: (OoErrorResponse?, OoResponseRecentAlbumList?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.getRecentAlbum(it, albumId, timestamp).enqueue(object :
                Callback<OoDataResponse<OoResponseRecentAlbumList>> {
                override fun onResponse(call: Call<OoDataResponse<OoResponseRecentAlbumList>>, response: Response<OoDataResponse<OoResponseRecentAlbumList>>) {
                    if (response.isSuccessful) {
                        OoRestManager.printLog(response.body()?.toString())
                        completion(null, response.body()?.data)
                    } else {
                        OoRestManager.printError(response.errorBody().toString())
                        completion(OoRestManager.parseError(response.errorBody()), null)
                    }
                }
                override fun onFailure(call: Call<OoDataResponse<OoResponseRecentAlbumList>>, t: Throwable) {
                    OoRestManager.printError("getRecentAlbumList Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }

    fun deleteAlbumPicture(service: OoRestServiceAlbum, albumId: String, timstamp: Long, completion: (OoErrorResponse?, OoResponse?) -> Unit) {
        OoRestManager.bearerToken?.let {
            service.deleteAlbumPicture(it, albumId, timstamp).enqueue(object : Callback<OoResponse> {
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
                    OoRestManager.printError("deleteAlbumPicture Failed. ${t.message}")
                    completion(null, null)
                }
            })
        }
    }
}
