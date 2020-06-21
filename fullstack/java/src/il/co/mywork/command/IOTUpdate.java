package il.co.mywork.command;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class IOTUpdate implements Command {

    public IOTUpdate(Object o) {}

    @Override
    public boolean execute(Object o) {
        JSONObject json = (JSONObject)o;

        HttpPost post = new HttpPost("http://localhost:8082/GenericIOTCompanyDatabases/updates");
        try {
            post.setEntity(new StringEntity(json.toString()));

            try (CloseableHttpClient client = HttpClients.createDefault();
                 CloseableHttpResponse response = client.execute(post)) {
                return response.getStatusLine().getStatusCode() == 201;
            } catch (IOException e) {
                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(); //TODO: some more relevant return value or exception
            return false;
        }
//        return true;
    }
}
