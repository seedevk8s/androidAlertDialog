package kr.co.alertdialogapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button button;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("사용자 정보 입력 (수정)");

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlgEdtName = dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail = dialogView.findViewById(R.id.dlgEdt2);

                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtEmail.setText(tvEmail.getText().toString());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());
                    }
                });

                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());

                        toast.setGravity(Gravity.TOP |  Gravity.LEFT, xOffset, yOffset);

                        toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                        toastText = toastView.findViewById(R.id.toastText);

                        toastText.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();
                    }
                });

                dlg.show();
            }
        });

    }
}

























