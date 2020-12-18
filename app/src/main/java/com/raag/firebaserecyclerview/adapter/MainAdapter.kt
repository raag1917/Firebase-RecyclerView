package com.raag.firebaserecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raag.firebaserecyclerview.R
import com.raag.firebaserecyclerview.data.Names
import com.raag.firebaserecyclerview.databinding.RowBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Names>()

    //permite asignar la lista de Firebase a la variable local
    fun setListData(data: MutableList<Names>) {
        dataList = data
    }

    //permite inflar la vista del item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false))

    //permite definir la posición de cada elemento dentro del recyclerview
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //define el tamaño de la vista
    override fun getItemCount() = dataList.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RowBinding.bind(view)

        fun bind(names: Names) = with(binding) {
            tvName.text = names.name
            tvLastName.text = names.lastName

        }
    }
}