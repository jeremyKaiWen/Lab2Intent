package my.edu.tarc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_TAG = "my.edu.tarc.lab2intent.MESSAGE";
    private static final int REQUEST_REPLY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void sendMessage(View view){
        String stringMsg;
        EditText textInput;
        textInput = findViewById(R.id.editTextMessage);
        if(TextUtils.isEmpty(textInput.getText())){
            textInput.setError("Please enter your message");
            return;
        }
        stringMsg = textInput.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class); // explicit intent
        intent.putExtra(MESSAGE_TAG, stringMsg);
        //intent.putExtra("MESSAGE", stringMsg);
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_REPLY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_REPLY_CODE){
            if(resultCode ==RESULT_OK){
                if(data.hasExtra(SecondActivity.REPLY_TAG)){
                    String stringReply;
                    TextView textView = findViewById(R.id.textViewReply);
                    stringReply = data.getStringExtra(SecondActivity.REPLY_TAG);
                    textView.setText(stringReply);
                }
            }
        }

        //TODO: Complete the rersults handling process
    }
}
