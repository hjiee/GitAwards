package com.repo.gitawards.util

import android.util.Log
import com.repo.gitawards.BuildConfig

class LogUtil {
    companion object {
        fun Loge(message : String) {
            if(BuildConfig.DEBUG) {
                Log.e("LogUtil",message)
            }
        }
    }
}