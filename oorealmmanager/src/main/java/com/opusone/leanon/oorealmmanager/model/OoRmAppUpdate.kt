package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject
import io.realm.annotations.Index

open class OoRmAppUpdate: RealmObject() {
    @Index
    var packageName: String? = null

    var default: Boolean = false
    var image: String? = null
    var version: String? = null
    var link: String? = null
    var linkImage: String? = null
    var displayName: String? = null
    var name: String? = null
    var category: String? = null
    var downloadUrl: String? = null
    var downloadedPath: String? = null
    var state: Int = 0
    var timestamp: Long = 0
}
