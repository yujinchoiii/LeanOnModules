package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoPushChat (var user: OoCompactUser? = null,
              var senderId: String? = null,
              var roomId: String? = null,
              var type: String? = null,
              var message: String? = null,
              var answer: List<String>? = null,
              var question: String? = null,
              var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoChat(user=$user, senderId=$senderId, roomId=$roomId, type=$type, message=$message, answer=$answer, question=$question, timestamp=$timestamp)"
    }
}

class OoPushMessage(var message: OoPushChat? = null): Serializable {

    override fun toString(): String {
        return "OoPushMessage(message=$message)"
    }
}

class OoChat (var id: String? = null,
              var deviceType: String? = null,
              var name: String? = null,
              var picture: String? = null,
              var roomId: String? = null,
              var type: String? = null,
              var message: String? = null,
              var answer: List<String>? = null,
              var question: String? = null,
              var timestamp: Long = 0): Serializable {

    override fun toString(): String {
        return "OoChat(id=$id, devicetype=$deviceType, name=$name, picture=$picture, roomId=$roomId, type=$type, message=$message, answer=$answer, question=$question, timestamp=$timestamp)"
    }
}
