package com.linda.acc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private NoteViewModel noteViewModel;
    private NoteAdapter noteAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);


        //레퍼런스객체 만들기
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        //.observe(context, 콜백함수 적기)
        noteViewModel.구독하기().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Log.d(TAG, "onChanged: 구독하고 있는 데이터가 변경되었습니다.");
                adapter.setNotes(notes); //덮어씌워요. UI갱신 신경안써도 된다.

            }
        });
    }
}