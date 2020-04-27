package com.mtjin.coronakorea.views.country

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mtjin.coronakorea.R
import com.mtjin.coronakorea.databinding.FragmentCountryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private val viewModel: CountryViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModelCallback()
        viewModel.requestCountry()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            countryResponse.observe(viewLifecycleOwner, Observer {
                with(binding.countryPcPiechart) {
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

                    val dataSet: PieDataSet = PieDataSet(yValues,"")
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
                        des.text =  "도시별 확진자 상위 5곳"
                        description = des
                    }
                    data = pieData
                }
            })
        }
    }
}