#include <FreqCounter.h>


//===Mesure de fréquence avec la librairie FreqCounter

// tiptopboards 22 08 2013

// Source : http://interface.khm.de/index.php/lab/experiments/arduino-frequency-counter-library/

//

// Branchement du capteur sur pin5 digital

//==========================================================

/*

  Martin Nawrath KHM LAB3

  Kunsthochschule f¸r Medien Kˆln

  Academy of Media Arts

  http://www.khm.de

  http://interface.khm.de/index.php/labor/experimente/

*/

// Variables utilisées

unsigned long frq;    //fréquence mesurée

int cnt;              //nombre de mesures réalisées

int encoches = 20; //16;       //nombre d encoches de la roue codeuse (1 ou plus)

float trmin;  //vitesse de rotation en tour/min

float vitesse; // vitesse en m/s



// Initialisation

void setup() {

  Serial.begin(9600);   //connection au port série

  Serial.println("Frequencemetre");

}



void ConversionVitesse() {

  vitesse = (2 * PI * 0.0325 * trmin / 60) * 10; // fonction pour calculer la vitesse ( en m/s)

  //en fonction du tr/mn
}



// === Boucle de mesures

void loop() {
  // Attendre le signal
  //compensation (étalonnage)
  FreqCounter::f_comp = 10; // Cal Value / Calibrate with professional Freq Counter
  // 10, 100 ou 1000 ms pour une résolution de 100, 10 et 1 Hz
  FreqCounter::start(100);  // 100 ms Gate Time
  // Attendre jusqu'à avoir un comptage terminé
  while (FreqCounter::f_ready == 0)
    // Afficher la mesure de fréquence (et de rotation)
    frq = FreqCounter::f_freq; // a ne pas supprimer permet de calculer le trmn
  //Serial.print(cnt++);
  //Serial.print("  Freq (Hz): ");
  //Serial.print(frq);
  trmin = frq / encoches * 60; //Vitesse de rotation en tour/min
  ConversionVitesse();
  Serial.print("  tour/min: ");
  Serial.println(trmin);
  Serial.print(" vitesse en m/s: ");
  Serial.println(vitesse);
  delay(500);

}
