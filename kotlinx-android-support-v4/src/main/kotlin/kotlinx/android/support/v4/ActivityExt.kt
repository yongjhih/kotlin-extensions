package kotlinx.android.support.v4

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.widget.Toast

fun FragmentActivity.toast(@StringRes resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    toast(getString(resourceId), length)
}

fun FragmentActivity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.color(@ColorRes colorResource: Int): Int {
    return ContextCompat.getColor(this, colorResource)
}

inline fun FragmentActivity.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager.beginTransaction()
            .function()
            .commit()
}
