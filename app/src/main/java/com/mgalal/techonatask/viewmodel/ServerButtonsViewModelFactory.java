package com.mgalal.techonatask.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.mgalal.techonatask.services.RemoteService;

import javax.inject.Inject;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

public class ServerButtonsViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    RemoteService remoteService;
    @Inject
    public ServerButtonsViewModelFactory() {
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ServerButtonsViewModel.class)) {
            return (T) new ServerButtonsViewModel(remoteService);
        }
        throw new IllegalArgumentException("Wrong ViewModel class");
    }
}
