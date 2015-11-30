package com.graffity

import android.content.Context
import kotlinx.android.sharedpreferences.Preferences

/**
 * Created by andrew on 11/28/15.
 */
public class User(context: Context) : Preferences(context) {
    var name: String? by Preference()
    var age: Int? by Preference()

    fun edit(func: User.() -> Unit) {
        func()
        editor.apply()
    }
}
