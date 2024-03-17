package com.guesthouse.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guesthouse.designsystem.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val pretendard = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendard_black, FontWeight.Black),
)
/*

//styleName: pretendard/regular/10;
font-family: Pretendard;
font-size: 10px;
font-weight: 400;
line-height: 12px;
letter-spacing: -0.03em;
text-align: left;


//styleName: pretendard/bold/10;
font-family: Pretendard;
font-size: 10px;
font-weight: 700;
line-height: 12px;
letter-spacing: -0.03em;
text-align: right;

//styleName: pretendard/regular/12;
font-family: Pretendard;
font-size: 12px;
font-weight: 400;
line-height: 14px;
letter-spacing: -0.03em;
text-align: right;

//styleName: pretendard/bold/12;
font-family: Pretendard;
font-size: 12px;
font-weight: 700;
line-height: 14px;
letter-spacing: -0.03em;
text-align: left;


//styleName: pretendard/bold/14;
font-family: Pretendard;
font-size: 14px;
font-weight: 700;
line-height: 17px;
letter-spacing: -0.03em;
text-align: right;

//styleName: pretendard/regular/14;
font-family: Pretendard;
font-size: 14px;
font-weight: 400;
line-height: 17px;
letter-spacing: -0.03em;
text-align: left;

//styleName: pretendard/bold/16;
font-family: Pretendard;
font-size: 16px;
font-weight: 700;
line-height: 19px;
letter-spacing: -0.03em;
text-align: left;


//styleName: pretendard/bold/18;
font-family: Pretendard;
font-size: 18px;
font-weight: 700;
line-height: 21px;
letter-spacing: -0.03em;
text-align: center;


//styleName: pretendard/bold/20;
font-family: Pretendard;
font-size: 20px;
font-weight: 700;
line-height: 24px;
letter-spacing: -0.03em;
text-align: left;

//styleName: pretendard/bold/20_5%;
font-family: Pretendard;
font-size: 20px;
font-weight: 700;
line-height: 24px;
letter-spacing: 0.05em;
text-align: center;



*/

