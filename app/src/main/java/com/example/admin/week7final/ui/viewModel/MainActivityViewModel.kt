package com.example.admin.week7final.ui.viewModel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.admin.week7final.model.network.NumberService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel : BaseViewModel() {

    val numbers: MutableLiveData<List<Int>> = MutableLiveData()
    val lastNumber: MutableLiveData<Int> = MutableLiveData()

    @Inject
    lateinit var numberService: NumberService

    private lateinit var subscription: Disposable

    init {
        loadNumbers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadNumbers() {
        subscription = numberService.getNumbers("40", "uint8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveStart() }
                .doOnSuccess { onRetrieveFinish() }
                .subscribe(
                        { onRetrieveSuccess() },
                        { onRetrieveError() }
                )
    }

    private fun onRetrieveStart() {
        lastNumber.value = View.VISIBLE
    }

    private fun onRetrieveFinish() {
        lastNumber.value = View.GONE
    }

    private fun onRetrieveSuccess() {

    }

    private fun onRetrieveError() {

    }
}