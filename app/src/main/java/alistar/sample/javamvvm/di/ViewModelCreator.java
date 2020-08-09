package alistar.sample.javamvvm.di;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import javax.inject.Inject;

public class ViewModelCreator<VM extends ViewModel> {

    private final ViewModelFactory<VM> factory;

    @Inject
    public ViewModelCreator(ViewModelFactory<VM> factory) {
        this.factory = factory;
    }

    @NonNull
    public <S extends ViewModelStoreOwner & SavedStateRegistryOwner> AbstractSavedStateViewModelFactory createFrom(@NonNull S owner, @Nullable Bundle defaultArgs) {
        return new AbstractSavedStateViewModelFactory(owner, defaultArgs) {
            @NonNull
            @Override
            protected <T extends ViewModel> T create(@NonNull String key, @NonNull Class<T> modelClass, @NonNull SavedStateHandle handle) {
                T viewModel = factory.create(modelClass);
                if (viewModel instanceof SavedStateViewModel) {
                    ((SavedStateViewModel) viewModel).init(handle);
                }
                return viewModel;
            }
        };
    }
}