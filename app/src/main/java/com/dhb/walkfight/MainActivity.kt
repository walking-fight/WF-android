package com.dhb.walkfight

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.common.KakaoSdk

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //kakao app key
        KakaoSdk.init(this, "kakao1d7bfef00f79df36741d6b32b85e4491")
        
        val button: Button = findViewById(R.id.myButton)
        button.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }
}

