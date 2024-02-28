package com.guesthouse.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guesthouse.base.use
import com.guesthouse.designsystem.icon.GuestHouseIcons
import com.guesthouse.designsystem.theme.GuestHouseTheme
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuestHouseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current
    val (state, event, effect) = use(viewModel = viewModel)

    LaunchedEffect(key1 = effect) {
        effect.collectLatest { effect ->
            when (effect) {
                LoginContract.Effect.KakaoLogin -> kakaoLogin(context)
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginLogo()
        Spacer(modifier = Modifier.height(83.dp))
        LoginIcon {
            event(LoginContract.Event.OnKaKaoLoginClicked)
        }
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BusinessSignUp()
        Spacer(modifier = Modifier.height(65.dp))
    }

}

private fun kakaoLogin(context: Context) {

    // 카카오계정으로 로그인 공통 callback 구성
    // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e("LOGIN", "카카오계정으로 로그인 실패", error)
        } else if (token != null) {
            Log.i("LOGIN", "카카오계정으로 로그인 성공 ${token.accessToken}")
        }
    }

    // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                Log.e("LOGIN", "카카오톡으로 로그인 실패", error)

                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    return@loginWithKakaoTalk
                }

                // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
            } else if (token != null) {
                Log.i("LOGIN", "카카오톡으로 로그인 성공 ${token.accessToken}")
            }
        }
    } else {
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }

}

@Composable
fun LoginLogo() {
    Image(
        modifier = Modifier.size(100.dp),
        painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
        contentDescription = stringResource(R.string.logo_image)
    )
}

@Composable
fun BusinessSignUp() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            stringResource(R.string.business_sign_up_text),
            style = TextStyle(
                fontSize = TextUnit(14f, type = TextUnitType.Sp),
                fontWeight = FontWeight(700),
                letterSpacing = TextUnit(-0.03f, type = TextUnitType.Em)
            ),
            lineHeight = TextUnit(17f, type = TextUnitType.Sp),
            textAlign = TextAlign.Right
        )
        Image(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = GuestHouseIcons.forward),
            contentDescription = stringResource(R.string.business_sign_up_button)
        )
    }
}

@Composable
fun LoginIcon(onKaKaoClicked: () -> Unit) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}, modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
                contentDescription = stringResource(R.string.naver_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(
            onClick = {
                onKaKaoClicked.invoke()
            },
            modifier = Modifier.size(54.dp)
        ) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
                contentDescription = stringResource(R.string.kakao_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(onClick = {}, modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
                contentDescription = stringResource(R.string.google_social_login_button)
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        IconButton(onClick = {}, modifier = Modifier.size(54.dp)) {
            Image(
                painter = painterResource(id = GuestHouseIcons.socialLoginKakao),
                contentDescription = stringResource(R.string.email_login_button)
            )
        }
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun GreetingPreview() {
    GuestHouseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            LoginScreen()
        }
    }
}