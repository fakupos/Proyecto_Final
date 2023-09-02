package com.curso.android.app.practica.proyectofinal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComparisonViewModel : ViewModel() {
    val comparisonResultLiveData = MutableLiveData<ComparisonResult>()

    fun compareStrings(str1: String, str2: String) {
        val areEqual = str1 == str2
        comparisonResultLiveData.value = ComparisonResult(areEqual)
    }
}
