package com.opusone.leanon.oocontentresolver

import android.content.ContentResolver
import android.net.Uri
import com.google.gson.Gson
import com.opusone.leanon.oocontentresolver.model.User

object OoContentResolver {
    private val TAG: String = "OoContentResolver"

    private val AUTHORITY = "com.opusone.leanon.oorealmprovider"
    private val USER_PATH = "user"
    private val USER_OBJECT = "user_object"
    private val USER_URI = Uri.parse("content://$AUTHORITY/$USER_PATH")
    private val USER_PROJECTION = arrayOf(USER_OBJECT)

    fun getUserInfo(contentResolver: ContentResolver): User? {
        var user = User()
        val cursor = contentResolver.query(Uri.parse(USER_URI.toString()), USER_PROJECTION, null, null, null)
        cursor?.let {
            it.apply {
                if (it.count <= 0) {
                    return null
                }
                it.moveToFirst()
                user = Gson().fromJson(getString(getColumnIndex(USER_PROJECTION[0])), User::class.java)
            }
            cursor.close()
        }
        return user
    }
}