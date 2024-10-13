package com.example.calculatorlinearlayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var text_result: TextView
    var state: Int = 1
//    var point: Boolean = false
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text_result = findViewById<TextView>(R.id.display)

        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.buttonAdd).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener(this)
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEqual).setOnClickListener(this)
        findViewById<Button>(R.id.buttonBS).setOnClickListener(this)
        findViewById<Button>(R.id.buttonC).setOnClickListener(this)
        findViewById<Button>(R.id.buttonCE).setOnClickListener(this)
        findViewById<Button>(R.id.buttondot).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.button0) {
            createNumber(0)
        } else if (id == R.id.button1) {
            createNumber(1)
        } else if (id == R.id.button2) {
            createNumber(2)
        } else if (id == R.id.button3) {
            createNumber(3)
        } else if (id == R.id.button4) {
            createNumber(4)
        } else if (id == R.id.button5) {
            createNumber(5)
        } else if (id == R.id.button6) {
            createNumber(6)
        } else if (id == R.id.button7) {
            createNumber(7)
        } else if (id == R.id.button8) {
            createNumber(8)
        } else if (id == R.id.button9) {
            createNumber(9)
        }
//        else if (id == R.id.buttondot) {
//            point = true
//        }
        else if (id == R.id.buttonCE) {
            op1 = 0
            op2 = 0
            text_result.text = "0"
        } else if (id == R.id.buttonC) {
            if (state == 1) {
                op1 = 0
                text_result.text = "0"
            } else {
                op2 = 0
                text_result.text = "0"
            }
        } else if (id == R.id.buttonEqual) {
            var result: Int = 0
            if (state == 1){
                text_result.text = "Error"
            }else {
                if (op == 1) {
                    result = op1 + op2
                    text_result.text = "$result"
                }
                if (op == 2) {
                    result = op1 - op2
                    text_result.text = "$result"
                }
                if (op == 3) {
                    result = op1 * op2
                    text_result.text = "$result"
                }
                if (op == 4) {
                    if (op2 != 0) {
                        val divideresult: Float = op1.toFloat() / op2
                        text_result.text = "$divideresult"
                    } else {
                        text_result.text = "Error"
                    }
                }
            }
            state = 1
            op1 = 0
            op2 = 0
        } else if (id == R.id.buttonAdd) {
            op = 1
            state = 2
        } else if (id == R.id.buttonSubtract) {
            op = 2
            state = 2
        } else if (id == R.id.buttonMultiply) {
            op = 3
            state = 2
        } else if (id == R.id.buttonDivide) {
            op = 4
            state = 2
        }
    }

    fun createNumber(c: Int) {
        if (state == 1) {
                op1 = op1 * 10 + c
            text_result.text = "$op1"
        } else {
                op2 = op2 * 10 + c
            text_result.text = "$op2"
        }
    }
}
