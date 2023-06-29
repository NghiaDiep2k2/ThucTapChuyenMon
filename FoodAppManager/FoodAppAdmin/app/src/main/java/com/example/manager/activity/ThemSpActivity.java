package com.example.manager.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.manager.R;
import com.example.manager.adapter.DonHangAdapter;
import com.example.manager.databinding.ActivityThemSpBinding;
import com.example.manager.model.MessageModel;
import com.example.manager.model.SanPhamMoi;
import com.example.manager.retrofit.ApiBanHang;
import com.example.manager.retrofit.RetrofitClient;
import com.example.manager.utils.Utils;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class ThemSpActivity extends AppCompatActivity {

    Toolbar toolbar;
    Spinner spinner;
    int loai = 0;

    ActivityThemSpBinding binding;
    ApiBanHang apiBanHang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    SanPhamMoi sanPhamSua;
    boolean flag = false;
    String mediaPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemSpBinding.inflate(getLayoutInflater());
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        setContentView(binding.getRoot());

        initView();
        initData();
        ActionToolBar();

        ActionBar a = getSupportActionBar();
        Intent intent = getIntent();
        sanPhamSua = (SanPhamMoi) intent.getSerializableExtra("Sua");
        if (sanPhamSua == null){
            // them san pham
            flag = false;
        }else {
            // sua san pham
            flag = true;
            a.setTitle("Sửa sản phẩm");
            binding.btnthemsp.setText("Sửa sản phẩm");
            // show data
            binding.tensanpham.setText(sanPhamSua.getTensp());
            binding.giasanpham.setText(sanPhamSua.getGiasp());
            binding.soluongsanpham.setText(sanPhamSua.getSltonkho() + " ");
            binding.hinhanh.setText(sanPhamSua.getHinhanh());
            binding.mota.setText(sanPhamSua.getMota());
            binding.spinnerLoai.setSelection(sanPhamSua.getLoai());
        }

    }

    private void initData() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Vui long chọn loại");
        stringList.add("Loại Pizza");
        stringList.add("Loại Hamburger");
        stringList.add("Loại Hotdog");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stringList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loai = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.btnthemsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == false){
                    themsanpham();
                }else {
                    suasanpham();
                }


            }
        });

        binding.imgcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.with(ThemSpActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mediaPath = data.getDataString();
        uploadMultipleFiles();
        Log.d("log", "onActivityResult: " + mediaPath);
    }

    private void themsanpham() {
        String str_tensp = binding.tensanpham.getText().toString().trim();
        String str_giasp = binding.giasanpham.getText().toString().trim();
        String str_hinhanh = binding.hinhanh.getText().toString().trim();
        String str_mota = binding.mota.getText().toString().trim();
        String str_soluong = binding.soluongsanpham.getText().toString();
        if (TextUtils.isEmpty(str_tensp) || TextUtils.isEmpty(str_giasp) || TextUtils.isEmpty(str_soluong) || TextUtils.isEmpty(str_mota) || TextUtils.isEmpty(str_hinhanh) || loai == 0){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin sản phẩm", Toast.LENGTH_LONG).show();
        }else {
            compositeDisposable.add(apiBanHang.themsanpham(str_tensp, str_giasp, str_hinhanh, str_mota, (loai), Integer.parseInt(str_soluong))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            messageModel -> {
                                if (messageModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                    binding.tensanpham.setText("");
                                    binding.giasanpham.setText("");
                                    binding.hinhanh.setText("");
                                    binding.mota.setText("");
                                    binding.soluongsanpham.setText("");
                                }else {
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }
                    ));
        }
    }

    private void suasanpham() {
        String str_tensp = binding.tensanpham.getText().toString().trim();
        String str_giasp = binding.giasanpham.getText().toString().trim();
        String str_hinhanh = binding.hinhanh.getText().toString().trim();
        String str_mota = binding.mota.getText().toString().trim();
        String str_soluong = binding.soluongsanpham.getText().toString();
        if (TextUtils.isEmpty(str_tensp) || TextUtils.isEmpty(str_giasp) || TextUtils.isEmpty(str_soluong) || TextUtils.isEmpty(str_mota) || TextUtils.isEmpty(str_hinhanh) || loai == 0){
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đủ thông tin sản phẩm", Toast.LENGTH_LONG).show();
        }else {
            compositeDisposable.add(apiBanHang.suasanpham(str_tensp, str_giasp, str_hinhanh, str_mota, loai, sanPhamSua.getId(), Integer.parseInt(str_soluong))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            messageModel -> {
                                if (messageModel.isSuccess()){
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(getApplicationContext(), messageModel.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            },
                            throwable -> {
                                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }
                    ));
        }
    }

    private String getPath(Uri uri){
        String result;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null){
            result = uri.getPath();
        }else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(index);
            cursor.close();
        }
        return result;
    }

    private void uploadMultipleFiles() {
        Uri uri = Uri.parse(mediaPath);
        File file = new File(getPath(uri));

        RequestBody requestBody1 = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload1 = MultipartBody.Part.createFormData("file", file.getName(), requestBody1);

        Call<MessageModel> call = apiBanHang.uploadFile(fileToUpload1);
        call.enqueue(new Callback<MessageModel>() {
            @Override
            public void onResponse(Call <MessageModel> call, Response<MessageModel> response) {
                MessageModel serverResponse = response.body();
                if (serverResponse != null) {
                    if (serverResponse.isSuccess()) {
                        binding.hinhanh.setText(serverResponse.getName());
                    } else {
                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert serverResponse != null;
                    Log.v("Response", serverResponse.toString());
                }
            }
            @Override
            public void onFailure(Call <MessageModel> call, Throwable t) {
                Log.d("log", t.getMessage());
            }
        });
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.spinner_loai);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}