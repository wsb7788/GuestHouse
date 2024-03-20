package com.guesthouse.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.guesthouse.designsystem.theme.Neutral900A30

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GHBottomSheet(
    modifier: Modifier  = Modifier,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
){
    val density = LocalDensity.current

    val sheetState = remember {
        SheetState(skipPartiallyExpanded = true, density = density, initialValue = SheetValue.Expanded)
    }

    ModalBottomSheet(
        modifier = modifier
            .fillMaxWidth(),
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        onDismissRequest = onDismissRequest,
        scrimColor = Neutral900A30,
        dragHandle = null,
    ){
        Column(
            modifier = Modifier
                .padding(
                    bottom = WindowInsets.navigationBars
                        .asPaddingValues()
                        .calculateBottomPadding()
                )
                .padding(horizontal = 24.dp),
        ){
            content()
        }
    }
}