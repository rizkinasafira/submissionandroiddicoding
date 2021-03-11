package com.android.androsubmission

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class fruit_detail: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Fruit"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tName  = intent.getStringExtra(PLUSNAME)
        val tImg = intent.getStringExtra(PLUSPHOTO)
        val tIden = intent.getStringExtra(PLUSKLASIFIKASITY)
        val tDetailew = intent.getStringExtra(PLUSDETAIL)
        val tAnggota = intent.getStringExtra(PLUSANGGOTA)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetIden: TextView = findViewById(R.id.tv_set_klasifikasi)
        val tvDetailew: TextView = findViewById(R.id.tv_set_detail)
        val tvAnggota: TextView = findViewById(R.id.tv_item_anggota)

        tvSetName.text = tName
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetIden.text = tIden
        tvDetailew.text = tDetailew
        tvAnggota.text = tAnggota
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object {
        const val PLUSNAME = "plus_name"
        const val PLUSPHOTO = "plus_photo"
        const val PLUSKLASIFIKASITY = "plus_klasifikasi"
        const val PLUSDETAIL = "plus_detail"
        const val PLUSANGGOTA = "plus_anggota"
    }

}
