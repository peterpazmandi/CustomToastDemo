package com.inspirecoding.customtoastdemo.util

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.inspirecoding.customtoastdemo.R


fun Toast.showCustomToast(message: String, activity: Activity)
{
    val layout = activity.layoutInflater.inflate (
        R.layout.custom_toast,
        activity.findViewById(R.id.cl_customToastContainer)
    )

    val textView = layout.findViewById<TextView>(R.id.tv_message)
    textView.text = message

    this.apply {
        setGravity(Gravity.BOTTOM, 0, 40)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}