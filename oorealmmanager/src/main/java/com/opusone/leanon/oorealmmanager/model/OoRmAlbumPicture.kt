package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmAlbumPicture: RealmObject() {
    var authorId: String? = null
    var authorName: String? = null
    var authorPicture: String? = null
    var url: String? = null
    var thumbnail: String? = null
    var timestamp: Long = 0
}