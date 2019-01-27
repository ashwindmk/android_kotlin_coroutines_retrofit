package samples.android.ashwin.com.coroutines

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        load_button.setOnClickListener {
            result_textview.text = "Loading..."
            viewModel.load()
        }

        viewModel.text.observe(this, Observer { result ->
            result?.let {
                result_textview.text = result
            }
        })
    }
}
