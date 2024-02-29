import extention.getApiKey
import plugin.configureSocialLogin

plugins {
    id("gh.feature")
}

android {
    defaultConfig {
        resValue("string", "KAKAO_OAUTH_HOST", getApiKey("kakao_oauth_host"))
    }
}

configureSocialLogin()