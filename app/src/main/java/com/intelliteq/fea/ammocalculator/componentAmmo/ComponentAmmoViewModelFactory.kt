package com.intelliteq.fea.ammocalculator.componentAmmo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.intelliteq.fea.ammocalculator.component.ComponentViewModel
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentAmmoDao
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentDao
import java.lang.IllegalArgumentException

class ComponentAmmoViewModelFactory (
    private val dataSource: ComponentAmmoDao,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ComponentAmmoViewModel::class.java)) {
            return ComponentAmmoViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}