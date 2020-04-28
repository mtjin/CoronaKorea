package com.mtjin.coronakorea.utils

import android.graphics.Color
import android.util.Log
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mtjin.coronakorea.R
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
            val remainPercent: Float =
                100 - it.city1p.toFloat() - it.city2p.toFloat() - it.city3p.toFloat() - it.city4p.toFloat() - it.city5p.toFloat()
            if (remainPercent.toInt() != 0) {
                add(
                    PieEntry(remainPercent, context.getString(R.string.remain_text))
                )
            }

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

@BindingAdapter("setCureOrDeadValues")
fun PieChart.setCureOrDeadValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(
                PieEntry(
                    it.recoveredPercentage.toFloat(),
                    context.getString(R.string.country_cure_rate_text)
                )
            )
            add(
                PieEntry(
                    it.deathPercentage.toFloat(),
                    context.getString(R.string.country_death_rate_text)
                )
            )
            val remainPercent: Float =
                100 - it.deathPercentage.toFloat() - it.recoveredPercentage.toFloat()
            add(
                PieEntry(
                    remainPercent,
                    context.getString(R.string.etc_text)
                )
            )
        }

        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.PASTEL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "국내 완치 및 사망 상대비율"
            description = des
        }
        data = pieData
    }
}

@BindingAdapter("setPositiveOrNegativeValues")
fun PieChart.setPositiveOrNegativeValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(
                PieEntry(
                    it.checkingPercentage.toFloat(),
                    context.getString(R.string.checking_text)
                )
            )
            add(
                PieEntry(
                    it.casePercentage.toFloat(),
                    context.getString(R.string.corona_positive_text)
                )
            )
            add(
                PieEntry(
                    it.notcasePercentage.toFloat(),
                    context.getString(R.string.corona_negative_text)
                )
            )
        }

        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.MATERIAL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "국내 검사결과"
            description = des
        }
        data = pieData
    }
}