package alistar.sample.javamvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import javax.inject.Inject;

import alistar.sample.javamvvm.di.SavedStateViewModel;

public class MainActivityViewModel extends ViewModel implements SavedStateViewModel {

    private SavedStateHandle savedStateHandle;
    private Gson gson;

    @Inject
    public MainActivityViewModel(Gson gson){
        this.gson = gson;
    }

    @Override
    public void init(@NonNull SavedStateHandle savedStateHandle){
        this.savedStateHandle = savedStateHandle;
    }

    public String doSomething() {
        savedStateHandle.set("test_string", "my test string");
        return gson.toJson("test");
    }
}
