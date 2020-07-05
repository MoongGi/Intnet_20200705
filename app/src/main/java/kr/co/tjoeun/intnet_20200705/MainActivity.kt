package kr.co.tjoeun.intnet_20200705

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToFirstBtn.setOnClickListener {
            //출발 -> 도착지)
            val myIntent = Intent(this,  FirstActivity::class.java)
            startActivity(myIntent)
        }

        sendToSecondBtn.setOnClickListener {
            val message = messageEdt.text.toString()

            //화면 이동
            val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("message",message)
            startActivity(myIntent)
        }

    }

}
