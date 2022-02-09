package com.example.recyclerviewwithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

public final class UserlistActivity : AppCompatActivity() {

    private lateinit var dbref:DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)

//        val fnames = arrayOf(
//            "Aishwariya", "Sai", "Madhuri", "Kareena", "Karishma", "Rashmika",
//            "Aishwariya", "Sai", "Madhuri"
//        )
//
//        val lnames = arrayOf(
//            "Bacchan", "Pallavi", "Dixit", "Kapoor", "Kapoor", "Mandana",
//            "Bacchan", "Pallavi", "Dixit"
//        )
//
//        val ages = arrayOf(
//            23, 24, 21, 23, 25, 22,
//            23, 24, 21
//        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        userList = ArrayList<User>()
        getUserData()
//        for(i in fnames.indices){
//            val newUser = User(fnames[i], lnames[i], ages[i])
//            userList.add(newUser)
//        }
//
//        recyclerView.adapter = MyAdapter(userList)
    }


    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Actresses")
        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(i in snapshot.children){
                        val newUser = i.getValue(User::class.java)
                        userList.add(newUser!!)
                    }

                    recyclerView.adapter = MyAdapter(userList)
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                finish()
            }
        })
    }
}