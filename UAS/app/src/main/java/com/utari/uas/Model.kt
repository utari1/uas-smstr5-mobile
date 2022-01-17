package com.utari.uas

class Model (
    val allkom: List<Data>
) {
    data class Data (val id:String?, val nama:String?, val brand:String?)
}
