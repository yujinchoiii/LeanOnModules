package com.opusone.leanon.oorestmanager.restful.service

import com.opusone.leanon.oorestmanager.params.OoParamAlbumPictureUpload
import com.opusone.leanon.oorestmanager.params.OoParamProfilePictureUpload
import com.opusone.leanon.oorestmanager.response.OoDataResponse
import com.opusone.leanon.oorestmanager.response.OoResponse
import com.opusone.leanon.oorestmanager.response.data.OoResponseAlbumUpload
import com.opusone.leanon.oorestmanager.response.data.OoResponseProfileImageUpload
import com.opusone.leanon.oorestmanager.response.data.OoResponseRecentAlbumList
import retrofit2.Call
import retrofit2.http.*

interface OoRestServiceAlbum {
    @POST("album/upload")
    fun uploadAlbumPicture(@Header("authorization") authorization : String, @Body param: OoParamAlbumPictureUpload): Call<OoDataResponse<OoResponseAlbumUpload>>

    @GET("album/recentAlbum/{albumId}/{pictureId}")
    fun getRecentAlbum(@Header("authorization") authorization : String, @Path("albumId") roomId: String, @Path("pictureId") pictureId: Long): Call<OoDataResponse<OoResponseRecentAlbumList>>

    @DELETE("album/delete/{albumId}/{pictureId}")
    fun deleteAlbumPicture(@Header("authorization") authorization : String, @Path("albumId") roomId: String, @Path("pictureId") timestamp: Long): Call<OoResponse>

    @POST("album/uploadProfile")
    fun uploadAlbumPicture(@Header("authorization") authorization : String, @Body param: OoParamProfilePictureUpload): Call<OoDataResponse<OoResponseProfileImageUpload>>
}