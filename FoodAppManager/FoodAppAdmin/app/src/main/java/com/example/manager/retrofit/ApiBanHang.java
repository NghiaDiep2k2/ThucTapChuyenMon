package com.example.manager.retrofit;

import io.reactivex.rxjava3.core.Observable;

import com.example.manager.model.DonHangModel;
import com.example.manager.model.LoaiSpModel;
import com.example.manager.model.MessageModel;
import com.example.manager.model.SpMoiModel;
import com.example.manager.model.ThongKeModel;
import com.example.manager.model.UserModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiBanHang {
    // GET DATA
    @GET("getsanpham.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SpMoiModel> getSpMoi();

    @GET("thongke.php")
    Observable<ThongKeModel> getthongke();

    @GET("thongkethang.php")
    Observable<ThongKeModel> getthongkethang();

    // POST DATA
    @POST("chitietsp.php")
    @FormUrlEncoded
    Observable<SpMoiModel> getSanPham(
        @Field("page") int page,
        @Field("loai") int loai
    );

    @POST("dangky.php")
    @FormUrlEncoded
    Observable<UserModel> dangky(
            @Field("gmail") String gmail,
            @Field("pass") String pass,
            @Field("username") String username,
            @Field("mobile") String mobile,
            @Field("uid") String uid
    );

    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable<UserModel> dangnhap(
            @Field("gmail") String gmail,
            @Field("pass") String pass
    );

    @POST("timkiem.php")
    @FormUrlEncoded
    Observable<SpMoiModel> timkiem(
            @Field("search") String search
    );

    @POST("donhang.php")
    @FormUrlEncoded
    Observable<UserModel> createOrder(
            @Field("gmail") String gmail,
            @Field("sdt") String sdt,
            @Field("tongtien") String tongtien,
            @Field("iduser") int iduser,
            @Field("diachi") String diachi,
            @Field("soluong") int soluong,
            @Field("chitiet") String chitiet
    );

    @POST("xemdonhang.php")
    @FormUrlEncoded
    Observable<DonHangModel> xemdonhang(
            @Field("iduser") int id
    );

    @POST("themsp.php")
    @FormUrlEncoded
    Observable<MessageModel> themsanpham(
            @Field("tensp") String tensp,
            @Field("giasp") String giasp,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int id,
            @Field("slsp") int soluong
    );

    @POST("suasp.php")
    @FormUrlEncoded
    Observable<MessageModel> suasanpham(
            @Field("tensp") String tensp,
            @Field("giasp") String giasp,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int idloai,
            @Field("id") int id,
            @Field("slsp") int soluong
    );

    @POST("xoasp.php")
    @FormUrlEncoded
    Observable<MessageModel> xoasanpham(
            @Field("id") int id
    );

    @Multipart
    @POST("upload.php")
    Call<MessageModel> uploadFile(
            @Part MultipartBody.Part file);

    @POST("updateorder.php")
    @FormUrlEncoded
    Observable<MessageModel> updateorder(
            @Field("id") int id,
            @Field("trangthai") int trangthai
    );

    @POST("updatetoken.php")
    @FormUrlEncoded
    Observable<MessageModel> updateToken(
            @Field("id") int id,
            @Field("token") String token
    );

    @POST("gettoken.php")
    @FormUrlEncoded
    Observable<UserModel> gettoken(
            @Field("status") int status,
            @Field("iduser") int iduser
    );
}
