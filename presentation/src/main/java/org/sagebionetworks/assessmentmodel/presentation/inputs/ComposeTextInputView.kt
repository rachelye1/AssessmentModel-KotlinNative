package org.sagebionetworks.assessmentmodel.presentation.inputs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Surface
import android.widget.LinearLayout
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.serialization.json.jsonPrimitive
import org.sagebionetworks.assessmentmodel.presentation.databinding.TextInputViewBinding
import org.sagebionetworks.assessmentmodel.presentation.inputs.ui.theme.AssessmentModelKotlinNativeTheme
import org.sagebionetworks.assessmentmodel.survey.FormattedValue
import org.sagebionetworks.assessmentmodel.survey.KeyboardInputItemState
import org.sagebionetworks.assessmentmodel.survey.TextValidator
import org.sagebionetworks.assessmentmodel.survey.inputTypeMask
import org.w3c.dom.Text

class ComposeTextInputView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AssessmentModelKotlinNativeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Rachel")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AssessmentModelKotlinNativeTheme {
            Greeting("Android")
        }

    }

}
