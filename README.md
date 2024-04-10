dependencies {
	        implementation 'com.github.huangfangjing:ChartLibrary:v1.0.0'
	}


折线图

       var lineView: AiLineChartView = findViewById(R.id.lineView)
        var lineData: List<TwoLevelData> =
            Gson().fromJson(StaticData.DATA, object : TypeToken<ArrayList<TwoLevelData>>() {}.type)
        lineView.buildDate(lineData, LineChartView.OnLineChartListener {
            //点击事件，不需要则传null
            Toast.makeText(baseContext, it.indexName, Toast.LENGTH_LONG).show()
        })
        lineView.setUseAnimation(true)//默认使用动画



条形图

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
