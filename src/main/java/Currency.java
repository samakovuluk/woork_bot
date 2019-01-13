import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Currency {



    public String getUSDKZT(){

    String res=new GettingCurrency().get("https://openexchangerates.org/api/latest.json?app_id=70dfe60d467c47e684346dc096a306ea&base=USD&symbols=KZT");
        JSONObject array = null;
        JSONObject jsonObj=null;
        try {
            jsonObj = new JSONObject(res);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            array = jsonObj.getJSONObject("rates");
        } catch (JSONException e) {
            e.printStackTrace();
        }
     
        return String.valueOf(array.get("KZT"));

    }

}
