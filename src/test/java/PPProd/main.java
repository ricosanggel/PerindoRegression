package PPProd;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import Utility.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class main {
	
		public static String chanel = "regression-test";
	    public static String base_url = "https://dev-api.partaiperindo.com";
	    public static String webHook = "https://hooks.slack.com/services/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";
	    public static GetToken tken = new GetToken();
	    public static void main(String[] args) throws InterruptedException
	    {
	        for(int i=0; i<3; i++)
	        {
	            String path ="C:\\Users\\ProBook\\Downloads\\dataAsuransiProd.xlsx";
	            JsonObject jsonObject = new JsonObject();
	            jsonObject.addProperty("insurance_no", strReadExcel(path, 0, i, 0));
	            jsonObject.addProperty("name", strReadExcel(path, 0, i, 2));
	            jsonObject.addProperty("birth_date", strReadExcel(path, 0, i, 3));
	            jsonObject.addProperty("nik", strReadExcel2(path, 0, i, 1));
	            jsonObject.addProperty("address", strReadExcel(path, 0, i, 4));
	            jsonObject.addProperty("phone_number", strReadExcel2(path, 0, i, 5));
	           
	            System.out.println("TOKEN =  "+tken.getDevAccessToken());
	            //Response response;
	            Response response= RestAssured.given()
	                    .contentType("application/x-www-form-urlencoded; charset=utf-8")
	                    .formParam("insurance_no", strReadExcel(path, 0, i, 0))
	                    .formParam("name", strReadExcel(path, 0, i, 2))
	                    .formParam("birth_date", strReadExcel(path, 0, i, 3))
	                    .formParam("scope", "openid email")
	                    .formParam("nik", strReadExcel2(path, 0, i, 1))
	                    .formParam("address", strReadExcel(path, 0, i, 4))
	                    .formParam("phone_number", strReadExcel2(path, 0, i, 5))
	                    .header("Authorization", tken.getDevAccessToken())
	                    //.header("Accept","application/json")
	                    .header("Content-Type","application/x-www-form-urlencoded")
	                    .when()
	                    //.body(jsonObject)
	                    // .multiPart("json", jsonObject, "application/json")
	                    .post(base_url+ "/insurance/openapi/client");
	            // .statusCode(200);
	            System.out.println("loop "+strReadExcel(path, 0, i, 0));
	            String msg = "Loop #"+i+" = No Ins "+ strReadExcel(path, 0, i, 0)+" "+response.getBody().asString();
	            try {
	                sendSlackMessage(webHook,chanel,msg);
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            } catch (Exception e) {
	                throw new RuntimeException(e);
	            }
	            TimeUnit.MINUTES.sleep(1);
	        }
	    }
	    public static String strReadExcel(String strPath, int intSheetIndex, int intRowIndex, int intCellIndex) {
	        String result2 = "";
	        try {
	            FileInputStream excelfile = new FileInputStream(new File(strPath));
	            XSSFWorkbook wb = new XSSFWorkbook(excelfile);
	            String result = wb.getSheetAt(intSheetIndex).getRow(intRowIndex).getCell(intCellIndex).toString();
	            result2 =wb.getSheetAt(intSheetIndex).getRow(intRowIndex).getCell(intCellIndex).toString();
	        } catch (FileNotFoundException ex) {
	            System.out.println("File tidak ditemukan!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result2;
	    }
	    public static String strReadExcel2(String strPath, int intSheetIndex, int intRowIndex, int intCellIndex) {
	        String result2 = "";
	        try {
	            FileInputStream excelfile = new FileInputStream(new File(strPath));
	            XSSFWorkbook wb = new XSSFWorkbook(excelfile);
	            String result = wb.getSheetAt(intSheetIndex).getRow(intRowIndex).getCell(intCellIndex).toString();
	            result2 =new BigDecimal(result.toString()).toPlainString();
	        } catch (FileNotFoundException ex) {
	            System.out.println("File tidak ditemukan!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result2;
	    }
	    public static void sendSlackMessage(String webhookUrl, String channel, String message) throws Exception {
	        HttpClient httpClient = HttpClient.newHttpClient();
	        Map<String, Object> data = new HashMap<>();
	        data.put("channel", channel);
	        data.put("text", message);
	        String payload = "{\"channel\":\"" + channel + "\",\"text\":\"" + message + "\"}";
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(webhookUrl))
	                .header("Content-Type", "application/json")
	                .POST(HttpRequest.BodyPublishers.ofString(payload))
	                .build();
	        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
	        if (response.statusCode() == 200) {
	            System.out.println("Message posted successfully to Slack!");
	        } else {
	            System.err.println("Failed to post message to Slack. Response Code: " + response.statusCode());
	            System.err.println("Response Body: " + response.body());
	        }
	    }
	}
