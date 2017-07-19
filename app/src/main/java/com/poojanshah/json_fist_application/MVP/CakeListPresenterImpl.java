package com.poojanshah.json_fist_application.MVP;

import android.content.Context;
import android.util.Log;

import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;
import com.poojanshah.json_fist_application.MyApp;
import com.poojanshah.json_fist_application.model.JustEat;
import com.poojanshah.json_fist_application.model.Restaurant;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shahp on 14/07/2017.
 */

public class CakeListPresenterImpl  extends  BasePresenter<ICakeListView> implements  ICakeListPresenter{
    //    @Inject
    Interactor_Impl interactor_;

    @Inject
    public CakeListPresenterImpl(Interactor_Impl interactor) {
        this.interactor_ = interactor_;
        setInjections();
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
        checkViewAttached();
//        interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);
    }

    private void onSuccess(JustEat justEat) {
        Log.i("Size", String.valueOf(justEat.getRestaurants().size()));
        for(Restaurant c: justEat.getRestaurants()){
            Log.i("CakeModelonSuccessD", c.getName());
        }
    }

    private void OnError(Throwable throwable) {
        Log.i("throwable.getMessage()", throwable.getMessage());
        Log.i("throwable.getCause()", String.valueOf(throwable.getCause()));

    }

    public void injectForData(APIComponent apiComponent) {
        interactor_.initiateInjectionGraph(apiComponent);
    }

    private void setInjections() {
        APIComponent apiComponent = ((MyApp) ).getApiComponent();
        this.injectForData(apiComponent);
    }

}
