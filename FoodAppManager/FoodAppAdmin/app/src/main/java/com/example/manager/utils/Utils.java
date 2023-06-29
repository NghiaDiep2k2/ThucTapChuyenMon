package com.example.manager.utils;

import com.example.manager.model.GioHang;
import com.example.manager.model.User;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String BASE_URL="http://192.168.1.25/banhang/";
    public static List<GioHang> manggiohang;

    public static List<GioHang> mangmuahang = new ArrayList<>();
    public static User user_current = new User();

    public static String ID_RECEIVED;
    public static final String SEND_ID = "idsend";
    public static final String RECEIVED_ID = "idreceived";
    public static final String MESS = "message";
    public static final String DATETIME = "datetime";
    public static final String PATH_CHAT = "chat";

}
