package com.example.applicationabsen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.applicationabsen.model.LoginRequest
import com.example.applicationabsen.model.UserResponse
import com.example.applicationabsen.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener({
        RetrofitConfig().getLogin().getAllLogin("filter=&field=&start=&limit=&filters[0][co][0][fl]=username&filters[0][co][0][op]=equal&filters[0][co][0][vl]=${loginEditFieldUsername.text.toString()}&filters[0][co][0][lg]=and&filters[0][co][1][fl]=password&filters[0][co][1][op]=equal&filters[0][co][1][vl]=${loginEditFieldPassword.text.toString()}&filters[0][co][1][lg]=and&sort_field=&sort_order=ASC")
            .enqueue(object :Callback<LoginRequest>{
                override fun onResponse(
                    call: Call<LoginRequest>,
                    response: Response<LoginRequest>
                ) {
                    Toast.makeText(this@MainActivity, "Login berhasil", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onFailure(call: Call<LoginRequest>, t: Throwable) {
                    Log.e("error request",t.localizedMessage.toString())
                }

            })
        })

    }


}