package com.poojanshah.json_fist_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.CakeListPresenterImpl;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;
import com.poojanshah.json_fist_application.model.JustEat;
import com.poojanshah.json_fist_application.model.Restaurant;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Inject
    Interactor_Impl interactor_;
    @Inject
    CakeListPresenterImpl cakeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interactor_ = new Interactor_Impl();
//        setInjections();

        cakeListPresenter.performCakeListDisplay();

//        interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);
    }

//    private void onSuccess(JustEat justEat) {
//        Log.i("Size", String.valueOf(justEat.getRestaurants().size()));
//        for(Restaurant c: justEat.getRestaurants()){
//            Log.i("CakeModelonSuccessD", c.getName());
//        }
//    }
//
//    private void OnError(Throwable throwable) {
//        Log.i("throwable.getMessage()", throwable.getMessage());
//        Log.i("throwable.getCause()", String.valueOf(throwable.getCause()));
//
//    }
//    public void injectForData(APIComponent apiComponent) {
//        interactor_.initiateInjectionGraph(apiComponent);
//    }
//
//    private void setInjections() {
//        APIComponent apiComponent = ((MyApp) getApplicationContext()).getApiComponent();
//        this.injectForData(apiComponent);
//    }





}
