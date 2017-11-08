package kotlinx.android.app

import android.app.Fragment
import android.widget.Toast

fun Fragment.toast(resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(resourceId, length)
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    activity.toast(message, length)
}

inline fun Fragment.fragmentTransaction(function: android.app.FragmentTransaction.() -> android.app.FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}
