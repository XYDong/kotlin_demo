package com.joker.kotlin_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        R.id.tv_test.onClick(this) {
            Toast.makeText(this@MainActivity, "点击了按钮", Toast.LENGTH_SHORT).show()
        }
    }
}