package alistar.sample.javamvvm.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelFactory<VM extends ViewModel> implements ViewModelProvider.Factory {

    private final Provider<VM> provider;

    @Inject
    public ViewModelFactory(@NonNull Provider<VM> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) provider.get();
    }
}