package com.example.acer.firebasestorage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button download;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download = (Button)findViewById(R.id.button2);
        img = (ImageView)findViewById(R.id.imageView);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/fir-storage-3ce72.appspot.com/o/Screenshot%20(1).png?alt=media&token=92e48f6b-09fb-4f8e-9ea4-bc1ad31392bd");
        final ProgressDialog progressDialog = new ProgressDialog(this);
        download.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                try {
                    //showProgressDialog("Download File", "Downloading File...");
                    //final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setTitle("Downloading");
                    progressDialog.show();
                    final File localFile = File.createTempFile("images", "jpg");
                    storageRef.getFile(localFile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                                    img.setImageBitmap(bitmap);
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this,"Download Sucessful",Toast.LENGTH_LONG).show();
                                }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            progressDialog.dismiss();
                            Toast.makeText(MainActivity.this,"Download Failed",Toast.LENGTH_LONG).show();
                        }
                    }).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
                           // double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount()
                           progressDialog.setMessage("In Progress");
                        }
                    });
                } catch (IOException e ) {
                    e.printStackTrace();
                    Log.e("Main", "IOE Exception");
                }

            }

        });

    }
}
