package kotlinx.android.activity

import android.app.Activity
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.widget.Toast
import android.content.Context

fun Activity.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    toast(getString(resourceId), length)
}

fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.color(@ColorRes colorResource: Int): Int {
    return ContextCompat.getColor(this, colorResource)
}

inline fun Activity.fragmentTransaction(function: android.app.FragmentTransaction.() -> android.app.FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}

inline fun FragmentActivity.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager.beginTransaction()
            .function()
            .commit()
}
