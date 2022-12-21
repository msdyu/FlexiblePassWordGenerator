package yu.masuda.flexiblepasswordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class PWSelectMenu extends AppCompatActivity {


        //------生成する要素の文字列を格納するArrayListを定義する------
        List<String> CheckBoxList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwselect_menu);


        /**------PWSelectMenu.javaを終了する処理------**/

        ImageButton closeSelectButton = findViewById(R.id.closeSelectButton);
        closeSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PWSelectMenu.this.finish();
            }
        });


        /**---初期値でdefaultRadioButtonを選択した状態にする。-------------------------------
           ---checkBoxの選択を無効化し、数字・英語(大文字・小文字)をCheckBoxListに追加する。------**/

        RadioGroup selectRadioGroup = findViewById(R.id.selectRadioGroup);
        RadioButton defaultRadioButton = findViewById(R.id.defaultRadioButton);
        RadioButton othersRadioButton = findViewById(R.id.othersRadioButton);

        CheckBox numberCheckBox = findViewById(R.id.numberCheckBox);
        CheckBox upperCaseCheckBox = findViewById(R.id.upperCaseCheckBox);
        CheckBox lowerCaseCheckBox = findViewById(R.id.lowerCaseCheckBox);
        CheckBox symbolCheckBox = findViewById(R.id.symbolCheckBox);

        //checkBoxの選択を無効化
        numberCheckBox.setEnabled(false);
        upperCaseCheckBox.setEnabled(false);
        lowerCaseCheckBox.setEnabled(false);
        symbolCheckBox.setEnabled(false);

        CheckBoxList.addAll(Arrays.asList
                ("1","2","3","4","5","6","7","8","9","0"));
        CheckBoxList.addAll(Arrays.asList
                ("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                        "O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        CheckBoxList.addAll(Arrays.asList
                ("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                        "o","p","q","r","s","t","u","v","w","x","y","z"));


        /**------使用する文字を選択する処理(デフォルトが外された場合)------**/

        selectRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.defaultRadioButton) {
                    //CheckBoxListがnullの場合
                    if (!CheckBoxList.contains("1") && !CheckBoxList.contains("A") &&
                            !CheckBoxList.contains("a") && !CheckBoxList.contains("#")) {
                        CheckBoxList.addAll(Arrays.asList
                                ("1","2","3","4","5","6","7","8","9","0"));
                        CheckBoxList.addAll(Arrays.asList
                                ("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                                        "O","P","Q","R","S","T","U","V","W","X","Y","Z"));
                        CheckBoxList.addAll(Arrays.asList
                                ("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                                        "o","p","q","r","s","t","u","v","w","x","y","z"));

                    /*othersRadioButton → symbolCheckBox → defaultRadiobuttonの場合
                      (CheckBoxListに記号しか入っていない場合)*/
                    }else if (CheckBoxList.contains("#")) {
                        CheckBoxList.removeAll(Arrays.asList
                                ("#","$","%","&","/","_"));
                    }

                    //checkBoxの選択を無効化する
                    numberCheckBox.setEnabled(false);
                    upperCaseCheckBox.setEnabled(false);
                    lowerCaseCheckBox.setEnabled(false);
                    symbolCheckBox.setEnabled(false);

                    //checkBoxの選択をリセットする
                    numberCheckBox.setChecked(false);
                    upperCaseCheckBox.setChecked(false);
                    lowerCaseCheckBox.setChecked(false);
                    symbolCheckBox.setChecked(false);

                }

                else if (checkedId == R.id.othersRadioButton) {
                    //defaultで入っている要素を削除する
                    CheckBoxList.removeAll(Arrays.asList
                            ("1","2","3","4","5","6","7","8","9","0"));
                    CheckBoxList.removeAll(Arrays.asList
                            ("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                                    "O","P","Q","R","S","T","U","V","W","X","Y","Z"));
                    CheckBoxList.removeAll(Arrays.asList
                            ("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                                    "o","p","q","r","s","t","u","v","w","x","y","z"));
                    //checkBoxの選択を有効にする
                    numberCheckBox.setEnabled(true);
                    upperCaseCheckBox.setEnabled(true);
                    lowerCaseCheckBox.setEnabled(true);
                    symbolCheckBox.setEnabled(true);
                }


                /*---------othersRadioButton → CheckBoxを選択するときの処理---------*/

                numberCheckBox.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          boolean check = numberCheckBox.isChecked();
                          if (check) {
                              CheckBoxList.addAll(Arrays.asList
                                      ("1","2","3","4","5","6","7","8","9","0"));
                          } else {
                              CheckBoxList.removeAll(Arrays.asList
                                      ("1","2","3","4","5","6","7","8","9","0"));
                          }
                      }
                });

                upperCaseCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = upperCaseCheckBox.isChecked();
                        if (check) {
                           CheckBoxList.addAll(Arrays.asList
                                   ("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                                       "O","P","Q","R","S","T","U","V","W","X","Y","Z"));
                        }
                        else {
                            CheckBoxList.removeAll(Arrays.asList
                                    ("A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                                            "O","P","Q","R","S","T","U","V","W","X","Y","Z"));
                        }
                    }
                });

                lowerCaseCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = lowerCaseCheckBox.isChecked();
                        if (check) {
                            CheckBoxList.addAll(Arrays.asList
                                    ("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                                            "o","p","q","r","s","t","u","v","w","x","y","z"));
                        }
                        else {
                            CheckBoxList.removeAll(Arrays.asList
                                    ("a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                                            "o","p","q","r","s","t","u","v","w","x","y","z"));
                        }
                    }
                });

                symbolCheckBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean check = symbolCheckBox.isChecked();
                        if (check) {
                            CheckBoxList.addAll(Arrays.asList
                                    ("#","$","%","&","/","_"));
                        }
                        else  {
                            CheckBoxList.removeAll(Arrays.asList
                                    ("#","$","%","&","/","_"));
                        }
                    }
                });
            }
        });


        /**------PWGenerateMenu.javaに画面遷移する処理------**/

        Button nextSelectButton = findViewById(R.id.nextSelectButton);

        nextSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), PWGenerateMenu.class);
                EditText editTextNumber = findViewById(R.id.editTextNumber);
                String editTextString = editTextNumber.getText().toString();

                /*---(editTextString != null) && (1 <= editTextString <= 20) でなおかつ、
                      CheckBoxList != null であれば画面遷移を行う-------------------------------*/

                if (editTextString.length() == 0) {
                    PWNumberNullDialog numberNullDialog = new PWNumberNullDialog();
                    numberNullDialog.show(getSupportFragmentManager(), "numberNull_dialog");

                }else {
                    int passWordSize = Integer.parseInt(editTextString);

                    if (passWordSize < 1 || passWordSize > 20) {
                        PWNumberNullDialog numberNullDialog = new PWNumberNullDialog();
                        numberNullDialog.show(getSupportFragmentManager(), "numberNull_dialog");

                    }else {
                        if (!CheckBoxList.contains("1") && !CheckBoxList.contains("A") &&
                                !CheckBoxList.contains("a") && !CheckBoxList.contains("#")) {
                            PWListNullDialog listNullDialog = new PWListNullDialog();
                            listNullDialog.show(getSupportFragmentManager(), "listNull_dialog");

                        }else {
                            intent.putExtra("SEND_NUMBER", passWordSize);
                            intent.putStringArrayListExtra("SEND_CHARACTER", (ArrayList) CheckBoxList);
                            //PWGenerateMenuに画面遷移
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}