package yu.masuda.flexiblepasswordgenerator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class PWGenerateMenu extends AppCompatActivity {

        //PWSelectMenuから文字列を受け取るarrayListを定義する
        private List<String>PWStringList = new ArrayList<>();
        //completePassWordを格納するarrayListを定義する
        private List<String>arrayListTexts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwgenerate_menu);


        /**------PWGenerateMenuを終了する処理------**/

        ImageButton closeGenerateButton = findViewById(R.id.closeGenerateButton);

        closeGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PWGenerateMenu.this.finish();
            }
        });


        //------PWSelectMenuからの値を取得------
        Intent intent = getIntent();
        //パスワードの長さをgetLengthDataに取得
        int getLengthData = intent.getIntExtra("SEND_NUMBER",0);
        //パスワードの文字列をPWStringListに取得
        PWStringList = intent.getStringArrayListExtra("SEND_CHARACTER");


        /**------PWSelectMenuから取得した情報をgetTextに反映する------**/
        //------パスワードの文字列情報をgetCharLengthTextに反映------

        TextView getCharLengthText = findViewById(R.id.getCharLengthText);

        //getLengthDataをString型getNumberに変換する
        String getNumber = Integer.toString(getLengthData);
        getCharLengthText.setText(getNumber);


        //------パスワードの文字列情報をgetBooleanTextに反映------

        TextView getBooleanNumberText = findViewById(R.id.getBooleanNumberText);
        //PWStringListが数字を含むかどうか確認する
        if (PWStringList.contains("1")) {
            getBooleanNumberText.setText("使用しています");
        }
        else {
            getBooleanNumberText.setText("使用していません");
        }

        TextView getBooleanUpperCaseText = findViewById(R.id.getBooleanUpperCaseText);
        //PWStringListが英語(大文字)を含むかどうか確認する
        if (PWStringList.contains("A")) {
            getBooleanUpperCaseText.setText("使用しています");
        }
        else {
            getBooleanUpperCaseText.setText("使用していません");
        }

        TextView getBooleanLowerCaseText = findViewById(R.id.getBooleanLowerCaseText);
        //PWStringListが英語(小文字)を含むかどうか確認する
        if (PWStringList.contains("a")) {
            getBooleanLowerCaseText.setText("使用しています");
        }
        else  {
            getBooleanLowerCaseText.setText("使用していません");
        }

        TextView getBooleanSymbolText = findViewById(R.id.getBooleanSymbolText);
        //PWStringListが記号を含むかどうか確認する
        if (PWStringList.contains("#")) {
            getBooleanSymbolText.setText("使用しています");
        }
        else {
            getBooleanSymbolText.setText("使用していません");
        }


        //getNumberをint型passWordSizeに戻す
        int passWordSize = Integer.parseInt(getNumber);
        //PWStringListに含まれる要素をシャッフルする
        Collections.shuffle(PWStringList);

        //PWStringListをString型変数lowPurityPassWordに変換する
        String lowPurityPassWord = Arrays.toString(PWStringList.toArray());;

        //lowPurityPassWordからコンマ、半角空白、角カッコを取り除き、highPurityPassWordに変換する
        String highPurityPassWord = lowPurityPassWord.replaceAll(",","")
                .replaceAll(" ","").replaceAll("\\[", "")
                    .replaceAll("]","");


        /**------nextPWButtonを押したときの処理(パスワードを生成する処理)------**/

        TextView arrayListTextView = findViewById(R.id.arrayListText);
        Button nextPWButton = findViewById(R.id.nextPWButton);

        //highPurityPassWordからpassWordSizeの数だけ要素を取り出し、completePassWordに格納する
        nextPWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String completePassword = "";
                Random r = new Random();

                    for (int i = 0; i < passWordSize ; i++) {
                        completePassword = completePassword + highPurityPassWord
                                        .charAt(r.nextInt(highPurityPassWord.length()));
                    }
                //completePasswordを表示する
                arrayListTexts.add(completePassword);
                arrayListTextView.setText(arrayListTexts.toString());
            }
        });
    }
}