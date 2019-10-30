package com.github.gitawards.util

import android.util.Log
import com.github.gitawards.BuildConfig

class LogUtil {
    companion object {
        fun Loge(message : String) {
            if(BuildConfig.DEBUG) {
                Log.e("LogUtil",message)
            }
        }
    }
}