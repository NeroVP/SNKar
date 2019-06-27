import gnu.io.*;
import java.util.Enumeration;

public class CommPort {

	public static void main(String[] args) {
		System.out.println(" Program Started!!! ");
		@SuppressWarnings("unused")
		int i = 1;
		@SuppressWarnings("unused")
		String vitesse;
		@SuppressWarnings("unused")
		String position;
		
		CommPortIdentifier serialPortId;

		@SuppressWarnings("rawtypes")
		Enumeration enumComm;

		enumComm = CommPortIdentifier.getPortIdentifiers();

		while(enumComm.hasMoreElements())
		{
			serialPortId = (CommPortIdentifier)enumComm.nextElement();
			if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				System.out.println(serialPortId.getName());
				
				/*if (i%2 != 0) { 
					vitesse = serialPortId.getName(); //Si la valeur reçu est impair, il s'agit de la vitesse
					System.out.println("vitesse");
					i++;
				}
				else
				{
					position = serialPortId.getName(); //Si la valeur reçu est pair, il s'agit de la position
					//Requete sql INSERT into donnee (vitesse, position) values (vitesse(valeur), position(valeur));
					System.out.println("position");
					i++;
				}*/
				
			}
		}

		System.out.println(" Program Finished Sucessfully ");
	}

}
