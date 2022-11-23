package com.vanphuc.androidchart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.vanphuc.androidchart.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            var x = 0f
            val data = mutableListOf<Entry>()
            chipLineChart.setOnClickListener {
                val random = Random
                repeat(10) {
                    data.add(Entry(x, random.nextFloat()))
                    x += 1f
                }
                lineChart.data = LineData(LineDataSet(data, "content"))
                lineChart.invalidate()
            }
            lineChart.apply {
                setMaxVisibleValueCount(10)
                description = Description().apply {
                    text = "Hello Line Chart"
                    textColor = Color.GREEN
                }
            }
        }
    }
}