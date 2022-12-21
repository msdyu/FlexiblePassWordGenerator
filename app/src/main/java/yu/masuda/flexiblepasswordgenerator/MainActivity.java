package yu.masuda.flexiblepasswordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**------PWSelectMenu.javaに画面遷移する処理------**/

        Button PWStartButton = findViewById(R.id.startButton);

        PWStartButton.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
                 Intent startIntent = new Intent(MainActivity.this, PWSelectMenu.class);
                 startActivity(startIntent);
             }
        });


        /**------PWInfoMenu.javaに画面遷移する処理------**/

        ImageButton PWInfoButton = findViewById(R.id.infoButton);

        PWInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(MainActivity.this, PWInfoMenu.class);
                startActivity(infoIntent);
            }
        });
    }
}