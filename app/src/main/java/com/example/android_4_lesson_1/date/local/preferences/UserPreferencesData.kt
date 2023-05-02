package com.example.android_4_lesson_1.date.local.preferences

const val PREF_IS_AUTHORIZED = "is_authorized"
const val PREF_ACCESS_TOKEN: String = "access_token"
const val PREF_REFRESH_TOKEN: String = "refresh_token"

class UserPreferencesData(
    private val preferenceHelper: PreferenceHelper
) {
    var isAuthorized: Boolean
        get() = preferenceHelper().getBoolean(PREF_IS_AUTHORIZED, false)
        set(value) = preferenceHelper().edit().putBoolean(PREF_IS_AUTHORIZED, value).apply()

    var accessToken: String
        get() = preferenceHelper().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preferenceHelper().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = preferenceHelper().getString(PREF_REFRESH_TOKEN, "null")!!
        set(value) = preferenceHelper().edit().putString(PREF_REFRESH_TOKEN, value).apply()
}