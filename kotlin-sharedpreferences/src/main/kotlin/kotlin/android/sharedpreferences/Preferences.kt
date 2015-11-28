/*
 * Copyright (C) 2015 8tory, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        //val type: T? = null
        @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_UNIT_OR_ANY")
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T {
            return when (property.returnType.toString()) {
                "kotlin.Int?" -> thisRef.getInt(property.name, 0)
                "kotlin.Boolean?" -> thisRef.getBoolean(property.name, false)
                "kotlin.String?" -> thisRef.getString(property.name, null)
                "kotlin.Float?" -> thisRef.getFloat(property.name, 0f)
                "kotlin.Long?" -> thisRef.getLong(property.name, 0L)
                else -> null
            } as T

            /*
            return when (type) {
                is Int -> {
                    Log.d(TAG, "is Int");
                    thisRef.getInt(property.name, 0)
                }
                is Boolean -> thisRef.getBoolean(property.name, false)
                is String -> {
                    Log.d(TAG, "is String");
                    thisRef.getString(property.name, null)
                }
                is Float -> thisRef.getFloat(property.name, 0f)
                is Long -> thisRef.getLong(property.name, 0L)
                else -> {
                    Log.d(TAG, "is ?");
                    null
                }
            } as T
            */
        }

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
    TODO
    fun edit(func: T?.() -> Unit) {
        func()
        editor.apply()
    }
    */
}
