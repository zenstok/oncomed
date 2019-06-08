package challengeaccepted.oncomed.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import challengeaccepted.oncomed.R;
import challengeaccepted.oncomed.addRequest.Drug;
import challengeaccepted.oncomed.addRequest.Pacient;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onSignUpBtn(View view) {
        final String lastName = ((TextView) findViewById(R.id.last_name_tw)).getText().toString();
        final String firstName = ((TextView) findViewById(R.id.first_name_tw)).getText().toString();
        final String CNP = ((TextView) findViewById(R.id.cnp_tw)).getText().toString();
        final String telephone = ((TextView) findViewById(R.id.telephone_tw)).getText().toString();
        final String email = ((TextView) findViewById(R.id.email_tw)).getText().toString();
        final String password = ((TextView) findViewById(R.id.password_tw)).getText().toString();

        if (lastName.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci numele!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (firstName.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci prenumele!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (CNP.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci CNP-ul!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (telephone.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci telefonul!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (email.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci adresa de email!",
                    Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(SignUpActivity.this, "Adresa de email trebuie sa fie intr-un format corect!",
                    Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(SignUpActivity.this, "Trebuie sa introduci parola!",
                    Toast.LENGTH_SHORT).show();
        } else {
            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("LOGIN SYSTEM LOG", "createUserWithEmail:success");
                                Toast.makeText(SignUpActivity.this, "Contul tau a fost creat. Te poti autentifica acum.",
                                        Toast.LENGTH_LONG).show();
                                FirebaseFirestore db = FirebaseFirestore.getInstance();
                                Pacient pacient = new Pacient(lastName, firstName, CNP, telephone, email, null);
                                db.collection("pacient").add(pacient).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        goToLogin();
                                    }
                                });

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("LOGIN SYSTEM LOG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUpActivity.this, "Parola trebuie sa aiba cel putin 6 caractere!",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
    }

    public void onLoginBtn(View view) {
        goToLogin();
    }

    private void goToLogin() {
        Intent goToLoginActivity = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(goToLoginActivity);
    }
}
