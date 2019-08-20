package com.opusone.leanon.oocontentresolver

import android.content.ContentResolver
import android.net.Uri
import com.google.gson.Gson
import com.opusone.leanon.oocontentresolver.model.Partner
import com.opusone.leanon.oocontentresolver.model.User

object OoContentResolver {
    private val TAG: String = "OoContentResolver"

    private val AUTHORITY = "com.opusone.leanon.oorealmprovider"
    private val USER_PATH = "user"
    private val PARTNER_PATH = "partner"
    private val USER_OBJECT = "user_object"
    private val PARTNER_OBJECT = "partner_object"
    private val USER_URI = Uri.parse("content://$AUTHORITY/$USER_PATH")
    private val PARTNER_URI = Uri.parse("content://$AUTHORITY/$PARTNER_PATH")


    private val USER_PROJECTION = arrayOf(USER_OBJECT)
    private val PARTNER_PROJECTION = arrayOf(PARTNER_OBJECT)

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

    fun getPartnerInfo(contentResolver: ContentResolver): Partner? {
        var partner = Partner()
        val cursor = contentResolver.query(Uri.parse(PARTNER_URI.toString()), PARTNER_PROJECTION, null, null, null)
        cursor?.let {
            it.apply {
                if (it.count <= 0) {
                    return null
                }
                it.moveToFirst()
                partner = Gson().fromJson(getString(getColumnIndex(PARTNER_PROJECTION[0])), Partner::class.java)
            }
            cursor.close()
        }
        return partner
    }

}