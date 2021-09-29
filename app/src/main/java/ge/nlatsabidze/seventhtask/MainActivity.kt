package ge.nlatsabidze.seventhtask

import android.graphics.Color
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import ge.nlatsabidze.seventhtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.passwordField.setTransformationMethod(PasswordTransformationMethod.getInstance())

        val emailId = binding.emailField
        val passwordId = binding.passwordField
        binding.btnSign.setOnClickListener {
            if (checkEmailCorrectness(emailId.text.toString()) && passwordId.text.toString().length != 0) {
                Toast.makeText(this, "You are signed in", LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Sign in correctly", LENGTH_SHORT).show()
            }
        }
    }

    private fun checkEmailCorrectness(email: String):Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}