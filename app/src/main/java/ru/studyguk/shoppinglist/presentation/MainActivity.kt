package ru.studyguk.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import ru.studyguk.shoppinglist.R
import ru.studyguk.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            Log.d("RRR", it.toString())
        }
        viewModel.deleteShopList(ShopItem("Name 2", 2, true, 2))
        viewModel.changeEnableState(ShopItem("Name 1", 1, true, 1))
    }
}