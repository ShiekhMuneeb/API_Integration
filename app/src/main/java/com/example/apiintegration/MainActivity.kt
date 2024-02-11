package com.example.apiintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi()
    }

    private fun callApi() {
        val apiService = RetrofitClient.apiService

        val call = apiService.getData()

        Thread {

        }
        call.enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    // Process the data
                    Log.i("TAG", "onResponse: $data")
                    runOnUiThread {

                    }
                    findViewById<TextView>(R.id.tvMain).text = data?.results?.get(0)?.name
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                // Handle network error
                Log.e("TAG", "onFailure: ${t.stackTrace}")
            }
        })

    }
}
