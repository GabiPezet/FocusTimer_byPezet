package com.example.focustimer.presentation.home

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.focustimer.core.Constants.Companion.ONE_HOUR_IN_MIN
import com.example.focustimer.core.Constants.Companion.ONE_MIN_IN_MILLIS
import com.example.focustimer.core.Constants.Companion.ONE_MIN_IN_SEC
import com.example.focustimer.core.Constants.Companion.ONE_SEC_IN_MILLIS
import com.example.focustimer.domain.model.TimerTypeEnum
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer
    private var isTimerActive: Boolean = false

    private val _timerValue = mutableStateOf(TimerTypeEnum.FOCUS.timeToMillis())  //based on Private set - Public get
    val timerValueState = _timerValue

    private val _timerTypeState = mutableStateOf(TimerTypeEnum.FOCUS)   //based on Private set - Public get
    val timerTypeState = _timerTypeState

    private val _roundState = mutableStateOf(0)     //based on Private set - Public get
    val roundState = _roundState

    private val _todayTimeState = mutableStateOf<Long>(0)   //based on Private set - Public get
    val todayTimeState = _todayTimeState

    fun onStartTimer() {

        viewModelScope.launch {
            timer = object : CountDownTimer(
                _timerValue.value,
                ONE_SEC_IN_MILLIS
            ) {
                override fun onTick(millisUntilFinished: Long) {
                    _timerValue.value = millisUntilFinished
                    _todayTimeState.value += ONE_SEC_IN_MILLIS
                }

                override fun onFinish() {
                    onCancelTimer()
                }
            }
            timer.start().also {
                if (!isTimerActive) {
                    _roundState.value += 1
                    isTimerActive = true
                }
            }
        }
    }

    fun onCancelTimer(reset: Boolean = false) {
        try {
            timer.cancel()
        } catch (_: UninitializedPropertyAccessException) {
            // Handle better the timer errors
        }
        if (!isTimerActive || reset) {
            _timerValue.value = _timerTypeState.value.timeToMillis()
        }
        isTimerActive = false
    }

    private fun onResetTime() {
        if (isTimerActive) {
            onCancelTimer()
            onStartTimer()
        }
    }

    fun onUpdateType(timerType: TimerTypeEnum) {
        _timerTypeState.value = timerType
        onCancelTimer(true)
    }

    fun onIncreaseTime() {
        _timerValue.value += ONE_MIN_IN_MILLIS
        onResetTime()
    }

    fun onDecreaseTime() {
        _timerValue.value -= ONE_MIN_IN_MILLIS
        onResetTime()
        if (_timerValue.value < 0) {
            onCancelTimer()
        }
    }

    @SuppressLint("DefaultLocale")
    fun millisToMinutes(value: Long): String {
        val totalSeconds = value.div(ONE_SEC_IN_MILLIS)
        val minutes = (totalSeconds.div(ONE_MIN_IN_SEC)).toInt()
        val seconds = (totalSeconds.rem(ONE_MIN_IN_SEC)).toInt()
        return String.format("%02d:%02d", minutes, seconds)
    }

    @SuppressLint("DefaultLocale")
    fun millisToHours(value: Long): String {
        val totalSecond = value.div(ONE_SEC_IN_MILLIS)
        val seconds = (totalSecond.rem(ONE_MIN_IN_SEC))
        val totalMinutes = (totalSecond.div(ONE_MIN_IN_SEC)).toInt()
        val hours = (totalMinutes.rem(ONE_HOUR_IN_MIN))
        val minutes = (totalMinutes.rem(ONE_HOUR_IN_MIN))

        return if (totalMinutes <= ONE_HOUR_IN_MIN) {
            String.format("%02dm %02ds", minutes, seconds)
        } else {
            String.format("%02dh %02dm", hours, minutes)
        }

    }
}