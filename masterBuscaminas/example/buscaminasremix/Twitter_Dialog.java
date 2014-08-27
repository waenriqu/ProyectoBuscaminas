package com.example.buscaminasremix;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Twitter_Dialog extends Dialog{

static final int                      BLUE                  = 0xFF6D84B4;
static final float[]                  DIMENSIONS_DIFF_LANDSCAPE =
                                                                { 20, 60 };
static final float[]                  DIMENSIONS_DIFF_PORTRAIT  =
                                                                { 40, 60 };
static final FrameLayout.LayoutParams   FILL                    = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
static final int                      MARGIN                    = 4;
static final int                      PADDING                   = 2;
static final String                   DISPLAY_STRING            = "touch";

private String                        mUrl;
private ProgressDialog                mSpinner;
private WebView                       mWebView;
private LinearLayout                  mContent;
private TextView                      mTitle;

public Twitter_Dialog(Context context, String url)
{
    super(context);
    mUrl = url;
}

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    mSpinner = new ProgressDialog(getContext());
    mSpinner.requestWindowFeature(Window.FEATURE_NO_TITLE);
    mSpinner.setMessage("Loading...");

    mContent = new LinearLayout(getContext());
    mContent.setOrientation(LinearLayout.VERTICAL);
    setUpTitle();
    setUpWebView();
    Display display = getWindow().getWindowManager().getDefaultDisplay();
    final float scale = getContext().getResources().getDisplayMetrics().density;
    int orientation = getContext().getResources().getConfiguration().orientation;
    float[] dimensions = (orientation == Configuration.ORIENTATION_LANDSCAPE) ? DIMENSIONS_DIFF_LANDSCAPE : DIMENSIONS_DIFF_PORTRAIT;
    addContentView(mContent, new LinearLayout.LayoutParams(display.getWidth() - ((int) (dimensions[0] * scale + 0.5f)), display.getHeight() - ((int) (dimensions[1] * scale + 0.5f))));
}

private void setUpTitle()
{
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    Drawable icon = getContext().getResources().getDrawable(R.drawable.twitter_icon);
    mTitle = new TextView(getContext());
    mTitle.setText("Website");
    mTitle.setTextColor(Color.WHITE);
    mTitle.setTypeface(Typeface.DEFAULT_BOLD);
    mTitle.setBackgroundColor(BLUE);
    mTitle.setPadding(MARGIN + PADDING, MARGIN, MARGIN, MARGIN);
    mTitle.setCompoundDrawablePadding(MARGIN + PADDING);
    mTitle.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
    mContent.addView(mTitle);
}

private void setUpWebView()
{
    mWebView = new WebView(getContext());
    mWebView.setVerticalScrollBarEnabled(false);
    mWebView.setHorizontalScrollBarEnabled(false);
    mWebView.setWebViewClient((WebViewClient) new Twitter_Dialog.DialogWebViewClient());
    mWebView.getSettings().setJavaScriptEnabled(true);
    System.out.println(" mURL = "+mUrl);

    mWebView.loadUrl(mUrl);
    mWebView.setLayoutParams(FILL);
    mContent.addView(mWebView);
}

private class DialogWebViewClient extends WebViewClient
{

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        view.loadUrl(url);
        return true;
    }
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
    {
        super.onReceivedError(view, errorCode, description, failingUrl);
        Twitter_Dialog.this.dismiss();
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon)
    {
        super.onPageStarted(view, url, favicon);
        mSpinner.show();
    }

    @Override
    public void onPageFinished(WebView view, String url)
    {
        super.onPageFinished(view, url);
        String title = mWebView.getTitle();
        if (title != null && title.length() > 0){
            mTitle.setText(title);
            if(title.equals("Twitter")){
                //This will close the Dialog after tweeting
                Twitter_Dialog.this.dismiss();

            }
        }
        mSpinner.dismiss();
    }

}
}
