package com.example.dataregistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var ModelClasslist: ArrayList<ModelClass>,var edit : (ModelClass) -> Unit,var delete : ((Int) -> Unit)) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
//    var ModelClasslist =  ArrayList<ModelClass>()

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var txtFname: TextView = itemview.findViewById(R.id.txtFname)
        var txtLname: TextView = itemview.findViewById(R.id.txtLname)
        var txtAge: TextView = itemview.findViewById(R.id.txtAge)
        var txtAdd: TextView = itemview.findViewById(R.id.txtAdd)
        var txtEmail: TextView = itemview.findViewById(R.id.txtEmail)
        var txtPhone: TextView = itemview.findViewById(R.id.txtPhone)
        var txtgender: TextView = itemview.findViewById(R.id.txtgender)
        var txtstatus: TextView = itemview.findViewById(R.id.txtstatus)
        var btnedit : AppCompatButton = itemview.findViewById(R.id.btnedit)
        var btndelete : AppCompatButton = itemview.findViewById(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.registery_form_itemfile, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        holder.txtFname.text = ModelClasslist[position].fname
        holder.txtLname.text = ModelClasslist[position].lname
        holder.txtAge.text = ModelClasslist[position].age.toString()
        holder.txtAdd.text = ModelClasslist[position].address
        holder.txtEmail.text = ModelClasslist[position].email
        holder.txtPhone.text = ModelClasslist[position].phone.toString()
        holder.txtgender.text = ModelClasslist[position].gender
        holder.txtstatus.text = ModelClasslist[position].status

        holder.btnedit.setOnClickListener {
            edit.invoke(ModelClasslist[position])
        }

        holder.btndelete.setOnClickListener {
            delete.invoke(ModelClasslist[position].id)
        }

    }

    override fun getItemCount(): Int {
        return ModelClasslist.size

    }
    fun updatedate(list: ArrayList<ModelClass>) {
        this.ModelClasslist=ArrayList()
        this.ModelClasslist.addAll(list)
        notifyDataSetChanged()

    }
}