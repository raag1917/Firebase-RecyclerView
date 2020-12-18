package com.raag.firebaserecyclerview.ui

/*
* Diseño y desarrollo:
* Ramiro Abad Gómez
* Android Developer
*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raag.firebaserecyclerview.adapter.MainAdapter
import com.raag.firebaserecyclerview.databinding.ActivityMainBinding
import com.raag.firebaserecyclerview.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private val adapter = MainAdapter()
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            //inicia el adaptador con el recyclervieew
            recyclerView.adapter = adapter

            //Observa los datos y los asigna por el adapter a la lista mutable
            viewModel.fetchData().observeForever {names ->
                adapter.setListData(names)
                adapter.notifyDataSetChanged()
            }
        }

    }

}
