package com.aptcoder.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.aptcoder.calculator.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    var finalresult: Double = 0.0
    var current: String = ""
    var finalExpression: String = ""
    var operator: String = ""
    var num1: String = ""
    private lateinit var mainactivity: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainactivity =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        mainactivity.one.setOnClickListener() {
            current += "1"
            mainactivity.userInput.text = current

        }
        mainactivity.two.setOnClickListener() {
            current += "2"
            mainactivity.userInput.text = current

        }
        mainactivity.three.setOnClickListener() {
            current += "3"
            mainactivity.userInput.text = current

        }
        mainactivity.four.setOnClickListener() {
            current += "4"
            mainactivity.userInput.text = current

        }
        mainactivity.five.setOnClickListener() {
            current += "5"
            mainactivity.userInput.text = current

        }
        mainactivity.six.setOnClickListener() {
            current += "6"
            mainactivity.userInput.text = current

        }
        mainactivity.seven.setOnClickListener() {
            current += "7"
            mainactivity.userInput.text = current

        }
        mainactivity.eight.setOnClickListener() {
            current += "8"
            mainactivity.userInput.text = current

        }
        mainactivity.nine.setOnClickListener() {
            current += "9"
            mainactivity.userInput.text = current

        }
        mainactivity.zero.setOnClickListener() {
            current += "0"
            mainactivity.userInput.text = current

        }
        mainactivity.dot.setOnClickListener() {
            current += "."
            mainactivity.userInput.text = current

        }

        mainactivity.clear.setOnClickListener() {
            current = ""
            finalresult = 0.0
            finalExpression = ""
            mainactivity.finalexpression.text = finalExpression
            mainactivity.userInput.text = ""
            mainactivity.finalResult.text = ""
        }
        //operators
        mainactivity.add.setOnClickListener() {
            operator = "+"

            showexpression()
        }
        mainactivity.subtract.setOnClickListener() {
            operator = "-"
            showexpression()
        }
        mainactivity.multiply.setOnClickListener() {
            operator = "x"
            showexpression()
        }
        mainactivity.devide.setOnClickListener() {
            operator = "/"
            showexpression()
        }
        mainactivity.modulo.setOnClickListener() {
            operator = "%"
            showexpression()
        }
        mainactivity.square.setOnClickListener() {
            try {
                if (mainactivity.userInput.text.isNotEmpty()) {
                    operator = "sq"
                    finalExpression = "sqr($current)"
                    mainactivity.finalexpression.text = finalExpression
                    var res = current.toDouble()
                        .pow(2.0).toString()
                    mainactivity.finalResult.text = res
                    current = res
                    saveToHistory(finalExpression, finalresult)
                } else {

                    Toast.makeText(this, "Enter A Number First", Toast.LENGTH_SHORT).show()

                }
            } catch (e: Exception) {
                mainactivity.finalResult.text = "INVALID INPUT"
            }

        }


        mainactivity.equals.setOnClickListener() {
            current = mainactivity.userInput.text.trim().toString()
            finalExpression += current
            mainactivity.finalexpression.text = finalExpression
            evaluate(operator)


        }


    }

    private fun evaluate(operator: String) {
        if (num1.isEmpty() || current.isEmpty()) {
            Toast.makeText(this, "Please clear and Try again", Toast.LENGTH_SHORT).show()

        } else {
            try {
                var res = 0.0
                when (operator) {

                    "+" -> {
                        res = num1.toDouble() + current.toDouble()
                        finalresult = res
                        mainactivity.finalResult.text = finalresult.toString()

                        mainactivity.finalexpression.text = finalExpression

                        saveToHistory(finalExpression, finalresult)

                    }
                    "x" -> {
                        res = num1.toDouble() * current.toDouble()
                        finalresult = res
                        mainactivity.finalResult.text = finalresult.toString()

                        mainactivity.finalexpression.text = finalExpression
                        saveToHistory(finalExpression, finalresult)
                    }
                    "-" -> {
                        res = num1.toDouble() - current.toDouble()
                        finalresult = res
                        mainactivity.finalResult.text = finalresult.toString()

                        mainactivity.finalexpression.text = finalExpression
                        saveToHistory(finalExpression, finalresult)
                    }
                    "%" -> {
                        res = num1.toDouble() % current.toDouble()
                        finalresult = res
                        mainactivity.finalResult.text = finalresult.toString()

                        mainactivity.finalexpression.text = finalExpression
                        saveToHistory(finalExpression, finalresult)
                    }
                    "/" -> {
                        res = num1.toDouble() / current.toDouble()
                        finalresult = res
                        mainactivity.finalResult.text = finalresult.toString()

                        mainactivity.finalexpression.text = finalExpression
                        saveToHistory(finalExpression, finalresult)
                    }
                }
                current = res.toString()
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun saveToHistory(finalExpression: String, finalresult: Double) {
        val histObj=HistObj(finalExpression,finalresult.toString(),Date().time)
        val ref = FirebaseDatabase.getInstance().reference.child("CalcHist")
        val key = ref.push().key!!
        ref.child(key).setValue(histObj)



    }

    private fun showexpression() {
        if (mainactivity.userInput.text.isEmpty()) {
            Toast.makeText(this, "Enter A Number First", Toast.LENGTH_SHORT).show()
        } else {
            finalExpression = current + operator
            num1 = current
            current = ""
            mainactivity.userInput.text = current
            mainactivity.finalexpression.text = finalExpression
        }

    }
}