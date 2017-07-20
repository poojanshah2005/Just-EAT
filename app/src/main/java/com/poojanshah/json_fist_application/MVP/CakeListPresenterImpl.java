package com.poojanshah.json_fist_application.MVP;

import android.util.Log;

import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;
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
//                interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);

    }

//    public CakeListPresenterImpl() {
//        this.interactor_ = new Interactor_Impl();
////                interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);
//
//    }



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
//        checkViewAttached();

        interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);

//        ReactiveNetwork.observeInternetConnectivity()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Boolean>() {
//                    @Override public void accept(Boolean isConnectedToInternet) {
//                        // do something with isConnectedToInternet value
//                        if(isConnectedToInternet){
//                            interactor_.getCakeList()
//                                    .observeOn(AndroidSchedulers.mainThread())
//                                    .subscribeOn(Schedulers.newThread())
//                                    .subscribe(this:: onSuccess, this:: OnError);
////                            Toast.makeText(MainActivity.this,"Network is Available",Toast.LENGTH_LONG).show();
//                        } else{
////                            Toast.makeText(MainActivity.this,"Network is Available",Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    private void OnError(Throwable throwable) {
//                        Log.i("throwable.getMessage()", throwable.getMessage());
//                        Log.i("throwable.getCause()", String.valueOf(throwable.getCause()));
//                    }
//
//                    private void onSuccess(List<CakesModel> cakesModels) {
//                        Log.i("Size", String.valueOf(cakesModels.size()));
//                        getView().onFetchDataSuccess(cakesModels);
//                        for(CakesModel c:cakesModels){
//                            Log.i("CakeModelonSuccess", c.getTitle());
//                        }
//                    }
//                });
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






//        public void updateOperate(){
//        ReactiveNetwork.observeInternetConnectivity()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Boolean>() {
//                    @Override public void accept(Boolean isConnectedToInternet) {
//                        // do something with isConnectedToInternet value
//                        if(isConnectedToInternet){
//                            requestInterface.getCakeList()
//                                    .observeOn(AndroidSchedulers.mainThread())
//                                    .subscribeOn(Schedulers.newThread())
//                                    .subscribe(MainActivity.this:: onSuccess, MainActivity.this:: OnError);
//                            Toast.makeText(MainActivity.this,"Network is Available",Toast.LENGTH_LONG).show();
//                        } else{
//                            Toast.makeText(MainActivity.this,"Network is Available",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
}
