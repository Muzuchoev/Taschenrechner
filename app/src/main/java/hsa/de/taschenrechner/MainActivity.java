package hsa.de.taschenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        String operator;
        String oldNumber;
        Boolean isNew = true;                                   // damit die Null nicht mehr vor der Zahl steht
        EditText editText;                                      //greifen darauf zu





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);                 // geben editText eine Bedeutung
    }

    public void clickNumber(View view) {                        //Drücken der Zahl und damit diese auf dem Bildschirm erscheint

        if(isNew)                                               // damit die Null nicht mehr vor der Zahl steht
            editText.setText("");                               // damit die Null nicht mehr vor der Zahl steht
        isNew=false;                                            // damit die Null nicht mehr vor der Zahl steht

        String number = editText.getText().toString();          // wir bekommen die Bedeutung "0"
        switch (view.getId()){                                  // wenn wir klicknumber klicken bekommen viewNumber -- also wenn wir auf die Zahl sieben drücken, ob die Id in den View vorkommt und sie übereinstimmen, dann wird der Null eine 7 dazuaddiert.
            case R.id.bu1: number = number+"1" ; break;
            case R.id.bu2: number = number+"2" ; break;
            case R.id.bu3: number = number+"3" ; break;
            case R.id.bu4: number = number+"4" ; break;
            case R.id.bu5: number = number+"5" ; break;
            case R.id.bu6: number = number+"6" ; break;
            case R.id.bu7: number = number+"7" ; break;
            case R.id.bu8: number = number+"8" ; break;
            case R.id.bu9: number = number+"9" ; break;
            case R.id.bu0: number = number+"0" ; break;
            case R.id.buPlus: number = "+" + number ; break;
            case R.id.buMinus: number = "-" + number ; break;
        }

        editText.setText(number);
    }

    public void operation(View view) {                                                                 //Funktion für PLus/Minus
        isNew = true;
        oldNumber = editText.getText().toString();

        switch (view.getId()){
            case R.id.buPlus: operator="+" ; break;
            case R.id.buMinus: operator="-"; break;
        }
        }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();                                               // Funktionalität für das "Istgleich", weil im vorherigen Code wir das Ergebis nicht bekamen
        Integer result = 0;

        switch (operator){
            case "+": result = Integer.parseInt(oldNumber) + Integer.parseInt(newNumber); break;
            case "-": result = Integer.parseInt(oldNumber) - Integer.parseInt(newNumber); break;
        }
        editText.setText(result+"");
    }

    public void clickCE(View view) {                                                                    //Funktionalität "CE" -> "0"
        editText.setText("0");
        isNew = true;                                                                                  // ist dafür da, damit wir beim Drücken der Taste "CE" keine Null vor der Zahl haben (ohne IsNew = True ) wird immer eine Null vor der Zahl stehen
    }
}