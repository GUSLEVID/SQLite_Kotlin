package com.example.sqlite_kotlin.db

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_kotlin.R

class MyAdapter(listMain:ArrayList<String>): RecyclerView.Adapter<MyAdapter.MyHolder>()
{
    var listArray = listMain

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

        fun setData(title:String)
        {
            tvTitle.text = title
        }
    }
// и тут он рисует столько раз сколько мы передали списков
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder //Готовим шаблом для рисования и создаем MyHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        return  MyHolder(inflater.inflate(R.layout.rc_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int)  //Заполняет
    {
        holder.setData(listArray.get(position)) // и сразу после рисования заполняет его
    }

    override fun getItemCount(): Int //Тут мы передаем размер нашего массива
    {

        return listArray.size //проверяет размер
    }

    fun updateAdapter(listItems:List<String>){
        listArray.clear() //Очищаем списов
        listArray.addAll(listItems) //помещаем данные
        notifyDataSetChanged() // говорим проверь еще раз и он снова проверяет размер

    }
}