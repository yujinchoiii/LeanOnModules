package com.opusone.leanon.oorestmanager.params

class OoParamChat(var userToken: String? = null,
                  var roomId: String? = null,
                  var type: String? = null,
                  var message: String? = null,
                  var answer: List<String>? = null,
                  var question: String? = null) {

    override fun toString(): String {
        return "OoParamChat(userToken=$userToken, roomId=$roomId, type=$type, message=$message, " +
                "answer=$answer, question=$question"
    }
}