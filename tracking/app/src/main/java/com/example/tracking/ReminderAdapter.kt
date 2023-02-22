package com.example.tracking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tracking.data.Expenses

class ReminderAdapter  (private val expensesList : ArrayList<Expenses>, var context: Context) :
    RecyclerView.Adapter<ReminderAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reminder, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = expensesList[position]
        holder.title.text = currentItem.title
        holder.amount.text = currentItem.rupees
        holder.switch.setOnClickListener{
            expensesList[position].title.let {
               Toast.makeText(context,"Alerted Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {

        return expensesList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTV)
        val amount: TextView = itemView.findViewById(R.id.amountTV)
        val switch : SwitchCompat = itemView.findViewById(R.id.switchs)
    }
}