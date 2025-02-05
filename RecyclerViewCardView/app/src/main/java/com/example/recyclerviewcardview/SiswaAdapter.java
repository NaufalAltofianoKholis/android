package com.example.recyclerviewcardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.ViewHolder> {

    private Context context;
    private List<Siswa> siswalist;

    public SiswaAdapter(Context context, List<Siswa> siswalist) {
        this.context = context;
        this.siswalist = siswalist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        ViewGroup ViewGroup = null;
//        View v = LayoutInflater.from(ViewGroup.getContext()).inflate(R.layout.item_siswa, ViewGroup,false);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_siswa, viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Siswa siswa = siswalist.get(i);
      viewHolder.tvNama.setText(siswa.getNama());
       viewHolder.tvAlamat.setText(siswa.getAlamat());

/*
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context, "Nama : "+siswa.getNama()+ " Alamat : "+siswa.getAlamat(), Toast.LENGTH_SHORT).show();
           }
       });

 */
        viewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,viewHolder.tvMenu);
                popupMenu.inflate(R.menu.menu_option);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        int idItem = item.getItemId();

                        if (idItem == R.id.menu_simpan) {
                            Toast.makeText(context, "Simpan Data"+siswa.getNama(), Toast.LENGTH_SHORT).show();
                        } else if (idItem == R.id.menu_hapus){
                            siswalist.remove(i);
                            notifyDataSetChanged();

                            Toast.makeText(context, siswa.getNama()+"sudah dihapus ya", Toast.LENGTH_SHORT).show();
                        }



                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return siswalist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

       TextView tvNama;
       TextView tvAlamat;
       TextView tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }

}
