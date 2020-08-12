package com.intelliteq.fea.ammocalculator.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentAmmoDao
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentDao
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponAmmoDao
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponDao
import com.intelliteq.fea.ammocalculator.persistence.models.Component
import com.intelliteq.fea.ammocalculator.persistence.models.ComponentAmmo
import com.intelliteq.fea.ammocalculator.persistence.models.Weapon
import com.intelliteq.fea.ammocalculator.persistence.models.WeaponAmmo

@Database(entities = [Weapon::class, WeaponAmmo::class, Component::class, ComponentAmmo::class], version = 1, exportSchema = false)
public abstract class AmmoRoomDatabase : RoomDatabase() {
    abstract fun weaponDaoAccess(): WeaponDao
    abstract fun weaponAmmoDaoAccess() : WeaponAmmoDao
    abstract fun componentDaoAccess() : ComponentDao
    abstract fun componentAmmoDaoAccess() : ComponentAmmoDao

    companion object {
        var INSTANCE: AmmoRoomDatabase? = null

        fun getAppDatabase(context: Context): AmmoRoomDatabase? {
            synchronized(this) {
                if (INSTANCE == null) {
                    synchronized(AmmoRoomDatabase::class) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AmmoRoomDatabase::class.java,
                            "ammo_db")
                            .build()
                    }
                }
                return INSTANCE
            }
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }

}