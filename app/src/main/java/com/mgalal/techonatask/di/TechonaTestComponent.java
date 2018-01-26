package com.mgalal.techonatask.di;

import com.mgalal.techonatask.MainActivity;
import javax.inject.Singleton;
import dagger.Component;
import dagger.Module;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */
@Singleton
@Component(modules = {DataProviderModule.class,WebServiceModule.class})
public interface TechonaTestComponent {
    void inject(MainActivity mainActivity);
}
