package kr.co.tjoeun.intnet_20200705

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*
import kotlinx.android.synthetic.main.activity_main.*

class EditNickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        // 완료 버튼을 눌러야 완료.
        okBtn.setOnClickListener {
            val newNickName = newNickNameEdt.text.toString()
            //복귀에 사용할 intent (결과를 담기 위한 용도 )
            //출발지 / 목적지를 기재 하지 않음
            val resultIntent = Intent()

            //입력한 값을 결과용 intent에 첨부
            resultIntent.putExtra("nick", newNickName)

            //화면의 최종 결과가 => OK 버튼을 눌렀다 + resultIntent 데이터 라고 명기
            setResult(Activity.RESULT_OK, resultIntent)

            //기존 화면 복귀
            finish()

        }
    }
}
