package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoUser(var gender: String?= null,
             var isLauncher: Boolean?,
             var deviceOS: String?= null,
             var address2: String?= null,
             var email: String?= null,
             var name: String?= null,
             var guardians: List<OoGuardian>?= null,
             var tel: String?= null,
             var mobile: String?= null,
             var height: String?= null,
             var partner: String?= null,
             var address1: String?= null,
             var birthdate: String?= null,
             var picture: String?= null,
             var deviceModel: String?= null,
             var deviceToken: String?= null,
             var deviceSerial: String?= null,
             var weight: String?= null,
             var requestGuardians: List<Any>?= null,
             var medicineAlarms: List<OoMedicineAlarm>?= null,
             var id: String?= null) : Serializable {

    override fun toString(): String {
        return "OoUser(gender=$gender, isLauncher=$isLauncher, deviceOS=$deviceOS, address2=$address2, email=$email, name=$name, guardians=$guardians, tel=$tel, mobile=$mobile, height=$height, partner=$partner, address1=$address1, birthdate=$birthdate, picture=$picture, deviceModel=$deviceModel, deviceToken=$deviceToken, deviceSerial=$deviceSerial, weight=$weight, requestGuardians=$requestGuardians, medicineAlarms=$medicineAlarms, id=$id)"
    }
}

class OoGuardian(var deviceToken: String?= null, var id: String?= null) : Serializable{
    override fun toString(): String {
        return "OoGuardian(deviceToken='$deviceToken', id='$id')"
    }
}

class OoMedicineAlarm(var weekdaysInfo: String?= null,
                      var hour: String?= null,
                      var min: String?= null,
                      var picture: String?= null,
                      var guardian: String?= null,
                      var name: String?= null,
                      var alarmId: String?= null) : Serializable{
    override fun toString(): String {
        return "OoMedicineAlarm(weekdaysInfo='$weekdaysInfo', hour='$hour', min='$min', picture='$picture', guardian='$guardian', name='$name', alarmId='$alarmId')"
    }
}
