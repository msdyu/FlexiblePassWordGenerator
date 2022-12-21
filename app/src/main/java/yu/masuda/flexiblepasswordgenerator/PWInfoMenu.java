package yu.masuda.flexiblepasswordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PWInfoMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwinfo_menu);


        /**------PWInfoMenu.javaを終了する処理------**/

        ImageButton closeInfoButton = findViewById(R.id.closeInfoButton);

        closeInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PWInfoMenu.this.finish();
            }
        });
    }
}