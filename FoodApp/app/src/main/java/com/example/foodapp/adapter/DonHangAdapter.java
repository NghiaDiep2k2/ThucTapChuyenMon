package com.example.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.model.DonHang;
import com.example.foodapp.model.GioHang;

import java.text.DecimalFormat;
import java.util.List;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.MyViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;
    List<DonHang> listDonHang;

    public DonHangAdapter(Context context, List<DonHang> listDonHang) {
        this.context = context;
        this.listDonHang = listDonHang;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_don_hang, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DonHang donHang = listDonHang.get(position);
        holder.diachi.setText("Địa chỉ: " + donHang.getDiachi());
        holder.tongtien.setText("Tổng tiền: " + donHang.getTongtien() + " Đ");
        holder.ngaydat.setText("Ngày đặt: " + donHang.getNgaydat());
        holder.sdt.setText("Số điện thoại: " + donHang.getSodienthoai());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerChiTiet.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(donHang.getItem().size());
        // adapter chi tiet
        ChiTietAdapter chitietAdapter = new ChiTietAdapter(context, donHang.getItem());
        holder.recyclerChiTiet.setLayoutManager(layoutManager);
        holder.recyclerChiTiet.setAdapter(chitietAdapter);
        holder.recyclerChiTiet.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return listDonHang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView diachi, tongtien, username, ngaydat, sdt;
        RecyclerView recyclerChiTiet;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            diachi = itemView.findViewById(R.id.diachi_donhang);
            sdt = itemView.findViewById(R.id.sdt_donhang);
            recyclerChiTiet = itemView.findViewById(R.id.recyclerview_chitiet);
            tongtien = itemView.findViewById(R.id.tongtien_dohang);
            ngaydat = itemView.findViewById(R.id.ngaydat_donhang);
        }
    }

}
