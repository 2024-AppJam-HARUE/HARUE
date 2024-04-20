package com.example.harue.ui.calender

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harue.databinding.GrupItemBinding

class CalenderRecyclerAdapta : RecyclerView.Adapter<CalenderRecyclerAdapta.MyviewHolder>() {
    lateinit var callback: (Int) -> Unit
    val datalist = mutableListOf<ClaenderData>(
        ClaenderData("2024앱잼", "2024.04.20",100),
        ClaenderData("연인", "2014.04.20",2),
        ClaenderData("가족", "2024.04.21",300),
        ClaenderData("앱잼 화잉팅", "2024.04.20",100))

    inner class MyviewHolder(private val binding : GrupItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(recyclerModel: ClaenderData, position: Int){
            binding.nameText.text = recyclerModel.name
            binding.gneraitDayText.text = recyclerModel.gneraterDay
            binding.person.text = "${recyclerModel.countPerson}명"
            binding.root.setOnClickListener {
                callback(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val binding = GrupItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(datalist[position], position)
    }
}