package com.markussabolins.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PVESetup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvesetup)

        val startBut:Button = findViewById(R.id.buttonStartPVE)
        startBut.setOnClickListener {
            val intent= Intent(this, PVPGame::class.java);
            intent.putExtra("pl1", findViewById<EditText>(R.id.pl1Name).text.toString())
            intent.putExtra("pl2", "robot")
            intent.putExtra("pve?", "true")
            startActivity(intent)
        }

    }
}