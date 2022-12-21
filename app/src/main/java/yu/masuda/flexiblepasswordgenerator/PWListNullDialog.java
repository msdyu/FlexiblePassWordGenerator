package yu.masuda.flexiblepasswordgenerator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**------CheckBoxListのnullを知らせるダイアログ------**/

public class PWListNullDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder listNullBuilder = new AlertDialog.Builder(getActivity());
        listNullBuilder.setTitle("入力エラー")
                .setMessage("いずれかの文字を選択してください")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // ボタンを押すとダイアログが終了

                    }
                });
        AlertDialog alertDialog = listNullBuilder.create();
        //戻るボタンを押してもダイアログが閉じなくする
        setCancelable(false);
        //ダイアログの外側をタップしてもダイアログが閉じなくする
        alertDialog.setCanceledOnTouchOutside(false);
        return listNullBuilder.create();
    }
}
