package com.example.lostandfound

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LostItemListActivity: AppCompatActivity() {

    lateinit var itemAdapter: AddItemAdapter
    lateinit var linearLayoutManager : LinearLayoutManager
    lateinit var lostItemBtn: Button
    var item: String = ""
    var date: String = ""
    var description: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lostitemlist)

        lostItemBtn = findViewById(R.id.btnLostItem)
        val recycler = findViewById<RecyclerView>(R.id.RecyclerView)

        itemAdapter = AddItemAdapter(this)
        linearLayoutManager = LinearLayoutManager(this)

        recycler.layoutManager = linearLayoutManager
        recycler.adapter = itemAdapter


        lostItemBtn.setOnClickListener {

            openActivityForResult()

        }

    }

    fun openActivityForResult(){
        val intent = Intent(this, AddItemActivity::class.java)
        resultLauncher.launch(intent)
    }

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data: Intent? = result.data
                item = data?.extras!!.get("item").toString()
                date = data?.extras!!.get("date").toString()
                description = data?.extras!!.get("description").toString()

                itemAdapter.add(LostItem(item, date, description))
                

//                val sendToAdapter = Intent(this, AddItemAdapter::class.java)
//                sendToAdapter.putExtra("item", item.toString())
//                sendToAdapter.putExtra("description", description.toString())
//                sendToAdapter.putExtra("date", date.toString())



                //Toast.makeText(applicationContext, "The item is: $item", Toast.LENGTH_SHORT).show()
            }
    }

}



