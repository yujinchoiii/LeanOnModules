package com.opusone.leanon.oorestmanager.response

import java.io.Serializable

open class OoResponse(val status: String?, val timestamp: Long) : Serializable {
    fun isSuccess(): Boolean {
        return status == "ok"
    }

    override fun toString(): String {
        return "OoResponse(status=$status, timestamp=$timestamp)"
    }
}

class OoDataResponse<T>(status: String?, timestamp: Long, val data: T) : OoResponse(status, timestamp), Serializable {
    override fun toString(): String {
        return "OoDataResponse(status=$status, timestamp=$timestamp, data=$data)"
    }
}


class OoError(var code: String?= null, var message: String?= null) : Serializable {
    override fun toString(): String {
        return "OoError(code=$code, message=$message)"
    }
}

class OoErrorResponse(status: String?, timestamp: Long, val error: OoError?) : OoResponse(status, timestamp), Serializable {
    override fun toString(): String {
        return "OoErrorResponse(status=$status, timestamp=$timestamp, error=$error)"
    }
}
