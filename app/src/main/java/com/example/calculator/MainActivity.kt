package com.example.calculator

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
     lateinit var display: TextView
     lateinit var zero: Button
     lateinit var one: Button
     lateinit var two: Button
     lateinit var three: Button
     lateinit var four: Button
     lateinit var five: Button
     lateinit var six: Button
     lateinit var seven: Button
     lateinit var eight: Button
     lateinit var nine: Button
     lateinit var plusMinus: Button
     lateinit var Colon: Button
     lateinit var Mull: Button
     lateinit var divide: Button
     lateinit var Sum: Button
     lateinit var Sub: Button
     lateinit var clear: Button
     lateinit var result: Button
     lateinit var del: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainView::class.java)

        display = findViewById(R.id.tvDisplay)

        display.text = viewModel.displayText

        zero = findViewById(R.id.bt0)
        zero.setOnClickListener { viewModel.setNum('0'); display.text = viewModel.displayText }
        one = findViewById(R.id.bt1)
        one.setOnClickListener { viewModel.setNum('1'); display.text = viewModel.displayText }
        two = findViewById(R.id.bt2)
        two.setOnClickListener { viewModel.setNum('2'); display.text = viewModel.displayText }
        three = findViewById(R.id.bt3)
        three.setOnClickListener { viewModel.setNum('3'); display.text = viewModel.displayText }
        four = findViewById(R.id.bt4)
        four.setOnClickListener { viewModel.setNum('4'); display.text = viewModel.displayText }
        five = findViewById(R.id.bt5)
        five.setOnClickListener { viewModel.setNum('5'); display.text = viewModel.displayText }
        six = findViewById(R.id.bt6)
        six.setOnClickListener { viewModel.setNum('6'); display.text = viewModel.displayText }
        seven = findViewById(R.id.bt7)
        seven.setOnClickListener { viewModel.setNum('7'); display.text = viewModel.displayText }
        eight = findViewById(R.id.bt8)
        eight.setOnClickListener { viewModel.setNum('8'); display.text = viewModel.displayText }
        nine = findViewById(R.id.bt9)
        nine.setOnClickListener { viewModel.setNum('9'); display.text = viewModel.displayText }
        Sum = findViewById(R.id.btSum)
        Sum.setOnClickListener { viewModel.handleOperator('+'); display.text = viewModel.displayText }
        Sub = findViewById(R.id.btSub)
        Sub.setOnClickListener { viewModel.handleOperator('-'); display.text = viewModel.displayText }
        Mull = findViewById(R.id.btMul)
        Mull.setOnClickListener { viewModel.handleOperator('*'); display.text = viewModel.displayText }
        divide = findViewById(R.id.btDiv)
        divide.setOnClickListener { viewModel.handleOperator('/'); display.text = viewModel.displayText }
        Colon = findViewById(R.id.btColon)
        Colon.setOnClickListener { viewModel.onClickDecimal(); display.text = viewModel.displayText }
        plusMinus = findViewById(R.id.btNeg)
        plusMinus.setOnClickListener { viewModel.onClickPlusMinus(); display.text = viewModel.displayText }
        clear = findViewById(R.id.btClear)
        clear.setOnClickListener { viewModel.clearAll(); display.text = viewModel.displayText }
        result = findViewById(R.id.btEqual)
        result.setOnClickListener { viewModel.calculate(); display.text = viewModel.displayText }
        del = findViewById(R.id.btDel)
        del.setOnClickListener { viewModel.deleteLast(); display.text = viewModel.displayText }
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            display.setPadding(0,0,24,0)
            display.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            display.setPadding(0,24,24,0)
            display.textSize = 32f
        }
    }
}