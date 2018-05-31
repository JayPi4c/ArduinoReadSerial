bool state;

void setup() {
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  state = false;
}



String s = "";

void loop() {

  if (Serial.available() > 0) {
    String msg;
    while (Serial.available() > 0) {
      delay(42); // das delay(42); ist wichtig, da sonst die bytes nicht in den Buffer geladen werden und dann nicht alle
      // nacheinander ausgelesen werden können.
      byte b = Serial.read();
      msg += (char)b;
      //msg += "  |available: ";
      //msg += Serial.available();
    }
    Serial.println(msg);
    s = msg;
  }





  if (s.equalsIgnoreCase("CHANGE")) {
    state = !state;
    s = "";
  }


  digitalWrite(LED_BUILTIN, state);

  //  Serial.println("Hello World!");
  //  digitalWrite(LED_BUILTIN, state = !state);
  //  delay(1000);
}
