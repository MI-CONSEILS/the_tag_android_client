package com.mokhtarihadjmohamed.tagwatchproject.Viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mokhtarihadjmohamed.thetag.data.datastore.SettingsDataStore
import kotlinx.coroutines.launch

/*
* this is viewmodel off the setting datastore is just used in view
* like composable.
* */

class SettingsViewModel(private val dataStore: SettingsDataStore) : ViewModel() {

    // TODO Auth
    val jwtToken = dataStore.jwtToken.asLiveData()

    fun saveToken(token: String) {
        viewModelScope.launch {
            dataStore.saveToken(token)
        }
    }

    fun clearToken() {
        viewModelScope.launch {
            dataStore.clearToken()
        }
    }
}