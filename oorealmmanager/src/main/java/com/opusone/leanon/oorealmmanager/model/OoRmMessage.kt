package com.opusone.leanon.oorealmmanager.model

import com.opusone.leanon.oorealmmanager.OoRealmManager
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index

open class OoRmMessage : RealmObject() {
    @Index
    var index : Long = OoRealmManager.getMessageCount() + 1
        private set
    var dataType: Int? = -1
    var picture : String? = ""
    var id : String? = ""
    var chatrommId : String? = ""
    var name : String? = ""
    var message: String? = ""
    var messageAnswer : RealmList<String?>? = RealmList()
    var timestamp: Long? = -1
    var question: String? = ""

    override fun toString(): String {
        return "OoRmMessage(index=$index, chatrommId=$chatrommId,dataType=$dataType, picture=$picture, id=$id, name=$name, message=$message, messageAnswer=$messageAnswer, timestamp=$timestamp, question=$question)"
    }
}