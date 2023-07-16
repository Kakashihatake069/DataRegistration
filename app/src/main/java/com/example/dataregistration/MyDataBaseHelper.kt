package com.example.dataregistration

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf

class MyDataBaseHelper (var context: Context) : SQLiteOpenHelper(context,"RegistrationTb",null,1){
    var list = ArrayList<ModelClass>()

    override fun onCreate(db: SQLiteDatabase?) {
        var sql ="create table RegistrationTb (registration_id integer primary key autoincrement,fname text,lname text,age integer,address text,email text,phone integer,gender text,status text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insert(fname : String,lname : String,age : String,address : String,email : String,phone : String,gender : String,status : String) {
            list.clear()

        var db1 = writableDatabase
        var c = ContentValues()

        c.put("fname",fname)
        c.put("lname",lname)
        c.put("age",age)
        c.put("address",address)
        c.put("email",email)
        c.put("phone",phone)
        c.put("gender",gender)
        c.put("status",status)


        db1.insert("RegistrationTb",null,c)

    }

    fun display() : ArrayList<ModelClass>{
        list.clear()
        val db1 = readableDatabase
        val sql = "select * from RegistrationTb"
        var cursor = db1.rawQuery(sql,null)
        if (cursor.moveToFirst())
        {
            do{
                val id = cursor.getInt(0)
                val fname = cursor.getString(1)
                val lname = cursor.getString(2)
                val age = cursor.getInt(3)
                val address = cursor.getString(4)
                val email = cursor.getString(5)
                val phone = cursor.getInt(6)
                val gender = cursor.getString(7)
                val status = cursor.getString(8)

                Log.e("TAG", "display: "+ id +" "+fname+" "+lname+" "+age+" "+email+" "+phone+" "+gender+" "+status)
                var model = ModelClass(id,fname,lname,age,address,email,phone,gender,status)
                list.add(model)
            }while (cursor.moveToNext())
        }else
        {
            Log.e("TAG", "display: " +"no data found")
        }

        return this.list
    }
    fun updaterecord(fname: String, lname: String,age: String,address: String,email: String,phone: String, storage_id: Int) {
        val db = writableDatabase
        val sql1 =
            "update RegistrationTb set fname = '$fname',lname = '$lname',age = '$age',address = '$address',email = '$email',phone = '$phone' where registration_id ='$storage_id'"
        db.execSQL(sql1)
        Toast.makeText(context, "update success", Toast.LENGTH_SHORT).show()
    }

    fun deleteData(id: Int) {
        var db = writableDatabase
        val delete = "delete from RegistrationTb where  registration_id ='$id'"
        db.execSQL(delete)
    }

}