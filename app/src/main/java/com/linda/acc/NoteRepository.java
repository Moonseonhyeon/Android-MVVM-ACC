package com.linda.acc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
// LiveData는 함수를 getter만 있음 - 데이터 변경 하지 않음
// MutableLiveData는 함수를 getter, setter를 가지고 있음. - 데이터 변경 가능. new해서 사용.
    public MutableLiveData<List<Note>> allNotes = new MutableLiveData<>(); // 이렇게

    public NoteRepository(){
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("제목", "설명", 0));
        allNotes.setValue(notes);
    }

    public LiveData<List<Note>> findAll(){
        return allNotes;
    };

    public LiveData<List<Note>> 구독하기(){
        return allNotes;
    }

    public void delete(Note note){
        List<Note> notes = allNotes.getValue();
        notes.remove(note);
        allNotes.setValue(notes);
    };

    public void save(Note note){
        List<Note> notes = allNotes.getValue();
        notes.add(note);
        allNotes.setValue(notes);
    };

    /*public LiveData<List<List>>전체보기(){
        return noteRepsitory.구독
    }*/

}
