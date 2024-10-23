package uz.gita.quotesapp.data.source.preference

import android.content.SharedPreferences
import uz.gita.quotesapp.R
import uz.gita.quotesapp.data.model.BackgroundImageData
import uz.gita.quotesapp.data.model.FontData

object SharedPreferences {

    private lateinit var preferences: SharedPreferences
    private const val BACKGROUND_IMAGE = "back_image"
    private const val FONT = "font"
    private const val FIRST_TIME = "first_time"
    var isFontChanged = false
    var isBackgroundChanged = false

    fun init(preferences: SharedPreferences) {
        this.preferences = preferences
    }

    fun getBackgroundImage(): Int {
        return preferences.getInt(BACKGROUND_IMAGE, R.drawable.wall_13)
    }

    fun saveBackgroundImage(imageData: BackgroundImageData) {
        preferences.edit().putInt(BACKGROUND_IMAGE, imageData.imageId).apply()
    }

    fun getFont(): Int {
        return preferences.getInt(FONT, R.font.space_grotesk_regular)
    }

    fun saveFont(fontData: FontData) {
        preferences.edit().putInt(FONT, fontData.fontId).apply()
    }

    fun isFirstTime(boolean: Boolean) {
        preferences.edit().putBoolean(FIRST_TIME, boolean).apply()
    }

    fun isFirstTime(): Boolean {
        return preferences.getBoolean(FIRST_TIME, true)
    }

}