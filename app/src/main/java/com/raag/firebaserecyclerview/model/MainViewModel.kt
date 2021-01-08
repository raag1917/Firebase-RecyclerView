package com.raag.firebaserecyclerview.model

import android.content.Context
import androidx.lifecycle.*
import com.raag.firebaserecyclerview.data.Names
import com.raag.firebaserecyclerview.repo.Repo
import kotlin.coroutines.coroutineContext

class MainViewModel {
    private val repo = Repo()

    //asigna la lista de Firebase en la lista mutable local
    fun fetchData(): LiveData<MutableList<Names>> {
        val mutableData = MutableLiveData<MutableList<Names>>()
        repo.getData().observeForever {
            mutableData.value = it
        }
        return mutableData
    }

}