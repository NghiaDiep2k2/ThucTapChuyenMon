package com.example.manager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manager.Interface.ItemClickListener;
import com.example.manager.R;
import com.example.manager.model.DonHang;
import com.example.manager.model.EventBus.DonHangEvent;
import com.example.manager.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        holder.txtdonhang.setText("Đơn hàng: " + donHang.getId());
        holder.trangthai.setText(trangThaiDon(donHang.getTrangthai()));
        holder.diachi.setText("Địa chỉ: " + donHang.getDiachi());
        holder.sdt.setText("Số điện thoại: " + donHang.getSodienthoai());
        holder.username.setText("Người đặt: " + donHang.getUsername());
        holder.tongtien.setText("Tổng tiền: " + donHang.getTongtien() + " Đ");
        holder.ngaydat.setText("Ngày đặt: " + donHang.getNgaydat());


        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerChiTiet.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(donHang.getItem().size());
        // adapter chi tiet
        ChiTietAdapter chitietAdapter = new ChiTietAdapter(context, donHang.getItem());
        holder.recyclerChiTiet.setLayoutManager(layoutManager);
        holder.recyclerChiTiet.setAdapter(chitietAdapter);
        holder.recyclerChiTiet.setRecycledViewPool(viewPool);
        holder.setListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (isLongClick){
                    EventBus.getDefault().postSticky(new DonHangEvent(donHang));
                }
            }
        });
    }

    private String trangThaiDon(int status){
        String result = "";
        switch (status){
            case 0:
                result = "Đơn hàng đang được xử lý";
                break;
            case 1:
                result = "Đơn hàng đã được nhận";
                break;
            case 2:
                result = "Đơn hàng đang được giao";
                break;
            case 3:
                result = "Đơn hàng giao thành công";
                break;
            case 4:
                result = "Đơn hàng đã được hủy";
                break;
        }

        return result;
    }

    @Override
    public int getItemCount() {
        return listDonHang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView txtdonhang, trangthai, diachi, username, sdt, tongtien, ngaydat;
        RecyclerView recyclerChiTiet;
        ItemClickListener listener;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdonhang = itemView.findViewById(R.id.iddonhang);
            trangthai = itemView.findViewById(R.id.trangthai);
            diachi = itemView.findViewById(R.id.diachi_donhang);
            username = itemView.findViewById(R.id.username_donhang);
            sdt = itemView.findViewById(R.id.sdt_donhang);
            tongtien = itemView.findViewById(R.id.tongtien_dohang);
            ngaydat = itemView.findViewById(R.id.ngaydat_donhang);
            recyclerChiTiet = itemView.findViewById(R.id.recyclerview_chitiet);
            itemView.setOnLongClickListener(this);
        }

        public void setListener(ItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public boolean onLongClick(View view) {
            listener.onClick(view, getAdapterPosition(), true);
            return false;
        }
    }

}
