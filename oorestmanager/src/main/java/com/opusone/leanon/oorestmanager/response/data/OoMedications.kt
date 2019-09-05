package com.opusone.leanon.oorestmanager.response.data

import java.io.Serializable
import com.opusone.leanon.oorestmanager.model.OoMedicatio

class OoResponseMedications(val medications: MutableList<OoMedicatio>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseMedications(medications=$medications)"
    }
}
