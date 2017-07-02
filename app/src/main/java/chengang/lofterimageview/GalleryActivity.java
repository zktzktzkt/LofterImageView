package chengang.lofterimageview;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import chengang.library.widget.LofterGallery;
import chengang.library.widget.LofterImageView;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class GalleryActivity extends AppCompatActivity implements LofterGallery.OnFirstPageInitListener {

    private LofterGallery mLofterGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        postponeEnterTransition();
        mLofterGallery = (LofterGallery) findViewById(R.id.lofter_Gallery);
        mLofterGallery.setOnFirstPageInitListener(this);

        ArrayList<String> gallery_image = getIntent().getStringArrayListExtra("GALLERY_IMAGE");
//        ViewCompat.setTransitionName(mLofterGallery.getLofterViewPager(), "GALLERY_IMAGE");
        mLofterGallery.showGallery(gallery_image, 0);
    }

    @Override
    public void onBackPressed() {
        mLofterGallery.getLofterViewPager().setCurrentItem(0, true);
        super.onBackPressed();
    }

    GalleryActivity getThis(){
        return this;
    }

    @Override
    public void onFirstPageInitSuccess(LofterImageView lofterImageView) {
//        scheduleStartPostponedTransition(lofterImageView);
    }
}
