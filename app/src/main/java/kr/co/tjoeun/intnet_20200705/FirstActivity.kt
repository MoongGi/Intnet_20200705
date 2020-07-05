package kr.co.tjoeun.intnet_20200705

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        moveToBackBtn.setOnClickListener {
            //출발 -> 도착지)
//            val myIntent = Intent(this,  MainActivity::class.java)
//            startActivity(myIntent)
//          지금 보는 액티비티 를 종료 => 이전 화면으로 돌아감
            finish()
        }

    }
}
