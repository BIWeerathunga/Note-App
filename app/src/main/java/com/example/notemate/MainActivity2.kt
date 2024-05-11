package com.example.notemate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notemate.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding
    private lateinit var db:NoteDatabaseHelper
    private lateinit var notesAdapter:NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)

        binding.notesrecyclerview.layoutManager = LinearLayoutManager(this)
        binding.notesrecyclerview.adapter=notesAdapter


        binding.imageViewadd.setOnClickListener{
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
        val add = findViewById<ImageView>(R.id.imageViewadd)
        add.setOnClickListener{
            val Intent = Intent(this,AddNoteActivity::class.java)
            startActivity(Intent)
        }
    }
    override fun onResume(){
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())
    }
}