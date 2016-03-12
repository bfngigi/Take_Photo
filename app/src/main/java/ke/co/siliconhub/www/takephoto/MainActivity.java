package ke.co.siliconhub.www.takephoto;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.pm.PackageInfo;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView siliconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button siliconButton = (Button) findViewById(R.id.siliconButton);
        siliconImageView = (ImageView) findViewById(R.id.siliconImageView);

        //Disable to camera if user doesnt have a camera
        if (!hasCamera())
            siliconButton.setEnabled(false);
    }

    private Boolean hasCamera(){
            return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }
    //Launcing Camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Take a picture and pass results
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
    //If you want to return the image taken


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode ==REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK){
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            siliconImageView.setImageBitmap(photo);

        }
    }
}




