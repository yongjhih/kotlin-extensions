package kotlinx.android.app

import android.app.Activity
import android.app.FragmentTransaction
import android.widget.Toast

fun Activity.toast(resourceId: Int, length: Int = Toast.LENGTH_SHORT) {
    toast(getString(resourceId), length)
}

fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

inline fun Activity.fragmentTransaction(function: FragmentTransaction.() -> FragmentTransaction) {
    fragmentManager.beginTransaction()
            .function()
            .commit()
}
