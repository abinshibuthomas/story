package com.example.storybook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class story1 extends AppCompatActivity {
    ImageView image1;
    TextView tExt1;
int[] story=new int[]{R.string.story1,R.string.story2,R.string.story3};
int[] storyImg= new int[]{R.drawable.image,R.drawable.image,R.drawable.image};
    private TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                    t1.setSpeechRate(0.70f);
                }
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
        String pos=getIntent().getExtras().getString("position");
        int position=Integer.parseInt(pos);
        image1=findViewById(R.id.imageView2);
        tExt1=findViewById(R.id.textView);
        image1.setImageResource(storyImg[position]);
        tExt1.setText((String.valueOf(story[position])));
        t1.speak(String.valueOf(story[position]), TextToSpeech.QUEUE_FLUSH, null);


    }
}