package com.android.androsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFruitAdapter(val listFruit: ArrayList<Fruit>) : RecyclerView.Adapter<ListFruitAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_card_fruit, viewGroup, false)
        return ListViewHolder(view)
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAnggota: TextView = itemView.findViewById(R.id.tv_item_anggota)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
    override fun getItemCount(): Int {
        return listFruit.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, anggota, photo, detail, klasifikasi) = listFruit[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvAnggota.text = anggota

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, fruit_detail::class.java)
            moveDetail.putExtra(fruit_detail.PLUSANGGOTA, anggota)
            moveDetail.putExtra(fruit_detail.PLUSNAME, name)
            moveDetail.putExtra(fruit_detail.PLUSPHOTO, photo)
            moveDetail.putExtra(fruit_detail.PLUSKLASIFIKASITY, klasifikasi)
            moveDetail.putExtra(fruit_detail.PLUSDETAIL, detail)
            mContext.startActivity(moveDetail)
        }
    }


}

