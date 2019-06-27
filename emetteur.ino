#include "capteurvitesse.h"
#include <VirtualWire.h>

int analogPin = A1;

void setup() {
  Serial.begin(9600);
  vw_set_tx_pin(analogPin);
  vw_setup(2000);
  Serial.println("Go !"); 
  
}
 
void loop() {

  CalculVitesse();
  vw_send((byte *) &vitesse, sizeof(vitesse)); // On envoie le message
  vw_wait_tx(); // On attend la fin de l'envoi
  Serial.println(vitesse);
}
