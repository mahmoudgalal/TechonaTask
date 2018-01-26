package com.mgalal.techonatask.di;

import com.mgalal.techonatask.model.ServerButton;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */
@Module
public class DataProviderModule {

    @Provides
    @Singleton
    public List<ServerButton> provideServerButtonsList(){
        String[] names = {"Apple","Yahoo","Google"};
        List<ServerButton> fakeServerList =  new ArrayList<>();
        int i = 0;
        for (; i < 3; i++) {
            ServerButton  btn = new ServerButton();
            btn.setName(names[i]);
            btn.setIndex(i);
            fakeServerList.add(btn);
        }
        return fakeServerList;
    }
}
