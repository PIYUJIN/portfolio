package com.example.portfolio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.portfolio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)



        binding.activityButton.setOnClickListener {

            startActivity(Intent(this@MainActivity, ActivitiesActivity::class.java))
        }

        binding.skillsButton.setOnClickListener {

            startActivity(Intent(this@MainActivity, SkillActivity::class.java))
        }

        binding.educationButton.setOnClickListener {

            startActivity(Intent(this@MainActivity, EducationActivity::class.java))
        }

        binding.awardButton.setOnClickListener {

            startActivity(Intent(this@MainActivity, AwardActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)       // main_menu 메뉴를 toolbar 메뉴 버튼으로 설정
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.tel -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9032-3366"))
                startActivity(intent)
            }
            R.id.email-> {
                Snackbar.make(binding.toolbar,"E-MAIL : 20102125@seoultech.ac.kr",Snackbar.LENGTH_SHORT).show()
            }
            R.id.github-> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/PIYUJIN"))
                startActivity(intent)
            }
            android.R.id.home -> {
                Snackbar.make(binding.toolbar,"cannot go back",Snackbar.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

