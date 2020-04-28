package com.mtjin.coronakorea.utils

import android.graphics.Color
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mtjin.coronakorea.data.country.CountryResponse

@BindingAdapter("setTop5Values")
fun PieChart.setTop5ValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(PieEntry(it.city1p.toFloat(), it.city1n))
            add(PieEntry(it.city2p.toFloat(), it.city2n))
            add(PieEntry(it.city3p.toFloat(), it.city3n))
            add(PieEntry(it.city4p.toFloat(), it.city4n))
            add(PieEntry(it.city5p.toFloat(), it.city5n))
        }

        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.JOYFUL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "도시별 확진자 상위 5곳"
            description = des
        }
        data = pieData
    }
}