package alistar.sample.javamvvm.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;

public interface SavedStateViewModel {
    void init(@NonNull SavedStateHandle savedStateHandle);
}
