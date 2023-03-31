package edu.cofc.andriod.yodatext

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import edu.cofc.andriod.yodatext.databinding.ActivityMainBinding
import java.net.URL
import java.net.URLEncoder
import org.json.JSONObject
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private fun getYodaString(userText: String): String {
        var yodaStr : String
        val baseUrl =
            "https://api.funtranslations.com/translate/yoda.json?text="
        val encodedEnglishText = URLEncoder.encode(userText, "UTF-8")
        val url = URL(baseUrl + encodedEnglishText)
        try {
            val yodaJSON = url.readText()
            // extract yoda text from json response
            val jsonObj = JSONObject(yodaJSON)
            if (jsonObj.has("success")) {
                val contents = jsonObj.getJSONObject("contents")
                yodaStr = contents.getString("translated")
            }
            else if (jsonObj.has("error")){
                yodaStr = "Error Too Many Tries"
            }
            else {
                yodaStr = resources.getString(R.string.error_message)
            }
        }
        catch (ex : Exception) {
            Log.e("YodaTranslation", ex.stackTraceToString())
            yodaStr = "${ex.message}"
        }
        return yodaStr
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.setBackgroundColor(Color.parseColor("#FFFFFF"))
        val editText = findViewById<EditText>(R.id.user_text)
        editText.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)

        binding.sendButton.setOnClickListener {
            val englishText = binding.userText.text.toString()
            thread {
                val yodaStr = getYodaString(englishText)
                binding.yodaText.post {
                    binding.yodaText.text = yodaStr
                }
            }
        }
    }
}