package com.opusone.leanon.oorealmmanager.model

import android.net.Uri
import io.realm.RealmList
import io.realm.RealmObject

open class OoRmMedicine : RealmObject() {
     var medicineId : String? = null
     var alarmId: Int = 0
     var hour: Int = -1
     var min: Int = -1
     var medicineName : String = ""
     var weekdaysInfo = RealmList<Boolean>(true, false, false, false, false, false, false, false)
     var isTaken = false
     var photoUri: String? = null
     var timestamp: Long? = null

     override fun toString(): String {
          return "OoRmMedicine(medicineId=$medicineId, alarmId=$alarmId, hour=$hour, min=$min, medicineName=$medicineName, weekdaysInfo=$weekdaysInfo, isTaken=$isTaken, photoUri=$photoUri, timestamp=$timestamp)"
     }
}