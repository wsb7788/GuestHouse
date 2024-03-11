package com.guesthouse.network

import com.guesthouse.datasource.LoginDataSource
import com.guesthouse.model.NetworkLogin
import javax.inject.Inject

/**
 * plugin application을 가지게 되기 때문에 application 과 android는 분리해야함
 */
class LoginDataSourceImpl @Inject constructor() : LoginDataSource {
    override fun getLoginInfo(): NetworkLogin {
        return NetworkLogin(
            NetworkLogin.Body(
                email = "guesthouse.test@test.com",
                token = "eyJhbGciOiJIUzUxMiJ9.eyJlbWFpbCI6Imd1ZXN0aG91c2UudGVzdEB0ZXN0LmNvbSIsImlhdCI6MTcxMDA0NjkzNSwiZXhwIjoxNzEwMDgyOTM1fQ.1hso9ZPYmY6m09T1yzcpWN_p2tthiQGzgZu3Inrfxf4nHzFS-YgFqWpZjdPtKfKtYP4T7uVrdzxVMQ9GOPLe1Q",
                imageUrl = "https://invitbucket.s3.ap-northeast-2.amazonaws.com/defaultUserProfileImage.svg"
            ),
            message = "로그인 성공",
            success = true,
        )
    }
}