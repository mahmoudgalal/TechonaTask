package com.mgalal.techonatask.di;

import com.mgalal.techonatask.model.ServerButton;
import com.mgalal.techonatask.services.RemoteService;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

@Module
public class WebServiceModule {

    @Provides
    @Singleton
    public RemoteService provideRemoteServiceInstance(List<ServerButton> items){
        return  new RemoteService(items);
    }

}
