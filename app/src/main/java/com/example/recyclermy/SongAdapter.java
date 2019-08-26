package com.example.recyclermy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> listSong;

    public SongAdapter(List<Song> list){
        listSong = list;
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder{

        private TextView tvRank,tvSongName,tvSinger,tvYear;
        public ImageView ivAlbumCover;

        public SongViewHolder(View itemView){
            super(itemView);

            tvRank = itemView.findViewById(R.id.tv_rank);
            tvSongName = itemView.findViewById(R.id.tv_song_name);
            tvSinger = itemView.findViewById(R.id.tv_singer);
            tvYear = itemView.findViewById(R.id.tv_year);
            ivAlbumCover = itemView.findViewById(R.id.iv_album_cover);
        }
    }

    @NonNull
    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_list_item,viewGroup,false);
        SongViewHolder svh = new SongViewHolder(view);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
        Song song = listSong.get(position);

        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.tvYear.setText(song.getYear());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");

    }

    @Override
    public int getItemCount() {
        return listSong.size();
    }


}
