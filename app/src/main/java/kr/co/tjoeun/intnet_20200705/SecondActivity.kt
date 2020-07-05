package kr.co.tjoeun.intnet_20200705

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // intent : 이 화면에 진입할때 사용한 Intent 객체
        // getStringExrea : 우리가 첨부한 데이터가 String 이니 이를 뽑아내자.
        // message : 보내줄떄 붙여준 이름표 (찾아낼 기준)

        val receiveMessage = intent.getStringExtra("message")

        // 텍스트뷰에 반영
        messageTxt.text = receiveMessage

    }
}
