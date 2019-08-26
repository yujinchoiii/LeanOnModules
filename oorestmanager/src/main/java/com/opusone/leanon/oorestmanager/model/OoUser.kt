package com.opusone.leanon.oorestmanager.model

import java.io.Serializable

class OoUser(var id: String?= null,
             var email: String?= null,
             var name: String?= null,
             var birthdate: String?= null,
             var gender: String?= null,
             var weight: String?= null,
             var height: String?= null,
             var picture: String?= null,
             var isLauncher: Boolean?,
             var address1: String?= null,
             var address2: String?= null,
             var tel: String?= null,
             var mobile: String?= null,
             var partner: String?= null,
             var deviceToken: String?= null,
             var deviceOS: String?= null,
             var deviceModel: String?= null,
             var deviceSerial: String?= null,
             var guardians: List<OoGuardian>?= null,
             var requestGuardians: List<String>?= null,
             var seniors: List<OoSenior>?= null,
             var requestSeniors: List<String>?= null,
             var medicineAlarms: List<OoMedicineAlarm>?= null) : Serializable {

    override fun toString(): String {
        return "OoUser(id='$id', email='$email', name='$name', birthdate='$birthdate', gender='$gender', " +
                "weigh='$weight', height='$height', picture='$picture', isLauncher='$isLauncher', " +
                "address1='$address1', address2='$address2', tel='$tel', mobile='$mobile', partner='$partner', deviceToke='$deviceToken', " +
                "deviceOS='$deviceOS', deviceModel='$deviceModel', deviceSerial='$deviceSerial', guardians='$guardians', " +
                "requestGuardians='$requestGuardians', seniors='$seniors', requestSeniors='$requestSeniors', medicineAlarms='$medicineAlarms')"
    }
}

class OoGuardian(var id: String?= null, var deviceToken: String?= null) : Serializable {
    override fun toString(): String {
        return "OoGuardian(id='$id', deviceToken='$deviceToken')"
    }
}

class OoSenior(var id: String?= null) : Serializable {
    override fun toString(): String {
        return "OoSenior(id='$id')"
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
