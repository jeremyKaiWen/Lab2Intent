package my.edu.tarc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String REPLY_TAG = "my.edu.tarc.lab2intent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String stringMsg;

        TextView textView = findViewById(R.id.textViewMessage);
        //Create an instance of the intent

        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.MESSAGE_TAG)) {
            stringMsg = intent.getStringExtra(MainActivity.MESSAGE_TAG);
            int age = intent.getIntExtra("TAG AGE", 0);
            textView.setText(stringMsg);
        }

    }
    public void sendReply(View view){
        EditText editTextReply;
        editTextReply = findViewById(R.id.editTextReply);
        if(TextUtils.isEmpty((editTextReply.getText()))){
            editTextReply.setError(getString(R.string.error_reply));
            return;
        }
        String stringReply = editTextReply.getText().toString();
        //create an instance of the Intent;
        Intent intent = new Intent();

        //pass the value to intent
        intent.putExtra(REPLY_TAG, stringReply);
        //set Result to OK
        setResult(RESULT_OK, intent);

    }
}
