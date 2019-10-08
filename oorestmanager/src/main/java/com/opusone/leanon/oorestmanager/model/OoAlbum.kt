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
