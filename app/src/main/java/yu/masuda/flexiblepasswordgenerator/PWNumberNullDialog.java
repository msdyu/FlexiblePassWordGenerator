package yu.masuda.flexiblepasswordgenerator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**------editTextNumberがnull,もしくは1~20以外の数字であることを知らせるダイアログ------**/

public class PWNumberNullDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder numberNullBuilder = new AlertDialog.Builder(getActivity());
        numberNullBuilder.setTitle("入力エラー")
                .setMessage("1~20の数字を入力してください")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // ボタンを押すとダイアログが終了

                    }
                });
        AlertDialog alertDialog = numberNullBuilder.create();
        //戻るボタンを押してもダイアログが閉じなくする
        setCancelable(false);
        //ダイアログの外側をタップしてもダイアログが閉じなくする
        alertDialog.setCanceledOnTouchOutside(false);
        return numberNullBuilder.create();
    }
}