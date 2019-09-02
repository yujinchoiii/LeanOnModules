package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoMessage (var id: String? = null,
                 var name: String? = null,
                 var picture: String? = null,
                 var index: String? = null,
                 var dataType: String? = null,
                 var message: String? = null,
                 var timestamp: String? = null,
                 var messageAswer: List<String>?= null): Serializable {

    override fun toString(): String {
        return "OoMessage (id='$id', 'name='$name', 'picture=$picture', 'index=$index'," +
                " 'dataType=$dataType', 'message=$message', 'timestamp=$timestamp', 'messageAswer=$messageAswer')"
    }
}