package Z_Receive_Module.reveiver.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.util.ReadProp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class APIReceiver extends DataReceiver {
    public APIReceiver(DataParser parser) {
        super(parser);
    }
    @Override
    public void receive(DataParser parser) {
        System.out.println("sub Thread "+Thread.currentThread().getName());
        try {
            // API 엔드포인트 URL
            String apiUrl = ReadProp.API_URL;
            int connectTimeOut = Integer.parseInt(ReadProp.CONNECT_TIMEOUT);

            // URL 객체 생성
            URL url = new URL(apiUrl);

            // HttpURLConnection 객체 생성
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(ReadProp.API_HTTP_METHOD);
            connection.setRequestProperty("Content-Type", ReadProp.CONTENT_TYPE);
            connection.setConnectTimeout(connectTimeOut);

            // Request Body에 데이터 추가
            String requestBodyData = "{\"sector_id\":3,\"token\":\"test code\"}";
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBodyData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            // 응답 데이터 읽기
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 응답 데이터 출력
                System.out.println("응답 데이터: " + response.toString());
            } else {
                System.out.println("HTTP 요청 실패");
            }

            // 연결 해제
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
