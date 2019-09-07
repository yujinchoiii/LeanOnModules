package com.opusone.leanon.oorestmanager.params

class OoParamMessage(var userToken: String? = null,
                     var to: String?,
                     var index: String?,
                     var dataType : String?,
                     var message: String? = null,
                     var messageAnswer: MutableList<String?>,
                     var tag : String? = null) {

    override fun toString(): String {
        return "OoParamMessage(userToken=$userToken, to=$to, index=$index, dataType=$dataType, " +
                "message=$message, messageAnswer=$messageAnswer, tag=$tag)"
    }
}


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