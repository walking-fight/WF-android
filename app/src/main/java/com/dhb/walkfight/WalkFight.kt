package com.dhb.walkfight

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class WalkFight : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_native_app_key))
    }
}