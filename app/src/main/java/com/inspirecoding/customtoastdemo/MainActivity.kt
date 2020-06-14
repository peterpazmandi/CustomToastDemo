package com.inspirecoding.customtoastdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.inspirecoding.customtoastdemo.util.showCustomToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_defaultToast.setOnClickListener {
            showPositionedToast(et_message.text.toString().trim())
        }
        btn_customToast.setOnClickListener {_button ->
//            showCustomToast(et_message.text.toString().trim())
            Toast(this).showCustomToast (
                et_message.text.toString().trim(),
                this
            )
        }
    }

    private fun showDefaultToast(message: String)
    {
        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show()
    }
    private fun showPositionedToast(message: String)
    {
        val toast = Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        )
        toast.apply {
            setGravity(Gravity.TOP, 0, 300)
            show()
        }
    }

    private fun showCustomToast(message: String)
    {
        val layout = layoutInflater.inflate (
            R.layout.custom_toast,
            findViewById(R.id.cl_customToastContainer)
        )

        val textView = layout.findViewById<TextView>(R.id.tv_message)
        textView.text = message

        Toast(this).apply {
            setGravity(Gravity.BOTTOM, 0, 40)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
    }
}
