package com.example.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Interface.ItemClickListener;
import com.example.foodapp.R;
import com.example.foodapp.activity.ChiTietActivity;
import com.example.foodapp.model.SanPhamMoi;
import com.example.foodapp.utils.Utils;

import java.text.DecimalFormat;
import java.util.List;

public class SpMoiAdapter extends RecyclerView.Adapter<SpMoiAdapter.MyViewHolder> {

    Context context;
    List<SanPhamMoi> array;

    public SpMoiAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi, parent, false);

        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPhamMoi sanPhamMoi = array.get(position);
        holder.txtten.setText(sanPhamMoi.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtgia.setText("Giá: " + decimalFormat.format(Double.parseDouble(sanPhamMoi.getGiasp())) + " Đ");
        if (sanPhamMoi.getHinhanh().contains("http")){
            Glide.with(context).load(sanPhamMoi.getHinhanh()).into(holder.imghinhanh);
        }else {
            String hinhanh = Utils.BASE_URL + "images/" + sanPhamMoi.getHinhanh();
            Glide.with(context).load(hinhanh).into(holder.imghinhanh);
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (!isLongClick){
                    // click
                    Intent intent = new Intent(context, ChiTietActivity.class);
                    intent.putExtra("chitiet", sanPhamMoi);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtgia, txtten;
        ImageView imghinhanh;

        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtgia = itemView.findViewById(R.id.itemsp_gia);
            txtten = itemView.findViewById(R.id.itemsp_ten);
            imghinhanh = itemView.findViewById(R.id.itemsp_image);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }
}