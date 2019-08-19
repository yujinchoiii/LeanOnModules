package com.opusone.leanon.oorealmmanager.model

import com.opusone.leanon.oorealmmanager.OoRealmManager
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index

open class OoRmMessage : RealmObject(){
    @Index
    var index : Long = OoRealmManager.getMessageCount() + 1
    var dataType: Int = -1
    var picture : String? = ""
    var id : String? = ""
    var name : String? = ""
    var message: String? = ""
    var message_answer : RealmList<String?>? = RealmList("")
    var timestamp: Long? = -1

    override fun toString(): String {
        return "OoRmMessage(index=$index, dataType=$dataType, picture=$picture, id=$id, name=$name, message=$message, message_answer=$message_answer, timestamp=$timestamp)"
    }
}