package com.mgalal.techonatask.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mgalal.techonatask.model.ServerButton;
import com.mgalal.techonatask.services.RemoteService;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

public class ServerButtonsViewModel extends ViewModel {

    private LiveData<List<ServerButton>> data;
    private RemoteService remoteService;


    @Inject
    public ServerButtonsViewModel(RemoteService downloadService){
        remoteService = downloadService;
    }
    public void init(){
        data = remoteService.getServerButtonsList();
    }

    public LiveData<List<ServerButton>> getData(){
        return data;
    }


}

