package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoAlbumPicture (var authorId: String? = null,
                      var albumId: String? = null,
                      var authorName: String? = null,
                      var authorPicture: String? = null,
                      var url: String? = null,
                      var thumbnail: String? = null,
                      var comment: String? = null,
                      var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoAlbumPicture(albumId=$albumId, authorId=$authorId, authorName=$authorName, authorPicture=$authorPicture, url=$url, thumbnail=$thumbnail, " +
                "comment=$comment, timestamp=$timestamp)"
    }
}

class OoAlbum (var user: OoCompactUser? = null,
                   var url:String? = null,
                   var albumId:String? = null,
                   var thumbnail: String?= null,
                   var comment: String?=null): Serializable {

    override fun toString(): String {
        return "OoAlbum(user=$user, url=$url, albumId=$albumId, thumbnail=$thumbnail, comment=$comment)"
    }
}

class OoPushAlbum (var album: OoAlbum? = null): Serializable {
    override fun toString(): String {
        return "OoPushAlbum(album=$album)"
    }
}
