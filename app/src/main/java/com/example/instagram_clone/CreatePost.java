package com.example.instagram_clone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;

public class CreatePost extends AppCompatActivity {

    Button upload_btn;
    ImageView imageToPost;
    Button submit_btn;
    EditText postDescription;

    private File photoFile;
    public String photoFileName = "photo.jpg";

    public final String TAG = "CreatePost";
    public final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 42;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        upload_btn = findViewById(R.id.upload_btn);
        imageToPost = findViewById(R.id.imageToPost);
        submit_btn = findViewById(R.id.submit_btn);
        postDescription = findViewById(R.id.postDescription);



//        queryPosts();


    }
}
