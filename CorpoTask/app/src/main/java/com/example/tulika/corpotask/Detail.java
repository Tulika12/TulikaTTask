package com.example.tulika.corpotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class Detail extends AppCompatActivity {
    String value;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView=(ImageView)findViewById(R.id.imageview1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("image");
        }
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(value,imageView);
    }
}
