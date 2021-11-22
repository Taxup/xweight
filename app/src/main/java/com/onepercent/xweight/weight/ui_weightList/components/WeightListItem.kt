package com.onepercent.xweight.weight.ui_weightList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.onepercent.xweight.weight.weight_domain.WeightMeasurement
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun WeightListItem(
    weightMeasurement: WeightMeasurement,
    previousMeasurement: WeightMeasurement?,
    onSelectMeasurement: (Long, Double) -> Unit,
) {

    val difference = if (previousMeasurement != null) {
        (weightMeasurement.weight - previousMeasurement.weight)
    } else 0.0

    val backgroundColor = when {
        difference > 0 -> Color(0xffe0fce0)
        difference < 0 -> Color(0xfffce0e0)
        else -> MaterialTheme.colors.background
    }

    val textColor = when {
        difference > 0 -> Color(0xff17bd17)
        difference < 0 -> Color(0xffbd1717)
        else -> MaterialTheme.colors.onSurface
    }

    Surface(
        modifier = Modifier
            .padding(bottom = 3.dp)
            .fillMaxWidth(),
        //elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxWidth()
                .clickable { onSelectMeasurement(weightMeasurement.date, weightMeasurement.weight) }
                .padding(15.dp),

            content = {
                // Date
                Text(
                    modifier = Modifier.weight(1f),
                    color = Color(0xff302f2f),
                    textAlign = TextAlign.Center,
                    text = SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(Date(weightMeasurement.date))
                )

                // Weight
                Text(
                    modifier = Modifier.weight(1f),
                    color = Color(0xff302f2f),
                    textAlign = TextAlign.Center,
                    text = "${weightMeasurement.weight} kg"
                )

                // Difference
                var differenceStr = DecimalFormat("#.##")
                    .format(difference)
                    .replace(",", ".")
                    .toDouble()
                    .toString()

                if (difference > 0) {
                    differenceStr = "+$differenceStr"
                }

                Text(
                    modifier = Modifier.weight(1f),
                    color = textColor,
                    textAlign = TextAlign.Right,
                    text = "$differenceStr kg",
                    maxLines = 1
                )
            }
        )
    }



//    val dividerColor =  when {
//        difference > 0 -> Color(0xffcfe8cf)
//        difference < 0 -> Color(0xffe8cfcf)
//        else -> MaterialTheme.colors.background
//    }
//    Divider(
//        //modifier = Modifier.background(Color.Black),
//        thickness = 1.dp,
//        color = dividerColor)
}