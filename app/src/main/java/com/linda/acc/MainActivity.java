package com.linda.acc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private NoteViewModel noteViewModel;
    private NoteAdapter noteAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton mFab;

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


    mFab = findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int priority = new Random().nextInt(100)+1;
           noteViewModel.추가하기(
                   new Note("제목"+priority,"설명"+priority, priority)
                   );
             }
         });
    }
}