package com.mtjin.coronakorea.views.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.city.Korea
import com.mtjin.coronakorea.data.city.source.CityRepository

class CityViewModel(private val cityRepository: CityRepository) : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>(false)
    private val _cityResponse = MutableLiveData<CityResponse>()
    private val _korea = MutableLiveData<Korea>()

    val isLoading: LiveData<Boolean> get() = _isLoading
    val cityResponse: LiveData<CityResponse> get() = _cityResponse
    val korea: LiveData<Korea> get() = _korea

    fun requestKorea() {
        _isLoading.value = true
        cityRepository.getSearchKorea(
            success = {
                _korea.value = it
                _isLoading.value = false
            },
            fail = {
                _isLoading.value = false
            }
        )
    }

    fun requestCity(query: String) {
        _isLoading.value = true
        cityRepository.getSearchCity(
            success = {
                _cityResponse.value = it
                _isLoading.value = false
            },
            fail = {
                _isLoading.value = false
            }
        )
    }
}