package miwok.android.example.com.learnc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class image extends AppCompatActivity {
    ImageView image;
    int roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image = (ImageView) findViewById(R.id.image);
        Intent intent = getIntent();
        if (intent != null) {
            roll = intent.getIntExtra("Roll", 2000);
        }
        if (roll == 107) {
            image.setImageResource(R.drawable.keywords);


        } else if (roll == 109) {
            image.setImageResource(R.drawable.loop);
        } else if (roll == 110) {
            image.setImageResource(R.drawable.types_loops);
        } else if (roll == 111) {
            image.setImageResource(R.drawable.do_flowchart);
        }
        else if (roll == 112) {
            image.setImageResource(R.drawable.forloop);
        }
        else if (roll == 113) {
            image.setImageResource(R.drawable.whiel);
        }
        else if (roll == 114) {
            image.setImageResource(R.drawable.while_loop);
        }
        else if (roll == 115) {
            image.setImageResource(R.drawable.literal_exp);
        }else if (roll == 117) {
            image.setImageResource(R.drawable.cswitch);
        }
        else if (roll == 119) {
            image.setImageResource(R.drawable.module2);
        }else if (roll == 120) {
            image.setImageResource(R.drawable.func);
        }


    }
}
