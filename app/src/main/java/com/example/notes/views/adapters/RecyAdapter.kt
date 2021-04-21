package com.example.notes.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Nota
import com.example.notes.databinding.ListUtilBinding
import java.net.ContentHandler
import java.security.AccessControlContext

class RecyAdapter(private var mData : ArrayList<Nota>, private val context: Context?) : RecyclerView.Adapter<RecyAdapter.Notina>() {

    inner class Notina(val binding : ListUtilBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Notina {
        return Notina(ListUtilBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Notina, position: Int) {

        with(holder.binding) {

            titolo.text = mData[position].titolo
            data.text = mData[position].data
            anteprima.text = mData[position].anteprima


        }

    }

    override fun getItemCount(): Int = mData.size
}