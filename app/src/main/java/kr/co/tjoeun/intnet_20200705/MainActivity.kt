package kr.co.tjoeun.intnet_20200705

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moveToFirstBtn.setOnClickListener {
            //출발 -> 도착지)
            val myIntent = Intent(this, FirstActivity::class.java)
            startActivity(myIntent)
        }

        sendToSecondBtn.setOnClickListener {
            val message = messageEdt.text.toString()

            //화면 이동
            val myIntent = Intent(this, SecondActivity::class.java)
            myIntent.putExtra("message", message)
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

        //전화걸기 다이얼
        dialBtn.setOnClickListener {
            //입력된 전화번호를 받아오자.

            val inputPhonNum = phoneNumEdt.text.toString()

            // 안드로이드 에게, 어디에 전화걸지 정보 전달 => URL
            // 전화 URL양식 - tel:010-5112-3237
            val myUrl = Uri.parse("tel:${inputPhonNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUrl)
            startActivity(myIntent)
        }

        //전화걸기 다이얼
        callBtn.setOnClickListener {
            //입력된 전화번호를 받아오자.

            val inputPhonNum = phoneNumEdt.text.toString()

            // 안드로이드 에게, 어디에 전화걸지 정보 전달 => URL
            // 전화 URL양식 - tel:010-5112-3237
        /*    val myUrl = Uri.parse("tel:${inputPhonNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUrl)
                startActivity(myIntent)*/
        }

        sendSmsBtn.setOnClickListener {
            //입력한 폰번호 / 문자 내용 받아오기
            val inputPhone = phoneNumEdt.text.toString()
            val inputMsg = smsContentEdt.text.toString()
            val myUrl = Uri.parse("smsto:${inputPhone}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUrl)
            myIntent.putExtra("sms_body",inputMsg)
            startActivity(myIntent)
        }

        naverLinkBtn.setOnClickListener {
            val myUrl = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUrl)
            startActivity(myIntent)
        }

        kakaoStoreLinkBtn.setOnClickListener {

        }
    }

    // MainActivity로 복귀하는 모든 시점에 실행되는 함수

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //어떤걸 가지러 다녀온건지 확인 (닉네임 인지)
        if (requestCode == 1000) {
            //완료를 누른게 맞는지
            if (resultCode == Activity.RESULT_OK) {
                //결과로  받아온 값을 텍스트뷰에 적용
                val newNickName = data?.getStringExtra("nick")
                nickNameTxt.text = newNickName
            }
        }
    }
}
