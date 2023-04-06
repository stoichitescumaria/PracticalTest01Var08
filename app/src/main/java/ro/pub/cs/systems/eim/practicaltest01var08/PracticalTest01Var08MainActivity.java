package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private EditText riddleEditText;
    private EditText answerEditText;
    private Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);
        riddleEditText = (EditText)findViewById(R.id.riddle_edit_text);
        answerEditText = (EditText)findViewById(R.id.answer_edit_text);
        playButton = (Button)findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String riddle = riddleEditText.getText().toString();
                String answer = answerEditText.getText().toString();
                if (riddle != null && answer != null) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02PlayActivity.class);
                    intent.putExtra("riddle", riddle);
                    intent.putExtra("answer", answer);
                    startActivityForResult(intent, 1);
                }
                if(answer != null) {
                   Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08Service.class);
                     intent.putExtra("answer", answer);
                     getApplicationContext().startService(intent);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("riddle", riddleEditText.getText().toString());
        outState.putString("answer", answerEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("riddle")) {
            riddleEditText.setText(savedInstanceState.getString("riddle"));
        }
        if (savedInstanceState.containsKey("answer")) {
            answerEditText.setText(savedInstanceState.getString("answer"));
        }
    }
}