package alistar.sample.javamvvm.di.component;

import javax.inject.Singleton;
import alistar.sample.javamvvm.App;
import alistar.sample.javamvvm.MainActivity;
import alistar.sample.javamvvm.di.module.GsonModule;
import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = { GsonModule.class })
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder app(App app);

        ApplicationComponent build();
    }

    void inject(MainActivity mainActivity);

}
