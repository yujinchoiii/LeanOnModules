package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoMessage (var user: OoCompactUser? = null,
                 var index: String? = null,
                 var dataType: String? = null,
                 var message: String? = null,
                 var timestamp: String? = null,
                 var tag: String? = null,
                 var messageAnswer: List<String>?= null): Serializable {

    override fun toString(): String {
        return "OoMessage (user='$user', 'index=$index'," +
                " 'dataType=$dataType', 'message=$message', 'timestamp=$timestamp', 'tag=$tag', messageAnswer=$messageAnswer')"
    }
}

class OoChat (var user: OoCompactUser? = null,
              var senderId: String? = null,
              var roomId: String? = null,
              var type: String? = null,
              var message: String? = null,
              var answer: List<String>? = null,
              var question: String? = null,
              var timestamp: Long? = null): Serializable {

    override fun toString(): String {
        return "OoChat(user=$user, senderId=$senderId, roomId=$roomId, type=$type, message=$message, answer=$answer, question=$question, timestamp=$timestamp)"
    }
}
