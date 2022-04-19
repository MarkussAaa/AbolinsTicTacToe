package com.markussabolins.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pvpButton: Button = findViewById (R.id.buttonPVP);
        val pveButton: Button = findViewById(R.id.buttonPVE);
        val exitButton: Button = findViewById(R.id.buttonExit);

        pvpButton.setOnClickListener {
            val Intent = Intent(this, PVPSetup::class.java)
            startActivity(Intent)
        }

        pveButton.setOnClickListener {
            val Intent = Intent(this, PVESetup::class.java)
            startActivity(Intent)
        }

        exitButton.setOnClickListener {
            exitProcess(0);
        }

    }
}