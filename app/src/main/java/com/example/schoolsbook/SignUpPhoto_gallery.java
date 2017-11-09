package com.example.schoolsbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * Created by 최민경 on 2017-11-10.
 */

public class SignUpPhoto_gallery extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_iMAGE = 2;

    private ImageView iv_UserPhoto;
    private String absoultePath;

    Uri mlmageCaptureUri;
    Gallery mSignUpPhoto = new Gallery(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Button btn_UploadPicture = (Button)this.findViewById(R.id.btn_UploadPicture);

        btn_UploadPicture.setOnClickListener(this);
    }
    public void onClick(View v){
        DialogInterface.OnClickListener cameraListener = new  DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                doTakePhotoAction();
            }
        };
        DialogInterface.OnClickListener albumListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                doTakeAlbumAction();
            }
        };

        DialogInterface.OnClickListener cancelListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        };

        new AlertDialog.Builder(this)
                .setTitle("업로드할 이미지 선택")
                .setPositiveButton("사진촬영", cameraListener)
                .setNeutralButton("앨범선택", albumListener)
                .setNegativeButton("취소", cancelListener)
                .show();
        }

        //카메라에서 사진 촬영
    public void doTakePhotoAction(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //임시로 사용할 파일의 경로 생성
        String url = "tmp_" + String.valueOf(System.currentTimeMillis()) + ",jpg";
        mlmageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), url));

        intent.putExtra(MediaStore.EXTRA_OUTPUT, mlmageCaptureUri);
        startActivityForResult(intent, PICK_FROM_CAMERA);
    }

    //앨범에서 이미지 가져오기
    public void doTakeAlbumAction(){
        //앨범호출
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode != RESULT_OK)
            return;

        switch (requestCode) {
            case PICK_FROM_ALBUM: {
                mlmageCaptureUri = data.getData();
                Log.d("SmartWheel", mlmageCaptureUri.getPath().toString());
            }
            case PICK_FROM_CAMERA: {
                //이미지를 가져온 이후의 리사이즈할 이미지 크기를 결정
                //이후에 이미지 크롭 어플리케이션 호출
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(mlmageCaptureUri, "image/*");

                //CROP할 이미지를 200*200 크기로 저장
                intent.putExtra("outputX", 200); //CROP한 이미지의 X축 크기
                intent.putExtra("outputY", 200); //CROP한 이미지의 Y축 크기
                intent.putExtra("aspectX", 1); //CROP 박스의 X축 비율
                intent.putExtra("aspectY", 1); //CROP 박스의 Y축 비율
                intent.putExtra("scale", true);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, CROP_FROM_iMAGE);
                break;
            }
            case CROP_FROM_iMAGE: {
                //크롭이 된 이후의 이미지를 넘겨받는다
                //이미지뷰에 이미지를 보여준다거나 부가적인 작업 이후에 임시파일 삭제
                if (resultCode != RESULT_OK) {
                    return;
                }
                final Bundle extras = data.getExtras();

                //CROP된 이미지를 저장하기 위한 FILE 경로
                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SmartWheel/" + System.currentTimeMillis() + ".jpg";

                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data"); //CROP된 BITMAP
                    iv_UserPhoto.setImageBitmap(photo); //레이아웃 이미지칸에 CROP된 BITMAP을 보여준다

                    storeCropImage(photo, filePath); //CROP된 이미지를 외부저장소, 앨범에 저장한다
                    absoultePath = filePath;
                    break;
                }
                //임시 파일 삭제
                File f = new File(mlmageCaptureUri.getPath());
                if (f.exists()) {
                    f.delete();
                }
            }
        }
    }

    //bitmap을 저장하는 부분
    private void storeCropImage(Bitmap bitmap, String filePath){
        //smartWheel폴더를 생성하여 이미지를 저장하는 방식
        String dirPath = Environment.getDownloadCacheDirectory().getAbsolutePath() + "/SmartWheel";
        File directory_SmartWheel = new File(dirPath);

        if(!directory_SmartWheel.exists()){//디렉터리에 폴더가 없다면
            directory_SmartWheel.mkdir();
        }

        File copyFile = new File(filePath);
        BufferedOutputStream out = null;

        try{
            copyFile.createNewFile();
            out = new BufferedOutputStream(new FileOutputStream(copyFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(copyFile)));

            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
