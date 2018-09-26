package ca.sheridancollege.prog39402_casestudy3.ext

import android.content.SharedPreferences
import androidx.core.content.edit

internal var SharedPreferences.tutorialShown: Boolean
    set(value) {
        edit { putBoolean("tutorialShown", value) }
    }
    get() {
        return getBoolean("tutorialShown", false)
    }
