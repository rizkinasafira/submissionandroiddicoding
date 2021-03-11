package com.android.androsubmission

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class about : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgMe: ImageView = findViewById(R.id.img_item_photo)

        val tImg = "https://media-exp1.licdn.com/dms/image/C4D03AQF1w5U0BQwHGg/profile-displayphoto-shrink_800_800/0/1614222671565?e=1620864000&v=beta&t=wumPy0S5dA0PXTUQ39IlHHKd4ZRjvc0xyEdJ6P1vh9k"

        Glide.with(this)
                .load(tImg)
                .apply(RequestOptions())
                .into(imgMe)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}