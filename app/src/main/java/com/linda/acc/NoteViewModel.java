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
    private NoteRepository noteRepository = new NoteRepository();

    public NoteViewModel(@NonNull Application application) {
        super(application);
        allNotes = noteRepository.findAll();
    }

    //디비에서 들고오는 함수 아님
    public LiveData<List<Note>> 구독하기(){
        return allNotes;
    }

     //ViewModel을 서비스라고 생각해도 괜찮음.
    public void 추가하기(Note note){
        noteRepository.save(note);
      /*  List<Note> notes = allNotes.getValue();
        notes.add()*/

    }

    public void 삭제하기(Note note){
        noteRepository.delete(note);
    }

    /*public List<Note> 전체보기(){
        //데이터가 알아서 계속 변경되고 있어서 필요가 없음
        return noteRepository.findAll();
    }*/

}
