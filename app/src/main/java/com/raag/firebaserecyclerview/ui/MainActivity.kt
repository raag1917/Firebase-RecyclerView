package com.raag.firebaserecyclerview.ui

/*
* Diseño y desarrollo:
* Ramiro Abad Gómez
* Android Developer
*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.raag.firebaserecyclerview.adapter.MainAdapter
import com.raag.firebaserecyclerview.data.Names
import com.raag.firebaserecyclerview.databinding.ActivityMainBinding
import com.raag.firebaserecyclerview.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //inicia el adaptador con el recyclervieew
            binding.recyclerView.adapter = adapter

            //Observa los datos y los asigna por el adapter a la lista mutable
            MainViewModel().fetchData().observe(this, Observer{
                adapter.setListData(it)
                adapter.notifyDataSetChanged()
            })


    }

}
