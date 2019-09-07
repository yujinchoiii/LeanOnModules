package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoChat
import com.opusone.leanon.oorestmanager.model.OoMessage
import java.io.Serializable

class OoResponseMessage(val message: OoMessage? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseMessage(message=$message)"
    }
}

class OoResponseChat(val chat: OoChat? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseChat(chat=$chat)"
    }
}

class OoResponseRecentChatList(val chatList: List<OoChat>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseRecentChatList(chatList=$chatList)"
    }
}

