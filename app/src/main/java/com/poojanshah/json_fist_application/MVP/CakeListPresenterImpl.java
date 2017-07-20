package com.poojanshah.json_fist_application.MVP;

import android.content.Intent;
import android.util.Log;

import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;
import com.poojanshah.json_fist_application.MainActivity;
import com.poojanshah.json_fist_application.MapsActivity;
import com.poojanshah.json_fist_application.MyApp;
import com.poojanshah.json_fist_application.model.JustEat;
import com.poojanshah.json_fist_application.model.Restaurant;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shahp on 14/07/2017.
 */

public class CakeListPresenterImpl  extends  BasePresenter<ICakeListView> implements  ICakeListPresenter{
    @Inject
    Interactor_Impl interactor_;

    @Inject
    public CakeListPresenterImpl(Interactor_Impl interactor_) {
        this.interactor_ = interactor_;
    }



    @Override
    public void attachView(ICakeListView MVPView) {
            super.attachView(MVPView);
    }

    @Override
    public void detachView() {
    super.detachView();
    }

    @Override
    public void performCakeListDisplay(){
        interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);
    }

    private void OnError(Throwable throwable) {
        Log.i("CPL Throwable", throwable.getMessage());
        Log.i("CPL Throwable", String.valueOf(throwable.getCause()));
    }

    private void onSuccess(JustEat justEat) {
        for(Restaurant restaurant: justEat.getRestaurants()){
            Log.i("restaurant.getName()", restaurant.getName());
        }
    }

    public void injectForData(APIComponent apiComponent) {
        interactor_.initiateInjectionGraph(apiComponent);
    }
}
