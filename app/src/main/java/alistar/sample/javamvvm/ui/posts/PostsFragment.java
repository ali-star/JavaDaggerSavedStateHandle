package alistar.sample.javamvvm.ui.posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import alistar.sample.javamvvm.databinding.FragmentPostsBinding;

public class PostsFragment extends Fragment {

    private FragmentPostsBinding binding;
    private PostsFragmentViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PostsFragmentViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPostsBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this.getViewLifecycleOwner());
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.getFinishLiveData().observe(getViewLifecycleOwner(), string -> {
            Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();
            if (getView() != null)
                Navigation.findNavController(getView()).popBackStack();
        });
    }
}
