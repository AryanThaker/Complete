package com.example.complete

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_iteam.view.*

class Adapter (val context:Context,var arr:ArrayList<Register>)
    :RecyclerView.Adapter<Adapter.PersonViewHolde>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.card_iteam,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
            holder.bind(arr[position])
        holder.itemView.imgDetele.setOnClickListener {
            if(context is ViewAll)
            {
                context.delete(position)
            }
        }
        /*holder.itemView.imgUpdate.setOnClickListener {
            if(context is ViewAll)
            {
                context.update(position)
            }
        }*/
    }


    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Register)
        {
            view.tvname.setText(p.s_name)
            view.tvuname.setText(p.s_username)
            view.tvupass.setText(p.s_password)
            view.tvuemail.setText(p.s_email)
            view.tvnum.setText(p.s_number.toString())

        }
    }
}