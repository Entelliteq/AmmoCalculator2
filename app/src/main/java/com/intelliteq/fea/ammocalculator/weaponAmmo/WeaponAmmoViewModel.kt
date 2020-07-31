package com.intelliteq.fea.ammocalculator.weaponAmmo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponAmmoDao
import com.intelliteq.fea.ammocalculator.persistence.models.Weapon
import kotlinx.coroutines.*

class WeaponAmmoViewModel(
    private val weaponAmmoKey: Long = 0L,
    val database: WeaponAmmoDao) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToInputComponent = MutableLiveData<Weapon?>()

    val navigateToInputComponent: LiveData<Weapon?>
        get() = _navigateToInputComponent

    fun doneNavigating() {
        _navigateToInputComponent.value = null
    }

    fun onAddAnotherAmmo() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val weapon = database.get(weaponAmmoKey) ?: return@withContext

            }
        }
    }


}