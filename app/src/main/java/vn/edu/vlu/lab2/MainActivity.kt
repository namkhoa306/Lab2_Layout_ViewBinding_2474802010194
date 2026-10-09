
package vn.edu.vlu.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.lab2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Xu ly nut Dang nhap
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            when {
                email.isEmpty() -> {
                    binding.etEmail.error =
                        getString(R.string.error_email_required)
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.etEmail.error =
                        getString(R.string.error_email_invalid)
                }

                password.isEmpty() -> {
                    binding.etPassword.error =
                        getString(R.string.error_password_required)
                }

                password.length < 6 -> {
                    binding.etPassword.error =
                        getString(R.string.error_password_short)
                }

                else -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("USER_EMAIL", email)
                    startActivity(intent)
                }
            }
        }

        // Xu ly nut Quen mat khau
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.forgot_password_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
