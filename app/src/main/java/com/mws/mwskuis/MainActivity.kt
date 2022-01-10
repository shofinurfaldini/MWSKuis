package com.mws.mwskuis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<QuotesResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvQuotes.setHasFixedSize(true)
        rvQuotes.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getQuotes().enqueue(object: Callback<ArrayList<QuotesResponse>>{
            override fun onResponse(
                call: Call<ArrayList<QuotesResponse>>,
                response: Response<ArrayList<QuotesResponse>>
            ) {
                val responseCode = response.code().toString()
                textQoutes.text = responseCode
                response.body()?.let { list.addAll(it)}
                val adapter = QuotesAdapter(list)
                rvQuotes.adapter = adapter

            override fun onFailure(call: Call<ArrayList<QuotesResponse>>, t: Throwable) {

            }

        })
    }
}