package com.example.recyclermy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSong;
    private List<Song> listSong;
    private RecyclerView.LayoutManager mLayoutManager;
    private SongAdapter songAdapter;

    String[] names = {"I Took A Pill In Ibiza", "7 Years", "Pillow Talk", "Work From Home", "Never Forget You", "Don't Let Me Down", "Love Yourself", "Me Myself & I", "Cake By The Ocean","Dangerous Woman","My House","Stressed Out", "One Dance", "Middle","No"};
    String[] singers = {"Mike Posner", "Lukas Graham","Zayn","Fifth Harmony","Zara Larsson & MNEK","The Chainsmokers","Justin Bieber","G-Eazy x Babe Rexha","DNCE","Ariana Grande","Flo Rida","Twenty One Pilots","Drake","DJ Snake","Meghan Trainer"};
    int[] pics = {R.drawable.took_a_pill,R.drawable.seven_years,R.drawable.pillow_talk,R.drawable.work,R.drawable.never_forget_you,R.drawable.dont_let_me_down,R.drawable.love_yourself,R.drawable.me_myself_and_i,R.drawable.cake_by_the_ocean,R.drawable.dangerous_woman,R.drawable.my_house_florida,R.drawable.stressed_out,R.drawable.one_dance,R.drawable.middle,R.drawable.no};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSong = findViewById(R.id.recycler_view);
        if(rvSong != null) {
            rvSong.setHasFixedSize(true);
        }

        mLayoutManager = new LinearLayoutManager(this);
        rvSong.setLayoutManager(mLayoutManager);

        listSong = new ArrayList<>();

        for(int i = 0; i < names.length; i++){
            Song song = new Song(names[i], singers[i], i + 1, pics[i]);
            listSong.add(song);
        }

        songAdapter = new SongAdapter(listSong);
        rvSong.setAdapter(songAdapter);
        songAdapter.notifyDataSetChanged();

        rvSong.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                Toast.makeText(MainActivity.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_grid:
                mLayoutManager = new GridLayoutManager(this,2);
                rvSong.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_staggered_grid:
                mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                rvSong.setLayoutManager(mLayoutManager);
                break;
            case R.id.item_horizontal:
                mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayout.HORIZONTAL,false);
                rvSong.setLayoutManager(mLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
