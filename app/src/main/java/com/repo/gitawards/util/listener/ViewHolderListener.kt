package com.repo.gitawards.util.listener

import android.view.View

interface ViewHolderListener {

}

interface ClickEventListener {
    fun onEvent(view : View)
}

interface PositionListener {
    fun onPosition(position : Int)
}
