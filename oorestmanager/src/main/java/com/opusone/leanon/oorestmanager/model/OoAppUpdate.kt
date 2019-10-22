package com.opusone.leanon.oorestmanager.model

class OoAppUpdate(val default: String? = null,
                  val image: String? = null,
                  val packageName: String? = null,
                  val version: String? = null,
                  val link: String? = null,
                  val linkImage: String? = null,
                  val displayName: String? = null,
                  val name: String? = null,
                  val category: String? = null,
                  val downloadUrl: String? = null,
                  val timestamp: Long = 0) {

    override fun toString(): String {
        return "OoAppUpdate(default=$default, image=$image, packageName=$packageName, version=$version, " +
                "link=$link, linkImage=$linkImage, displayName=$displayName, name=$name, category=$category, downloadUrl=$downloadUrl, timestamp=$timestamp)"
    }
}
