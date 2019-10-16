package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoAlbumPicture
import java.io.Serializable

class OoResponseAlbumUpload(val picture: OoAlbumPicture? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseAlbumUpload(picture=$picture)"
    }
}
class OoResponseRecentAlbumList(val albumList: List<OoAlbumPicture>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseRecentAlbumList(albumList=$albumList)"
    }
}
