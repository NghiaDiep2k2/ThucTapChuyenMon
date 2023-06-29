package com.example.manager.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.manager.R;
import com.example.manager.adapter.LoaiSpAdapter;
import com.example.manager.adapter.SpMoiAdapter;
import com.example.manager.model.LoaiSp;
import com.example.manager.model.SanPhamMoi;
import com.example.manager.model.User;
import com.example.manager.retrofit.ApiBanHang;
import com.example.manager.retrofit.RetrofitClient;
import com.example.manager.utils.Utils;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewMain;
    NavigationView navigationViewMain;
    ListView listViewMainScreeen;
    DrawerLayout drawerLayout;
    LoaiSpAdapter loaiSpAdapter;
    List<LoaiSp> mangloaisp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    List<SanPhamMoi> mangspmoi;
    SpMoiAdapter spAdaper;
    NotificationBadge badge;
    FrameLayout frameLayout;
    ImageView imgsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);

        Paper.init(this);
        if (Paper.book().read("user") != null){
            User user = Paper.book().read("user");
            Utils.user_current = user;
        }

        getToken();
        Anhxa();
        ActionBar();

        if (isConnected(this)){
            ActionViewFlipper();
            getLoaiSanPham();
            getSpMoi();
            getEventClick();
        }else {
            Toast.makeText(getApplicationContext(), "Không Có Internet, Vui Lòng Kết Nối", Toast.LENGTH_SHORT).show();
        }
    }

    private void getToken(){
        FirebaseMessaging.getInstance().getToken()
                .addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        if (!TextUtils.isEmpty(s)){
                            compositeDisposable.add(apiBanHang.updateToken(Utils.user_current.getId(), s)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(
                                            messageModel -> {

                                            },
                                            throwable -> {
                                                Log.d("log", throwable.getMessage());
                                            }
                                    ));

                        }
                    }
                });
    }

    private void getEventClick() {
        listViewMainScreeen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent trangchu = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(trangchu);
                        break;
                    case 1:
                        Intent pizza = new Intent(getApplicationContext(), PizzaActivity.class);
                        pizza.putExtra("loai", 1);
                        startActivity(pizza);
                        break;
                    case 2:
                        Intent hamburger = new Intent(getApplicationContext(), PizzaActivity.class);
                        hamburger.putExtra("loai", 2);
                        startActivity(hamburger);
                        break;
                    case 3:
                        Intent hotdog = new Intent(getApplicationContext(), PizzaActivity.class);
                        hotdog.putExtra("loai", 3);
                        startActivity(hotdog);
                        break;
                    case 4:
                        Intent donhang = new Intent(getApplicationContext(), XemDonHangActivity.class);
                        startActivity(donhang);
                        break;
                    case 5:
                        Intent quanly = new Intent(getApplicationContext(), QuanLyActivity.class);
                        startActivity(quanly);
                        break;
                    case 6:
                        Intent thongke = new Intent(getApplicationContext(), ThongKeActivity.class);
                        startActivity(thongke);
                        break;
                    case 7:
                        Intent chat = new Intent(getApplicationContext(), ChatToUsersActivity.class);
                        startActivity(chat);
                        break;
                    case 8:
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                        builder.setTitle("Thông Báo");
                        builder.setMessage("Bạn có muốn đăng xuất không?");
                        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Paper.book().delete("user");
                                FirebaseAuth.getInstance().signOut();
                                Intent dangnhap = new Intent(getApplicationContext(), DangNhapActivity.class);
                                Toast.makeText(getApplicationContext(), "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                                startActivity(dangnhap);
                                finish();
                            }
                        });
                        builder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                        break;
                }
            }
        });
    }

    private void getSpMoi() {
        compositeDisposable.add(apiBanHang.getSpMoi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        spMoiModel -> {
                            if (spMoiModel.isSuccess()){
                                mangspmoi = spMoiModel.getResult();
                                spAdaper = new SpMoiAdapter(getApplicationContext(), mangspmoi);
                                recyclerViewMain.setAdapter(spAdaper);
                            }
                        },

                        throwable -> {
                            Toast.makeText(getApplicationContext(), "Không Kết Nối Được Với Server" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                ));
    }

    private void getLoaiSanPham() {
        compositeDisposable.add(apiBanHang.getLoaiSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        loaiSpModel -> {
                            if (loaiSpModel.isSuccess()){
                                mangloaisp = loaiSpModel.getResult();
                                mangloaisp.add(new LoaiSp("Quản lý đơn hàng", "https://media.istockphoto.com/id/1284067597/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-h%C3%B3a-%C4%91%C6%A1n-vector-thi%E1%BA%BFt-k%E1%BA%BF-h%E1%BB%A3p-th%E1%BB%9Di-trang.jpg?s=612x612&w=0&k=20&c=B_aiQnY3lIRQlVdEqoSFT3xYd3l4-sOdBZ6qq6UrFXo="));
                                mangloaisp.add(new LoaiSp("Quản lý sản phẩm", "https://media.istockphoto.com/id/1033799364/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-quy-tr%C3%ACnh-l%C3%A0m-vi%E1%BB%87c-theo-ki%E1%BB%83u-ph%E1%BA%B3ng-b%C3%A1nh-r%C4%83ng-b%C3%A1nh-r%C4%83ng-v%E1%BB%9Bi-m%C5%A9i-t%C3%AAn-vector-minh.jpg?s=612x612&w=0&k=20&c=51Pj_kQPQRxXkJHdNvqdiSTyKlGEjuLGPkB-HEiyhrI="));
                                mangloaisp.add(new LoaiSp("Thống kê", "https://media.istockphoto.com/id/1225609127/vi/vec-to/ph%C3%A1t-tri%E1%BB%83n-kh%C3%A1i-ni%E1%BB%87m-kinh-doanh.jpg?s=612x612&w=0&k=20&c=d8oNcwEA4qLHS0mfnQJLKZjKMPOS5OAK4pFASagw-xA="));
                                mangloaisp.add(new LoaiSp("Chat", "https://media.istockphoto.com/id/1017015696/vi/vec-to/bong-b%C3%B3ng-gi%E1%BB%8Dng-n%C3%B3i-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-vector-thi%E1%BA%BFt-k%E1%BA%BF-ph%E1%BA%B3ng-minh-h%E1%BB%8Da-c%C3%B4-l%E1%BA%ADp-tr%C3%AAn-m%C3%A0u-tr%E1%BA%AFng.jpg?s=612x612&w=0&k=20&c=8pssFoEg0CMza3ko3lSlIyaqOadOtAKOnuBhLb6VVP4="));

                                mangloaisp.add(new LoaiSp("Đăng xuất", "https://media.istockphoto.com/id/1383119801/vi/vec-to/bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-l%E1%BB%91i-ra-logout-v%C3%A0-%C4%91%E1%BA%A7u-ra-%E1%BB%95-c%E1%BA%AFm-ra-bi%E1%BB%83u-t%C6%B0%E1%BB%A3ng-h%C3%ACnh-minh-h%E1%BB%8Da-vector-ph%E1%BA%B3ng.jpg?s=612x612&w=0&k=20&c=6JuYgusnQPWldwoxlJNIcooyuPiKtdzSogtmYmFdD_E="));
                                loaiSpAdapter = new LoaiSpAdapter(getApplicationContext(), mangloaisp);
                                listViewMainScreeen.setAdapter(loaiSpAdapter);
                            }
                        }
                ));
    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://img.freepik.com/premium-photo/concept-fast-food-white-background_185193-47667.jpg?w=826");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/12/16/1314124/thuc-an-nhanh-la-gi-an-thuc-an-nhanh-co-tot-hay-khong-202012161146206471.jpg");
        mangquangcao.add("https://cdn.tgdd.vn/Files/2020/12/16/1314124/thuc-an-nhanh-la-gi-an-thuc-an-nhanh-co-tot-hay-khong-202012161146588670.jpg");
        for (int i = 0; i < mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        imgsearch = findViewById(R.id.imgsearch);
        toolbar = findViewById(R.id.toolbarmain);
        viewFlipper = findViewById(R.id.viewflipper);
        recyclerViewMain = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewMain.setLayoutManager(layoutManager);
        recyclerViewMain.setHasFixedSize(true);
        navigationViewMain = findViewById(R.id.navigationview);
        listViewMainScreeen = findViewById(R.id.listviewmain);
        drawerLayout = findViewById(R.id.drawerLayout);
        badge = findViewById(R.id.menu_sl);
        frameLayout = findViewById(R.id.framegiohang);
        // khoi tao list;
        mangloaisp = new ArrayList<>();
        mangspmoi = new ArrayList<>();
        if (Utils.manggiohang == null){
            Utils.manggiohang = new ArrayList<>();
        }else {
            int totalItem = 0;
            for (int i = 0; i < Utils.manggiohang.size(); i++){
                totalItem = totalItem + Utils.manggiohang.get(i).getSoluong();
            }
            badge.setText(String.valueOf(totalItem));
        }
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giohang = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(giohang);
            }
        });

        imgsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TimKiemActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        int totalItem = 0;
        for (int i = 0; i < Utils.manggiohang.size(); i++){
            totalItem = totalItem + Utils.manggiohang.get(i).getSoluong();
        }
        badge.setText(String.valueOf(totalItem));
    }

    private boolean isConnected (Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI); // Cap quyen
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnected()) || (mobile != null && mobile.isConnected())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}