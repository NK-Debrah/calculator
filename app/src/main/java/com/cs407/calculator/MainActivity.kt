package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    fun isInteger(input: String): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val addButton = findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val multButton = findViewById<Button>(R.id.multButton)
        val divButton = findViewById<Button>(R.id.divButton)
        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)

        addButton.setOnClickListener{

            if (firstNumber.text.toString().isBlank() || secondNumber.text.toString().isBlank()){
                Toast.makeText(this, "You need 2 inputs", Toast.LENGTH_SHORT).show()
            } else if (!isInteger(firstNumber.text.toString()) || !isInteger(secondNumber.text.toString())) {
                Toast.makeText(this, "Please enter valid integers only", Toast.LENGTH_SHORT).show()
            } else {
                val answer = firstNumber.text.toString().toInt() + secondNumber.text.toString().toInt()
                val intent = Intent(this, ResultPage::class.java)
                intent.putExtra("Answer", answer.toString())
                startActivity(intent)
            }

        }
        subButton.setOnClickListener{
            if (firstNumber.text.toString().isBlank() || secondNumber.text.toString().isBlank()){
                Toast.makeText(this, "You need 2 inputs", Toast.LENGTH_SHORT).show()
            } else if (!isInteger(firstNumber.text.toString()) || !isInteger(secondNumber.text.toString())) {
                Toast.makeText(this, "Please enter valid integers only", Toast.LENGTH_SHORT).show()
            } else {
                val answer = firstNumber.text.toString().toInt() - secondNumber.text.toString().toInt()
                val intent = Intent(this, ResultPage::class.java)
                intent.putExtra("Answer", answer.toString())
                startActivity(intent)

            }
        }
        multButton.setOnClickListener{
            if (firstNumber.text.toString().isBlank() || secondNumber.text.toString().isBlank()){
                Toast.makeText(this, "You need 2 inputs", Toast.LENGTH_SHORT).show()
            } else if (!isInteger(firstNumber.text.toString()) || !isInteger(secondNumber.text.toString())) {
                Toast.makeText(this, "Please enter valid integers only", Toast.LENGTH_SHORT).show()
            } else {

                val answer = firstNumber.text.toString().toInt() * secondNumber.text.toString().toInt()
                val intent = Intent(this, ResultPage::class.java)
                intent.putExtra("Answer", answer.toString())
                startActivity(intent)
            }
        }
        divButton.setOnClickListener{
            if (firstNumber.text.toString().isBlank() || secondNumber.text.toString().isBlank()){
                Toast.makeText(this, "You need 2 inputs", Toast.LENGTH_SHORT).show()
            } else if (!isInteger(firstNumber.text.toString()) || !isInteger(secondNumber.text.toString())) {
                Toast.makeText(this, "Please enter valid integers only", Toast.LENGTH_SHORT).show()
            } else {
                val answer =
                    firstNumber.text.toString().toFloat() / secondNumber.text.toString().toFloat()
                val intent = Intent(this, ResultPage::class.java)
                intent.putExtra("Answer", answer.toString())
                startActivity(intent)
            }
        }



    }
}