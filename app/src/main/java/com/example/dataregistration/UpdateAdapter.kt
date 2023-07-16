package com.example.dataregistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.dataregistration.UpdateAdapter.MyViewHolder

class UpdateAdapter (var updatelist : ArrayList<ModelClass>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        var txtFname : TextView = itemview.findViewById(R.id.txtFname)
        var txtLname : TextView = itemview.findViewById(R.id.txtLname)
        var txtAge : TextView = itemview.findViewById(R.id.txtAge)
        var txtAdd : TextView = itemview.findViewById(R.id.txtAdd)
        var txtEmail : TextView = itemview.findViewById(R.id.txtEmail)
        var txtPhone : TextView = itemview.findViewById(R.id.txtPhone)
        var txtgender : TextView = itemview.findViewById(R.id.txtgender)
        var txtstatus : TextView = itemview.findViewById(R.id.txtstatus)
        var btnedit : ImageView = itemview.findViewById(R.id.btnedit)
        var btndelete : ImageView = itemview.findViewById(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.registery_form_itemfile,null,false)

        return UserAdapter.MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
            holder.txtFname.setText(updatelist[position].fname)
        holder.txtLname.setText(updatelist[position].lname)
        holder.txtAge.setText(updatelist[position].age)
        holder.txtAdd.setText(updatelist[position].address)
        holder.txtEmail.setText(updatelist[position].email)
        holder.txtPhone.setText(updatelist[position].phone)
        holder.txtgender.setText(updatelist[position].gender)
        holder.txtstatus.setText(updatelist[position].status)





    }

    override fun getItemCount(): Int {
        return updatelist.size
    }
}