package com.opusone.leanon.oorealmmanager.model

import android.net.Uri
import io.realm.RealmList
import io.realm.RealmObject

open class OoRmMedicine : RealmObject() {
     var alarmID: Int = 0
     var hour: String? = null
     var min: String? = null
     var medicineName : String? = null
     var weekdaysInfo = RealmList<Boolean?>(true, false, false, false, false, false, false, false)
     var isTaken = false
     var photoUri: String? = null


}