package com.example.mychart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.chartlibraby.bean.StaticData
import com.example.chartlibraby.bean.TwoLevelData
import com.example.chartlibraby.widget.AiLineChartView
import com.example.chartlibraby.widget.AiVerticalBarView
import com.example.chartlibraby.widget.LineChartView
import com.example.chartlibraby.widget.VerticalBarView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lineView: AiLineChartView = findViewById(R.id.lineView)

        var lineData: List<TwoLevelData> =
            Gson().fromJson(StaticData.DATA, object : TypeToken<ArrayList<TwoLevelData>>() {}.type)
        lineView.buildDate(lineData, LineChartView.OnLineChartListener {
            //点击事件，不需要则传null
            Toast.makeText(baseContext, it.indexName, Toast.LENGTH_LONG).show()
        })
        lineView.setUseAnimation(true)//默认使用动画


        var barView: AiVerticalBarView = findViewById(R.id.barView)
        var barData: List<TwoLevelData> = Gson().fromJson(
            StaticData.DATA_BAR,
            object : TypeToken<ArrayList<TwoLevelData>>() {}.type
        )
        barView.buildDate(barData, VerticalBarView.OnVerticalBarClick { position, levelData ->
            //点击事件，不需要则传null
            Toast.makeText(baseContext, levelData.indexName, Toast.LENGTH_LONG).show()
        }, "人数", "分数")
        barView.hideIndicate()
        barView.setUseAnimation(true)//默认使用动画

    }
}