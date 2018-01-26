package com.mgalal.techonatask.services;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;

import com.mgalal.techonatask.model.ServerButton;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

public class RemoteService {
   // @Inject
    //@Named("dummy")
    List<ServerButton> dummyItems;
    private Handler handler;

    @Inject
    public RemoteService(List<ServerButton> dummyItems){
        this.dummyItems = dummyItems;
    }
    public LiveData<List<ServerButton>>  getServerButtonsList(){
        handler =  new Handler();
        final MutableLiveData<List<ServerButton>> data = new MutableLiveData<>();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Collections.sort(dummyItems, new Comparator<ServerButton>() {
                    @Override
                    public int compare(ServerButton o1, ServerButton o2) {
                        return o1.getIndex()-o2.getIndex();
                    }
                });
                data.setValue(dummyItems);
            }
        },3000);
        return data;
    }
}
