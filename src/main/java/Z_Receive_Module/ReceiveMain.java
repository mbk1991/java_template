package Z_Receive_Module;

import Z_Receive_Module.parser.DataParser;
import Z_Receive_Module.parser.impl.UD4M_centering;
import Z_Receive_Module.repository.DataRepository;
import Z_Receive_Module.reveiver.DataReceiver;
import Z_Receive_Module.reveiver.impl.APIReceiver;
import Z_Receive_Module.reveiver.impl.TCPReceiver;
import Z_Receive_Module.reveiver.impl.UDPReceiver;
import Z_Receive_Module.util.ReadProp;

public class ReceiveMain {
    public static void main(String[] args) {

        System.out.println("시작해보즈아");
        System.out.println("Main Thread : "+Thread.currentThread().getName());

        Thread receiver = new APIReceiver(new UD4M_centering());
        receiver.start();
    }
}
