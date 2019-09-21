package com.opusone.leanon.oorestmanager.response.data

import com.opusone.leanon.oorestmanager.model.OoChat
import java.io.Serializable

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

