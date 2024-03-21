package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val label: TextView = findViewById(R.id.label)
        val button00 : Button = findViewById(R.id.button00)
        val button0 : Button = findViewById(R.id.button0)
        val button1 : Button = findViewById(R.id.button1)
        val button2 : Button = findViewById(R.id.button2)
        val button3 : Button = findViewById(R.id.button3)
        val button4 : Button = findViewById(R.id.button4)
        val button5 : Button = findViewById(R.id.button5)
        val button6 : Button = findViewById(R.id.button6)
        val button7 : Button = findViewById(R.id.button7)
        val button8 : Button = findViewById(R.id.button8)
        val button9 : Button = findViewById(R.id.button9)
        val buttonZap : Button = findViewById(R.id.buttonZap)
        val buttonAC : Button = findViewById(R.id.buttonAC)
        val buttonProc : Button = findViewById(R.id.buttonProc)
        val buttonDel : Button = findViewById(R.id.buttonDel)
        val buttonDiv : Button = findViewById(R.id.buttonDiv)
        val buttonMulty : Button = findViewById(R.id.buttonMulty)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        val buttonRavno : Button = findViewById(R.id.buttonRavno)

        button00.setOnClickListener {if (label.text.length > 0) label.text = label.text.toString() + "00"}
        button0.setOnClickListener {if (label.text.length != 1) label.text = label.text.toString() +"0"}
        button1.setOnClickListener {label.text = label.text.toString() +"1"}
        button2.setOnClickListener {label.text = label.text.toString() +"2"}
        button3.setOnClickListener {label.text = label.text.toString() +"3"}
        button4.setOnClickListener {label.text = label.text.toString() +"4"}
        button5.setOnClickListener {label.text = label.text.toString() +"5"}
        button6.setOnClickListener {label.text = label.text.toString() +"6"}
        button7.setOnClickListener {label.text = label.text.toString() +"7"}
        button8.setOnClickListener {label.text = label.text.toString() +"8"}
        button9.setOnClickListener {label.text = label.text.toString() +"9"}
        buttonZap.setOnClickListener {if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() +"."}
        buttonProc.setOnClickListener { if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() + "%"}
        buttonDiv.setOnClickListener {if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() + "/"}
        buttonMulty.setOnClickListener {if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() + "*"}
        buttonMinus.setOnClickListener {if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() + "-"}
        buttonPlus.setOnClickListener {if (label.text.length > 0 && label.text[label.text.length - 1].isDigit()) label.text = label.text.toString() + "+"}
        buttonDel.setOnClickListener {if (label.text.length > 0) label.text = label.text.substring(0, label.text.length - 1)}
        buttonAC.setOnClickListener {label.text = ""}

        buttonRavno.setOnClickListener {
            if (label.text.length > 0) {
                try{
                    val expression = ExpressionBuilder(label.text.toString()).build()
                    val result = expression.evaluate()
                    val longRes = result.toLong()
                    val resultIntent = Intent(this, MainActivity2::class.java)
                    if (result == longRes.toDouble())
                        resultIntent.putExtra(MainActivity2.ANSWER, longRes.toString())
                    else
                        resultIntent.putExtra(MainActivity2.ANSWER, result.toString())
                    startActivity(resultIntent)
                    label.text = ""
                }catch (e: Exception){
                    label.text = "Error"
                }

            }
        }








    }


}
