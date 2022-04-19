package com.markussabolins.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class PVPGame : AppCompatActivity() {

    enum class curTurn{
        circle,
        cross;

    }
    private var firstTurn:curTurn = curTurn.values()[Random.nextInt(0,2)]
    var currentTurn:curTurn = firstTurn;

    var robot = "false"

    /*val somebtn= Button(this);

    var square11:Button = somebtn
    var square12:Button= somebtn
    var square13:Button= somebtn

    var square21:Button= somebtn
    var square22:Button= somebtn
    var square23:Button= somebtn

    var square31:Button= somebtn
    var square32:Button= somebtn
    var square33:Button= somebtn
     */
    lateinit var Buttons: List<Button>

    private fun MarkSquare(btn:Button){
        Log.d("Begin", currentTurn.toString())
        if(btn.text !=" " ) return;
        if (currentTurn.equals(curTurn.circle)){
            btn.text = "O"
            currentTurn = curTurn.cross
        }
        else if (currentTurn.equals(curTurn.cross)){
            btn.text = "X"
            currentTurn = curTurn.circle
        }
        Log.d("End", currentTurn.toString())

        TurnIndicator()

        CheckWin("O")
        CheckWin("X")
        if (CheckFull()){
            DisplayWin("draw")
            return
        }

    }

    private fun CheckWin(s:String){
        Log.d("CheckWin", "checking...")

        //horizontal check
        if (Buttons[0].text==s && Buttons[1].text==s && Buttons[2].text==s){ DisplayWin(s); return}
        if (Buttons[3].text==s && Buttons[4].text==s && Buttons[5].text==s) { DisplayWin(s); return}
        if (Buttons[6].text==s && Buttons[7].text==s && Buttons[8].text==s) { DisplayWin(s); return}
        //vertical check
        if (Buttons[0].text==s && Buttons[3].text==s && Buttons[6].text==s) { DisplayWin(s); return}
        if (Buttons[1].text==s && Buttons[4].text==s && Buttons[7].text==s) { DisplayWin(s); return}
        if (Buttons[2].text==s && Buttons[5].text==s && Buttons[8].text==s) { DisplayWin(s); return}
        //Diagonal check
        if (Buttons[6].text==s && Buttons[4].text==s && Buttons[2].text==s) { DisplayWin(s); return}
        if (Buttons[0].text==s && Buttons[4].text==s && Buttons[8].text==s) { DisplayWin(s); return}



    }

    private fun CheckFull(): Boolean {
        var b = true
        for(btn in Buttons){
            if (btn.text==" "){
                b= false;
                break;
            }
        }
        return b

    }
    var hasWon:Boolean = false;
    private fun DisplayWin(s:String){
        if (hasWon) return
        hasWon=true
        Log.d("CheckWin", "someone won...")
        var winner = ""
        if (s == "X") winner = getIntent().getStringExtra("pl1").toString();
        else if (s == "O") winner = getIntent().getStringExtra("pl2").toString();
        else winner = "no one :("
        Log.d("DisplayWin", winner)
        AlertDialog.Builder(this)
            .setTitle("The winner is..." + winner)
            .setPositiveButton("Play again")
            {_,_->
                ResetGame()
            }
            .setCancelable(false)
            .show()
    }

    private fun ResetGame(){
        for(btn in Buttons){
            btn.text=" "
        }
        hasWon=false
    }
    private fun TurnIndicator(){

        var s = ""
        if(currentTurn.equals(curTurn.circle)){
            s = getIntent().getStringExtra("pl2").toString() + " , It's your turn!"
        }
        else s = getIntent().getStringExtra("pl1").toString() + " , It's your turn!"
        var label:TextView = findViewById(R.id.textCurTurn)
        label.text = s

        if (robot=="true" && currentTurn.equals(curTurn.circle)) robotTurn()

    }

    private fun robotTurn(){
        if(CheckFull()) return
        var rand = Random.nextInt(0, Buttons.size)
        if (Buttons[rand].text == " "){
            MarkSquare(Buttons[rand])
            return
        }
        robotTurn()
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pvpgame)
        Log.d("TAG", firstTurn.toString())
        val btnreturn: Button= findViewById(R.id.buttonReturn1)
        robot = getIntent().getStringExtra("pve?").toString()
        Log.d("Robot?", robot)
        Log.d("src", getIntent().getStringExtra("pve?").toString())

        btnreturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
        }

        TurnIndicator();

        var square11:Button= findViewById(R.id.button11)
        var square12:Button = findViewById(R.id.button12)
        var square13:Button = findViewById(R.id.button13)

        var square21:Button = findViewById(R.id.button21)
        var square22:Button = findViewById(R.id.button22)
        var square23:Button = findViewById(R.id.button23)

        var square31:Button = findViewById(R.id.button31)
        var square32:Button = findViewById(R.id.button32)
        var square33:Button = findViewById(R.id.button33)
        square11.setOnClickListener {
            MarkSquare(square11)
        }
        square12.setOnClickListener {
            MarkSquare(square12)
        }
        square13.setOnClickListener {
            MarkSquare(square13)
        }
        square21.setOnClickListener {
            MarkSquare(square21)
        }
        square22.setOnClickListener {
            MarkSquare(square22)
        }
        square23.setOnClickListener {
            MarkSquare(square23)
        }
        square31.setOnClickListener {
            MarkSquare(square31)
        }
        square32.setOnClickListener {
            MarkSquare(square32)
        }
        square33.setOnClickListener {
            MarkSquare(square33)
        }

        Buttons = listOf(square11, square12, square13,
            square21, square22, square23,
            square31, square32, square33);




    }
}