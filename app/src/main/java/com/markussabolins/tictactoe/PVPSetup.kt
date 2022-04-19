package com.markussabolins.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

public class PVPSetup : AppCompatActivity() {

    public var Player1Name = "player1"
    public var Player2Name = "Player2"

    public fun GetPl1(): String {
        return Player1Name;
    }
    public fun GetPl2(): String {
        return Player2Name;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvpsetup)

        val btnStart: Button = findViewById(R.id.btnStartPVP)

        btnStart.setOnClickListener {
            Player1Name = findViewById<EditText>(R.id.txtPlayerName1).text.toString();
            Player2Name = findViewById<EditText>(R.id.txtPlayerName2).text.toString();
            val intent= Intent(this, PVPGame::class.java);
            intent.putExtra("pl1", Player1Name)
            intent.putExtra("pl2", Player2Name)
            intent.putExtra("pve?", "false")
            startActivity(intent)
        }
    }
}