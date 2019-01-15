

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.wukay.wukayapp.R
import com.project.wukay.wukayapp.metier.FeedAnimalsModel

class FeedAnimalsControler : AppCompatActivity() {
    private var feedAnimalsModel = FeedAnimalsModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_animals)
        feedAnimalsModel.beginGame()
        

    }
}