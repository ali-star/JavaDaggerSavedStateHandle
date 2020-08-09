package alistar.sample.javamvvm;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import alistar.sample.javamvvm.di.ViewModelCreator;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelCreator<MainActivityViewModel> vmFactory;

    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject();

        viewModel = new ViewModelProvider(this, vmFactory.createFrom(this, null)).get(MainActivityViewModel.class);

        Toast.makeText(this, viewModel.doSomething(), Toast.LENGTH_LONG).show();
    }

    private void inject() {
        ((App) getApplication()).getApplicationComponent().inject(this);
    }
}