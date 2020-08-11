package alistar.sample.javamvvm.ui.posts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import alistar.sample.javamvvm.entity.Customer;

public class PostsFragmentViewModel extends ViewModel {
    private MutableLiveData<Customer> mutableLiveDataCustomer = new MutableLiveData<>();
    private MutableLiveData<String> _mutableLiveDataFinish = new MutableLiveData<>();
    private LiveData<String> finishLiveData = _mutableLiveDataFinish;

    public PostsFragmentViewModel() {
        mutableLiveDataCustomer.setValue(new Customer());
    }

    public LiveData<String> getFinishLiveData() {
        return finishLiveData;
    }

    public MutableLiveData<Customer> getMutableLiveDataCustomer() {
        return mutableLiveDataCustomer;
    }

    public void setMutableLiveDataCustomer(MutableLiveData<Customer> mutableLiveDataCustomer) {
        this.mutableLiveDataCustomer = mutableLiveDataCustomer;
    }


    public void addPost() {
        Customer customer = new Customer();
        customer = mutableLiveDataCustomer.getValue();
        _mutableLiveDataFinish.setValue(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getPhone());

    }
}
