package ru.studyguk.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.studyguk.shoppinglist.data.ShopListRepositoryImpl
import ru.studyguk.shoppinglist.domain.DeleteShopItemUseCase
import ru.studyguk.shoppinglist.domain.EditShopItemUseCase
import ru.studyguk.shoppinglist.domain.GetShopListUseCase
import ru.studyguk.shoppinglist.domain.ShopItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _shopList = getShopListUseCase.getShopList()
    val shopList: LiveData<List<ShopItem>> = _shopList

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
//        shopItem.enabled = !shopItem.enabled
//        editShopItemUseCase.editShopItem(shopItem)
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}