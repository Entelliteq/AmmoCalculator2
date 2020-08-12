package com.intelliteq.fea.ammocalculator.weapon

import android.app.Application
import android.app.ApplicationErrorReport
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponDao
import com.intelliteq.fea.ammocalculator.persistence.models.Weapon
import kotlinx.coroutines.*

class WeaponViewModel (
    val database: WeaponDao,
    application: Application) : AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val weapon = MutableLiveData<Weapon?>()

    private val _navigateToInputWeaponAmmo = MutableLiveData<Weapon>()

    val navigateToInputWeaponAmmo: LiveData<Weapon>
        get() = _navigateToInputWeaponAmmo

    init {
        initializeWeapon()
    }
    //resets variable that triggers navigation
    fun doneNavigation() {
        _navigateToInputWeaponAmmo.value = null
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

    //cancel all coroutines
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}