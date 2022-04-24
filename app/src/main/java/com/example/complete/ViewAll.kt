package com.example.complete

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_view_all.*

class ViewAll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        updateRecyclerView()
    }

     fun updateRecyclerView() {
        var db = DBHelper(this)
        var arr=db.retriveall()
        var adapter= Adapter(this,arr)
        abc.adapter=adapter
    }

    fun delete(position: Int) {
        Toast.makeText(applicationContext,"im here", Toast.LENGTH_LONG).show()
        var db=DBHelper(this)
        var arr:ArrayList<Register> = db.retriveall()
        var sub=arr.get(position)
        Toast.makeText(applicationContext,"${sub.s_name}", Toast.LENGTH_LONG).show()
        db.Delete(sub.s_name)
        updateRecyclerView()
    }

   /* fun update(position: Int) {
        var db=DBHelper(this)
        var arr:ArrayList<Bike_updeta> = db.retriveAll()
        var person=arr.get(position)
        var dialog= Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.txtUpadateId.setText(person.bid.toString())
        dialog.edtupadetename.setText(person.bname)
        dialog.edtUpdatedesc.setText(person.bdesc)
        dialog.btnUpdate.setOnClickListener {
            var id=dialog.txtUpadateId.text.toString().toInt()
            var name=dialog.edtupadetename.text.toString()
            var desc=dialog.edtUpdatedesc.text.toString()
            var p=Bike_updeta(id,name,desc)
            db.update(p)
            dialog.dismiss()
            updateRecyclerView()
        }
        dialog.show()
    }*/


}