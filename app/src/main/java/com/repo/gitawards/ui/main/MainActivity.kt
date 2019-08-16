package com.repo.gitawards.ui.main

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.repo.gitawards.R
import com.repo.gitawards.SimpleRecyclerAdapter
import com.repo.gitawards.base.BaseActivity
import com.repo.gitawards.databinding.ActivityMainBinding
import com.repo.gitawards.network.model.GithubResponse
import com.repo.gitawards.util.LogUtil.Companion.Loge
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

//    val awardAdapter = SimpleRecyclerAdapter(list)
    val awardAdapter = SimpleRecyclerAdapter(listOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding.run {
            recyclerview.run {
                adapter = awardAdapter
            }
        }



        //        viewModel.getRepository()

//        awardAdapter.addItem(
//            AwardsEntity(
//                "",
//                "효진",
//                "1",
//                "1"
//            )
//        )
//        awardAdapter.addItem(
//            AwardsEntity(
//                "",
//                "철수",
//                "1",
//                "5"
//            )
//        )
//        awardAdapter.addItem(
//            AwardsEntity(
//                "",
//                "영희",
//                "1",
//                "4"
//            )
//        )
    }


    override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {

        return super.onCreateView(parent, name, context, attrs)
    }
}
