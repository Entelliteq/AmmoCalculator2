package com.intelliteq.fea.ammocalculator.weapon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponDao
import com.intelliteq.fea.ammocalculator.persistence.models.Weapon
import kotlinx.coroutines.*

class WeaponViewModel (
    private val weaponKey: Long = 0L,
    val database: WeaponDao
) : ViewModel() {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val weapons = database.getAll()

    private val weapon = MutableLiveData<Weapon?>()

    private val weaponId = weapon.value?.weaponId

    private val _navigateToWeaponAmmo = MutableLiveData<Weapon>()

    val navigateToWeaponAmmo: LiveData<Weapon>
        get() = _navigateToWeaponAmmo

    init {
        initializeWeapon()
    }
    //resets variable that triggers navigation
    fun doneNavigation() {
        _navigateToWeaponAmmo.value = null
    }

    private fun initializeWeapon() {
        uiScope.launch {
            weapon.value = getWeaponFromDatabase()
        }
    }

    private suspend fun getWeaponFromDatabase() : Weapon? {
        return withContext(Dispatchers.IO) {
            var weapon = database.getNewWeapon()
            weapon
        }
    }

    fun onInputAmmo() {
        uiScope.launch {
            val newWeapon = Weapon()
            insert(newWeapon)
        }
    }

    private suspend fun insert(weapon: Weapon) {
        withContext(Dispatchers.IO) {
            database.insert(weapon)
        }
    }
}