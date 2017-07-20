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
        setInjections();

//        ((MyApp) getApplicationContext()).getiPresenterComponent().inject(this);


        cakeListPresenter = new CakeListPresenterImpl(interactor_);

//        cakeListPresenter.attachView(this);

        interactor_.getCakeList().observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread()).subscribe(this:: onSuccess, this:: OnError);

//                                            interactor_.getCakeList()
//                                    .observeOn(AndroidSchedulers.mainThread())
//                                    .subscribeOn(Schedulers.newThread())
//                                    .subscribe(this:: onSuccess, this:: OnError);
//
//        cakeListPresenter.performCakeListDisplay();

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


//
//        swiperefresh = (SwipeRefreshLayout )findViewById(R.id.swipeRefreshCakes);
//        updateOperate();
        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
//         */
////        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout");
////                updateOperate();
//                // This method performs the actual data-refresh operation.
//                // The method calls setRefreshing(false) when it's finished.
////                myUpdateOperation();
//            }
//        });
//
//    }

//    public void updateOperate(){
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

//    private void onSuccess(List<CakesModel> cakesModels) {
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        /**
//         * Two important things required: layout, adapter
//         */
////        try {
////            realm = Realm.getDefaultInstance();
////            realmHelper = new RealmHelper(realm);
////            for (CakesModel c : cakesModels) {
////                Cake cake = new Cake();
////                cake.setTitle(c.getTitle());
////                cake.setDesc(c.getDesc());
////                cake.setImage(c.getImage());
////                realmHelper.saveCake(cake);
////                Log.i("cakesModels.size()", c.getTitle());
////            }
////        } catch (Exception e){
////            System.out.println(e);
////        }
//        try {
//            realm = Realm.getDefaultInstance();
//            realmHelper = new RealmHelper(realm);
//            for (CakesModel c : cakesModels) {
//                realmHelper.saveCakesModel(c);
//            }
//        } catch (Exception e){
//            System.out.println(e);
//            Log.i("Error P", e.getMessage());
//        }
//
//        Log.i("cakesModels.size()",cakesModels.size()+"");
//
////        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        try {
//            mRecyclerView.setAdapter(new CakeAdapter(realmHelper.getCakesModel(), getApplicationContext()));
//        }catch (Exception e){
//            System.out.println(e);
//            Log.i("Error P", e.getMessage());
//            mRecyclerView.setAdapter(new CakeAdapter(cakesModels, getApplicationContext()));
//        }
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        swiperefresh.setRefreshing(false);
//
//
//    }
//
//    private void OnError(Throwable throwable){
//        try {
//            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//            mRecyclerView.setAdapter(new CakeAdapter(realmHelper.getCakesModel(), getApplicationContext()));
//            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        }catch (Exception e){
//            System.out.println(e);
//            Log.i("Error P", e.getMessage());
//
//        }
//
//        Log.i("throwable.getMessage()", throwable.getMessage());
//        Log.i("throwable.getCause()", String.valueOf(throwable.getCause()));
//        swiperefresh.setRefreshing(false);
//    }


    public void injectForData(APIComponent apiComponent) {
        interactor_.initiateInjectionGraph(apiComponent);
    }

    private void setInjections() {
        APIComponent apiComponent = ((MyApp) getApplicationContext()).getApiComponent();
        this.injectForData(apiComponent);
    }





}
