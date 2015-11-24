package com.graffity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.facebook.appevents.AppEventsLogger
//import kotlinx.android.synthetic.activity_main.hello as helloView
//import org.jetbrains.anko.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //helloView.setText("yo")
        //relativeLayout {
        //    textView(R.string.hello_world) {
        //    }
        //}
        /*
        var user = User(this)
        user.name = "Andrew Chen"
        user.age = 18
        user.apply()
        */
        val user = User(this)
        user.edit {
            name = "Andrew Chen"
            age = 16
        }
        Log.d("Andrew", "age: " + user.age);
        user.edit {
            age = 15
        }
        Log.d("Andrew", "age: " + user.age);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        AppEventsLogger.activateApp(this)
    }

    override fun onPause() {
        super.onPause()

        AppEventsLogger.deactivateApp(this)
    }
}
