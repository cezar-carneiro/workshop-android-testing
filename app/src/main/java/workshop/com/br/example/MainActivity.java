package workshop.com.br.example;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import workshop.com.br.example.api.ConversorApiException;
import workshop.com.br.example.api.ConversorDistancia;
import workshop.com.br.example.api.ConversorMassa;
import workshop.com.br.example.api.ConversorMoeda;
import workshop.com.br.example.api.ConversorTemperatura;
import workshop.com.br.example.api.IConversor;

public class MainActivity extends AppCompatActivity {

    private IConversor conversorDistancia;
    private IConversor conversorMassa;
    private IConversor conversorMoeda;
    private IConversor conversorTemperatura;

    private EditText milhasEditText;
    private EditText librasEditText;
    private EditText dolarEditText;
    private EditText celsiusEditText;

    private Button milhasButton;
    private Button librasButton;
    private Button dolarButton;
    private Button celsiusButton;

    private TextView quilometrosTextView;
    private TextView quilosTextView;
    private TextView realTextView;
    private TextView fahrenheitTextView;

    private Button limparButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milhasEditText = (EditText) findViewById(R.id.milhasEditText);
        librasEditText = (EditText) findViewById(R.id.librasEditText);
        dolarEditText = (EditText) findViewById(R.id.dolarEditText);
        celsiusEditText = (EditText) findViewById(R.id.celsiusEditText);

        milhasButton = (Button) findViewById(R.id.milhasButton);
        librasButton = (Button) findViewById(R.id.librasButton);
        dolarButton = (Button) findViewById(R.id.dolarButton);
        celsiusButton = (Button) findViewById(R.id.celsiusButton);

        quilometrosTextView = (TextView) findViewById(R.id.quilometrosTextView);
        quilosTextView = (TextView) findViewById(R.id.quilosTextView);
        realTextView = (TextView) findViewById(R.id.realTextView);
        fahrenheitTextView = (TextView) findViewById(R.id.fahrenheitTextView);

        limparButton = (Button) findViewById(R.id.limparButton);

        conversorDistancia = new ConversorDistancia();
        conversorMassa = new ConversorMassa();
        conversorMoeda = new ConversorMoeda();
        conversorTemperatura = new ConversorTemperatura();

    }

    public void onLimparButtonClick(View v){
        milhasEditText.setText("");
        librasEditText.setText("");
        dolarEditText.setText("");
        celsiusEditText.setText("");

        quilometrosTextView.setText("0.00 Km");
        quilosTextView.setText("0.00 Kg");
        realTextView.setText("R$ 0.00");
        fahrenheitTextView.setText("0.00 ºF");
    }

    public void onMilhasButtonClick(View v){
        try {
            BigDecimal bg = new BigDecimal(milhasEditText.getText().toString());
            BigDecimal valorEmKm = conversorDistancia.converter(bg);
            quilometrosTextView.setText(valorEmKm.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString() + " Km");
        } catch (NumberFormatException e){
            Log.e(null, null, e);
            showAlertDialog();
        } catch (ConversorApiException e) {
            Log.e(null, null, e);
            showAlertDialog();
        }

    }

    public void onLibrasButtonClick(View v){
        try {
            BigDecimal valorEmQuilos = conversorMassa.converter(new BigDecimal(librasEditText.getText().toString()));
            quilosTextView.setText(valorEmQuilos.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString() + " Kg");
        } catch (NumberFormatException e){
            Log.e(null, null, e);
            showAlertDialog();
        } catch (ConversorApiException e) {
            Log.e(null, null, e);
            showAlertDialog();
        }

    }

    public void onDolarButtonClick(View v){
        try {
            BigDecimal valorEmReais = conversorMoeda.converter(new BigDecimal(dolarEditText.getText().toString()));
            realTextView.setText("R$ " + valorEmReais.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString());
        } catch (NumberFormatException e){
            Log.e(null, null, e);
            showAlertDialog();
        } catch (ConversorApiException e) {
            Log.e(null, null, e);
            showAlertDialog();
        }

    }

    public void onCelsiusButtonClick (View v){
        try {
            BigDecimal valorEmFahrenheit = conversorTemperatura.converter(new BigDecimal(celsiusEditText.getText().toString()));
            fahrenheitTextView.setText(valorEmFahrenheit.setScale(2, BigDecimal.ROUND_HALF_DOWN).toString() + " ºF");
        } catch (NumberFormatException e){
            Log.e(null, null, e);
            showAlertDialog();
        } catch (ConversorApiException e) {
            Log.e(null, null, e);
            showAlertDialog();
        }
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Erro");
        builder.setMessage("Valor invalido");
        builder.create().show();
    }

}
