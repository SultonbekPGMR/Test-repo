package uz.gita.quotesapp.app

import android.app.Application
import android.util.Log
import uz.gita.quotesapp.data.source.AppDatabase
import uz.gita.quotesapp.data.source.preference.SharedPreferences
import uz.gita.quotesapp.data.source.repository.AppRepository
import uz.gita.quotesapp.data.source.repository.DataLoader
import uz.gita.quotesapp.utils.AppConstants.SHARED_NAME

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
        SharedPreferences.init(getSharedPreferences(SHARED_NAME, MODE_PRIVATE))
        if (SharedPreferences.isFirstTime()){
            DataLoader.loadAllData()
            SharedPreferences.isFirstTime(false)
        }

        AppRepository.init()



    }
}