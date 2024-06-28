package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.News

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
      supportActionBar?.hide()
        recyclerView = findViewById(R.id.rv)

        val foodImageArray = arrayOf(
            R.drawable.jalebi, R.drawable.chaumin, R.drawable.chilla,
            R.drawable.litti, R.drawable.dhokla, R.drawable.appe,
            R.drawable.samosa, R.drawable.upma , R.drawable.dosa, R.drawable.pavbhaji, R.drawable.panipuri,R.drawable.pakodi,
            R.drawable.potato,R.drawable.breadpakoda,R.drawable.idli,R.drawable.white,R.drawable.frenchfries,R.drawable.cholebhature,R.drawable.kulche,
            R.drawable.chaat, R.drawable. pizza,R.drawable.pink,R.drawable.burger,R.drawable.sanwich,R.drawable.chips,R.drawable.maggie,R.drawable.onion,R.drawable.red,
            R.drawable.momos,R.drawable.tikki
        )


        val foodNameArray = arrayOf(
            "Jalebi", "Chaumin", "Chilla", "Litti Chokha",
            "Dhokla", "Appe", "Samosa", "Upma","Dosa","Pav Bhaji","Pani Puri","Pakodi","Chilli Potato","Bread Pakoda", "Idli Shambhar","White Sauce Pasta","French Fries",
            "Chole Bhature","Chole Kulche","Chaat","Pizza","Pink Sauce Pasta" ,"Burger" ,"Sandwich","Chips" , "Maggie","Onion Ring","Red Sauce Pasta" ,"Momos" , "Tikki"
        )

        val foodcontentarray = arrayOf(

            getString(R.string.mycontent),getString(R.string.mydish1),getString(R.string.mydish2),getString(R.string.mydish3),getString(R.string.mydish4),getString(R.string.mydish5),getString(R.string.mydish6),getString(R.string.mydish7),getString(R.string.mydish8),getString(R.string.mydish9),getString(R.string.mydish10),getString(R.string.mydish11),getString(R.string.mydish12),getString(R.string.mydish13),getString(R.string.mydish14)
                   , getString(R.string.mydish15),getString(R.string.mydish16),getString(R.string.mydish17),getString(R.string.mydish18),getString(R.string.mycontent1),getString(R.string.mydish20),getString(R.string.mydish21),getString(R.string.mydish22),getString(R.string.mydish23),getString(R.string.mydish24),getString(R.string.mydish25),getString(R.string.mydish26),getString(R.string.mydish27),getString(R.string.mydish28),getString(R.string.mydish29))
        recyclerView.layoutManager = LinearLayoutManager(this)
        arrayList = ArrayList()

        for (index in foodNameArray.indices) {
            val details = News(foodNameArray[index], foodImageArray[index],foodcontentarray[index])
            Log.d("MainActivity", "Adding item: ${details.foodname}")
            arrayList.add(details)
        }
var myAdapter =MyAdapter(arrayList, this)
        recyclerView.adapter = myAdapter

        myAdapter.setitemclicklistener(object :MyAdapter.myOnclicklistener{
            override fun onItemClick(position: Int) {
//on clicking each item
                val intent = Intent(this@MainActivity,newActivity::class.java)

                intent.putExtra("image",arrayList[position].foodimage)
                intent.putExtra("content",arrayList[position].fooddata)
                startActivity(intent)

            }
        })

    }

    private fun enableEdgeToEdge() {
        // Implement your edge-to-edge functionality here if needed
    }
}


