import okhttp3.Request;
public class GettingCurrency {

    public String get(String url) {
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .build();
            return connect(request);
    }




}
