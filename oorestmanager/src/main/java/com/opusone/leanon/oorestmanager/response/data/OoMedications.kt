package com.opusone.leanon.oorestmanager.response.data

import java.io.Serializable
import com.opusone.leanon.oorestmanager.model.OoMedication

class OoResponseMedications(val medications: List<OoMedication>? = null) : Serializable {
    override fun toString(): String {
        return "OoResponseMedications(medications=$medications)"
    }
}
