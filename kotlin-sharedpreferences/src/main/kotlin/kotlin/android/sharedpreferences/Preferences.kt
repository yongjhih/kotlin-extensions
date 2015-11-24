package kotlin.android.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KType
import kotlin.reflect.jvm.javaType

/**
 * Created by andrew on 11/28/15.
 */
public open class Preferences(prefs: SharedPreferences): SharedPreferences by prefs {
    val TAG = "Preferences"
    val editor: SharedPreferences.Editor by lazy { edit() }

    constructor(context: Context) : this(prefs = PreferenceManager.getDefaultSharedPreferences(context)) {
    }

    public inner class Preference<T>: ReadWriteProperty<SharedPreferences, T> {
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T {
            Log.d(TAG, "prop: " + property.returnType)
            Log.d(TAG, "toString: " + property.returnType.toString())
            Log.d(TAG, "javaClass: " + property.returnType.javaClass)
            Log.d(TAG, "javaType: " + property.returnType.javaType)
            Log.d(TAG, "Int.javaClass: " + Int.javaClass)
            Log.d(TAG, "Int: " + Int)
            Log.d(TAG, "java.lang.Integer.TYPE: " + java.lang.Integer.TYPE)
            /*
            val i: Int = 1
            val bool: Boolean = false
            return if (property.returnType.javaType == java.lang.Integer.TYPE) {
                Log.d(TAG, ":Int")
                return thisRef.getInt(property.name, i) as T
            } else if (property.returnType.javaType.equals(java.lang.Integer.TYPE)) {
                Log.d(TAG, ":Int2")
                return thisRef.getInt(property.name, i) as T
            } else if (property.returnType.javaType.equals(Int)) {
                Log.d(TAG, ":Int3")
                return thisRef.getInt(property.name, i) as T
            } else if (property.returnType.equals(bool)) {
                Log.d(TAG, "Boolean")
                return thisRef.getBoolean(property.name, bool) as T
            } else if (property.returnType.equals(String())) {
                Log.d(TAG, "String")
                return thisRef.getString(property.name, null) as T
            } else if (property.returnType.equals(Float)) {
                Log.d(TAG, "Float")
                return thisRef.getFloat(property.name, 0f) as T
            } else if (property.returnType.equals(Long)) {
                Log.d(TAG, "Long")
                return thisRef.getLong(property.name, 0) as T
            } else {
                return null as T
            }
            */
            return when (property.returnType.toString()) {
                "kotlin.Int?" -> thisRef.getInt(property.name, 0)
                "kotlin.Boolean?" -> thisRef.getBoolean(property.name, false)
                "kotlin.String?" -> thisRef.getString(property.name, null)
                "kotlin.Float?" -> thisRef.getFloat(property.name, 0f)
                "kotlin.Long?" -> thisRef.getLong(property.name, 0L)
                else -> null
            } as T
            /*
            return when (property.returnType.toString()) {
                "Int" -> thisRef.getInt(property.name, 0)
                "Boolean" -> thisRef.getBoolean(property.name, false)
                "String" -> thisRef.getString(property.name, null)
                "Float" -> thisRef.getFloat(property.name, 0f)
                "Long" -> thisRef.getLong(property.name, 0)
                else -> null
            } as T
            */
        }

        /*
        fun isType(l: KType, r: Any): Boolean {
            return l.toString().equals(r.toString())
        }
        */

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T) {
            when (value) {
                is Int -> editor.putInt(property.name, value)
                is Boolean -> editor.putBoolean(property.name, value)
                is String -> editor.putString(property.name, value)
                is Float -> editor.putFloat(property.name, value)
                is Long -> editor.putLong(property.name, value)
                else -> null!!
            }
        }
    }

    public inner class IntPreference: ReadWriteProperty<SharedPreferences, Int> {
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Int {
            return thisRef.getInt(property.name, 0)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: Int) {
            editor.putInt(property.name, value)
        }
    }

    public inner class StringPreference: ReadWriteProperty<SharedPreferences, String> {
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): String {
            return thisRef.getString(property.name, null)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: String) {
            editor.putString(property.name, value)
        }
    }

    /*
    fun edit(func: Any?.() -> Unit) {
        func()
        editor.apply()
    }
    */
}
