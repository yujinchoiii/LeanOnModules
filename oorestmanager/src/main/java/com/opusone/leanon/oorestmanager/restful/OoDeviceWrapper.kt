package com.opusone.leanon.oorestmanager.restful

import android.os.Build

object OoDeviceWrapper {
    var type = "0"
    var token = ""

    val os = "android"
    val model = "${Build.BRAND}, ${Build.MODEL}"
    val version = Build.VERSION.RELEASE

    override fun toString(): String {
        return "OoDeviceWrapper(type=$type, token=$token, os=$os, model=$model, version=$version)"
    }
}