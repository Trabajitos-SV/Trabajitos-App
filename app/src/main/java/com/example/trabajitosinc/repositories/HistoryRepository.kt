package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.TrabajitoModel

class HistoryRepository(private val trabajitos: MutableList<TrabajitoModel>) {

    fun getTrabajitos() = trabajitos

    fun getCompletedTrabajitos() =trabajitos.filter {
        it.TrabajitoStatus == "Completed"
    }

}