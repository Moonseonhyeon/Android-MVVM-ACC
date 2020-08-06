package com.linda.acc;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


//View가 VM을 바라봐야함 여기서는 MainActivity(V)를!

public class NoteViewModel extends AndroidViewModel {

    //View모델이 가진 데이터다
    private LiveData<List<Note>> allNotes; // MainActivity(V)가 이 아이를 구독
    //타이밍을 잡지않고 Observer가 livedata를 지켜보고

    public NoteViewModel(@NonNull Application application) {
        super(application);
    }

    //디비에서 들고오는 함수 아님
    public LiveData<List<Note>> 구독하기(){
        return allNotes;
    }
}
