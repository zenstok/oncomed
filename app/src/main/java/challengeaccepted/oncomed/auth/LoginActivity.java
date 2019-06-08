package challengeaccepted.oncomed.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import challengeaccepted.oncomed.R;
import challengeaccepted.oncomed.main.MainActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginBtn(View view) {
        String email = ((TextView) findViewById(R.id.email_tw)).getText().toString();
        String password = ((TextView) findViewById(R.id.password_tw)).getText().toString();

        if (email.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Trebuie sa introduci adresa de email!",
                    Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "Trebuie sa introduci parola!",
                    Toast.LENGTH_SHORT).show();
        } else {
            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("LOGIN SYSTEM LOG", "signInWithEmail:success");
                                Intent goToMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(goToMainActivity);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("LOGIN SYSTEM LOG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Credentiale incorecte.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
        }

    }

    public void onSignUpBtn(View view) {
        Intent goToSignUpActivity = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(goToSignUpActivity);
    }
}
