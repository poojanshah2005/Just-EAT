package com.poojanshah.json_fist_application.MVP;

import com.poojanshah.json_fist_application.Injection.components.APIComponent;
import com.poojanshah.json_fist_application.MVP.interactor.Interactor_Impl;

import javax.inject.Inject;

/**
 * Created by shahp on 14/07/2017.
 */

public class CakeListPresenterImpl  extends  BasePresenter<ICakeListView> implements  ICakeListPresenter{
//    @Inject
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
        checkViewAttached();

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
