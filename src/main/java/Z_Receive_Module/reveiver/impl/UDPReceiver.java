package Z_Receive_Module.reveiver.impl;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.util.ReadProp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver extends DataReceiver {
    public UDPReceiver(DataParser parser) {
        super(parser);
    }
    @Override
    public void receive(DataParser parser) {

        System.out.println("여긴누구나는어디");
        System.out.println("sub Thread "+Thread.currentThread().getName());
        DatagramSocket socket = null;
        int receivePort = Integer.parseInt(ReadProp.UDP_PORT);


        try {
            // 포트 번호 9876으로 소켓 생성
            socket = new DatagramSocket(receivePort);
            // 버퍼 크기 1024 설정
            byte[] receiveData = new byte[1024];
            System.out.println("서버 시작... 포트:" + receivePort);

            while (true) {
                // 데이터를 수신하기 위한 DatagramPacket 생성
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // 데이터 수신 대기
                socket.receive(receivePacket);
                // 수신된 데이터 추출
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // 수신된 데이터 출력
                System.out.println("수신된 메시지: " + receivedMessage);
                // 클라이언트에 응답 전송 (예제에서는 수신한 메시지 그대로 돌려보냄)
                byte[] sendData = receivedMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }
}
