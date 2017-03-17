package comsci.adoublelz.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TestLayout extends AppCompatActivity {


    //Explicit
    MediaPlayer mediaPlayer;
    int soundID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);

        //Toast onClick
        ImageView clickImageView = (ImageView) findViewById(R.id.imvMyPic);
        clickImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello! My name is Allvinz" , Toast.LENGTH_SHORT ).show();
                //play sound when click Image
                soundID =R.raw.hello;
                playSound(soundID);
            }
        }); //end Toast onClick

        //Toast onLongClick
        ImageView longClickImageView = (ImageView) findViewById(R.id.imvMyPic);
        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks guys ggwp yeah!" , Toast.LENGTH_SHORT).show();
                //play sound when click image
                soundID = R.raw.thank;
                playSound(soundID);

                return true;
            }
        }); //end Toast onLongClick

            //Phone onclick
            TextView phoneTextView = (TextView) findViewById(R.id.txtTel);
            phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0910732604"));
                startActivity(phoneIntent);
            }
        });


    } //main method


    private void playSound(int soundID){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundID);
        mediaPlayer.start();
    }
    public void facebook (View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com/MomuntineZ"));
        startActivity(intent);

    }

    public void onclickBack (View view ){
        finish();


    }
} //main class
