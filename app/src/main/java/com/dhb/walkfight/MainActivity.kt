package com.dhb.walkfight

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var kakaoLoginButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        kakaoLoginButton = findViewById(R.id.button_kakao_login)
        val context = this
        kakaoLoginButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    // 서비스 코드에서는 간단하게 로그인 요청하고 oAuthToken 을 받아올 수 있다.
                    val oAuthToken = UserApiClient.loginWithKakao(context)
                    Log.i("MainActivity", "로그인에 성공하였습니다. token: $oAuthToken")
                    
                    //move to webview
                    val intent = Intent(context, WebViewActivity::class.java)
                    startActivity(intent)
                    
                } catch (error: Throwable) {
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        Log.d("MainActivity", "사용자가 명시적으로 취소")
                    } else {
                        Log.e("MainActivity", "인증 에러 발생", error)
                    }
                }
            }
        }
    }
}

