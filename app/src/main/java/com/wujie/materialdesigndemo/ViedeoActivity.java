package com.wujie.materialdesigndemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.VideoView;

public class ViedeoActivity extends AppCompatActivity {

    VideoView mVideoView;
    TextView mTimeText;
    PopupWindow popupWindow;
    String url = "/storage/sdcard0/ddmsrec.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viedeo);
        mVideoView = (VideoView) findViewById(R.id.video);
        mTimeText = (TextView) findViewById(R.id.time_tx);
        mVideoView.setVideoURI(Uri.parse(url));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mTimeText.setText(mVideoView.getDuration()+"");
            }
        });
        popupWindow = new PopupWindow(getLayoutInflater().inflate(R.layout.layout, null), 300,300);
        getSDVideo();
        mTimeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(view);
            }
        });

    }

    private void getSDVideo () {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = this.getContentResolver();
        Cursor cursor = contentResolver.query(uri, null,null, null, null);
        while (cursor.moveToNext()) {
            for (int i = 0; i < 9; i++) {
                Log.e(cursor.getColumnName(i), cursor.getString(i));
            }
//            String number= cursor.getString(0); // 视频编号
//            String path = cursor.getString(1); // 视频文件路径
//            String size = cursor.getString(2); // 视频大小
//            String name = cursor.getString(3); // 视频文件名
//            String a = cursor.getString(4) +cursor.getColumnName(4);
//            String b = cursor.getString(5) + cursor.getColumnName(5);
//            String c = cursor.getString(6) +cursor.getColumnName(6);
//            String d = cursor.getString(7) +cursor.getColumnName(7);
//
//            Log.e("-----","number="+number);
//            Log.e("-----","v_path="+path);
//            Log.e("-----","v_size="+size);
//            Log.e("-----","v_name="+name);
//            Log.e("-----","v_a="+a);
//            Log.e("-----","v_b="+b);
//            Log.e("-----","v_c="+c);
//            Log.e("-----","v_d="+d);
        }
    }
}
