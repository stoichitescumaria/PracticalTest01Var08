package ro.pub.cs.systems.eim.practicaltest01var08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02PlayActivity extends AppCompatActivity {

    private EditText riddleEditText;
    private EditText answerEditText;
    private Button checkButton;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_play);
        riddleEditText = (EditText)findViewById(R.id.riddle_edit_text);
        answerEditText = (EditText)findViewById(R.id.answer_edit_text);
        checkButton = (Button)findViewById(R.id.check_button);
        backButton = (Button)findViewById(R.id.back_button);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String riddle = extras.getString("riddle");
                riddleEditText.setText(riddle);
            }
        }
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    Bundle extras = getIntent().getExtras();
                    String answer = extras.getString("answer");
                    String myAnswer = answerEditText.getText().toString();
                    if (myAnswer.equals(answer)) {
                        Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}