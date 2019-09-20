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
             var isLauncher: String?= null,
             var address1: String?= null,
             var address2: String?= null,
             var tel: String?= null,
             var mobile: String?= null,
             var partner: String?= null,
             var nationalCode: String?=null) : Serializable {

    override fun toString(): String {
        return "OoUser(id='$id', email='$email', name='$name', birthdate='$birthdate', gender='$gender', " +
                "weigh='$weight', height='$height', picture='$picture', isLauncher='$isLauncher', " +
                "address1='$address1', address2='$address2', tel='$tel', " +
                "mobile='$mobile', partner='$partner', nationalCode='$nationalCode')"
    }
}


class OoCompactUser (var id: String? = null,
                     var name: String? = null,
                     var picture: String? = null,
                     var timestamp: String? = null,
                     var deviceType: String? = null): Serializable {
    override fun toString(): String {
        return "OoCompactUser (id='$id', 'name='$name', 'picture='$picture', " +
                "'timestamp='$timestamp', 'deviceType='$deviceType')"
    }
}

/**
 * Device Type
 *
 * 0: Unknown
 *
 * 1~10: Senior. 1: Tablet, 2: mobile
 *
 * 11~20: Guardian. 11: Tablet, 12: mobile
 *
 */
class OoUserDevice (var os: String? = null,
                    var type: String? = null,
                    var token: String? = null,
                    var model: String? = null,
                    var ver: String? = null): Serializable {

    override fun toString(): String {
        return "OoUserDevice (os='$os', 'type='$type', 'token='$token', 'model='$model', 'ver='$ver')"
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
        return "OoMedicineAlarm(weekdaysInfo='$weekdaysInfo', hour='$hour', min='$min', picture='$picture', " +
                "guardian='$guardian', name='$name', alarmId='$alarmId')"
    }
}
