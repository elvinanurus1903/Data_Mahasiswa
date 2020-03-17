package com.example.mahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.tambah
import kotlinx.android.synthetic.main.activity_tambah.*
import org.json.JSONObject

class Tambah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        val context = this

        tambah.setOnClickListener{

            var data_namamhs = nama.text.toString()
            var data_nomermhs= nomer.text.toString()
            var data_alamatmhs= alamat.text.toString()

            postkeserver(data_namamhs,data_nomermhs,data_alamatmhs)

            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)

        }
    }

    fun postkeserver(data1:String, data2:String, data3:String){


        AndroidNetworking.post("http://10.35.180.28/mahasiswa/insert_data.php")
            .addBodyParameter("nama_mahasiswa", data1)
            .addBodyParameter("nomer_mahasiswa", data2)
            .addBodyParameter("alamat_mahasiswa", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {


                }

                override fun onError(anError: ANError) { // handle error

                }
            })
    }
}
