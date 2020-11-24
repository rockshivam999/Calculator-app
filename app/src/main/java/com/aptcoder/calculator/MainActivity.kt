package com.aptcoder.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.aptcoder.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
        var finalresult:Double = 0.0
        var current:String=""
        var finalExpression:String=""
        var operator:String=""
    private lateinit var mainactivity:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         mainactivity=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)


        mainactivity.one.setOnClickListener(){
            current+="1"
            mainactivity.userInput.text=current

        }
        mainactivity.two.setOnClickListener(){
            current+="2"
            mainactivity.userInput.text=current

        }
        mainactivity.three.setOnClickListener(){
            current+="3"
            mainactivity.userInput.text=current

        }
        mainactivity.four.setOnClickListener(){
            current+="4"
            mainactivity.userInput.text=current

        }
        mainactivity.five.setOnClickListener(){
            current+="5"
            mainactivity.userInput.text=current

        }
        mainactivity.six.setOnClickListener(){
            current+="6"
            mainactivity.userInput.text=current

        }
        mainactivity.seven.setOnClickListener(){
            current+="7"
            mainactivity.userInput.text=current

        }
        mainactivity.eight.setOnClickListener(){
            current+="8"
            mainactivity.userInput.text=current

        }
        mainactivity.nine.setOnClickListener(){
            current+="9"
            mainactivity.userInput.text=current

        }
        mainactivity.zero.setOnClickListener(){
            current+="0"
            mainactivity.userInput.text=current

        }
        mainactivity.dot.setOnClickListener(){
            current+="."
            mainactivity.userInput.text=current

        }

        mainactivity.clear.setOnClickListener(){
            current=""
            finalresult=0.0
            finalExpression=""
            mainactivity.finalexpression.text=finalExpression
            mainactivity.userInput.text=""
        }
        //operators
        mainactivity.add.setOnClickListener(){
            operator="+"
            evaluate(operator,it)
            showexpression()
        }
        mainactivity.subtract.setOnClickListener(){
            operator="-"
            showexpression()
        }
        mainactivity.multiply.setOnClickListener(){
            operator="x"
            showexpression()
        }
        mainactivity.devide.setOnClickListener(){
            operator="d"
            showexpression()
        }
        mainactivity.modulo.setOnClickListener(){
            operator="%"
            showexpression()
        }
        mainactivity.square.setOnClickListener(){
            operator="^2"
            finalExpression=""
            showexpression()
        }









    }

    private fun evaluate(operator: String, it: View?) {
        when(it!!.id){
            mainactivity.add.id->{
                if(current.isNotEmpty()) {
                    finalresult += current.toDouble()
                }

            }
        }
    }

    private fun showexpression() {

        finalExpression+=current+operator
        current=""
        mainactivity.finalexpression.text=finalExpression

    }
}