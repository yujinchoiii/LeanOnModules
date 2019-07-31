package com.opusone.leanon.realmprovider.OoDataManager

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import com.opusone.leanon.oorealmmanager.OoRealmManager

class OoRealmProvider : ContentProvider() {
    private val AUTHORITY = "com.opusone.leanon.realmprovider"
    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    private val USER_URI = "user"
    private val PARTNER_URI = "partner"

    private val USER_ID = "userid"
    private val USER_EMAIL = "useremail"
    private val USER_NAME = "username"
    private val USER_TOKEN = "usertoken"
    private val USER_DEVICETOKEN = "userdevicetoken"

    val PARTNER_EMAIL = "partneremail"
    val PARTNER_TOKEN = "partnertoken"

    val USER = 0
    val PARTNER = 1

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        initUriMatching()

        context?.let {
            OoRealmManager.initRealm(it)
            return true
        }
        return false
    }

    private fun initUriMatching() {
        uriMatcher.addURI(AUTHORITY, USER_URI, USER)
        uriMatcher.addURI(AUTHORITY, PARTNER_URI, PARTNER)
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        var userCursor = MatrixCursor(arrayOf())
        when (uriMatcher.match(uri)) {
            USER -> {
                userCursor = MatrixCursor(arrayOf(USER_ID, USER_EMAIL, USER_NAME, USER_TOKEN, USER_DEVICETOKEN))
                val result = OoRealmManager.readUser("1234")
                result?.apply {
                        userCursor.addRow(arrayOf(this.id, this.email, this.name, this.userToken, this.deviceToken))
                }
            }
            PARTNER -> {
                userCursor = MatrixCursor(arrayOf(PARTNER_EMAIL, PARTNER_TOKEN))
                val result = OoRealmManager.readPartner()
                result?.apply {
                        userCursor.addRow(arrayOf(this.email, this.token))

                }
            }
        }
        return userCursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}
