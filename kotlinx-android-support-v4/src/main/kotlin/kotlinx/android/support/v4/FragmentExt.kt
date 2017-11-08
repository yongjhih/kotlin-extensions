package kotlinx.android.support.v4

import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.widget.Toast

fun Fragment.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(resourceId, length)
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(message, length)
}

fun Fragment.colorFromResource(@ColorRes colorResource: Int): Int {
    return ContextCompat.getColor(activity, colorResource)
}

inline fun Fragment.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}
