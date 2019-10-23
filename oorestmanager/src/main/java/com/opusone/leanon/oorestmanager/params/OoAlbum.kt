package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamAlbumPictureUpload (var userToken: String? = null,
                                 var albumId: String? = null,
                                 var author: String? = null,
                                 var url: String? = null,
                                 var filename: String? = null,
                                 var comment: String? = null,
                                 var bucketName: String? = null): Serializable {

    override fun toString(): String {
        return "OoParamAlbumPictureUpload(author=$author, albumId=$albumId, " +
                "url=$url, filename=$filename, comment=$comment, bucketName=$bucketName)"
    }
}

class OoParamProfilePictureUpload (var userId: String? = null,
                                   var url: String? = null,
                                   var filename: String? = null,
                                   var bucketName: String? = null): Serializable {

    override fun toString(): String {
        return "OoParamAlbumPictureUpload(userId=$userId, " +
                "url=$url, filename=$filename, bucketName=$bucketName)"
    }
}
