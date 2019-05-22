package yitiao;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author yuantongqin
 * 2019/5/8
 */
public class Demo {


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

//        2018-11-02 12:37:45

        calendar.set(2018,10,1);

        System.out.println("sss"+calendar.getTime());
        calendar.set(2018,10,29);
        System.out.println(calendar.getTime());
    }


}
