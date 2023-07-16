package ru.studyguk.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.studyguk.shoppinglist.data.ShopListRepositoryImpl
import ru.studyguk.shoppinglist.domain.DeleteShopItemUseCase
import ru.studyguk.shoppinglist.domain.EditShopItemUseCase
import ru.studyguk.shoppinglist.domain.GetShopListUseCase
import ru.studyguk.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _shopList = MutableLiveData<List<ShopItem>>()
    val shopList: LiveData<List<ShopItem>> = _shopList

    fun getShopList() {
        _shopList.value = getShopListUseCase.getShopList()
    }

    fun deleteShopList(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        shopItem.enabled = !shopItem.enabled
        editShopItemUseCase.editShopItem(shopItem)
        getShopList()
    }
}