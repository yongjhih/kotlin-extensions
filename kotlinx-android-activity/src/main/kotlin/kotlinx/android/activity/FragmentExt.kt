package kotlinx.android.activity

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.widget.Toast

fun Fragment.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(resourceId, length)
}

fun android.app.Fragment.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(resourceId, length)
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(message, length)
}

fun android.app.Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(message, length)
}

fun Fragment.colorFromResource(@ColorRes colorResource: Int): Int {
    return ContextCompat.getColor(activity, colorResource)
}

fun android.app.Fragment.colorFromResource(@ColorRes colorResource: Int): Int {
    return ContextCompat.getColor(activity, colorResource)
}

inline fun Fragment.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}

inline fun android.app.Fragment.fragmentTransaction(function: android.app.FragmentTransaction.() -> android.app.FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}
