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

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickNameActivity::class.java)
            //화면 이동 => 단순 조회 이동 x
            //데이터를 받으러 (결과를 얻으러) 가는 이동
            //받을 데이터 (요청) 구별 고유 숫자 : requestCode
            //어떤 결과 => 새 닉네임을 얻으러
            startActivityForResult(myIntent, 1000)
        }

    }

}
