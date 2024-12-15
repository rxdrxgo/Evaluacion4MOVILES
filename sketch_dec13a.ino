#include "DHT.h"

#define DHTPIN 2 
#define DHTTYPE DHT11 

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();  
}

void loop() {
  delay(10000); 

  float t = dht.readTemperature(); 

  if (isnan(t)) {
    Serial.println("Error obteniendo los datos del sensor DHT11");
    return;
  }

  Serial.print("Temperatura: ");
  Serial.print(t);
  Serial.println(" °C"); 
}
