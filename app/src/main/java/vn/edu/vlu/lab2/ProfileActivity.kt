
package vn.edu.vlu.lab2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.lab2.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getStringExtra("USER_EMAIL") ?: "Chưa có email"

        // Chỉ dùng nếu activity_profile.xml có TextView mang ID tvEmail
        binding.tvEmail.text = email

        binding.btnLogout.setOnClickListener {
            finish()
        }

        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(
                this,
                "Chức năng chỉnh sửa hồ sơ",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
