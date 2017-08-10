package workshop.com.br.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText milhasEditText;
    private EditText librasEditText;
    private EditText dolarEditText;

    private Button milhasButton;
    private Button librasButton;
    private Button dolarButton;

    private TextView quilometrosTextView;
    private TextView quilosTextView;
    private TextView realTextView;

    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milhasEditText = (EditText) findViewById(R.id.milhasEditText);
        librasEditText = (EditText) findViewById(R.id.librasEditText);
        dolarEditText = (EditText) findViewById(R.id.dolarEditText);

        milhasButton = (Button) findViewById(R.id.milhasButton);
        librasButton = (Button) findViewById(R.id.librasButton);
        dolarButton = (Button) findViewById(R.id.dolarButton);

        quilometrosTextView = (TextView) findViewById(R.id.quilometrosTextView);
        quilosTextView = (TextView) findViewById(R.id.quilosTextView);
        realTextView = (TextView) findViewById(R.id.realTextView);

        limparButton = (Button) findViewById(R.id.limparButton);

    }
}
