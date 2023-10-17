package com.example.droidtiketing.view.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.droidtiketing.R
import com.example.droidtiketing.databinding.ListItemHistoryBinding
import com.example.droidtiketing.model.ModelDatabase
import com.example.droidtiketing.utils.FunctionHelper.rupiahFormat

class HistoryAdapter(var modelDatabase: MutableList<ModelDatabase>)
    : RecyclerView.Adapter<HistoryAdapter.ViewHolder>(){
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var tvKelas = itemView.tvKelas
//        var tvDate = itemView.tvDate
//        var tvNama = itemView.tvNama
//        var tvHargaTiket = itemView.tvHargaTiket
//        var tvKode1 = itemView.tvKode1
//        var tvKode2 = itemView.tvKode2
//        var tvKeberangkatan = itemView.tvKeberangkatan
//        var tvTujuan = itemView.tvTujuan
//    }

    inner class ViewHolder(val binding: ListItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_history, parent, false)
//        return ViewHolder(view)
        val binding = ListItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
        val data = modelDatabase[position]

        when (data.keberangkatan) {
            "Jakarta" -> holder.binding.tvKode1.text = "JKT"
            "Semarang" -> holder.binding.tvKode1.text = "SRG"
            "Surabaya" -> holder.binding.tvKode1.text = "SUB"
            "Bali" -> holder.binding.tvKode1.text = "DPS"
        }

        when (data.tujuan) {
            "Jakarta" -> holder.binding.tvKode2.text = "JKT"
            "Semarang" -> holder.binding.tvKode2.text = "SRG"
            "Surabaya" -> holder.binding.tvKode2.text = "SUB"
            "Bali" -> holder.binding.tvKode2.text = "DPS"
        }

        holder.binding.tvKelas.text = data.kelas
        holder.binding.tvDate.text = data.tanggal
        holder.binding.tvNama.text = data.namaPenumpang
        holder.binding.tvKeberangkatan.text = data.keberangkatan
        holder.binding.tvTujuan.text = data.tujuan
        holder.binding.tvHargaTiket.text = rupiahFormat(data.hargaTiket)
    }

    override fun getItemCount(): Int {
        return modelDatabase.size
    }
    fun setSwipeRemove(position: Int): ModelDatabase {
        return modelDatabase.removeAt(position)
    }
    fun setDataAdapter(items: List<ModelDatabase>) {
        modelDatabase.clear()
        modelDatabase.addAll(items)
        notifyDataSetChanged()
    }
}