package com.vivek.alarmtestlab

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn:Button = findViewById(R.id.btnClick)
        btn.setOnClickListener {
            var intent :Intent = Intent(this,SecondActivity::class.java)

            //for one time alarm
            //var pi:PendingIntent = PendingIntent.getActivity(this,13,intent,PendingIntent.FLAG_ONE_SHOT)
            var pi:PendingIntent = PendingIntent.getActivity(this,13,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            var alarm:AlarmManager= getSystemService(ALARM_SERVICE) as AlarmManager

            //todo for simple alarm
            //alarm.set(AlarmManager.ELAPSED_REALTIME,60,pi)

            //todo for repeating alarm
            alarm.setRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+60,60000,pi)

        }
    }
}