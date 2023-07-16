package com.example.dataregistration

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataregistration.databinding.ActivityMainBinding
import com.example.dataregistration.databinding.DeleteDialogBoxBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var db: MyDataBaseHelper
    lateinit var rcvmain : RecyclerView
    var list = ArrayList<ModelClass>()

    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        db = MyDataBaseHelper(this)


        initview()
    }

    private fun initview() {

        binding.drawermenu.setOnClickListener {
            binding.navigationdrawer.openDrawer(GravityCompat.START)
        }

        binding.addbtn.setOnClickListener {
            var addregistry = Intent(this,Registratiom_Form_Activity::class.java)
            startActivity(addregistry)
            finish()
        }


        binding.records.setOnClickListener {
            var records = Intent(this,Registration_records::class.java)
            startActivity(records)
            finish()
        }



    }
}