package com.intelliteq.fea.ammocalculator.component

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentDao

class ComponentViewModel (
    val database: ComponentDao,
    application: Application
) : AndroidViewModel(application) {

}