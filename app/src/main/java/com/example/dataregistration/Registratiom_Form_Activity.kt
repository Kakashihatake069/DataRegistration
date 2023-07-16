package com.example.dataregistration

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataregistration.databinding.ActivityRegistratiomFormBinding
import kotlin.math.E

class Registratiom_Form_Activity : AppCompatActivity() {

    lateinit var RegistryBinding: ActivityRegistratiomFormBinding
    lateinit var gender: String
    lateinit var Maritalstatus: String
    lateinit var txttitle: TextView
    lateinit var db: MyDataBaseHelper
    var list = ArrayList<ModelClass>()
    lateinit var rcvmain : RecyclerView
    lateinit var adapter: UserAdapter
    var storage_id = 0
    var obj = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RegistryBinding = ActivityRegistratiomFormBinding.inflate(layoutInflater)
        setContentView(RegistryBinding.root)

         db = MyDataBaseHelper(this)
//
//        adapter = UserAdapter()
//        var LayoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        RegistryBinding.rcvmain.layoutManager=LayoutManager
//        RegistryBinding.rcvmain.adapter=adapter
//
        initview()
    }

    private fun initview() {

        RegistryBinding.imgback.setOnClickListener {
            var intent = Intent(this@Registratiom_Form_Activity,MainActivity::class.java)
            startActivity(intent)
        }

        RegistryBinding.btnsubmit.setOnClickListener {


            val FirstName: String = RegistryBinding.edtFname.getText().toString()
            val LastName: String = RegistryBinding.edtLname.getText().toString()
            val Age: String = RegistryBinding.edtAge.getText().toString()
            val Address: String = RegistryBinding.edtAdd.getText().toString()
            val Email: String = RegistryBinding.edtEmail.getText().toString()
            val Phone: String = RegistryBinding.edtPhone.getText().toString()

            //            Gender Radion Button

            val id: Int = RegistryBinding.rdbgender.getCheckedRadioButtonId()
            val rb = findViewById<RadioButton>(id)
            if (id != -1) {
                gender = rb.text.toString()
            }

//                martialstatus Radio Button

            val id2: Int = RegistryBinding.rdbmartial.getCheckedRadioButtonId()
            val rb2 = findViewById<RadioButton>(id2)
            if (id2 != -1) {
                Maritalstatus = rb2.text.toString()
            }


//                checkbox


//            //            langguages
//            if (RegistryBinding.chkclang.isChecked()) {
//                obj.append("  " + RegistryBinding.chkclang.getText().toString())
//            }
//            if (RegistryBinding.chkcplus.isChecked()) {
//                obj.append("  " + RegistryBinding.chkcplus.getText().toString())
//            }
//            if (RegistryBinding.chkjava.isChecked()) {
//                obj.append("  " + RegistryBinding.chkjava.getText().toString())
//            }
//            if (RegistryBinding.chkkotlin.isChecked()) {
//                obj.append("  " + RegistryBinding.chkkotlin.getText().toString())
//            }
//            if (RegistryBinding.chkphp.isChecked()) {
//                obj.append("  " + RegistryBinding.chkphp.getText().toString())
//            }
//            if (RegistryBinding.chkandriod.isChecked()) {
//                obj.append("  " + RegistryBinding.chkandriod.getText().toString())
//            }
//            if (RegistryBinding.chkhtml.isChecked()) {
//                obj.append("  " + RegistryBinding.chkhtml.getText().toString())
//            }
//            if (RegistryBinding.chkjavascript.isChecked()) {
//                obj.append("  " + RegistryBinding.chkjavascript.getText().toString())
//            }

            // Condition Check

            if (RegistryBinding.edtFname == null) {
                Toast.makeText(this, "please enter your name", Toast.LENGTH_SHORT).show()
            } else if (RegistryBinding.edtFname.length() < 5 || RegistryBinding.edtFname.length() > 10) {
                Toast.makeText(
                    this,
                    "First Name should be more than 3 letters & less than 10 letters",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (RegistryBinding.edtLname == null) {
                Toast.makeText(this, "please enter last name", Toast.LENGTH_SHORT).show()
            } else if (RegistryBinding.edtLname.length() < 5) {
                Toast.makeText(this, "Last Name should be more than 3 letters", Toast.LENGTH_SHORT)
                    .show()
            } else if (RegistryBinding.edtAge == null) {
//                Log.e("TAG", "Phone filed is empty");
                Toast.makeText(this, "Age field is empty", Toast.LENGTH_SHORT).show()
            } else if (RegistryBinding.edtAdd.length() < 10) {
                Toast.makeText(this, "Address field is empty", Toast.LENGTH_SHORT).show()
            } else if (RegistryBinding.edtEmail == null) {
//
                Toast.makeText(this, "Phone field is empty", Toast.LENGTH_SHORT).show()
            } else if (RegistryBinding.edtPhone == null) {
                Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show()
            } else if (gender == null) {
                Toast.makeText(this, "Please select Gender", Toast.LENGTH_SHORT).show()
            } else if (Maritalstatus == null) {
//                Log.e("TAG", "execute:Status field is empty ");

//                Log.e("TAG", "execute:Status field is empty ");
                Toast.makeText(this, "Please select your marital status", Toast.LENGTH_SHORT).show()
            }
            else
            {
                db.insert(FirstName,LastName,Age,Address,Email,Phone,gender,Maritalstatus)
                val i = Intent(this@Registratiom_Form_Activity,MainActivity::class.java)
                startActivity(i)
            }


//            list =  db.display()
//            adapter.updatedate(list)

            if (RegistryBinding.txttitle.text.toString().equals("Edit details")) {
                if (RegistryBinding.btnsubmit.text.toString().equals("update"))
                    db.updaterecord(FirstName,LastName,Age,Address,Email,Phone, storage_id)
            } else {
                db.insert(
                    FirstName,
                    LastName,
                    Age,
                    Address,
                    Email,
                    Phone,
                    gender,
                    Maritalstatus
                )

            }

            var done = Intent(this@Registratiom_Form_Activity, MainActivity::class.java)
            startActivity(done)

        }

        if (intent != null && intent.hasExtra("updateRecord")) {
            var Nfname: String? = intent.getStringExtra("fname")
            var Nlname: String? = intent.getStringExtra("lname")
            var Nage: String? = intent.getStringExtra("age")
            var Nadd: String? = intent.getStringExtra("address")
            var Nemail: String? = intent.getStringExtra("email")
            var Nphone: String? = intent.getStringExtra("phone")
            var newtitle: String? = intent.getStringExtra("title")
            var newdonebtn: String? = intent.getStringExtra("update")
            storage_id = intent.getIntExtra("id", 0)
//            var datenew : String? = intent.getStringExtra("adddate")
//            var timenew : String? = intent.getStringExtra("addtime")

            RegistryBinding.edtFname.setText(Nfname)
            RegistryBinding.edtLname.setText(Nlname)
            RegistryBinding.edtAge.setText(Nage)
            RegistryBinding.edtAdd.setText(Nadd)
            RegistryBinding.edtEmail.setText(Nemail)
            RegistryBinding.edtAdd.setText(Nadd)
            RegistryBinding.edtPhone.setText(Nphone)
            RegistryBinding.txttitle.setText(newtitle)
            RegistryBinding.btnsubmit.setText(newdonebtn)


        }

    }
}

