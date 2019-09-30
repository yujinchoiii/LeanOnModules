package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoAlbumPicture (var author: String? = null,
                      var url: String? = null,
                      var thumbnail: String? = null,
                      var comment: String? = null,
                      var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoAlbumPicture(author=$author, url=$url, thumbnail=$thumbnail, " +
                "comment=$comment, timestamp=$timestamp)"
    }
}
