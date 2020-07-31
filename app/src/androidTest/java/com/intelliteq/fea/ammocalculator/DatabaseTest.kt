package com.intelliteq.fea.ammocalculator

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.intelliteq.fea.ammocalculator.persistence.daos.ComponentDao
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponAmmoDao
import com.intelliteq.fea.ammocalculator.persistence.daos.WeaponDao
import com.intelliteq.fea.ammocalculator.persistence.database.AmmoRoomDatabase
import com.intelliteq.fea.ammocalculator.persistence.models.Component
import com.intelliteq.fea.ammocalculator.persistence.models.Weapon
import com.intelliteq.fea.ammocalculator.persistence.models.WeaponAmmo
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var weaponDao: WeaponDao
    private lateinit var weaponAmmoDao: WeaponAmmoDao
    private lateinit var componentDao: ComponentDao
    private lateinit var db: AmmoRoomDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AmmoRoomDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        weaponDao = db.weaponDaoAccess()
        weaponAmmoDao = db.weaponAmmoDaoAccess()
        componentDao = db.componentDaoAccess()

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWeaponCount() {
        val newWeapon = Weapon()
        weaponDao.insert(newWeapon)
        val count = weaponDao.countAll()
        Assert.assertEquals(count, 1)
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWeaponAndAmmoID() {
        val newWeapon = Weapon()
        weaponDao.insert(newWeapon)
        newWeapon.weaponId = 100
        weaponDao.update(newWeapon)
        val newAmmo = WeaponAmmo()
        weaponAmmoDao.insert(newAmmo)
        newAmmo.weaponId = newWeapon.weaponId
        weaponAmmoDao.update(newAmmo)
        val ammoWeaponID = newAmmo.weaponId
        Assert.assertEquals(ammoWeaponID, newWeapon.weaponId) //100

    }

    @Test
    fun add10andCheckFor10Weapons() {
        val weapon1 = Weapon()
        weaponDao.insert(weapon1)
        val weaponID1 = weaponDao.getNewWeapon()
        val weapon2 = Weapon()
        weaponDao.insert(weapon2)
        val weaponID2 = weaponDao.getNewWeapon()
        val weapon3 = Weapon()
        weaponDao.insert(weapon3)
        val testWeaponID3 = weaponDao.getNewWeapon()?.weaponAutoId
        val weaponID3 = weaponDao.getNewWeapon()
        val weapon4 = Weapon()
        weaponDao.insert(weapon4)
        val weapon5 = Weapon()
        weaponDao.insert(weapon5)
        val weapon6 = Weapon()
        weaponDao.insert(weapon6)
        val weapon7 = Weapon()
        weaponDao.insert(weapon7)
        val weapon8 = Weapon()
        weaponDao.insert(weapon8)
        val weapon9 = Weapon()
        weaponDao.insert(weapon9)
        val weapon10 = Weapon()
        weaponDao.insert(weapon10)

        Log.i("Testing", "Weapon ID 1::::///" + weaponID1?.weaponAutoId)
        Log.i("Testing", "Weapon ID 2::::///" + weaponID2?.weaponAutoId)
        Log.i("Testing", "Weapon ID 3 :::///" + weaponID3?.weaponAutoId)
        Log.i("Testing", "Weapon ID 3 AGAIN :::/// $testWeaponID3")
        Assert.assertEquals(weaponDao.countAll(), 10)
    }

    //Incomplete test case
    @Test
    @Throws(Exception::class)
    fun componentSuccessfullyAddedToWeapon() {
        val newWeapon = Weapon()  //new weapon
        weaponDao.insert(newWeapon)  //add weapon to db
        newWeapon.weaponId = 100  //change weaponId
        weaponDao.update(newWeapon) //update db
        val newAmmo = WeaponAmmo()  //new ammo
        weaponAmmoDao.insert(newAmmo)  //add ammo
        newAmmo.weaponId = newWeapon.weaponId  //change ammo weapon id
        weaponAmmoDao.update(newAmmo) //update db
        val newComponent = Component()  //new component
        val newComponent2 = Component()  //new component
        newComponent.weaponId = newWeapon.weaponId  //add weapon id to weapon component
        componentDao.insert(newComponent)  //add component to db

    }
}