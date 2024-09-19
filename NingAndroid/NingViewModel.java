package NingAndroid;

public class NingViewModel extends ViewModel{
    private LiveData<Integer> liveData;

    public LiveData<Integer> getLiveData(){
        if(liveData == null) {
            liveData = new LiveData<>();
            liveData.setValue(0);
        }
        return liveData;
    }
}
