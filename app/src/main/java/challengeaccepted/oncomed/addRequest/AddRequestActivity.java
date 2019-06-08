package challengeaccepted.oncomed.addRequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.google.firebase.firestore.FirebaseFirestore;

import challengeaccepted.oncomed.R;

public class AddRequestActivity extends AppCompatActivity {
    private EditText editTextSubstance;
    private EditText editTextName;
    private EditText editTextConcentration;
    private EditText editTextQuantity;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    static int requestId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);

        initView();
    }

    private void initView() {
        editTextConcentration = findViewById(R.id.editText3);
        editTextName = findViewById(R.id.editTextDrugName);
        editTextSubstance = findViewById(R.id.editTextActiveSubstance);
        editTextQuantity = findViewById(R.id.editTextQuantity);
    }

    public void SendRequestBtnOnClick(View view) {
        if(editTextQuantity.getText() != null && editTextSubstance.getText() != null && editTextName.getText() != null && editTextConcentration.getText() != null){
//            Map<String, Object> request = new HashMap<>();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            request.put("date", dateFormat.format(date));
//            request.put("drug_active_substance", editTextSubstance.getText());
//            request.put("drug_concentration", editTextConcentration.getText());
//            request.put("drug_name", editTextName.getText());
//            request.put("drug_quantity", editTextQuantity.getText());
            Request request = new Request();
            request.setDate("Data default");
            request.setDrugActiveSubstance(editTextSubstance.getText().toString());
            request.setDrugConcentration(editTextConcentration.getText().toString());
            request.setDrugName(editTextName.getText().toString());
            request.setQuantity(Integer.parseInt(editTextQuantity.getText().toString()));
            db.collection("request").add(request);
        }
        else{
            Toast.makeText(this, "Va rugam sa introduceti toate datele despre medicament!", Toast.LENGTH_LONG).show();
        }
    }
}
