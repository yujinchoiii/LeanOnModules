package com.opusone.leanon.oorealmmanager.model

import io.realm.RealmObject

open class OoRmAppUpdate: RealmObject() {
    var default: String? = null
    var image: String? = null
    var packageName: String? = null
    var vision: String? = null
    var link: String? = null
    var linkImage: String? = null
    var displayName: String? = null
    var name: String? = null
    var category: String? = null
    var downloadUrl: String? = null
    var timestamp: Long = 0
}
