package com.example.bbct_rmu.ui.report

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import com.example.bbct_rmu.MainPresenter
import com.example.bbct_rmu.R
import com.example.bbct_rmu.model.response.ResponseDataPr
import com.example.bbct_rmu.model.response.ResponseDataShowNsr
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class ReportActivity : AppCompatActivity() {

    var mdataReport = ArrayList<ResponseDataShowNsr>()

    var mMainPresenter= MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setapi()


    }

    private fun setapi() {

        mMainPresenter.MainPersenterRx(

            {
                for (i in it.indices){
                    mdataReport.add(it[i])
                }

                val barChart = findViewById<View>(R.id.barchart) as BarChart
                val entries = ArrayList<BarEntry>()
                entries.add(BarEntry(mdataReport.size.toFloat(), 0))
                entries.add(BarEntry(2f, 1))
                entries.add(BarEntry(5f, 2))
                entries.add(BarEntry(mdataReport.size.toFloat(),3))
                entries.add(BarEntry(15f, 4))
                entries.add(BarEntry(19f, 5))

                val bardataset = BarDataSet(entries, "Cells")


                val labels = ArrayList<String>()
//                for (i in it){
//                    labels.add(i.notic_time)
//                }
                labels.add("2020")
                labels.add("2019")
                labels.add("2018")
                labels.add("2017")
                labels.add("2016")
                labels.add("2015")

                val data = BarData(labels, bardataset)
                barChart.data = data // set the data and list of labels into chart
                barChart.setDescription("Set Bar Chart Description Here") // set the description
                bardataset.setColors(ColorTemplate.COLORFUL_COLORS)
                barChart.animateY(5000)
            },
            {

            }
        )


    }
}