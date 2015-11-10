package axis2;
import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import axis2.Axis2Stub.GetMyValues;


public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Axis2Stub stub = new Axis2Stub("http://localhost:8080/Axis2/services/axis2");
			GetMyValues obj = new GetMyValues();
			obj.setX(5);
			try{
			System.out.println("The value is:"+ stub.getMyValues(obj).get_return());
			} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
