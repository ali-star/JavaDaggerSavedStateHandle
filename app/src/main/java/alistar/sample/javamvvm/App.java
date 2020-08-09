package alistar.sample.javamvvm;

import android.app.Application;

import alistar.sample.javamvvm.di.component.ApplicationComponent;
import alistar.sample.javamvvm.di.component.DaggerApplicationComponent;

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().app(this).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
