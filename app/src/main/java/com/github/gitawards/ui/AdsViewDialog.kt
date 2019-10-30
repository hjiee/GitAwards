package com.github.gitawards.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.github.gitawards.R
import com.github.gitawards.util.LogUtil.Companion.Loge
import kotlinx.android.synthetic.main.dialog_ad.*

class AdsViewDialog(context: Context) : AppCompatDialog(context) {

    lateinit var negativeListener: () -> Unit
    lateinit var positiveListener: () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_ad)
        window?.apply {
            setBackgroundDrawableResource(R.drawable.border)
        }
        initEvent()
        adView.apply {
            AdRequest.Builder().build().let {
                loadAd(it)
            }

            adListener = object : AdListener() {
                override fun onAdImpression() {
                    super.onAdImpression()
                    Loge("onAdImpression")
                }

                override fun onAdLeftApplication() {
                    super.onAdLeftApplication()
                    Loge("onAdLeftApplication")
                }

                override fun onAdClicked() {
                    super.onAdClicked()
                    Loge("onAdClicked")
                }

                override fun onAdClosed() {
                    super.onAdClosed()
                    Loge("onAdClosed")
                }

                override fun onAdOpened() {
                    super.onAdOpened()
                    Loge("onAdOpened")
                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    Loge("onAdLoaded")
                }

                /**
                 * onAdFailedToLoad() 메소드는 매개변수를 포함하는 유일한 메소드입니다. errorCode 매개변수는 발생한 오류 유형을 나타냅니다. 가능한 값이 AdRequest 클래스의 상수로 정의됩니다.
                 * 0 ERROR_CODE_INTERNAL_ERROR: 광고 서버에서 잘못된 응답을 받는 등 내부적으로 오류가 발생했다는 의미입니다.
                 * 1 ERROR_CODE_INVALID_REQUEST: 광고 단위 ID가 잘못된 경우처럼 광고 요청이 잘못되었다는 의미입니다.
                 * 2 ERROR_CODE_NETWORK_ERROR: 네트워크 연결로 인해 광고 요청에 성공하지 못했다는 의미입니다.
                 * 3 ERROR_CODE_NO_FILL: 광고 요청에는 성공했지만 광고 인벤토리의 부족으로 광고가 반환되지 않았다는 의미입니다.
                 */
                override fun onAdFailedToLoad(errorCode: Int) {
                    super.onAdFailedToLoad(errorCode)
                    Loge("onAdFailedToLoad : $errorCode")
                }
            }
        }


    }

    fun setPositiveButton(pListener: () -> Unit) {
        positiveListener = pListener
    }

    fun setNegativeButton(nListener: () -> Unit) {
        negativeListener = nListener
    }

    private fun initEvent() {
        btn_positive.setOnClickListener {
            when (::positiveListener.isInitialized) {
                true -> {
                    dismiss()
                    positiveListener.invoke()
                }
                false -> falseInvoke()
            }
        }
        btn_negative.setOnClickListener {
            when (::negativeListener.isInitialized) {
                true -> negativeListener.invoke()
                false -> falseInvoke()
            }
        }
    }

    private fun falseInvoke() {
        dismiss()
    }

}