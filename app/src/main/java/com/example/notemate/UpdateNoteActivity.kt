package com.example.notemate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notemate.databinding.ActivityUpdateBinding

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUpdateBinding
    private lateinit var db:NoteDatabaseHelper
    private var noteId:Int=-1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        noteId = intent.getIntExtra("node_id",-1)
        if(noteId==-1){
            finish()
            return
        }
        val note = db.getNoteByID(noteId)
        binding.updateeditText1.setText(note.title)
        binding.updateeditText2.setText(note.content)

        binding.update.setOnClickListener{
            val newTitle = binding.updateeditText1.text.toString()
            val newContent = binding.updateeditText2.text.toString()
            val updatedNote=Note(noteId,newTitle,newContent)
            db.updateNote(updatedNote)
            finish()
            Toast.makeText(this,"Changes Saved", Toast.LENGTH_SHORT).show()
        }

    }
}