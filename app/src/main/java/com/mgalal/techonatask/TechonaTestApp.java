package com.mgalal.techonatask;

import android.app.Application;

import com.mgalal.techonatask.di.DaggerTechonaTestComponent;
import com.mgalal.techonatask.di.TechonaTestComponent;

/**
 * Created by fujitsu-lap on 26/01/2018.
 */

public class TechonaTestApp extends Application {

    private TechonaTestComponent techonaTestComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        techonaTestComponent = DaggerTechonaTestComponent.create();
    }

    public TechonaTestComponent getTechonaTestComponentechona() {
        return techonaTestComponent;
    }


}
