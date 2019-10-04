package com.opusone.leanon.oorestmanager.params

import java.io.Serializable

class OoParamAlbumPictureUpload (var userToken: String? = null,
                                 var albumId: String? = null,
                                 var author: String? = null,
                                 var url: String? = null,
                                 var thumbnail: String? = null,
                                 var comment: String? = null): Serializable {

    override fun toString(): String {
        return "OoParamAlbumPictureUpload(author=$author, albumId=$albumId, " +
                "url=$url, thumbnail=$thumbnail, comment=$comment)"
    }
}


