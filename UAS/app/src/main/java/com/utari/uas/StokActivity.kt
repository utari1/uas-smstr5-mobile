package com.utari.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.utari.uas.adapter.Adapter
import com.utari.uas.api.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StokActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var stokAdapter: Adapter
    private lateinit var lisNote : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stok)
        setupList()

    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_stok)
        stokAdapter = Adapter(arrayListOf())
        lisNote.adapter = stokAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.allkom
                    stokAdapter.setData( listData )
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

        })
    }
}